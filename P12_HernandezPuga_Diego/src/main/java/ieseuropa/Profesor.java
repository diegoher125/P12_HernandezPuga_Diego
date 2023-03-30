package main.java.ieseuropa;

import java.util.ArrayList;

public class Profesor {
	
	private String nombre;
	private ArrayList<Alumno> alumnos;
	private String etapa;
	private int curso;
	
	public Profesor(String nombre, String etapa, int curso) {
		this.nombre = nombre;
		this.alumnos = new ArrayList<>();
		this.etapa = etapa;
		this.curso = curso;
	}
	
	public Profesor(String nombre) {
		this.nombre = nombre;
		this.alumnos = new ArrayList<>();
		this.etapa = "";
		this.curso = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public String getEtapa() {
		return etapa;
	}

	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}
	
	public void addAlumno(Alumno alumno) {
		this.alumnos.add(alumno);
	}
	
	public boolean maximoAlumnos() {
		if(alumnos.size() == 20)
			return true;
		else
			return false;
	}
	
	public String maximaNotaMedia() {
		String nombreMax = "";
		float mediaMax = 0;
		for(Alumno alumno: alumnos) {
			if(mediaMax < alumno.notaMedia()) {
				mediaMax = alumno.notaMedia();
				nombreMax = alumno.getNombre();
			}
		}
		return "La nota media mas alta de " + curso + " " + etapa + " es de " + nombreMax + " con un " + (Math.round(mediaMax * 100.0) / 100.0);
	}
	
	public String medianasAlumnos() {
		String medianas = "Las medianas en " + curso + " " + etapa + " son\n";
		for(Alumno alumno: alumnos) {
			medianas += alumno.getNombre() + "-" + alumno.mediana() + "\n";
		}
		return medianas;
	}
	
	@Override
	public boolean equals(Object o) {
		if (nombre.equalsIgnoreCase(((Profesor) o).nombre)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Profesor [nombre=" + nombre + ", alumnos=" + alumnos + ", etapa=" + etapa + ", curso=" + curso + "]";
	}

}
