package com.sathya.springbootmvc.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sathya.springbootmvc.entity.Productentity;
import com.sathya.springbootmvc.model.Productmodel;
import com.sathya.springbootmvc.service.Productservice;

import jakarta.validation.Valid;



@Controller
public class Productdetails {
	@Autowired
	Productservice productservice;
	@GetMapping("/delete/{id}")
	public String deleteproductbyid(@PathVariable Long id)	
	{
		productservice.daleteproductbyid(id);
		return "redirect:/getallproducts";
	}
	
	
	@GetMapping("/search")
	public String searchid()
	{
		return "searchproduct";
	}
	
	@PostMapping("/searchbyid")
	public String searchbyid(@RequestParam Long id,Model model) 
	{
		Productentity product=productservice.searchbyid(id);
	model.addAttribute("product",product);
	return "searchproduct";
    }

	
	@GetMapping("/getallproducts")
	public String getallproducts(Model model)
	{
		List <Productentity> products=productservice.getAllProducts();
		model.addAttribute("Products", products);
		return "productlist";
	}
	
	
	@GetMapping("/product")
	public String product()
	{
		return "product";
	}
//     @PostMapping("/saveproduct")
//     public String saveproduct(Productmodel Productmodel)
//    {
//	
//	productservice.saveproductdetails(Productmodel);
//	return "success";
//    }
     
     
     @GetMapping("/edit/{id}")
     public String editById(@PathVariable Long id,Model model)
     {
    	 Productmodel product=productservice.editById(id);
    	 model.addAttribute("product", product);
    	 model.addAttribute("id", id);
    	 return "edit-product-form";
     } 
     
     @PostMapping("/editproductsave/{id}")
     public String updateData(@PathVariable Long id, Productmodel productmodel)
     {
    	productservice.updateData(id, productmodel);
    	return "redirect:/getallproducts";
     }
     
     
     @GetMapping("/productform")
     public String getProductForm(Model model)
     {
    	Productmodel productmodel=new Productmodel();
    	productmodel.setMadeIn("India");
    	productmodel.setQuantity(2);
    	productmodel.setDiscountrate(10.5);
    	model.addAttribute("productmodel", productmodel);
    	return "add product";
     }
   @PostMapping("/saveproduct")
   public String saveproduct(@Valid Productmodel productmodel, BindingResult bindingResult,Model model)
   {
	   HashMap<String, String> validationErrors=new HashMap<String, String>();
	   if(bindingResult.hasErrors())
	   {
		   for(FieldError fieldError:bindingResult.getFieldErrors())
		   {
			   validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		   }
		   model.addAttribute("validationErrors", validationErrors);
		   return "add product";
		   }
	   productservice.saveproductdetails(productmodel);
	   return "redirect:/getallproducts";
}
}
   



 


	


