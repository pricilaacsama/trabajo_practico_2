package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {

	public static void main(String[] args) {
		ArrayList<Efemeride> efemerides = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int opcion;
		do{
			mostrarMenu();
			System.out.println("ingrese una opcion: ");
			opcion = scanner.nextInt();
			scanner.nextLine();
			
			 switch (opcion) {
             case 1:
                 crearEfemeride(scanner, efemerides);
                 break;
             case 2:
                 mostrarEfemerides(efemerides);
                 break;
             case 3:
                 eliminarEfemeride(efemerides, scanner);
                 break;
             case 4:
                 modificarEfemeride(efemerides, scanner);
                 break;
             case 5:
                 System.out.println("Saliendo del menu...");
                 break;
             default:
                 System.out.println("Opción no válida. Intentelo de nuevo.");
         }
			
	}while(opcion!=5);
	
		scanner.close();
	}


	private static void eliminarEfemeride(ArrayList<Efemeride> efemerides, Scanner scanner) {
		if (efemerides.isEmpty()) {
			System.out.println("no hay efemerides para eliminar");
		}else {
			 System.out.print("Ingrese el índice de la efeméride a eliminar: ");
	         int indice = scanner.nextInt();
	         scanner.nextLine();
	         if(indice >= 0 && indice<efemerides.size()) {
	        	 efemerides.remove(indice);
	        	 System.out.println("efermeride eliminada correctamente");
	         }else {
	        	 System.out.println("indice no existe. Intentelo de nuevo");
	         }
		}
	}



	private static void modificarEfemeride(ArrayList<Efemeride> efemerides,Scanner scanner) {
		if (efemerides.isEmpty()) {
            System.out.println("No hay efemerides para modificar");
        } else {
        	System.out.println("ingrese el indice del efemeride a modificar:");
        	int indice = scanner.nextInt();
        	scanner.nextLine();
        	
        	if(indice >= 0 && indice < efemerides.size()) {
        		Efemeride efemeride = efemerides.get(indice);
        		
        		System.out.println("modificando efemeride "+indice+" :");
        		System.out.println(efemeride);
        		
        		System.out.println("ingrese nuevo codigo: ");
        		int nuevocodigo = scanner.nextInt();
        		efemeride.setCodigo(nuevocodigo);
        		int nuevodia=0;
        		Mes nuevomes;
        		
				do {
        			System.out.print("Ingrese el nuevo mes (1-12): ");
        			int numMes = scanner.nextInt();
        			scanner.nextLine();
        			nuevomes = obtenerMes(numMes);
        			if (nuevomes==null) {
        				System.out.println("Mes ingresado no valido.");
        				}else {
        					if (nuevomes == Mes.FEBRERO) {
                                System.out.println("Ingrese un nuevo dia entre 1 y 29.");
                            } else {
                                System.out.println("Ingrese un nuevo dia entre 1 y 31.");
                            }
        					
                            nuevodia = scanner.nextInt();
                            scanner.nextLine();
        					
        				}
					
        			}while(nuevomes==null || (nuevomes == Mes.FEBRERO && (nuevodia < 1 || nuevodia > 29)) || ((nuevodia < 1 || nuevodia > 31)));
        		
        		efemeride.setDia(nuevodia);
        		efemeride.setMes(nuevomes);
        		
        		System.out.println("ingrese el nuevo detalle: ");
        		String nuevodetalle = scanner.nextLine();
        		efemeride.setDetalle(nuevodetalle);
        		
        		System.out.println("Efemeride modificada exitosamente");
        		
        	}else {
        		System.out.println("indice no existe. intente de nuevo");
        	}
        	
        }
		
	}



	private static void mostrarEfemerides(ArrayList<Efemeride> efemerides) {
		if(efemerides.isEmpty()) {
			System.out.println("no hay efemerides para mostrar");
		}else {
			System.out.println("Efemerides: ");
			for(Efemeride efemeride : efemerides) {
				System.out.println(efemeride);
			}
		}
	}



	private static void mostrarMenu() {
		System.out.println("-----MENU------");
		System.out.println("1) Crear efemerides");
		System.out.println("2) Mostrar efemerides");
		System.out.println("3) Eliminar efemerides");
		System.out.println("4) Modificar efemerides");
		System.out.println("5) Salir");
	}

	private static void crearEfemeride(Scanner scanner, ArrayList<Efemeride> efemerides) {
		System.out.println("ingrese el codigo: ");
		int codigo = scanner.nextInt();
		scanner.nextLine();
		int numMes;
		Mes mes;
		int dia = 0;
		
		do {
		System.out.print("Ingrese el mes (1-12): ");
		numMes = scanner.nextInt();
		scanner.nextLine();
		mes = obtenerMes(numMes);
		if (mes==null) {
			System.out.println("Mes ingresado no valido.");
			}else  {
				if(mes == Mes.FEBRERO) {
				System.out.print("Ingrese el día (1-29): ");
			}else {
				System.out.println("ingrese un dia (1-31):");
			}
				dia = scanner.nextInt();
				scanner.nextLine();
			}
		}while(mes==null || (mes == Mes.FEBRERO &&(dia <1 || dia >29)) || ((dia<1 || dia>31)));
		
		
	     
	     System.out.print("Ingrese el detalle: ");
	     String detalle = scanner.nextLine();
	     
	     Efemeride efemeride = new Efemeride(codigo, mes, dia, detalle);
	     efemerides.add(efemeride);
	     System.out.println("Efeméride creada correctamente.");
	        
		
	}
	
	private static Mes obtenerMes(int numMes) {
        switch (numMes) {
            case 1: return Mes.ENERO;
            case 2: return Mes.FEBRERO;
            case 3: return Mes.MARZO;
            case 4: return Mes.ABRIL;
            case 5: return Mes.MAYO;
            case 6: return Mes.JUNIO;
            case 7: return Mes.JULIO;
            case 8: return Mes.AGOSTO;
            case 9: return Mes.SEPTIEMBRE;
            case 10: return Mes.OCTUBRE;
            case 11: return Mes.NOVIEMBRE;
            case 12: return Mes.DICIEMBRE;
            default: return null;
        }
    }
	
	
	
}
