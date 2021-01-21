package covid.java.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import covid.java.Cas;

public class CasTest {
	private Cas cas;
	
	@Before
	public void init() {
		cas = new Cas();
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testCasAutoIncrement() {
		Cas test = new Cas();
		long index = test.getId_cas();
		test = new Cas();
		test = new Cas();
		assertEquals(index + 2, test.getId_cas());
	}
	
	
	@Test
	public void testNomEspaceDevant() throws WrongCovidInputException {
		exception.expect(WrongCovidInputException.class);
		cas.setNom_complet(" test");
	}
	
	@Test
	public void testNomEspaceDerriere() throws WrongCovidInputException {
		exception.expect(WrongCovidInputException.class);
		cas.setNom_complet("test ");
	}
	
	@Test
	public void testNomSansEspace() throws WrongCovidInputException {
		exception.expect(WrongCovidInputException.class);
		cas.setNom_complet("test");
	}
	
	@Test
	public void testNomCorrect() throws WrongCovidInputException {
		cas.setNom_complet("Nom Prenom");
		assertTrue(cas.getNom_complet().equals("Nom Prenom"));
	}
	
	@Test
	public void testCodePostaleNonEntier() throws NumberFormatException, WrongCovidInputException {
		exception.expect(WrongCovidInputException.class);
		cas.setCode_postale("abcde");
	}
	
	@Test
	public void testCodePostaleLongueur6() throws NumberFormatException, WrongCovidInputException {
		exception.expect(WrongCovidInputException.class);
		cas.setCode_postale("abcdef");
	}
	
	@Test
	public void testCodePostaleCorrect() throws NumberFormatException, WrongCovidInputException {
		exception.expect(WrongCovidInputException.class);
		cas.setCode_postale("31330");
	}
	
	@Test
	public void testEtatInvalide() throws WrongCovidInputException {
		exception.expect(WrongCovidInputException.class);
		cas.setEtat(3);
	}
	
	@Test
	public void testEtatCorrect() throws WrongCovidInputException {
		cas.setEtat(1);
		assertEquals(1, cas.getEtat());
	}
	
	@Test
	public void testTelephoneLongueur6() throws WrongCovidInputException {
		exception.expect(WrongCovidInputException.class);
		cas.setTelephone("123456");
	}
	
	@Test
	public void testTelephoneWrongIndicatif() throws WrongCovidInputException {
		exception.expect(WrongCovidInputException.class);
		cas.setTelephone("123456789");
	}
	
	@Test
	public void testTelephoneIndicatif00() throws WrongCovidInputException {
		cas.setTelephone("00123456789");
		assertTrue(cas.getTelephone().equals("00123456789"));
	}
	
	@Test
	public void testTelephoneIndicatifPlus() throws WrongCovidInputException {
		cas.setTelephone("+330123456789");
		assertTrue(cas.getTelephone().equals("+330123456789"));
	}
	
	@Test
	public void testTelephoneAvecEspace() throws WrongCovidInputException {
		exception.expect(WrongCovidInputException.class);
		cas.setTelephone("+3301 23456789");
	}
}
