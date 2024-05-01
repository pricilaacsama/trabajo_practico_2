package ar.edu.unju.fi.ejercicio1.main;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;

public class Main {

	public static void main(String[] args) {
		
		int opcion;
		ArrayList<Producto> listaProducto = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		
		
		
		do{
			try {
			System.out.println("----Menu----");
			System.out.println("1 – Crear producto");
			System.out.println("2- Mostrar productos");
			System.out.println("3- Modificar producto");
			System.out.println("4- Salir");
			System.out.println("Elije una opcion: ");
			opcion = scanner.nextInt();
			scanner.nextLine();
			
			switch (opcion) {
			case 1: 
				crearProducto(listaProducto, scanner);
				break;
			case 2: 
				mostrarProducto(listaProducto);
				break;
			case 3: 
				modificarProducto(listaProducto, scanner);
				break;
			case 4: 
				System.out.println("Saliendo del menu...");
				break;
			default:
				System.out.println("opcion invalida. ingrese nuevamente la opcion.");
			
			}
		} catch(InputMismatchException e) {
			System.out.println("Error! Ingrese un número entero.");
            scanner.nextLine();
            opcion = 0;
		}
			
		}while(opcion!=4);
	
		scanner.close();

	}

	private static void modificarProducto(ArrayList<Producto> listaProducto, Scanner scanner) {
		
		try {
		if (listaProducto.isEmpty()) {
			System.out.println("no hay productos para modificar");
			return;
		}
		
		mostrarProducto(listaProducto);
		System.out.println("ingrese el codigo que desea modificar:");
		int codigoBus = scanner.nextInt();
		scanner.nextLine();
		
		Producto productoModificar = null;
		
		for (int i=0;i<listaProducto.size();i++) {
			Producto producto1 = listaProducto.get(i);
			if(producto1.getCodigo() == codigoBus) {
				productoModificar = producto1;
				break;
			}
		}
		
		if (productoModificar == null) {
			System.out.println("no se encontro ningun producto con ese codigo");
			return;
		}
		
		int opcion;
		do {
			try {
			mostrarOpciones();
			opcion = scanner.nextInt();
			scanner.nextLine();
			
			switch(opcion){
			case 1:
				System.out.println("ingrese nueva descripcion: ");
				String nuevaDescripcion = scanner.nextLine();
				productoModificar.setDescripcion(nuevaDescripcion);
				System.out.println("Descripcion modificada con exito");
				break;
			case 2:
				System.out.println("ingrese nuevo precio unitario: ");
				double nuevoPrecioUnitario = scanner.nextDouble();
				productoModificar.setPrecioUnitario(nuevoPrecioUnitario);
				System.out.println("Precio unitario modifcado con exito");
				break;
			case 3:
				Producto.OrigenFabricacion nuevoOrigenFabri = seleccionarOrigenFabricacion(scanner);
				productoModificar.setOrigenFabri(nuevoOrigenFabri);
				System.out.println("Origen de fabricacion modificado con exito");
				break;
			case 4:
				Producto.Categoria nuevaCategoria = seleccionarCategoria(scanner);
				productoModificar.setCategoria(nuevaCategoria);
				System.out.println("Categoria modificada con exito");
				break;
			case 5: 
				System.out.println("Salinedo del menu...");
				break;
			default:
				System.out.println("opcion invalida. ingrese nuevamente la opcion");
			}
		} catch(InputMismatchException e) {
			 System.out.println("Error: Ingrese un número entero.");
             scanner.nextLine();
             opcion = 0;
			}
			
		}while(opcion!=5);
	}catch(Exception e) {
		System.out.println("Error! " +e.getMessage());
	}
		
}

	private static void mostrarProducto(ArrayList<Producto> listaProducto) {
		try {
		if (listaProducto.isEmpty()) {
			System.out.println("no hay productos");
		}else {
		for(Producto producto : listaProducto) {
			System.out.println(producto);
		}
	  }
	}catch(Exception e) {
		System.out.println("Error! "+ e.getMessage());
	}
}

	private static void crearProducto(ArrayList<Producto> listaProducto, Scanner scanner) {
	try {
		int codigo;
		String descripcion;
		double precioUnitario;
	    Producto.OrigenFabricacion origenFabri;
	    Producto.Categoria categoria;
		
	    System.out.println("creando producto...");
	    System.out.println("ingrese codigo: ");
	    codigo = scanner.nextInt();
	    scanner.nextLine();
	    System.out.println("ingrese descripcion: ");
	    descripcion = scanner.nextLine();
	    System.out.println("ingrese precio unitario: ");
	    precioUnitario = scanner.nextDouble();
	   
	    scanner.nextLine();
	    origenFabri = seleccionarOrigenFabricacion(scanner);
	    categoria=seleccionarCategoria(scanner);
	    
	    Producto producto = new Producto(codigo, descripcion, precioUnitario, origenFabri, categoria);
	    listaProducto.add(producto);
	    System.out.println("agregado con exito");
	}catch(InputMismatchException e) {
		System.out.println("error! ingrese un numero entero valido");
		scanner.nextLine();
	}catch (Exception e) {
		System.out.println("error! "+e.getMessage());
	}
}

	
	private static OrigenFabricacion seleccionarOrigenFabricacion(Scanner scanner) {
	try {	
		int op;
		do {
			System.out.println("----- Origen de fabricación -----");
            System.out.println("1 - Argentina");
            System.out.println("2 - China");
            System.out.println("3 - Brasil");
            System.out.println("4 - Uruguay");
            System.out.print("Elija una opción: ");
            op = scanner.nextInt();
            scanner.nextLine();
            
            switch(op) {
            case 1: 
            	return Producto.OrigenFabricacion.ARGENTINA;
            case 2:
            	return Producto.OrigenFabricacion.CHINA;
            case 3:
            	return Producto.OrigenFabricacion.BRASIL;
            case 4: 
            	return Producto.OrigenFabricacion.URUGUAY;
            default:
            	System.out.println("opcion invalida. ingrese de nuevo.");
            }
			
		}while(true);
	}catch(InputMismatchException e) {
		throw new InputMismatchException("ingrese un num entero");
	}
}

	public static Producto.Categoria seleccionarCategoria(Scanner scanner) {
	try {
		int op;
		do {
			System.out.println("----- Categoría -----");
            System.out.println("1 - Telefonía");
            System.out.println("2 - Informática");
            System.out.println("3 - Electrohogar");
            System.out.println("4 - Herramientas");
            System.out.print("Elija una opción: ");
            op=scanner.nextInt();			
			scanner.nextLine();
			
			switch(op) {
			case 1: return Producto.Categoria.TELEFONIA;
			case 2: return Producto.Categoria.INFORMATICA;
			case 3: return Producto.Categoria.ELECTROHOGAR;
			case 4: return Producto.Categoria.HERRAMIENTAS;
			default: System.out.println("opcion invalida. ingrese de nuevo.");
			
			}
			
			
		}while(true);
	}catch (InputMismatchException e) {
		throw new InputMismatchException("ingrese un numero entero");
	}
}
	
	public static void mostrarOpciones() {
        System.out.println("----- Modificar Producto -----");
        System.out.println("1 - Modificar descripción");
        System.out.println("2 - Modificar precio unitario");
        System.out.println("3 - Modificar origen de fabricación");
        System.out.println("4 - Modificar categoría");
        System.out.println("5 - Volver al menú principal");
        System.out.print("Elija una opción: ");
    }
	
	
}
