package com.sumeet.demorepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentsRepository {

	
	 List<Student> students= new ArrayList();;
	 
	 StudentsRepository(){
		 Student s1= new Student();
		 s1.setUsername("sumeetsingh");
		 s1.setName("sumeet singh");
		 s1.setUsercity("raigarh");

		 Student s2= new Student();
		 s2.setUsername("asdasd");
		 s2.setName("asd");
		 s2.setUsercity("raisad");

		 students.add(s1);
		 students.add(s2);
		 
		
	 }
	 
	 public List<Student> getStudents() {
		 return students;
	 }
	 
	 public Student getStudent(String id) {
		 
		 for(Student s: students) {
			 if(s.getUsername().equals(id)) {
				 return s;
			 }
		 }
		 
		 return null;
	 }

	 public void add(Student s1) {
		// TODO Auto-generated method stub
		students.add(s1);
	 }
	 
	 public void printStudents() {
		 for(Student s: students) {
			 System.out.println(s.getName());
		 }
	 }

	 @Override
	 public String toString() {
		return "StudentsRepository [students=" + students + "]";
	 }
	 
	 
}
