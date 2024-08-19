package Controller;
import java.sql.SQLException;


import java.util.Scanner;

import model.staffLogin;
import model.login;
import model.details;
import dao.loginDAO;
import dao.detailsDAO;
import dao.staffLoginDAO;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Scanner sc = new Scanner(System.in);
		int choice,details;
		
		staffLogin sl=new staffLogin();
		login l = new login();
		staffLoginDAO sldao =new staffLoginDAO();
		loginDAO ldao = new loginDAO();
		details p = new details();
		detailsDAO pdao = new detailsDAO();
		
		do
		{
			System.out.println("1. staff\n2. student\n3. Exit");
			System.out.println("*");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("staff Login!!!");
				System.out.println("Enter the username");
				String username = sc.next();
				System.out.println("Enter the password");
				String password = sc.next();
				sl.setUsername(username);
				sl.setPass(password);
				if(sldao.staffloginValidation(sl))
				{
					System.out.println("staff successfully logged in!!!");
					do
					{
						System.out.println("*");
						System.out.println("1. Add details\n2. Display details\n3.delete details\n4.update details\n5. Logout");
						System.out.println("*");
						System.out.println("Enter your choice");
						details = sc.nextInt();
						switch(details)
						{
						case 1:
							System.out.println("Add details");
							System.out.println("Enter Student ID");
							int studID = sc.nextInt();
							System.out.println("Enter Student Name");
							String studName = sc.next();
							System.out.println("Enter Student rollno");
							int  studroll= sc.nextInt();
							sc.nextLine();
							System.out.println("Enter Student Gmail");
							String gmail = sc.nextLine();
							System.out.println("Enter Student cgpa");
							int cgpa = sc.nextInt();
							p.setStudID(studID);
							p.setStudName(studName);
							p.setStudroll(studroll);
							p.setGmail(gmail);
							p.setCgpa(cgpa);
							pdao.adddetails(p);
							System.out.println("details added Successfully!!!");
							
							/*System.out.println("*");
							System.out.println("1. Add details\n2. Display details\n3. Logout");
							System.out.println("*");
							System.out.println("Enter your choice");
							details=sc.nextInt();*/
							break;
						case 2:
							System.out.println("student details are below:");
							pdao.display();
							/*
							System.out.println("*");
							System.out.println("1. Add details\n2. Display details\n3. Logout");
							System.out.println("*");
							System.out.println("Enter your choice");
							details=sc.nextInt();*/
							break;
						case 3:
                            System.out.println("Delete details");
                            System.out.println("Enter Student ID to delete:");
                            int deleteID = sc.nextInt();
                            pdao.delete(deleteID);
                            System.out.println("Details deleted successfully!!!");
                            
                           /* System.out.println("*");
                            System.out.println("1. Add details\n2. Display details\n3. Logout");
							System.out.println("*");
							System.out.println("Enter your choice");
							details=sc.nextInt();*/
                            break;
						case 4:
                            System.out.println("Update details");
                            System.out.println("Enter Student ID to update:");
                            int updateID = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter new Student Name:");
                            String newName = sc.nextLine();
                            System.out.println("Enter new Student Roll Number:");
                            int newRollNo = sc.nextInt();
                            sc.nextLine();                            
                            System.out.println("Enter new Student Gmail:");
                            String newGmail = sc.nextLine();
                            System.out.println("Enter new Student CGPA:");
                            int newCgpa = sc.nextInt();

                            p.setStudID(updateID);
                            p.setStudName(newName);
                            p.setStudroll(newRollNo);
                            p.setGmail(newGmail);
                            p.setCgpa(newCgpa);

                            pdao.updateDetails(p);
                            System.out.println("Details updated successfully!!!");
                            break;
						case 5:
							System.out.println("Logged out successfully!!!");
							break;
						}
					}while(details!=5);
				}
				else
				{
					System.out.println("staff failed to login!!!\nInvalid Username/Password");
				
				}
				break;
				
			case 2:
				System.out.println("student Login!!!");
				System.out.println("Enter the username");
				String username1 = sc.next();
				System.out.println("Enter the password");
				String password1 = sc.next();
				l.setUsername(username1);
				l.setPass(password1);
				if(ldao.loginValidation(l))
				{
					System.out.println("student successfully logged in!!!");
					do
					{
						System.out.println("*");
						System.out.println("1. Display details\n2. Logout");
						System.out.println("*");
						System.out.println("Enter your choice");
						details = sc.nextInt();
						switch(details)
						{
						case 1:
							System.out.println("student details are below:");
							pdao.display();
							break;
						case 2:
							System.out.println("Logged out successfully!!!");
							break;
						}
					}while(details!=2);
				}
				else
				{
					System.out.println("student failed to login!!!\nInvalid Username/Password");
				}
				break;
			case 3:
				System.out.println("Exit");
				break;
			}
		}while(choice!=3);
		sc.close();
	}
}