package main.java.ieseuropa;

import java.util.ArrayList;
import java.util.Collections;

public class Alumno {
	
	private String nombre;
	private int edad;
	private ArrayList<Integer> asignaturas;
	private String nombreProfesor;
	
	public Alumno(String nombre, int edad, String nombreProfesor) {
		this.nombre = nombre;
		this.edad = edad;
		this.asignaturas = new ArrayList<>();
		this.nombreProfesor = nombreProfesor;
	}
	
	public Alumno() {
		this.nombre = "";
		this.edad = 0;
		this.asignaturas = new ArrayList<>();
		this.nombreProfesor = "";
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

	public ArrayList<Integer> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(ArrayList<Integer> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	public String getNombreProfesor() {
		return nombreProfesor;
	}

	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}

	public String addNota(int nota) {
		if(!maximoAsignaturas()) {
			if(sePuedeAddNota(nota)) {
				this.asignaturas.add(nota);
				return "Se ha añadido correctamente la nota";
			}else {
				return "No se puede añadir esa nota";
			}
		}else {
			return "No se pueden añadir mas notas";
		}
	}
	
	public boolean sePuedeAddNota(int num) {
		if(num >= 1 && num <= 10) {
			return true;
		}else {
			return false;
		}
	}
	
	public float notaMedia() {
		return (float)sumaNotas()/asignaturas.size();
	}
	
	public boolean maximoAsignaturas() {
		if(asignaturas.size() >= 6) {
			return true;
		}else{
			return false;
		}
	}
	
	public int sumaNotas() {
		int sum = 0;
		for(int nota: asignaturas) {
			sum += nota;
		}
		return sum;
	}
	
	public float mediana() {
		Collections.sort(asignaturas);
        float mediana;
        if (asignaturas.size() % 2 == 0) {
        	mediana = ((asignaturas.get(asignaturas.size() / 2 - 1)) + asignaturas.get(asignaturas.size() / 2)) / 2.0f;
        } else {
            mediana = (float)asignaturas.get(asignaturas.size());
        }
        return mediana;
	}
	
	public int numAsignaturas() {
		return asignaturas.size();
	}
	
	public int numSuperanNota(int notaASuperar) {
		int cont = 0;
		for(int nota: asignaturas) {
			if(nota > notaASuperar) {
				cont++;
			}
		}
		return cont;
	}
	
	public int numSuspensos() {
		int cont = 0;
		for(int nota: asignaturas) {
			if(nota < 5) {
				cont++;
			}
		}
		return cont;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", edad=" + edad + ", asignaturas=" + asignaturas + ", nombreProfesor="
				+ nombreProfesor + "]";
	}

}

