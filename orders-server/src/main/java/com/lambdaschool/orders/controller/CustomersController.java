package com.lambdaschool.orders.controller;

import com.lambdaschool.orders.model.Customers;
import com.lambdaschool.orders.model.Orders;
import com.lambdaschool.orders.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

	@PostMapping("/new")
	public ResponseEntity<?> addNewCustomer(@Valid @RequestBody Customers newCustomer)
	{
		newCustomer = customersService.save(newCustomer);
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(newCustomer.getCustomerid()).toUri();
		responseHeaders.setLocation(newCustomerURI);
		return new ResponseEntity<>(newCustomerURI, HttpStatus.OK);
	}

	@PutMapping("update/{custcode}")
	public ResponseEntity<?> updateCustomer(@RequestBody Customers updateCustomer, @PathVariable long custcode)
	{
		customersService.update(updateCustomer, custcode);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
