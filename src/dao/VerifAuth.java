package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class VerifAuth {
	
	
	public static boolean IsCompteValid(String login, String password) throws SQLException  {
		Connection conn = Connecteur.getConnection();
		Statement st = null;
		ResultSet rs = null;
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
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		finally {
			conn.close();
			
		}
		
		
		
		return auth;
}
}