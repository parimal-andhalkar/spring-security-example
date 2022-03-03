package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dao.StudentRepository;
import com.model.CustomUserDetails;
import com.model.Student;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Student student = studentRepository.findByUsername(username);
		if(student == null)
		{
			throw new UsernameNotFoundException("NO_USER");
		}
		UserDetails userDetails = new CustomUserDetails(student);
		
		return userDetails;
	}

}
