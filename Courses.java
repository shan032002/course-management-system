package com.unique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Courses {
			public static void main(String[] args) {
				 Scanner sc = new Scanner(System.in);  
				 try {
			        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/available_courses","root", "");
			        System.out.println("The Courses Available in the portal \n");
			        Statement statement = connection.createStatement();
			        String sql = "SELECT course_code,course_name FROM course_list order by course_code";
			        ResultSet resultSet = statement.executeQuery(sql);
			        System.out.println("******************************************************************************************");
			        System.out.println("course_code \t course_name");
			        while (resultSet.next()) {
			            int c_code=resultSet.getInt("course_code");
			            
			            String c_name = resultSet.getString("course_name");
			           
			            System.out.print(c_code+"\t\t");
			            System.out.print(c_name+"\n");
			        }
			        System.out.println("******************************************************************************************");
			        resultSet.close();
			        statement.close();
			        connection.close();
			    } catch (SQLException se) {
			    	se.printStackTrace();
			        }
			}
}
