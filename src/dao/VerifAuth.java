package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class VerifAuth {
	
	
	public static boolean IsCompteValid(String login, String password)  {
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
			try {
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return auth;
}
}