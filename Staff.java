package com.unique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Staff{
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in); 
		 System.out.println("Enter your REG NUMBER");
		 String r_num=sc.next();
			int var=0;
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/available_courses","root", "");
				Statement statement = connection.createStatement();
				 String sql = "SELECT staff_reg_num FROM admin";
			      ResultSet resultSet = statement.executeQuery(sql);
	            
	           
	            String count;
	           // System.out.println("data doesnt exits");
	            while(resultSet.next()) {
	            	count=resultSet.getString("staff_reg_num");
	            	if(count.equals(r_num)) {
	            		System.out.println("login sucess");
	            		var++;
	            		break;
	            }
	            }
	            if(var==0) {
	            	System.out.println("Please contact admin !!!!!!!!  access is not provided for you!!!!");}
	            }
			catch(Exception e) {
				e.printStackTrace();
			}
			if(var>0) {
		 System.out.println("enter the option to update or delete or upload the course"); 
		 String opt=sc.next();
		 System.out.println("enter the course code");
		 String c_code=sc.next();
		 System.out.println("enter the course name");
		 String c_name=sc.next();
		 String op=opt.toLowerCase();
		 switch(op) {
		 
		 case "insert":{
			 try {
			        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/available_courses","root", "");
			       // System.out.println("The Courses Available in the portal \n");
			        PreparedStatement Statement = connection.prepareStatement(" insert into course_list(course_code,course_name)"
			                + " values (?, ?)");
			        
			             Statement.setString(1,c_code);
			             Statement.setString (2,c_name);
			             Statement.execute();
			              
			              connection.close();
			              System.out.println("data inserted");
				}
				
			     catch (SQLException se) {
			    	se.printStackTrace();
			        } 
			 break;
				}
		 case "delete":{
			 try {
			        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/available_courses","root", "");
			       // System.out.println("The Courses Available in the portal \n");
			        PreparedStatement Statement = connection.prepareStatement(" delete from course_list where course_code=?");
			        	Statement.setString(1,c_code);
			             Statement.execute();
			              connection.close();
			              System.out.println("data removed");
				}
				
			     catch (SQLException se) {
			    	se.printStackTrace();
			        } 
			 
			 break;
		 }
		default:
			System.out.println("Please make sure tha you have enter either *delete* or *insert*");
		 }
		 }
}
}
