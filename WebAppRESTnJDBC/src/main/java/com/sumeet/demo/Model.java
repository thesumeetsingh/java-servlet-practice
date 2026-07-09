package com.sumeet.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Model {

		Connection connect=null;
		PreparedStatement pstmt=null;
		Statement statement=null;
		
		public boolean register(Student student){
			int row=0;
			try {
				connect= JDBCUtil.getConnection();
				String sqlQuery="INSERT INTO USERS(FIRSTNAME, LASTNAME, USERNAME, CITY, EMAIL, PHONE, PASSWORD) VALUES(?,?,?,?,?,?,?)";
				pstmt= connect.prepareStatement(sqlQuery);
				pstmt.setString(1,  student.getFirstname());
				pstmt.setString(2,  student.getLastname());
				pstmt.setString(3,  student.getUsername());
				pstmt.setString(4,  student.getUsercity());
				pstmt.setString(5,  student.getEmail());
				pstmt.setString(6,  student.getPhone());
				pstmt.setString(7,  student.getPassword());
				row=pstmt.executeUpdate();
				if(row>0) {
					return true;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					JDBCUtil.closeResource(connect, pstmt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return false;
		}

		public List<Student> getStudents(){
			System.out.println("inside model: getStudents");
			List<Student> studentList= new ArrayList<>();
			System.out.println("created empty LIST<STUDENT>");
			
			try {
				connect= JDBCUtil.getConnection();
				statement=connect.createStatement();
				String query="SELECT * FROM USERS";
				ResultSet rs= statement.executeQuery(query);
				
				while(rs.next()) {
					Student curr= new Student();
					curr.setFirstname(rs.getString("firstname"));
					curr.setLastname(rs.getString("lastname"));
					curr.setUsername(rs.getString("username"));
					curr.setUsercity(rs.getString("city"));
					curr.setPassword(rs.getString("password"));
					curr.setPhone(rs.getString("phone"));
					curr.setEmail(rs.getString("email"));
					
					System.out.println(curr.toString());
					
					studentList.add(curr);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
				return null;
			}finally {
				try {
					JDBCUtil.closeResource(connect, statement);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return studentList;
		}

		public Student getStudent(String username) {
			System.out.println("inside get student method in MODEL");
			try {
				connect= JDBCUtil.getConnection();
				String sqlQuery="SELECT * FROM USERS WHERE USERNAME=?";
				pstmt= connect.prepareStatement(sqlQuery);
				
				pstmt.setString(1, username );
				ResultSet rs=pstmt.executeQuery();
				
				if(rs.next()) {
					String firstname=rs.getString("firstname");
					String lastname=rs.getString("lastname");
					String city=rs.getString("city");
					String phone=rs.getString("phone");
					String email=rs.getString("email");
					String password=rs.getString("password");
					
					Student current= new Student();
					current.setFirstname(firstname);
					current.setLastname(lastname);
					current.setUsername(username);
					current.setUsercity(city);
					current.setEmail(email);
					current.setPhone(phone);
					current.setPassword(password);
					System.out.println(current.toString());
					return current;
				}
					
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					JDBCUtil.closeResource(connect, pstmt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			// TODO Auto-generated method stub
			return null;
		}

		public Student update(String username, Student student) {
			String sqlQuery="UPDATE USERS set FIRSTNAME=?, LASTNAME=? WHERE USERNAME=?";
			try {
				connect= JDBCUtil.getConnection();
				pstmt= connect.prepareStatement(sqlQuery);
				pstmt.setString(1, student.getFirstname());
				pstmt.setString(2,  student.getLastname());
				pstmt.setString(3,  username);
				int row= pstmt.executeUpdate();
				
				if(row>0) {
					System.out.println("update successfull...");
					JDBCUtil.closeResource(connect, pstmt);
					return student;
				}else {
					System.out.println("unable to update...");
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					JDBCUtil.closeResource(connect, pstmt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return new Student();
			
			
		}

		public Student deleteStudent(String username) {
			Student del= this.getStudent(username);
			String query = "DELETE FROM USERS WHERE USERNAME='" + username + "'";
			try {
				connect= JDBCUtil.getConnection();
				statement= connect.createStatement();
				int row=statement.executeUpdate(query);
				if(row>0) {
					System.out.println("deleted...");
					JDBCUtil.closeResource(connect, statement);
					return del;
					
				}else {
					System.out.println("unable to delete...");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					JDBCUtil.closeResource(connect, statement);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			return null;
			
		}
}
