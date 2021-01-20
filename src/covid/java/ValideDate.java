package covid.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class ValideDate {
	private final static Set<Integer> mois31 = new HashSet<>(Arrays.asList(1,3,5,7,8,10,12));
	private final static Set<Integer> mois30 = new HashSet<>(Arrays.asList(4,6,9,11));
	
	public static boolean isValide(int jour, int mois, int annee) {

		if (mois <1 || mois >12)
			return false;
		if (jour < 1)
			return false;
		if (mois31.contains(mois) && jour >31)
			return false;
		if (mois30.contains(mois) && jour >30)
			return false;
		if (mois == 2 && annee % 4 == 0 && jour > 29)
			return false;
		if (mois == 2 && annee % 4 != 0 && jour > 28)
			return false;
		return true;
	}
	
}
