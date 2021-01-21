package daw.ej2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import daw.ej1.Utilidades;

public class Jugador {

	private String nombre, apellido;
	private LocalDate nacimiento;
	private boolean pares; // En caso de ser nones este valor será false
	private int contadorJugadores = 0;

	// Constructor por defecto
	public Jugador() {
		nombre = "Pepe";
		apellido = "Gonzalez";
		nacimiento = LocalDate.of(1957, 10, 2);
		pares = true;
		this.contadorJugadores++;
	}

	// Constructor parametrizado
	public Jugador(String nombre, String apellido, LocalDate nacimiento, boolean pares) {
		if ((ChronoUnit.YEARS.between(nacimiento, LocalDate.now()) < 18)
				|| (ChronoUnit.YEARS.between(nacimiento, LocalDate.now()) < 0)) {
			nombre = "Pepe";
			apellido = "Gonzalez";
			nacimiento = LocalDate.of(1957, 10, 2);
			pares = true;
			this.contadorJugadores++;
		} else {
			this.nombre = nombre;
			this.apellido = apellido;
			this.nacimiento = nacimiento;
			this.pares = pares;
			this.contadorJugadores++;
		}
	}

	// Metodo para consultar jugadores creados
	public int consultarJ() {
		return contadorJugadores;
	}

	// Constructor copia
	public Jugador(Jugador j) {
		this.nombre = j.nombre;
		this.apellido = j.apellido;
		this.nacimiento = j.nacimiento;
		this.pares = j.pares;
		this.contadorJugadores++;
	}

	@Override
	public String toString() {
		String eleccion;
		if (pares) {
			eleccion = "Pares";
		} else {
			eleccion = "Nones";
		}
		return "Nombre: " + nombre + "\tApellido: " + apellido + "\nFecha: " + nacimiento + "\t Elección" + eleccion;
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
		if ((ChronoUnit.YEARS.between(nacimiento, LocalDate.now()) < 18)
				|| (ChronoUnit.YEARS.between(nacimiento, LocalDate.now()) < 0)) {

		} else {
			this.nacimiento = nacimiento;
		}
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

	public static int sacarDedos() {
		return Utilidades.intAleatorio(0, 10);
	}

}
