package com.lambdaschool.orders.controller;

import com.lambdaschool.orders.model.Customers;
import com.lambdaschool.orders.model.Orders;
import com.lambdaschool.orders.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomersController
{
	@Autowired
	private CustomersService customersService;

	@GetMapping(value = "/order", produces = {"application/json"})
	public ResponseEntity<?> listAllCustomers()
	{
		ArrayList<Customers> customersList = customersService.findAll();
		return new ResponseEntity<>(customersList, HttpStatus.OK);
	}

	@GetMapping("/name/{custname}")
	public ResponseEntity<?> orderByCustname(@PathVariable String custname)
	{
		Customers customer = customersService.findCustomerByName(custname);
		return new ResponseEntity<>(customer.getCustomerorders(), HttpStatus.OK);
	}
}
