package daw.ej1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Utilidades {

	private static Scanner s = new Scanner(System.in);
	private static Random aleatorio = new Random();
	
	public static int intAleatorio(int min, int max) {
		
		return aleatorio.nextInt(max - min + 1)+min; //Valores entre max y min ambos inclusive
	}
	
	public static int leerEnteroRango(int min, int max) {
		int num = min - 1;
		
		do {
			try {
				System.out.println("Introduzca un número por pantalla");
				num = s.nextInt();
			}catch(InputMismatchException ime) {
				continue;
			}
		}while(num < min || num > max);
		
		return num;
	}
	
	public static int calcularYear(LocalDate fecha) {
		return(int) ChronoUnit.YEARS.between(fecha, LocalDate.now());
	}
}
