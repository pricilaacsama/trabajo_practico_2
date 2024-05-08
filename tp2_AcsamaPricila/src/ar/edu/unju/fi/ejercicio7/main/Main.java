package ar.edu.unju.fi.ejercicio7.main;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio5.productos.Producto;
import ar.edu.unju.fi.ejercicio5.productos.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5.productos.Producto.OrigenFabricacion;


public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Producto> productos = new ArrayList<>();
		
		productos.add(new Producto(1, "HP 15 FHD touch notebook", 30000.45, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
		productos.add(new Producto(2, "Smart tv LG UHD 4K Al ThinQ", 100000.55, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto(3, "Samsung A14", 420030.12, OrigenFabricacion.CHINA, Categoria.TELEFONIA, true));
		productos.add(new Producto(4, "Notebook EXO 14", 2500000.45, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true));
		productos.add(new Producto(5, "Noblex tv smart", 706020.45, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto(6, "Motorola g30", 563000.45, OrigenFabricacion.CHINA, Categoria.INFORMATICA, false));
		productos.add(new Producto(7, "Auriculares inalambricos suono tws m12", 25000.45, OrigenFabricacion.BRASIL, Categoria.TELEFONIA, false));
		productos.add(new Producto(8, "Ventilador de pie liliana", 120000.45, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto(9, "Impresora multifuncion hp 580", 76200.45, OrigenFabricacion.URUGUAY, Categoria.INFORMATICA, true));
		productos.add(new Producto(10, "Taladro percutor electrico gamma 710w 13mm", 4230.45, OrigenFabricacion.URUGUAY, Categoria.HERRAMIENTAS, false));
		productos.add(new Producto(11, "Soldadora inverter daewoo 50hz 220v", 1300.45, OrigenFabricacion.CHINA, Categoria.HERRAMIENTAS, true));
		productos.add(new Producto(12, "Heladera con freezer HGF358 AFB blanca 282lt Gafa", 300000.45, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto(13, "Monitor gamer NBX-GM2700 27", 635134.45, OrigenFabricacion.BRASIL, Categoria.INFORMATICA, false));
		productos.add(new Producto(14, "Samsung S21 FE", 682001.45, OrigenFabricacion.CHINA, Categoria.TELEFONIA, true));
		productos.add(new Producto(15, "Destornillador plano crossmaster 6x150 mm", 3100.45, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, false));
		
		
		int opcion;
		
		do {
			mostrarMENU();
			opcion=scanner.nextInt();
			scanner.nextLine();
			
			switch(opcion) {
			case 1:
				System.out.println("Productos Disponibles: ");
				Consumer<Producto> mostrar = p -> {if (p.isEstado())
					System.out.println(p);
				};
				productos.forEach(mostrar);
				break;
			case 2:
				System.out.println("Productos no disponibles: ");
				System.out.println(mostrarNoDisponible(productos));
				
				
				break;
			case 3:
				System.out.println("Incrementando precios de los productos en un 20%");
				ArrayList<Producto> productosIncrementados = incrementarPrecio(productos);
				System.out.println(productosIncrementados);
				
				break;
			case 4:
				System.out.println("Productos de categoria ELECTROHOGAR disponibles:");
				System.out.println(mostrarProductosdeElectoHogar(productos));
				
				break;
			case 5:
				System.out.println("Productos ordenados de forma descendente:");
				System.out.println(ordenarporPrecio(productos));
				
				break;
			case 6:
				
				productosEnMayusculas(productos);
				
				break;
			case 0:
				System.out.println("Saliendo del menu...");
				break;
			default:
				System.out.println("esta opcion es invalida, ingrese nuevamente la opcion");
				break;
			}
			
			
			
			
		}while(opcion!=0);
		
		
		scanner.close();
	}

	

	private static void productosEnMayusculas(ArrayList<Producto> productos) {
		System.out.println("Nombres de productos en mayusculas: ");
		Function<Producto, String> nombreMayuscula = p -> p.getDescripcion().toUpperCase();
		productos.stream().map(nombreMayuscula).forEach(System.out :: println);
		
	}



	public static ArrayList<Producto> ordenarporPrecio(ArrayList<Producto> productos) {
		Comparator<Producto> c = Comparator.comparing(Producto :: getPrecioUnitario).reversed();
		productos.sort(c);
		
	return productos;	
	}

	public static ArrayList<Producto> mostrarProductosdeElectoHogar(ArrayList<Producto> productos) {
		Predicate<Producto> condicion = p -> p.isEstado() && p.getCategoria()== Producto.Categoria.ELECTROHOGAR;
		return (ArrayList<Producto>) productos.stream().filter(condicion).collect(Collectors.toList());
			
	}

	public static ArrayList<Producto> incrementarPrecio(ArrayList<Producto> productos) {
		Function<Producto, Producto> nuevoPrecio = p -> {
			p.setPrecioUnitario(p.getPrecioUnitario()*1.20f);
			return p;
		};
		
		return (ArrayList<Producto>) productos.stream().map(nuevoPrecio).collect(Collectors.toList());
		
	}

	public static ArrayList<Producto> mostrarNoDisponible(ArrayList<Producto> productos) {
		Predicate<Producto> condicion = p -> !p.isEstado();
		return (ArrayList<Producto>) (productos.stream().filter(condicion).collect(Collectors.toList()));
		
	}

	private static void mostrarMENU() {
		 System.out.println("-----MENU-----");
         System.out.println("1 - Mostrar productos disponibles");
         System.out.println("2 - Mostrar productos faltantes");
         System.out.println("3 - Incrementar precios de productos");
         System.out.println("4 - Mostrar productos de la categoría Electrohogar disponibles");
         System.out.println("5 - Ordenar productos por precio descendente");
         System.out.println("6 - Mostrar nombres de productos en mayúsculas");
         System.out.println("0 - Salir");
         System.out.print("Ingrese su opción: ");
		
	}

}
