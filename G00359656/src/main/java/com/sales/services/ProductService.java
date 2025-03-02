package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Customer;
import com.sales.models.Product;
import com.sales.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository pr;
	
	public ArrayList<Product> getAllProducts() {
		
		return (ArrayList<Product>)pr.findAll();
		
	}
	
	public void save(Product p)
	{
		pr.save(p);
	}

}
