package main.java.ieseuropa;

public class Asignatura {
	
	private int nota;
	
	public Asignatura(int nota) {
		this.nota = nota;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Asignatura [nota=" + nota + "]";
	}

}
