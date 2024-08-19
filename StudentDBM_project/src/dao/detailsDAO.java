package dao;

import java.sql.*;
import connectionManager.ConnectionManager;
import model.details;

public class detailsDAO {
	public void adddetails(details p) throws ClassNotFoundException, SQLException
	{
		int studID=p.getStudID();
		String studName=p.getStudName();
		int studroll=p.getStudroll();
		String gmail=p.getGmail();
		int cgpa=p.getCgpa();
		
		ConnectionManager conm = new ConnectionManager();
		Connection con = conm.establishConnection();
		
		String query = "insert into studentdetails values (?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1,studID);
		ps.setString(2, studName);
		ps.setInt(3,studroll);
		ps.setString(4,gmail);
		ps.setInt(5,cgpa);
		
		ps.executeUpdate();
		
		conm.closeConnection();
	}
	public void updateDetails(details p) throws ClassNotFoundException, SQLException {
	    int studID = p.getStudID();
	    String studName = p.getStudName();
	    int studroll = p.getStudroll();
	    String gmail = p.getGmail();
	    int cgpa = p.getCgpa();

	    ConnectionManager conm = new ConnectionManager();
	    Connection con = conm.establishConnection();

	    String query = "UPDATE studentdetails SET student_name = ?, student_rollno = ?, gmail_id = ?, student_cgpa = ? WHERE student_id = ?";

	    PreparedStatement ps = con.prepareStatement(query);
	    ps.setString(1, studName);
	    ps.setInt(2, studroll);
	    ps.setString(3, gmail);
	    ps.setInt(4, cgpa);
	    ps.setInt(5, studID);

	    int rowsAffected = ps.executeUpdate();

	    if (rowsAffected > 0) {
	        System.out.println("Student record updated successfully.");
	    } else {
	        System.out.println("No student found with the given ID.");
	    }

	    ps.close();
	    con.close();
	}

	
	public void delete(int studentId) throws ClassNotFoundException, SQLException {
	    ConnectionManager conm = new ConnectionManager();
	    Connection con = conm.establishConnection();
	    
	    String query = "DELETE FROM studentdetails WHERE student_id = ?";
	    
	    PreparedStatement ps = con.prepareStatement(query);
	    
        ps.setInt(1, studentId);
	    
	    int rowsAffected = ps.executeUpdate();
	    
	    if (rowsAffected > 0) {
	        System.out.println("Student record deleted successfully.");
	    } else {
	        System.out.println("No student found with the given ID.");
	    }
	    
	    ps.close();
	    con.close();
	}
	
	public void display() throws ClassNotFoundException, SQLException
	{
		ConnectionManager conm = new ConnectionManager();
		Connection con = conm.establishConnection();
		
		Statement st = con.createStatement();
		ResultSet rs1 = st.executeQuery("select * from studentdetails");
		while(rs1.next())
		{
			System.out.println(rs1.getInt("student_id")+" | "+rs1.getString("student_name")+" | "+rs1.getInt("student_rollno")+" | "+rs1.getString("gmail_id")+" | "+rs1.getInt("student_cgpa"));
		}
	}
	
}