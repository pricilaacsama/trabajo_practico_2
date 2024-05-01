package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY(811611,53291), 
	SALTA(1441351,155488), 
	TUCUMAN(1687305,22524), 
	CATAMARCA(429562, 102602), 
	LA_RIOJA(383865, 89680), 
	SANTIAGO_DEL_ESTERO(1060906, 136351);

	private int cantidadPoblacion;
	private int superficie;
	
	private Provincia(int cantidadPoblacion, int superficie) {
		this.cantidadPoblacion = cantidadPoblacion;
		this.superficie = superficie;
	}

	public int getCantidadPoblacion() {
		return cantidadPoblacion;
	}

	public void setCantidadPoblacion(int cantidadPoblacion) {
		this.cantidadPoblacion = cantidadPoblacion;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	
	
	public double calcularDensidadPoblacion() {
		return (double) cantidadPoblacion / superficie;
		
	}
	
	

}
