package com.sales.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Order;
import com.sales.models.Product;
import com.sales.services.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService ps;
	
	@RequestMapping(value = "/showProducts.html")
	public String getProducts(Model model) 
	{
		ArrayList<Product> products = ps.getAllProducts();
		model.addAttribute("products", products); 
		
//		Product p = new Product();
//		
//		for(int i=0; i<products.size(); i++)
//		{
//			// update quantity stock
//			Order o = new Order();
//			int qtyInStock = p.getQtyInStock();
//			qtyInStock = p.getQtyInStock() - o.getQty();
//			p.setQtyInStock(qtyInStock);
//			
//			System.out.println("Quantity in stock: " + qtyInStock);
//		}
		
		return "showProducts";
	}
	
	@RequestMapping(value = "/addProduct.html", method=RequestMethod.GET)
	public String addProductGET(Model model) 
	{
		Product p = new Product();
		model.addAttribute("product", p);
		return "addProduct";
	}
	
	@RequestMapping(value = "/addProduct.html", method=RequestMethod.POST)
	public String addProductPOST(@Valid @ModelAttribute("product")
					Product p, BindingResult result) 
	{
		if (result.hasErrors()) {
			return "addProduct";
		}
		
		ps.save(p);
		return "redirect:showProducts.html";
	}
}