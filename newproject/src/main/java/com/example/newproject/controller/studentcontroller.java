package com.example.newproject.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.newproject.Entity.StudentEntity;
import com.example.newproject.repository.studentrepo;
import com.example.newproject.service.StudentService;



@RestController
@RequestMapping("/create")

public class studentcontroller {
	
	@GetMapping("/demo")
	public String addone() {
		
		return "Hello world";
	}
	
	@Autowired
	studentrepo stdre;
	
	@Autowired
	StudentService serv;
	
	@PostMapping("/add")
	public StudentEntity add(@RequestBody StudentEntity use) {
		
		StudentEntity stdadd = serv.adduser(use);
	
		return stdadd;
	}
	
//	http://localhost:8088/create/post
	@PostMapping("/post")
	public StudentEntity postadd(@RequestBody StudentEntity std)
	{
		StudentEntity s = stdre.save(std);
	    return s;	
	}
	
	@GetMapping("/list")   //Show the All Data 
	public List<StudentEntity> stdlist()
	{
		List<StudentEntity> stdlist = serv.getuser();
		return stdlist;
	}
	
	@GetMapping("/getuser/{id}")    //Show the Particular data
	
	public StudentEntity single( StudentEntity one, @PathVariable int id) {
		
		return serv.showdata(one, id);
	}
	
	@PostMapping("/update/{id}")
	public String updatestd(@RequestBody StudentEntity supdate, @PathVariable int id) {
		
		serv.update(supdate, id);
		return "Update Successfull";
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@RequestBody StudentEntity sdelete, @PathVariable int id) {
		
		serv.remove(sdelete, id);
		return "Delete Successfull";
	}
	
	@GetMapping("/delete1/{id}")
	
	public ResponseEntity <?> username(@PathVariable int id){
		stdre.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK)
				.body("Delete Done");
	}
	
	@GetMapping("/getuser/{name}/{email}")    //Show the Particular Row data
	public ResponseEntity <?>  single(@PathVariable String name,@PathVariable String email) {
		
		StudentEntity us = stdre.getUserByName(name,email);
		if(us!=null)
		{
			return ResponseEntity.status(HttpStatus.OK)
					.body(us);
		}
		else
			return ResponseEntity.status(HttpStatus.OK)
					.body("User NAme is invalid");
			
	}
		
}
