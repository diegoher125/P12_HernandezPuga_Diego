package main.java.ieseuropa;

import java.util.ArrayList;
import java.util.Scanner;

public class P12_HernandezPuga_Diego {
	
	private static String pedirString(String texto) {
		Scanner teclado = new Scanner(System.in);
		System.out.println(texto);
		return teclado.nextLine();
	}

	private static int pedirInt(String texto) {
		Scanner teclado = new Scanner(System.in);
		System.out.println(texto);
		return teclado.nextInt();
	}
	
	private static ArrayList<String> listaEtapas(){
		ArrayList<String> etapas = new ArrayList<>();
		etapas.add("Secundaria");
		etapas.add("Bachillerato");
		etapas.add("SMR");
		etapas.add("DAW");
		etapas.add("DAM");
		return etapas;
	}
	
	private static boolean esEtapaCorrecta(String etapa) {
		if(listaEtapas().contains(etapa))
			return true;
		else
			return false;
	}
	
	private static boolean esCursoCorrecto(String etapa, int curso) {
		if(etapa.equals("Secundaria")) {
			if(curso >= 1 && curso <= 4) {
				return true;
			}else {
				return false;
			}
		}else {
			if(curso == 1 || curso == 2) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	private static String nombreProfesor(ArrayList<Profesor> profesores) {
		String nombre = "";
		do {
			nombre = pedirString("Escriba el nombre del profesor");
		}while(profesores.contains(new Profesor(nombre)));
		return nombre;
	}
	
	private static String pedirEtapa(String nombre) {
		String etapa = "";
		do {
			etapa = pedirString("Introduzca la etapa de la cual es tutor " + nombre);
		}while(!esEtapaCorrecta(etapa));
		return etapa;
	}
	
	private static int pedirCurso(String etapa, String nombre) {
		int curso = 0;
		do {
			curso = pedirInt("Introduzca el curso del cual es tutor " + nombre);
		}while(!esCursoCorrecto(etapa,curso));
		return curso;
	}
	
	private static Profesor nuevoProfesor(ArrayList<Profesor> profesores) {
		String nombre = nombreProfesor(profesores);
		String etapa = pedirEtapa(nombre);
		int curso = pedirCurso(etapa,nombre);
		return new Profesor(nombre, etapa, curso);
	}
	
	private static ArrayList<Profesor> addAlumnos(ArrayList<Profesor> profesores){
		for(Profesor profesor: profesores) {
			while(!profesor.maximoAlumnos()) {
				profesor.addAlumno(nuevoAlumno());
			}
		}
		return profesores;
	}
	
	private static Alumno crearAlumno() {
		String nombre = pedirString("Introduzca el nombre del alumno");
		int edad = pedirInt("Introduzca la edad de " + nombre);
		return new Alumno(nombre,edad);
	}
	
	private static Alumno nuevoAlumno() {
		Alumno alumno = crearAlumno();
		int nota = 0;
		do {
			nota = pedirInt("Introduzca la nota de " + alumno.getNombre());
			alumno.addAsignatura(nota);
		}while(nota != 0 || !alumno.maximoAsignaturas());
		return alumno;
	}
	
	private static ArrayList<Profesor> crearCurso(){
		ArrayList<Profesor> profesores = new ArrayList<>();
		String qh = "";
		while(!qh.equals("0")) {
			qh = pedirString("¿Quieres añadir un nuevo profesor?(0 si es que no)");
			profesores.add(nuevoProfesor(profesores));
			profesores = addAlumnos(profesores);
		}
		return profesores;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Profesor> profesores = crearCurso();
		
		
	}

}
