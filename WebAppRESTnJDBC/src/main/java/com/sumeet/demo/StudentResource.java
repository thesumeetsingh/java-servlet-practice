package com.sumeet.demo;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




@Path("students")
public class StudentResource {

		Connection connect=null;
		Statement statement=null;
		Model model= new Model();
		
		
		
		@GET
		@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
		public List<Student> getAllStudents(){
			System.out.println("fetching student data from model...");
			return model.getStudents();
		}
		
		@GET
		@Path("{username}")
		@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
		public Student getStudent(@PathParam("username") String username) {
			System.out.println("calling getstudent in model to check for USERNAME: "+username);
			return model.getStudent(username);
		}
		
		@POST
		@Path("register")
		public Student register(Student student) {
			
			model.register(student);
			return student;
		}
		
		
		@PUT
		@Path("update/{username}")
		public Student update(@PathParam("username") String username, Student student) {
			Student current= model.getStudent(username);
			if(current!=null) {
				System.out.println("student found "+current.toString());
				System.out.println("updating values...");
				model.update(username, student);
			}else {
				model.register(student);
			}
			
			
			return student;
		}
		
		@DELETE
		@Path("delete/{username}")
		public Student delete(@PathParam("username") String username) {
			Student deleted= model.deleteStudent(username);
			
			return deleted;
		}
		
		
}
