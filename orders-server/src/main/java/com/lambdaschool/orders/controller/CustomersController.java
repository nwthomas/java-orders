package com.lambdaschool.orders.controller;

import com.lambdaschool.orders.model.Customers;
import com.lambdaschool.orders.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/customers")
public class CustomersController
{
	@Autowired
	private CustomersService customersService;

	@GetMapping(value = "customers", produces = {"application/json"})
	public ResponseEntity<?> listAllCustomers()
	{
		ArrayList<Customers> customersList = customersService.findAll();
		return new ResponseEntity<>(customersList, HttpStatus.OK);
	}
}
