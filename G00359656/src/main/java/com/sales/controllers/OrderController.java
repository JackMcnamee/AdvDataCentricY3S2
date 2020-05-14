package com.sales.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.exceptions.QuantityException;
import com.sales.models.Customer;
import com.sales.models.Order;
import com.sales.models.Product;
import com.sales.services.CustomerService;
import com.sales.services.OrderService;
import com.sales.services.ProductService;

@Controller
public class OrderController {

	@Autowired
	OrderService os;
	
	@Autowired
	CustomerService cs;
	
	@Autowired
	ProductService ps;
	
	@RequestMapping(value = "/showOrders.html")
	public String getOrders(Model model) 
	{
		ArrayList<Order> orders = os.getAllOrders();
		model.addAttribute("orders", orders); 
		
		return "showOrders";
	}
	
	@RequestMapping(value = "/newOrder.html", method=RequestMethod.GET)
	public String newOrderGET(Model model) 
	{
		ArrayList<Customer> customers = cs.getAllCustomers();
		
		Map<Long, String> customersList = new LinkedHashMap<Long, String>();
		
		for(Customer c : customers) 
		{
			customersList.put(c.getcId(), c.getcName());
		}
		
		model.addAttribute("customersList", customersList);
		
		ArrayList<Product> products = ps.getAllProducts();
		
		Map<Long, String> productsList = new LinkedHashMap<Long, String>();
		
		for(Product p : products) 
		{
			productsList.put(p.getpId(), p.getpDesc());
		}
		
		model.addAttribute("productsList", productsList);
		
		Order o = new Order();
		model.addAttribute("order", o);
		
		return "newOrder";
	}
	
	@RequestMapping(value = "/newOrder.html", method=RequestMethod.POST)
	//@ExceptionHandler({QuantityException.class})
	public String newOrderPOST(@Valid @ModelAttribute("order") 
					Order o, BindingResult result)
	{	
		if (result.hasErrors()) {
			return "newOrder";
		}
		
		// sets order date to current date
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		String strDate = df.format(date);
		o.setOrderDate(strDate);
		
		// update quantity stock		
//		Product p = new Product();
//		int qtyInStock = p.getQtyInStock();
//		qtyInStock = p.getQtyInStock() - o.getQty();
//		p.setQtyInStock(qtyInStock);
//		
//		System.out.println("Quantity in stock: " + qtyInStock);
				
		os.save(o);
		return "redirect:showOrders.html";
	}
}
