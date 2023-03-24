package main.java.ieseuropa;

public class Asignatura implements Comparable<Asignatura>{
	
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
	
	public void sumarNota(int sum) {
		this.nota += sum;
	}
	
	public void restarNota(int res) {
		this.nota -= res;
	}
	
	@Override
	public int compareTo(Asignatura asignatura) {
		return (nota < asignatura.getNota() ? 1 : nota == asignatura.getNota() ? 0 : -1);
	}

	@Override
	public String toString() {
		return "Asignatura [nota=" + nota + "]";
	}

}
