package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Student;

@Service
public class StudentService {

	List<Student> list = new ArrayList<>();
	
	{
		list.add(new Student(11, "parimal", "abc", "Admin"));
		list.add(new Student(12, "raj", "123", "Normal"));
	}

	public Student getStudent(int id) {
		Student st = null;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				st = list.get(i);
			}
		}
		return st;
	}

	public List<Student> getAllStudents() {
		return list;
	}

	public Student addStudent(Student s) {

		list.add(s);

		return s;
	}

}
