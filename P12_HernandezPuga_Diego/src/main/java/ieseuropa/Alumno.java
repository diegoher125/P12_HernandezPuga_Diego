package main.java.ieseuropa;

import java.util.ArrayList;

public class Alumno {
	
	private String nombre;
	private int edad;
	private ArrayList<Asignatura> asignaturas;
	
	public Alumno(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
		this.asignaturas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public ArrayList<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", edad=" + edad + ", asignaturas=" + asignaturas + "]";
	}

}
