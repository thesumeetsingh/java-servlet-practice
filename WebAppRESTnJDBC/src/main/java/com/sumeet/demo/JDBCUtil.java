package com.sumeet.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {

	
	 static {
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
	 
	 public static Connection getConnection() throws SQLException {
		 
		 String url="jdbc:mysql://localhost:3306/jdbcdemo";
		 String user= "root";
		 String pass="root";
		 Connection connect= DriverManager.getConnection(url, user, pass);
		 return connect;
	 }
	 
	 public static void closeResource(Connection connect, Statement stmt) throws SQLException {
		 if(connect!=null) {
			 connect.close();
			 System.out.println("connection closed successfully...");
		 }if(stmt!=null) {
			 stmt.close();
			 System.out.println("statement closed successfully...");
		 }
	 }
}
