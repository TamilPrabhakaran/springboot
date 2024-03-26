package com.example.newproject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.newproject.Entity.StudentEntity;
import com.example.newproject.repository.studentrepo;
import com.example.newproject.service.StudentService;

//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.example.newproject.Entity.StudentEntity;
//import com.example.newproject.repository.studentrepo;
//import com.example.newproject.service.StudentService;

@Service
public  class serviceimpl implements StudentService {

	
	@Autowired
	studentrepo rep;
	
	public StudentEntity adduser(StudentEntity adds) {
		
		StudentEntity us = rep.save(adds);
		return us;
	}

	public List<StudentEntity> getuser() {
		
		List<StudentEntity> l =  rep.findAll();
		return l;
	}
	
	public StudentEntity showdata(StudentEntity show, @PathVariable int id) {
		
		StudentEntity s = rep.findById(id).get();
		return s;
	}

	public StudentEntity update(StudentEntity up, int id) {
		
		StudentEntity u = rep.findById(id).get();
		u.setEmail(up.getEmail());
		rep.save(u);
		return u;
	}

	public String remove(StudentEntity re, int id) {
		
		rep.deleteById(id);
		return "Deleted";
	}
	
	

	
}
 