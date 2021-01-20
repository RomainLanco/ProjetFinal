package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import covid.java.Cas;
import covid.java.ListCas;
import covid.java.TestPcr;
import covid.java.tests.WrongCovidInputException;



public class Model {
	public static ArrayList<Cas> listeCas ;
	public static Connection conn = Connecteur.getConnection();
	private static ArrayList<TestPcr> listePcr;
	
//	public static ArrayList<Produit> filtreProduit(int idCat){
//		ArrayList<Produit> listFiltre = new ArrayList<Produit>();
//		liste = versCollection();
//		
//		for(Produit p : liste) {
//			if(p.getIdCat()==idCat) {
//				listFiltre.add(p);
//			}
//		}
//		return listFiltre;
//	}
	
	public static ArrayList<Cas> getListeCas() {
		listeCas=versCollectionCas();
		return listeCas;
	}
	public static ArrayList<TestPcr> getListePcr(int id_database) {
		listePcr=versCollectionPcr(id_database);
		return listePcr;
	}

	public static void setListe(ArrayList<Cas> liste) {
		Model.listeCas = liste;
	}

	public static Connection getConn() {
		return conn;
	}

	public static void setConn(Connection conn) {
		Model.conn = conn;
	}
	

	public static void ajouterCas(Cas p) {
		try {
			//Statement st = conn.createStatement();
			PreparedStatement prst = conn.prepareStatement(
					"insert into cas(nom_complet, telephone, adresse, code_postale , etat) value(?,?,?,?,?)");
//			prst.setInt(1, Cas.getNb_cas());
			prst.setString(2, p.getNom_complet());
			prst.setString(3, p.getTelephone());
			prst.setString(4, p.getAdresse());
			prst.setString(5, p.getCode_postale());
			prst.setDouble(6, p.getEtat());
			
			prst.execute();
			listeCas = versCollectionCas();
		} catch (SQLException excep) {
			excep.printStackTrace();
		}

	}
	
	public static void ajouterTestPcr(TestPcr p) {
		try {
			//Statement st = conn.createStatement();
			PreparedStatement prst = conn.prepareStatement(
					"insert into testpcr(jour, mois, annee, resultat , id_cas) value(?,?,?,?,?)");

			prst.setInt(1, p.getJour());
			prst.setInt(2, p.getMois());
			prst.setInt(3, p.getAnnee());
			prst.setInt(4, p.getResultat());
			prst.setInt(5, p.getId_teste());
			
			prst.execute();
//			listePcr = versCollectionPcr();
		} catch (SQLException excep) {
			excep.printStackTrace();
		}

	}

//	public static Participant chercherParticipant(String login, String pwd) {
//		for (Participant p : liste) {
//			if (p.getLogin().equals(login) && p.getPwd().equals(pwd))
//				return p;
//		}
//		return null;
//	}
	
	public static Cas chercherCas(int id_database) {
		listeCas=versCollectionCas();
		for (Cas p : listeCas) {
			
			if (p.getId_database()==id_database)
				return p;
		}
		return null;
	}

//	public static void modifierProduit(int id, Produit nvp) {
//		PreparedStatement prst = null;
//		ResultSet rs = null;
//		try {
//			prst = conn.prepareStatement(
//					"update produit set description = ?, id_cat=?, image=?,ingredients=?, nom=?,poid=?,pourcentage_alcool=?,prix=?,volume=? where id= ?");
//			prst.setString(5, nvp.getNom());
//			prst.setString(1, nvp.getDescription());
//			prst.setString(4, nvp.getIngredient());
//			prst.setString(3, nvp.getImage());
//			prst.setDouble(8, nvp.getPrix());
//			
//			switch(nvp.getIdCat()) {
//			case 1 : 
//				//Aliment
//				System.out.println(" modif getIdcat est : "+nvp.getIdCat());
//				System.out.println("nom est : "+nvp.getNom());
//				prst.setDouble(6, ((Aliment)nvp).getPoid());
//				prst.setString(7, null);
//				prst.setString(9, null);
//				break;
//			case 2 : 
//				//Boisson
//				
//				prst.setString(6, null);
//				prst.setDouble(9, ((Boisson)nvp).getVolume());
//				prst.setString(7, null);
//				break;
//			case 3 : 
//				//Boisson18
//				
//				prst.setString(6, null);
//				prst.setDouble(9, ((Boisson)nvp).getVolume());
//				prst.setDouble(7, ((Boisson18)nvp).getPourcentageAlcool());
//				break;
//				
//			}
//			prst.setInt(2, nvp.getIdCat());
//			
//			prst.setInt(10, id);
//
//			prst.executeUpdate();
//			liste = versCollection();
//
//		} catch (NumberFormatException | SQLException e) {
//			e.getStackTrace();
//		}
//	}

	public static ArrayList<Cas> versCollectionCas() {
		Connection conn = Connecteur.getConnection();
		Statement st;
		ResultSet rs;
		ArrayList<Cas> listec = new ArrayList<Cas>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from cas");
			if (rs != null) {
				while (rs.next()) {
					Cas cas1;
					try {

					String nom = rs.getString("nom_complet");
					String adresse = rs.getString("adresse");
					String code = rs.getString("code_postale");
					String tel = rs.getString("telephone");
					int etat= rs.getInt("etat");
					int id_database = rs.getInt("id_cas");
					
					cas1= new Cas(nom, code, adresse, etat, tel);
					cas1.setId_database(id_database);
					listec.add(cas1);
						} catch (WrongCovidInputException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						}

						
					}
				
				}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listec;
	}

	
	public static ArrayList<TestPcr> versCollectionPcr(int id_database) {
		Connection conn = Connecteur.getConnection();
		Statement st;
		ResultSet rs;
		ArrayList<TestPcr> listec = new ArrayList<TestPcr>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from testpcr where id_cas="+id_database);
			if (rs != null) {
				while (rs.next()) {
					TestPcr test1;
					try {

					int jour = rs.getInt("jour");
					int mois = rs.getInt("mois");
					int annee = rs.getInt("annee");
					int resultat = rs.getInt("resultat");
					int idCas= rs.getInt("id_cas");
					
					test1= new TestPcr(jour, mois, annee, idCas, resultat);
					listec.add(test1);
						} catch (WrongCovidInputException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						}

						
					}
				
				}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listec;
	}
//	public static void supprimerProduit(double id) {
//		PreparedStatement prst = null;
//		try {
//			prst = conn.prepareStatement("delete from produit where id = ?");
//			prst.setDouble(1, id);
//			System.out.println("je veux supprimer "+id);
//			prst.executeUpdate();
//			liste = versCollection();
//		} catch (NumberFormatException | SQLException e) {
//			e.printStackTrace();
//		}
//	}


//	public static ArrayList<String> getListeGroupes(){
//		ResultSet rs = null;
//		Statement st=null;
//		ArrayList<String> listeg = new ArrayList<String>();
//		try {
//			st = conn.createStatement();
//			
//			rs = st.executeQuery("select code_groupe from groupe");
//			if (rs != null) {
//				while (rs.next()) {
//					listeg.add(rs.getString("code_groupe"));					
//				}
//			}
//		}catch(SQLException e) {
//			e.getMessage();
//		}
//		return listeg;
//
//	}
	
}
