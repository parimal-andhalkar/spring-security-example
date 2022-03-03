package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.dao.StudentRepository;
import com.model.Student;

@SpringBootApplication
public class SpringSecurityApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Student s1 = new Student(11, "terry",this.bCryptPasswordEncoder.encode("2121") , "ROLE_ADMIN");
		studentRepository.save(s1);

		Student s2 = new Student(12, "bob", this.bCryptPasswordEncoder.encode("112"), "ROLE_NORMAL");
		studentRepository.save(s2);
	}
	
	
}