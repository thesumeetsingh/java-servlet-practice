package com.sumeet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentResource {

	
	
	@GetMapping("students")
	public List<Student> getStudent(){
		List<Student> list= new ArrayList<>();
		
		Student s1= new Student();
		s1.setFirstname("sumeet");
		s1.setLastname("Singh");
		s1.setUsername("sumeetsingh");
		s1.setUsercity("raigarh");
		s1.setPassword("sumeetsingh");
		s1.setEmail("sumeet@sumeet.com");
		s1.setPhone("1231231231");
		
		Student s2= new Student();
		s2.setFirstname("sumeetasd");
		s2.setLastname("Singhasd");
		s2.setUsername("sumeetsinghasd");
		s2.setUsercity("raigarhasd");
		s2.setPassword("sumeetsinghasd");
		s2.setEmail("sumeet@sumeet.comasd");
		s2.setPhone("1231231231asd");
		
		list.add(s1);
		list.add(s2);
		
		
		
		return list;
	}
}
