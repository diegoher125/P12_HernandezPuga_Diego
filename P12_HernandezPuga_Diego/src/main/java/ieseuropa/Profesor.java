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
	
	public void anadirAlumno(Alumno alumno) {
		this.alumnos.add(alumno);
	}
	
	public boolean maximoAlumnos() {
		if(alumnos.size() == 20)
			return true;
		else
			return false;
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
