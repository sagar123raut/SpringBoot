package com.sr.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sr.springboot.entity.Grocery;
import com.sr.springboot.repository.GroceryRepository;

@Service
public class GroceryService {

	@Autowired
	GroceryRepository groceryRepository ;

	
	
	public ArrayList<Grocery> getAllGrocery(){
	
		 ArrayList<Grocery> grocery = new ArrayList<>();
		
		 groceryRepository.findAll().forEach(grocery::add);;
		return grocery;
		
	}
	
	public void addGrocery(Grocery grocery) {
		  groceryRepository.save(grocery);
		  
	}
	
	public void removeGrocery(int [] id) {
		
		 for(int i : id) {
		 groceryRepository.deleteById(i);;
		 }
	}
	
}
