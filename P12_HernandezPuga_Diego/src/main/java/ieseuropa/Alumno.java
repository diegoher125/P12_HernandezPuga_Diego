package main.java.ieseuropa;

import java.util.ArrayList;
import java.util.Collections;

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
	
	public void anadirAsignatura(int nota) {
		this.asignaturas.add(new Asignatura(nota));
	}
	
	public float notaMedia() {
		return (float)sumaNotas()/asignaturas.size();
	}
	
	public boolean maximoAsignaturas() {
		if(asignaturas.size() == 6)
			return true;
		else
			return false;
	}
	
	public int sumaNotas() {
		int sum = 0;
		for(Asignatura asignatura: asignaturas) {
			sum += asignatura.getNota();
		}
		return sum;
	}
	
	public float mediana() {
		Collections.sort(asignaturas);
        float mediana;
        if (asignaturas.size() % 2 == 0) {
        	mediana = ((asignaturas.get(asignaturas.size() / 2 - 1).getNota()) + asignaturas.get(asignaturas.size() / 2).getNota()) / 2.0f;
        } else {
            mediana = (float)asignaturas.get(asignaturas.size()).getNota();
        }
        return mediana;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", edad=" + edad + ", asignaturas=" + asignaturas + "]";
	}

}
