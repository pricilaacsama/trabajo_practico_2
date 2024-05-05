package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago {
	
	private String numTarjeta;
	private LocalDate fechaPago;
	private double montoPagado;
	
	public PagoTarjeta(String numTarjeta, LocalDate fechaPago, double montoPagado) {
		this.numTarjeta = numTarjeta;
		this.fechaPago = fechaPago;
		this.montoPagado = montoPagado;
	}
	
	
	public String getNumTarjeta() {
		return numTarjeta;
	}


	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}


	public LocalDate getFechaPago() {
		return fechaPago;
	}


	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}


	@Override
	public void realizarPago(double monto) {
		this.montoPagado=monto + (monto*0.15);
		System.out.println("Pago realizado con tarjeta por un monto de $" +monto);
		
	}


	@Override
	public void imprimirRecibo() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
		String fechaFormateada = fechaPago.format(formatter);
		
		System.out.println("Recibo del pago realizado con tarjeta:");
        System.out.println("Numero de tarjeta: " + numTarjeta);
        System.out.println("Fecha de pago: " + fechaFormateada);
        System.out.println("Monto pagado: $" + montoPagado);
		
	}
	
	
	
	
}
