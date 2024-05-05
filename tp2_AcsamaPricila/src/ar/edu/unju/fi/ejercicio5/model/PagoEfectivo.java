package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago{
	
	
	private double montoPagado; 
	private LocalDate fechaPago;
	
	
	public PagoEfectivo(double montoPagado, LocalDate fechaPago) {
		this.montoPagado = montoPagado;
		this.fechaPago = fechaPago;
	}
	
	
	@Override
	public void realizarPago(double monto) {
		this.montoPagado=monto - (monto*0.10);
		System.out.println("Pago realizado en efectivo por un monto de $"+monto);
		
	}
	@Override
	public void imprimirRecibo() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
		String fechaFormateada = fechaPago.format(formatter);
		
		System.out.println("Recibo del pago realizado en efectivo: ");
		System.out.println("Fecha de pago: " + fechaFormateada);
	    System.out.println("Monto pagado: $" + montoPagado);
		
	}


	public double getMontoPagado() {
		return montoPagado;
	}


	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}


	public LocalDate getFechaPago() {
		return fechaPago;
	}


	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}
	
	
	
}
