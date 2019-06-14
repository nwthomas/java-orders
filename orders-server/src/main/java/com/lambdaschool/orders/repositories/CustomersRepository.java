package com.lambdaschool.orders.repositories;

import com.lambdaschool.orders.model.Customers;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CustomersRepository extends CrudRepository<Customers, Long>
{
	ArrayList<Customers> findAll();

	Customers findCustomerById(long id);

	Customers findCustomerByName(String name);

	void delete(long id);

	Customers save(Customers customer);

	Customers update(Customers customer, long id);
}
