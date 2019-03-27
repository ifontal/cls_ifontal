
/**
 * Write a description of class EntradaG here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.time.LocalDate;
import java.time.LocalTime;

public class EntradaReducida extends Entrada {
    private double descuento;
    
    public EntradaReducida(boolean vip, LocalDate fechaInicio, Cliente cliente) {
        super.setVip(vip);
        super.setFechaInicio(fechaInicio);
        super.setHoraInicio(LocalTime.parse("00:00"));
        super.setCliente (cliente);
        this.descuento=0.60;
    }
    
    public double getPrecioEntrada() {
        Cliente cliente = super.getCliente();
        double precio = super.getPrecio()*cliente.getDescuento();
        
        if(super.isVip()) {
            precio = precio + super.getSuplementoVip()*cliente.getDescuento();
            return precio*this.descuento;
        } else {
            return precio*this.descuento*FactoriaTemporadas.getPrecio(super.getFechaInicio());
        }
    }
    
    public double getDescuento() {
        return this.descuento;
    }
    
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
}
