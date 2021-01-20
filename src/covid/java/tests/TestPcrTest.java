package covid.java.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import covid.java.Cas;
import covid.java.ListCas;
import covid.java.TestPcr;

public class TestPcrTest {
	private TestPcr test;
	
	@Before
	public void init() throws WrongCovidInputException {
		ListCas.addCas((new Cas("ROUTIER Paul","31330","120 chemin du factou",-1,"00100000000")));
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testJour0() throws WrongCovidInputException {
		exception.expect(WrongCovidInputException.class);
		test = new TestPcr(0,1,2000,1,1);
	}

	@Test
	public void testJour32() throws WrongCovidInputException {
		exception.expect(WrongCovidInputException.class);
		test = new TestPcr(32,1,2000,1,1);
	}
	
	@Test
	public void testFevrierBisextille30() throws WrongCovidInputException {
		exception.expect(WrongCovidInputException.class);
		test = new TestPcr(30,2,2000,1,1);
	}
	
	@Test
	public void testFevrierBisextille29() throws WrongCovidInputException {
		test = new TestPcr(29,2,2000,1,1);
		assertEquals(29, test.getJour());
	}
	
	@Test
	public void testFevrierNonBisextille28() throws WrongCovidInputException {
		test = new TestPcr(28,2,1999,1,1);
		assertEquals(28, test.getJour());
	}
	
	@Test
	public void testFevrierNonBisextille29() throws WrongCovidInputException {
		exception.expect(WrongCovidInputException.class);
		test = new TestPcr(29,2,1999,1,1);
	}
	
	@Test
	public void testMarsJour31() throws WrongCovidInputException {
		test = new TestPcr(31,3,1999,1,1);
		assertEquals(31, test.getJour());
	}
	
	@Test
	public void testAvrilJour31() throws WrongCovidInputException {
		exception.expect(WrongCovidInputException.class);
		test = new TestPcr(31,4,1999,1,1);
	}
	
	@Test
	public void testAvrilJour30() throws WrongCovidInputException {
		test = new TestPcr(30,4,1999,1,1);
		assertEquals(30, test.getJour());
	}
	
	@Test
	public void testId_testOK() throws WrongCovidInputException {
		test = new TestPcr(12,12,2000,1,1);
		assertEquals(12, test.getJour());
	}
	
	@Test
	public void testId_testKO() throws WrongCovidInputException {
		exception.expect(WrongCovidInputException.class);
		test = new TestPcr(12,12,2000,100,1);
	}
}
