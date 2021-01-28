package daw.ej2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import daw.ej1.Utilidades;

public class Jugador {

	private String nombre, apellido;
	private LocalDate nacimiento;
	private boolean pares; // En caso de ser nones este valor será false
	private static int contadorJugadores = 0;

	// Constructor por defecto
	public Jugador() {
		nombre = "Pepe";
		apellido = "Gonzalez";
		nacimiento = LocalDate.of(1957, 10, 2);
		pares = true;
		Jugador.contadorJugadores++;
	}

	// Constructor parametrizado
	public Jugador(String nombre, String apellido, LocalDate nacimiento, boolean pares) {
		//Otra opción
		this();//this(parametro); //Para llamar a constructores con parámetros
		if(Utilidades.calcularYear(nacimiento) >= 18){
			this.nombre = nombre;
			this.apellido = apellido;
			this.nacimiento = nacimiento;
			this.pares = pares;
			Jugador.contadorJugadores++;
		}
//		//Mejor opción anterior
//		if ((ChronoUnit.YEARS.between(nacimiento, LocalDate.now()) < 18)) { //Utilidades.calcularYear(nacimiento) < 18
//			this.nombre = "Pepe";
//			this.apellido = "Gonzalez";
//			this.nacimiento = LocalDate.of(1957, 10, 2);
//			this.pares = true;
//			Jugador.contadorJugadores++;
//		} else {
//			this.nombre = nombre;
//			this.apellido = apellido;
//			this.nacimiento = nacimiento;
//			this.pares = pares;
//			Jugador.contadorJugadores++;
//		}
	}

	// Metodo para consultar jugadores creados
	public static int consultarJ() {
		return contadorJugadores;
	}

	// Constructor copia
	public Jugador(Jugador j) {
		this.nombre = j.nombre;
		this.apellido = j.apellido;
		this.nacimiento = j.nacimiento;
		this.pares = j.pares;
		Jugador.contadorJugadores++;
	}

	//ERROR EN FECHA --> ya corregido
	@Override
	public String toString() {
		String eleccion;
		if (pares) {
			eleccion = "Pares";
		} else {
			eleccion = "Nones";
		}
		
		//Faltaba darle formato a la fecha
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Nombre: " + nombre + "\tApellido: " + apellido + "\nFecha: " + nacimiento.format(fecha) + "\t Elección" + eleccion;
//		return "Nombre: " + nombre + "\tApellido: " + apellido + "\nFecha: " + nacimiento + "\t Elección" + eleccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(LocalDate nacimiento) {
		if(Utilidades.calcularYear(nacimiento) < 18) {
			this.nacimiento = LocalDate.of(1957, 10, 2);
		} else {
			this.nacimiento = nacimiento;
		}
		/*//Mejor la forma de arriba
		if ((ChronoUnit.YEARS.between(nacimiento, LocalDate.now()) < 18)) {
			this.nacimiento = LocalDate.of(1957, 10, 2);
		} else {
			this.nacimiento = nacimiento;
		}
		*/
	}

	public boolean isPares() {
		return pares;
	}

	public void setPares(boolean pares) {
		this.pares = pares;
	}

	public int getEdad() {
		return Utilidades.calcularYear(this.nacimiento);
	}

	public int sacarDedos() {
		return Utilidades.intAleatorio(0, 10);
	}

}
