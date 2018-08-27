package com.sr.springboot.repository;

import org.springframework.data.repository.CrudRepository;


import com.sr.springboot.entity.Grocery;

public interface GroceryRepository  extends CrudRepository<Grocery, Integer>{

}
