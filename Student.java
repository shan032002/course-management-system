package com.unique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Student {
	static int security_key=12345;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter your reg num");
		String r_num=sc.next();
		int var=0;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/available_courses","root", "");
			Statement statement = connection.createStatement();
			 String sql = "SELECT stud_reg_num FROM admin";
		      ResultSet resultSet = statement.executeQuery(sql);
            
           
            String count;
           // System.out.println("data doesnt exits");
            while(resultSet.next()) {
            	count=resultSet.getString("stud_reg_num");
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
		if(var>0){
		System.out.println("Have you enrolled for a course");
		System.out.println("if yes write yes else write no");
		String s=sc.next();
		String m=s.toLowerCase();
		switch (m) {
		case "yes": {
			
			System.out.println("Enter your register number");
			int x=sc.nextInt();
			int falg=0;
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/available_courses","root", "");
				Statement statement = connection.createStatement();
				 String sql = "SELECT reg_num FROM student";
			      ResultSet resultSet = statement.executeQuery(sql);
	            
	           
	            int count;
	           // System.out.println("data doesnt exits");
	            while(resultSet.next()) {
	            	count=resultSet.getInt("reg_num");
	            	if(count==x) {
	            		System.out.println("data exits");
	            		falg++;
	            		break;
	            }
	            }
	            if(falg==0) {
	            	System.out.println("Please make sure!!!!!!!!  you haven't enrolled??");}
	            }
			catch(Exception e) {
				e.printStackTrace();
			}
			if(falg>0){
				System.out.println("Materials available on : https://www.google.com/");
			}
			
			break;
		}
		case "no":
		{
			System.out.println("enter the course Id");
			String c =sc.next();
			System.out.println("enter you reg num");
			int i=sc.nextInt();
			System.out.println("enter the security key to enroll");
			int key=sc.nextInt();
			if(key==security_key){
				System.out.println("you have entered the correct key proceed");
			
			//System.out.println(i +"\t"+c);
			
			try {
		        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/available_courses","root", "");
		       // System.out.println("The Courses Available in the portal \n");
		        PreparedStatement Statement = connection.prepareStatement(" insert into student (reg_num,course_enrolled)"
		                + " values (?, ?)");
		        
		             Statement.setInt(1,i);
		             Statement.setString (2,c);
		             Statement.execute();
		              
		              connection.close();
		              System.out.println("data inserted");
			}
			
		     catch (SQLException se) {
		    	se.printStackTrace();
		        } 
			}
			else {
				System.out.println("the key entered is wrong..Please check the key entered\n");
				System.out.println("***data aborted***");
			}
			
		  
			break;
			
		}
		default:
			System.out.println("Unexpected value: " + m);
		}

	}
	}

}