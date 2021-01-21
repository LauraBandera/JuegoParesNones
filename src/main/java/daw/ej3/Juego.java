package daw.ej3;

import java.time.LocalDate;
import java.util.Scanner;
import daw.ej2.Jugador;

public class Juego {

	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Número de rondas
		final int k;
		
		System.out.println("Introduce el número de partidas a jugar:");
		k = s.nextInt();
		s.nextLine();
		
		//Pedimos los valores para el jugador comprobando las restricciones pedidas
		System.out.println("Introduzca el nombre para el jugador: ");
		String nombre = s.nextLine();
		System.out.println("Introduzca el apellido para el jugador: ");
		String apellido = s.nextLine();
		LocalDate nacimiento = LocalDate.of(year(), mes(), dia());
		s.nextLine();
		String eleccion;
		do {
			System.out.println("¿Desea jugar con pares? (Si/No");
			eleccion = s.nextLine();
		}while(!(eleccion.equals("Si")||(eleccion.equals("No"))));
		boolean pares;
		if(eleccion.equals("Si")) {
			pares = true;
		}else {
			pares = false;
		}
		
		//Creamos al jugador
		Jugador j1 = new Jugador(nombre, apellido, nacimiento, pares);

		//Creamos un array para guardar quien gana las partidas
		char[] partidas = new char[k];
		//Declaramos una variable donde guardaremos en cada ronda la tirada obtenida
		int tiradaJ1, tiradaMaquina;
		
		//Hacemos k partidas
		for(int i = 0; i < k; i++) {
			//guardamos las tiradas de cada jugador
			tiradaJ1 = j1.sacarDedos();
			tiradaMaquina = sacarDedosMaquina();
			//Mostramos las tiradas de cada jugador
			System.out.println(j1.getNombre() + " ha sacado: " + tiradaJ1 + " dedos.");
			System.out.println("La máquina ha sacado: "+ tiradaMaquina + " dedos.");
			
			System.out.println("--------- Ganador de la partida " + i + "---------");
			//Mostramos por pantalla el ganador y lo guardamos en el array
			if((tiradaJ1 + tiradaMaquina)%2 == 0) {
				if(j1.isPares()) {
					System.out.println("Ha ganado " + j1.getNombre());
					partidas[i] = 'J';
				}else {
					System.out.println("Ha ganado la máquina");
					partidas[i] = 'M';
				}
			}else {
				if(!j1.isPares()) {
					System.out.println("Ha ganado " + j1.getNombre());
					partidas[i] = 'J';
				}else {
					System.out.println("Ha ganado la máquina");
					partidas[i] = 'M';
				}
			}
		}
		
		System.out.println("----------- Ganador -----------");
		if(contarRondasGanadasJugador(partidas) > contarRondasGanadasMaquina(partidas)) {
			System.out.println("El ganador de la partida es: " + j1.getNombre() +
					" " + j1.getApellido() + ". Enhorabuena!!!");
		}else if(contarRondasGanadasJugador(partidas) < contarRondasGanadasMaquina(partidas)) {
			System.out.println("El ganador de la partida es: la máquina.");
		}else {
			System.out.println("Hemos tenido empate.");
		}
		

		
	}

	//Método de clase para conseguir un día correcto
	private static int dia() {
		int dia;
		do {
			System.out.println("Introduzca el día del mes de nacimiento:");
			dia = s.nextInt();
		} while (dia < 1 || dia > 31);

		return dia;
	}
	
	//Método de clase para conseguir un mes correcto
	private static int mes() {
		int mes;
		do {
			System.out.println("Introduzca el mes de nacimiento:");
			mes = s.nextInt();
		} while (mes < 1 || mes > 12);

		return mes;
	}
	
	//Método de clase para conseguir un año correcto
	private static int year() {
		int year;
		do {
			System.out.println("Introduzca el año de nacimiento:");
			year = s.nextInt();
		} while (year < 1990 || year > LocalDate.now().getYear());

		return year;
	}
	
	private static int sacarDedosMaquina() {
		return Jugador.sacarDedos();
	}
	
	private static int contarRondasGanadasJugador(char[] array) {
		int contador = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] == 'J') {
				contador++;
			}
		}
		return contador;
	}
	
	private static int contarRondasGanadasMaquina(char[] array) {
		int contador = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] == 'M') {
				contador++;
			}
		}
		return contador;
	}

}
