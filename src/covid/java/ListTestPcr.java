package covid.java;

import java.util.ArrayList;

public class ListTestPcr {
	private static ArrayList<TestPcr> listTestPcr = new ArrayList<>();
	
	public static void addTestPcr(TestPcr test) {
		if(test != null) {
			listTestPcr.add(test);
		}
	}
	
	public static String afficherHistorique(long id) {
		StringBuilder resultat = new StringBuilder();
		
		for(TestPcr test: listTestPcr) {
			if (test.getId_teste() == id)
				resultat.append(test.toString()+"\n");
		}
		
		return resultat.toString();
	}
}
