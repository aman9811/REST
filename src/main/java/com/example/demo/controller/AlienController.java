package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@RestController
public class AlienController
{
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
     public String home()
     {
    	 return "home.jsp";
     }
     
	@DeleteMapping("/alien/{aid}")   //Code to  delete data
	public String deleteAlien(@PathVariable int aid)
	{
		Alien a = repo.getOne(aid);
		
		repo.delete(a);
		
		return "deleted";
		
		
	}
     
	@PostMapping(path="/alien",consumes= {"application/json"})  // code to Insert data
	public Alien addAlien(@RequestBody Alien alien) 
	{
		repo.save(alien);
		return alien;
	}
	
	@GetMapping(path="/aliens")     // Code to Retrieve data
	@ResponseBody
	public java.util.List<Alien> getAlien()
	{
	
		return repo.findAll();
	}
	
	@PutMapping(path="/alien",consumes= {"application/json"})  // Code to Update data
	public Alien saveOrUpdateAlien(@RequestBody Alien alien) 
	{
		repo.save(alien);
		return alien;
	}
	
	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public Optional<Alien> getAlien(@PathVariable("aid")int aid)
	{
	
		return repo.findById(aid);
	}
}
