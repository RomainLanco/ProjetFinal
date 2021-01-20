package covid.java;

import java.util.ArrayList;

public class ListCas {
	private static ArrayList<Cas> listCas = new ArrayList<>();
	
	public static void addCas(Cas cas) {
		if(cas != null) {
			listCas.add(cas);
		}
	}
	
	public static boolean checkID(long Id) {
		for(Cas cas: listCas) {
			if (cas.getId_cas() == Id) {
				return true;
			}
		}
		return false;
	}
	
	public static String afficher() {
		StringBuilder resultat = new StringBuilder();
		
		for(Cas cas: listCas) {
			resultat.append(cas.toString()+"\n");
		}
		
		return resultat.toString();
	}
}
