package com.sumeet.demorepository;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("students")
public class StudentResource {

	 StudentsRepository repo= new StudentsRepository();
	
	 @GET
	 @Produces(MediaType.APPLICATION_XML)
	 public List<Student> getStudents() {
		 
		 return repo.getStudents();
	 }
}
