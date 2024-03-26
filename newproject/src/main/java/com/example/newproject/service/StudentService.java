package com.example.newproject.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.newproject.Entity.StudentEntity;

public interface StudentService {
	
 StudentEntity adduser(StudentEntity adds);
 
 List<StudentEntity> getuser();
 
 StudentEntity showdata(StudentEntity show, @PathVariable int id);
 
 StudentEntity update(StudentEntity up, @PathVariable int id);
 
 String remove(StudentEntity re, @PathVariable int id);
}
