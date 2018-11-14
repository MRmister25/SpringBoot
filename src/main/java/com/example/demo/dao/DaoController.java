package com.example.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.UserDetails;

import java.util.*;



	public interface DaoController extends CrudRepository<UserDetails,Integer>{

		//List<UserDetails> findByUsername(String username);
		
		@Query("from UserDetails where email=?1 and password=?2")
		List<UserDetails> loginchecker(String email,String password);
	}

