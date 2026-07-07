package com.sumeet.demorest;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("aliens")
public class AliensResource {

	
	 @GET
	 @Produces(MediaType.APPLICATION_XML)
	 public List<Aliens> getAliens(){
		 Aliens a1= new Aliens();
		 Aliens a2= new Aliens();
		 
		 a1.setName("sumeet");
		 a2.setName("shweta");
		 a1.setPoints(10);
		 a2.setPoints(20);
		 
		 List<Aliens> list= Arrays.asList(a1,a2);
		 
		 return list;
				 
	 }
}
