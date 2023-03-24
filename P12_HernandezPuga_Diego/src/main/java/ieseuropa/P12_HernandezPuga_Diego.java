package main.java.ieseuropa;

import java.util.ArrayList;

public class P12_HernandezPuga_Diego {
	
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Profesor> profesores = new ArrayList<>();

	}

}
