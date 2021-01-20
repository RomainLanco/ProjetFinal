package covid.java.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import covid.java.Admin;
import covid.java.Cas;
import covid.java.ListCas;
import covid.java.ListTestPcr;
import covid.java.TestPcr;

public class TestGlobale {

	public static void main(String[] args) throws IOException, WrongCovidInputException {
		String login;
		String password;
		int nbCas = 0;
		Admin user = new Admin();
		String line;
		Cas cas;
		String[] mots;
		int id_cas;
		
		Scanner sc = new java.util.Scanner(System.in);
		System.out.print("Login: ");
		login = sc.next();
		System.out.print("Password: ");
		password = sc.next();
		
		user.setLogin(login);
		user.setPassword(password);
		if (!user.isValidAdminLogin()) {
			System.out.println("Wrong user");
			System.exit(0);
		}
		System.out.print("Nombre de cas à saisir: ");
		nbCas = sc.nextInt();
		System.out.println();
		System.out.println("Nom complet;Code Postale;Mon adresse;Etat;Telephone");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<nbCas;i++) {
			cas = new Cas();
			line = br.readLine();
			mots = line.split(";");
			try {
				if (mots.length == 5) {
					cas.setNom_complet(mots[0]);
					cas.setCode_postale(mots[1]);
					cas.setAdresse(mots[2]);
					cas.setEtat(Integer.parseInt(mots[3]));
					cas.setTelephone(mots[4]);
				}
			} catch (WrongCovidInputException e) {
				cas = null;
				e.printStackTrace();
			}
			ListCas.addCas(cas);
		}
		System.out.println();
		System.out.println("Historique des cas: ");
		System.out.println("############");
		System.out.println(ListCas.afficher());
		
		ListTestPcr.addTestPcr(new TestPcr(12,12,2020,1,-1));
		ListTestPcr.addTestPcr(new TestPcr(12,12,2020,2,-1));
		ListTestPcr.addTestPcr(new TestPcr(12,12,2020,3,-1));
		ListTestPcr.addTestPcr(new TestPcr(18,1,2021,3,1));
		
		System.out.println();
		System.out.println("Donner l'id du cas: ");
		id_cas = sc.nextInt();
		System.out.println("Historique des tests du cas "+id_cas);
		System.out.println("############");
		System.out.println(ListTestPcr.afficherHistorique(id_cas));
		sc.close();
		
		
	}

}
