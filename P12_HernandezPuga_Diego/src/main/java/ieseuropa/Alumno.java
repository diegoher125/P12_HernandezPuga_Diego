package main.java.ieseuropa;

import java.util.ArrayList;
import java.util.Collections;

public class Alumno {
	
	private String nombre;
	private int edad;
	private ArrayList<Integer> asignaturas;
	
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

	public ArrayList<Integer> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(ArrayList<Integer> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	public void addNota(int nota) {
		if(!maximoAsignaturas() && sePuedeAddNota(nota)) {
			this.asignaturas.add(nota);
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

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", edad=" + edad + ", asignaturas=" + asignaturas + "]";
	}

}
