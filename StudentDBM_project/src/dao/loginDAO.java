package dao;

import java.sql.*;

import connectionManager.ConnectionManager;
import model.login;
public class loginDAO {
	
	public boolean loginValidation(login l) throws ClassNotFoundException, SQLException
	{
		String username = l.getUsername();
		String password = l.getPass();
		
		ConnectionManager conm = new ConnectionManager();
		Connection con = conm.establishConnection();
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from login");
		while(rs.next())
		{
			if(username.equals(rs.getString("username")) && password.equals(rs.getString("password")))
			{
				conm.closeConnection();
				return true;
			}
		}
		conm.closeConnection();
		return false;
	}
}
