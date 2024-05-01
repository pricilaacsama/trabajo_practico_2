package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {

	public static void main(String[] args) {
		ArrayList<Jugador> jugadores = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int opcion = 0;
		
		do {
			mostrarMenu();
			
			try {
				opcion = scanner.nextInt();
				scanner.nextLine();
				
				switch(opcion) {
				case 1: 
					altaJugador(jugadores, scanner);
					break;
				case 2: 
					mostrarJugadores(jugadores);
					break;
				case 3:
					modificarPosicion(jugadores, scanner);
					break;
				case 4:
					eliminarJugador(jugadores, scanner);
					break;
				case 5:
					System.out.println("saliendo del menu...");
					break;
				default:
					System.out.println("opcion invalida, ingrese de nuevo la opcion ");
				}
			} catch(InputMismatchException e) {
				System.out.println("ERROR, DEBE INGRESAR UN NUMERO ENTERO");
				scanner.next();
				opcion = 0;
			} catch (Exception e) {
				System.out.println("ERROR: " + e.getMessage());
				opcion = 0;
			} finally {
				if (opcion == 5) {
					scanner.close();
				}
			}
		}while(opcion!=5);

	}

	private static void eliminarJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
		System.out.println("ELIMINAR UN JUGADOR");
		System.out.print("ingrese nombre del jugador: ");
        String nombre = scanner.nextLine();
        System.out.print("ingrese apellido del jugador: ");
        String apellido = scanner.nextLine();
        
        Iterator<Jugador> iterator = jugadores.iterator();
        
        while(iterator.hasNext()) {
        	Jugador jugador = iterator.next();
        	
        	if(jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
        		iterator.remove();
        		System.out.println("JUGADOR ELIMINADO CORRECTAMENTE");
        		return;
        	}
        }
		System.out.println("no se encontro al jugador con ese nombre y apellido");
        
	}

	

	private static void mostrarJugadores(ArrayList<Jugador> jugadores) {
		System.out.println("LISTA DE JUGADORES");
		
		if(jugadores.isEmpty()) {
			System.out.println("no hay jugadores para mostrar");
		}else {
			for(Jugador jugador : jugadores) {
				System.out.println(jugador);
			}
		}
	}

	private static void altaJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
		System.out.println("ALTA DE JUGADOR");
		System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese fecha de nacimiento (YYYY-MM-DD): ");
        LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());
        System.out.print("Ingrese nacionalidad: ");
        String nacionalidad = scanner.nextLine();
        System.out.print("Ingrese estatura (en metros): ");
        double estatura = scanner.nextDouble();
        System.out.print("Ingrese peso (en kg): ");
        double peso = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Ingrese posicion(DELANTERO, MEDIO, DEFENSA, ARQUERO): ");
        String posicionStr = scanner.nextLine().toUpperCase();
        Posicion posicion = Posicion.valueOf(posicionStr);
        
        Jugador jugador = new Jugador(nombre,apellido,fechaNacimiento,nacionalidad,estatura,peso,posicion);
        jugadores.add(jugador);
        System.out.println("JUGADOR AGREGADO EXITOSAMENTE");
        
        
	}

	private static void mostrarMenu() {
		 System.out.println("-----MENU-----");
         System.out.println("1 - Alta de jugador");
         System.out.println("2 - Mostrar todos los jugadores");
         System.out.println("3 - Modificar la posición de un jugador");
         System.out.println("4 - Eliminar un jugador");
         System.out.println("5 - Salir");
         System.out.print("Ingrese una opción: ");
		
	}
private static void modificarPosicion(ArrayList<Jugador> jugadores, Scanner scanner) {
		System.out.println("MODIFICAR POSION DE UN JUGADOR");
		System.out.println("ingrese nombre del jugador: ");
		String nombre = scanner.nextLine();
		System.out.println("ingrese apellido del jugador: ");
		String apellido = scanner.nextLine();
		
		boolean encontrado = false;
		
		Iterator<Jugador> iterator = jugadores.iterator();
		
		while(iterator.hasNext()) {
			Jugador jugador = iterator.next();
			
			if(jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
				System.out.println("ingrese nueva posicion (DELANTERO, MEDIO, DEFENSA, ARQUERO):");
				String nuevaPosicionStr = scanner.nextLine().toUpperCase();
				Posicion nuevaPosicion = Posicion.valueOf(nuevaPosicionStr);
				jugador.setPosicion(nuevaPosicion);
				System.out.println("POSICION MODIFICADO CORRECTAMENTE");
				encontrado = true;
				break;
			}
			
		}
		if (!encontrado) {
			System.out.println("no se encontro al jugador con ese nombre y apellido");
		}
		
	}

}
