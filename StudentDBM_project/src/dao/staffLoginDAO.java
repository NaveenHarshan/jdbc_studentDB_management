package dao;

import java.sql.*;

import connectionManager.ConnectionManager;
import model.staffLogin;
public class staffLoginDAO {
	public boolean staffloginValidation(staffLogin sl) throws ClassNotFoundException, SQLException
	{
		String username = sl.getUsername();
		String password = sl.getPass();
		
		ConnectionManager conm = new ConnectionManager();
		Connection con = conm.establishConnection();
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from staffLogin");
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
