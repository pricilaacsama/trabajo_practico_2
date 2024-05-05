package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.productos.Producto;
import ar.edu.unju.fi.ejercicio5.productos.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5.productos.Producto.OrigenFabricacion;

public class Main {

	public static void main(String[] args) {
		
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
		productos.add(new Producto(12, "Notebook ASUS vivobook 15", 300000.45, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto(13, "Monitor gamer NBX-GM2700 27", 635134.45, OrigenFabricacion.BRASIL, Categoria.INFORMATICA, false));
		productos.add(new Producto(14, "Samsung S21 FE", 682001.45, OrigenFabricacion.CHINA, Categoria.TELEFONIA, true));
		productos.add(new Producto(15, "Destornillador plano crossmaster 6x150 mm", 3100.45, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, false));
		
		
		
		Scanner scanner = new Scanner(System.in);
		int opcion;
		
		do {
			mostrarMenu();
			try {
				opcion=scanner.nextInt();
				switch(opcion) {
				case 1:
					mostrarProductos(productos);
					break;
				case 2:
					realizarCompra(productos, scanner);
					break;
				case 3:
					System.out.println("Saliendo del menu...");
					break;
				default:
					System.out.println("Opcion no valida, por favor ingrese nuevamente");
					break;
				
				}
			} catch (InputMismatchException e) {
				System.out.println("ERROR INGRESE UN NUMERO ENTERO VALIDO");
				scanner.next();
				opcion=0;
			}		
		
		}while(opcion!=3);
		
}

	private static void mostrarMenu() {
		System.out.println("-----Menu-----");
        System.out.println("1 - Mostrar productos");
        System.out.println("2 - Realizar compra");
        System.out.println("3 - Salir");
        System.out.print("Ingrese su opcion: ");
		
	}

	public static void mostrarProductos(ArrayList<Producto> productos) {
		
		System.out.println("Lista de productos: ");
		for (Producto producto : productos) {
			System.out.println(producto);
		}
	}
	
	private static void realizarCompra(ArrayList<Producto> productos, Scanner scanner) {
		ArrayList<Producto> productosComprados = new ArrayList<>();
		
		double totalCompra=0;
		
		mostrarProductos(productos);
		System.out.println("Ingrese el número de producto que desea comprar (0 para finalizar):");
		int opcion;
		
		do {
			
			try {
				opcion=scanner.nextInt();
				if(opcion>0 && opcion<=productos.size()) {
					Producto producto = productos.get(opcion-1);
					
					if(producto.isEstado()) {
						productosComprados.add(producto);
						totalCompra = totalCompra + producto.getPrecioUnitario();
						producto.setEstado(false);
					} else {
						System.out.println("Este producto no esta disponible en stock");
					}
					
					
				}else if(opcion != 0) {
					System.out.println("opcion no valida, ingrese nuevamente la opcion");
				}
				
				
			}catch(InputMismatchException e) {
				System.out.println("ERROR INGRESE UN NUMERO ENTERO VALIDO");
				scanner.next();
				opcion=-1;
			}
			
		}while(opcion!=0);
		
		if (!productosComprados.isEmpty()) {
			realizarPago(totalCompra, scanner);
		}
		
	}
	
	public static void realizarPago(double totalCompra, Scanner scanner) {
		System.out.println("Seleccione metodo de pago:");
        System.out.println("1 - Pago en efectivo");
        System.out.println("2 - Pago con tarjeta");
        
        int opcion;
        
        do {
        	try {
        		
        		opcion = scanner.nextInt();
        		if (opcion==1) {
        			realizarPagoEfectivo(totalCompra);
        		}else if(opcion == 2) {
        			realizarPagoTarjeta(totalCompra, scanner);
        		}else {
        			System.out.println("opcion no valida, ingrese 1 o 2 solamente");
        		}
        	}catch (InputMismatchException e) {
        		System.out.println("ERROR INGRESE UN NUMERO ENTERO VALIDO");
        		scanner.next();
        		opcion=0;
        	}
        	
        }while(opcion != 1 && opcion != 2);
	}
	
	public static void realizarPagoEfectivo(double totalCompra) {
		LocalDate fechaPago = LocalDate.now();
		PagoEfectivo pagoEfectivo = new PagoEfectivo(totalCompra, fechaPago);
		pagoEfectivo.realizarPago(totalCompra);
		pagoEfectivo.imprimirRecibo();
		
	}
	
	
	public static void realizarPagoTarjeta(double totalCompra, Scanner scanner) {
		scanner.nextLine();
		System.out.println("Ingrese el numero de tarjeta: ");
		String numeroTarjeta;
		numeroTarjeta = scanner.nextLine();
		LocalDate fechaPago = LocalDate.now();
		
		PagoTarjeta pagoTarjeta = new PagoTarjeta(numeroTarjeta, fechaPago, totalCompra);
		pagoTarjeta.realizarPago(totalCompra);
		pagoTarjeta.imprimirRecibo();
		
	}
}
