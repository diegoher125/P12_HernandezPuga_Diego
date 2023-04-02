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

	private static ArrayList<String> listaEtapas() {
		ArrayList<String> etapas = new ArrayList<>();
		etapas.add("Secundaria");
		etapas.add("Bachillerato");
		etapas.add("SMR");
		etapas.add("DAW");
		etapas.add("DAM");
		return etapas;
	}

	private static boolean esEtapaCorrecta(String etapa) {
		if (listaEtapas().contains(etapa))
			return true;
		else
			return false;
	}

	private static boolean esCursoCorrecto(String etapa, int curso) {
		if (etapa.equals("Secundaria")) {
			if (curso >= 1 && curso <= 4) {
				return true;
			} else {
				return false;
			}
		} else {
			if (curso == 1 || curso == 2) {
				return true;
			} else {
				return false;
			}
		}
	}

	private static String nombreProfesor(ArrayList<Profesor> profesores) {
		String nombre = "";
		do {
			nombre = pedirString("Escriba el nombre del profesor");
		} while (profesores.contains(new Profesor(nombre)));
		return nombre;
	}

	private static String pedirEtapa(String nombre) {
		String etapa = "";
		do {
			etapa = pedirString("Introduzca la etapa de la cual es tutor " + nombre);
		} while (!esEtapaCorrecta(etapa));
		return etapa;
	}

	private static int pedirCurso(String etapa, String nombre) {
		int curso = 0;
		do {
			curso = pedirInt("Introduzca el curso del cual es tutor " + nombre);
		} while (!esCursoCorrecto(etapa, curso));
		return curso;
	}

	private static Profesor nuevoProfesor(ArrayList<Profesor> profesores) {
		String nombre = nombreProfesor(profesores);
		String etapa = pedirEtapa(nombre);
		int curso = pedirCurso(etapa, nombre);
		return new Profesor(nombre, etapa, curso);
	}

	private static ArrayList<Profesor> addAlumnos(ArrayList<Profesor> profesores) {
		String qh = "";
		for (Profesor profesor : profesores) {
			System.out.println("A continuación, introduciremos las notas de la clase " + profesor.getCurso() + " "
					+ profesor.getEtapa() + ":");
			while (!qh.equals("0")) {
				qh = pedirString("¿Quieres añadir un nuevo alumno?(0 si es que no)");
				if (!qh.equals("0") && !profesor.maximoAlumnos()) {
					profesor.addAlumno(nuevoAlumno(profesores.indexOf(profesor), profesor.getNombre()));
				}
			}
		}
		return profesores;
	}

	private static Alumno crearAlumno(int num, String nombreP) {
		String nombre = pedirString("Introduzca el nombre del alumno " + (num + 1));
		int edad = 0;
		while (edad < 11 || edad > 80) {
			edad = pedirInt("Introduzca la edad de " + nombre);
		}
		return new Alumno(nombre, edad, nombreP);
	}

	private static Alumno nuevoAlumno(int num, String nombreP) {
		Alumno alumno = crearAlumno(num, nombreP);
		int nota = -1;
		while (nota != 0) {
			nota = pedirInt("Introduzca la nota de " + alumno.getNombre());
			System.out.println(alumno.addNota(nota));
		}
		return alumno;
	}

	private static ArrayList<Profesor> crearCurso() {
		ArrayList<Profesor> profesores = new ArrayList<>();
		String qh = "";
		while (!qh.equals("0")) {
			qh = pedirString("¿Quieres añadir un nuevo profesor?(0 si es que no)");
			if (!qh.equals("0")) {
				profesores.add(nuevoProfesor(profesores));
			}
		}
		return profesores;
	}

	private static void imprimirMediaMax(ArrayList<Profesor> profesores) {
		for (Profesor profesor : profesores) {
			System.out.println(profesor.maximaNotaMedia());
		}
		System.out.println();
	}

	private static void imprimirMediaMaxInstituto(ArrayList<Profesor> profesores) {
		Alumno alumnoMax = new Alumno();
		for (Profesor profesor : profesores) {
			if (alumnoMax.notaMedia() < profesor.alumnoMaximaNotaMedia().notaMedia()) {
				alumnoMax = profesor.alumnoMaximaNotaMedia();
			}
		}
		System.out.println("La nota media maxima es de " + alumnoMax.getNombre() + " con un "
				+ (Math.round(alumnoMax.notaMedia() * 100.0) / 100.0) + " de "
				+ profesores.get(profesores.indexOf(new Profesor(alumnoMax.getNombreProfesor()))).getCurso() + " "
				+ profesores.get(profesores.indexOf(new Profesor(alumnoMax.getNombreProfesor()))).getEtapa()
				+ " cuyo profesor es " + alumnoMax.getNombreProfesor());
	}

	private static void imprimirMediaMin(ArrayList<Profesor> profesores) {
		for (Profesor profesor : profesores) {
			System.out.println(profesor.minimaNotaMedia());
		}
		System.out.println();
	}

	private static void imprimirMedianas(ArrayList<Profesor> profesores) {
		for (Profesor profesor : profesores) {
			System.out.println(profesor.medianasAlumnos());
		}
		System.out.println();
	}

	private static void imprimirSuspensos(ArrayList<Profesor> profesores) {
		for (Profesor profesor : profesores) {
			System.out.println(profesor.suspensosClase());
		}
		System.out.println();
	}

	private static void imprimirMediaTotal(ArrayList<Profesor> profesores) {
		int[] array = new int[2];
		for (Profesor profesor : profesores) {
			array[0] += profesor.sumaNotasAlumnos();
			array[1] += profesor.getAlumnos().size();
		}
		float mediaTotal = (float) array[0] / array[1];
		int numSuperanMT = numSuperanMediaTotal(profesores, mediaTotal);
		System.out.println("La media de todos los alumnos es" + (Math.round(mediaTotal * 100.0) / 100.0)
				+ ", superada por el " + (Math.round(((numSuperanMT * 100) / array[1]) * 100.0) / 100.0)
				+ "% de los alumnos (" + numSuperanMT + " de " + array[1] + ")\n");
	}

	private static int numSuperanMediaTotal(ArrayList<Profesor> profesores, float mediaTotal) {
		int numSuperanMT = 0;
		for (Profesor profesor : profesores) {
			numSuperanMT += profesor.alumnosSuperanMediaTotal(mediaTotal);
		}
		return numSuperanMT;
	}

	private static void imprimirTotalSuperanNota(ArrayList<Profesor> profesores, int notaASuperar) {
		float totalNotas = 0;
		float asigSuperanX = 0;
		for (Profesor profesor : profesores) {
			totalNotas += (float) profesor.numTotalAsignaturas();
			asigSuperanX += (float) profesor.numTotalSuperanNota(notaASuperar);
		}
		System.out.println("La nota de " + notaASuperar + " se ha superado en el "
				+ (Math.round(((asigSuperanX * 100) / totalNotas) * 100.0) / 100.0) + "% de asignaturas, en "
				+ asigSuperanX + " de " + totalNotas + " calificaciones");
	}

	private static void imprimirTodo(ArrayList<Profesor> profesores, int notaASuperar) {
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("Los resultados son los siguientes");
		imprimirMediaMax(profesores);
		imprimirMediaMin(profesores);
		imprimirMediaMaxInstituto(profesores);
		imprimirMedianas(profesores);
		imprimirSuspensos(profesores);
		imprimirMediaTotal(profesores);
		imprimirTotalSuperanNota(profesores, notaASuperar);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Profesor> profesores = new ArrayList<>();
		profesores = crearCurso();
		int notaASuperar = 0;
		notaASuperar = pedirInt("Indique la nota a superar en las asignaturas:");
		profesores = addAlumnos(profesores);
		imprimirTodo(profesores, notaASuperar);
	}

}