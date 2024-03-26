package com.example.newproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.newproject.Entity.StudentEntity;

public interface studentrepo extends JpaRepository<StudentEntity, Integer>{
	
	@Query ("select u from StudentEntity u where u.name=?1 and u.email=?2")
	StudentEntity getUserByName(String name, String email);
}
