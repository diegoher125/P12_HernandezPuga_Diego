package main.java.ieseuropa;

import java.util.ArrayList;

public class Profesor {
	
	private String nombre;
	private ArrayList<Alumno> alumnos;
	
	public Profesor(String nombre) {
		this.nombre = nombre;
		this.alumnos = new ArrayList<>();
	}

}
