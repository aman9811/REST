package com.example.demo.dao;

import com.example.demo.model.Alien;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AlienRepo extends JpaRepository<Alien, Integer>
{
	
}
