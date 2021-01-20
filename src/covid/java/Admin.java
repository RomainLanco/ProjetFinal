package covid.java;

public class Admin {
	private static double nb_admins = 0;
	private double id_admin;
	private String login;
	private String password;
	
	public Admin() {
		super();
		id_admin = nb_admins++;
	}
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getId_admin() {
		return id_admin;
	}
	
	public boolean isValidAdminLogin() {
		if (this.getPassword().indexOf("orsys") == -1 || !this.getLogin().equals("admin")) {
			return false;
		} else {
			return true;
		}
	}
}
