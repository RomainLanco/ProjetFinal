package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class VerifAuth {
	
	
	public static boolean IsCompteValid(String login, String password) {
		Connection conn = Connecteur.getConnection();
		Statement st;
		ResultSet rs;
		boolean auth=false;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from admin");
			if (rs != null) {
				
				while (rs.next()) {
					
					if(rs.getString("login").equals(login) && rs.getString("password").equals(password) ) {

						auth=true;	
					}
				
				}
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return auth;
}
}