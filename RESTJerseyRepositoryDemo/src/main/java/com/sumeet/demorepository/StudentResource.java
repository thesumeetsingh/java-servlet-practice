package com.sumeet.demorepository;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("students")
public class StudentResource {

	 StudentsRepository repo= new StudentsRepository();
	
	 @GET
	 @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	 public List<Student> getStudents() {
		 
		 return repo.getStudents();
	 }
	 
	 @GET
	 @Path("student/{username}")
	 @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	 public Student getStudent(@PathParam("username") String username) {
		 return repo.getStudent(username);
	 }
	 
	 @POST
	 @Path("student")
	 public Student createStudent(Student s1) {
		 repo.add(s1);
		 repo.printStudents();
		 return s1;
		 
	 }
}
