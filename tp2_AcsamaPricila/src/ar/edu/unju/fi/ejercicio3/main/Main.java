package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		Provincia[] provincias = Provincia.values();
		
		for (Provincia provincia : provincias) {
			System.out.println("Provincia: " + provincia);
			System.out.println("CANTIDAD DE POBLACION: " + provincia.getCantidadPoblacion() + " Habitantes");
			System.out.println("SUPEFICIE: " + provincia.getSuperficie() + " km²");
			System.out.println("DENSIDAD: " + provincia.calcularDensidadPoblacion() + " habitantes/km²");
			System.out.println();
		}
	}
}
