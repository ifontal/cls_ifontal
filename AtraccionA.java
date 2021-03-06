/**
 * Clase que implementa la atraccion a
 * 
 * @author: Miguel Traseira López
 * @version marzo de 2019
 */
import java.time.LocalDate;

public class AtraccionA extends Atraccion {
    private static double alturaMin = 1.20;

    /**
     * Constructor for objects of class AtraccionA
     */
    public AtraccionA(String id) {
        super(6, 1, true, true, id);  
    }

    /**
     * Método que comprueba si un cliente está admitido
     * 
     * @param  el cliente
     */
    public boolean clienteAdmitido (Cliente cliente) {
        while (cliente instanceof IncrementarDescuento) {
            cliente = cliente.getCliente();
        }
        if (((cliente instanceof Adulto) || (cliente instanceof Niño)
        || (cliente instanceof Senior)) && (cliente.getAltura() >= this.alturaMin)) {
            super.addRegistro(cliente, LocalDate.now());
            return true;
        } else {
            return false;
        }
    }
}
