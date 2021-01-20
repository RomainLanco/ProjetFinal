package covid.java.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import covid.java.Admin;

public class AdminTest {
	private Admin admin;
	
	@Before
	public void init() {
		admin = new Admin();
	}
	
	@Test
	public void testWrongLogin() {
		admin.setLogin("toto");
		admin.setPassword("aorsysb");
		assertFalse(admin.isValidAdminLogin());
	}
	
	@Test
	public void testWrongPassword() {
		admin.setLogin("admin");
		admin.setPassword("test");
		assertFalse(admin.isValidAdminLogin());
	}

	@Test
	public void testCorrectAdmin() {
		admin.setLogin("admin");
		admin.setPassword("monorsyspass");
		assertTrue(admin.isValidAdminLogin());
	}
}
