package com.sr.springboot.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sr.springboot.entity.Grocery;
import com.sr.springboot.service.GroceryService;

@Controller
@RequestMapping(value = "grocery")
public class GrocerryController {
 
	
	@Autowired
	GroceryService groceryService ;
	
	@RequestMapping(value = "")
	public String Index(Model model) {
    	   
		 
		model.addAttribute("grocerylist",groceryService.getAllGrocery());
		model.addAttribute("title", "grocery List");
	 	
		
		//model.addAttribute("standardDate", new Date());

		// return html template form template/grocery/
		return "grocery/index";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String displayAddGroceryForm(Model model) {
       model.addAttribute("title", "Add Grocery");
		return "grocery/add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String processAddGroceryFrom(@ModelAttribute Grocery newGrocery ) {
     	  
		groceryService.addGrocery(newGrocery);
		
		// redirect to /grocery/ i.e index page ,value after : means go to that url
		return "redirect:";
	}
    
	@RequestMapping(value = "remove", method = RequestMethod.GET)
	public String displayRemoveGroceryForm(Model model) {
		model.addAttribute("grocerylist",groceryService.getAllGrocery());
        model.addAttribute("title", "Add Grocery");
		return "grocery/remove";
	}
	
	@RequestMapping(value = "remove", method = RequestMethod.POST)
	public String processRemoveGroceryForm(@RequestParam int[] groceryId) {
		
		  groceryService.removeGrocery( groceryId);
		return "redirect:/grocery/index" ;
	}
		
}













 



















