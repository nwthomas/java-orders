package com.lambdaschool.orders.service;

import com.lambdaschool.orders.model.Customers;
import com.lambdaschool.orders.model.Orders;
import com.lambdaschool.orders.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service(value = "customersService")
public class CustomersServiceImpl implements CustomersService
{
	@Autowired
	private CustomersRepository custRepos;

	@Override
	public ArrayList<Customers> findAll()
	{
		ArrayList<Customers> list = new ArrayList<>();
		custRepos.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public Customers findCustomerById(long id)
	{
		return custRepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
	}

	@Override
	public Customers findCustomerByName(String custName)
	{
		Customers customer = custRepos.findByCustname(custName);
		if (customer == null)
		{
			throw new EntityNotFoundException("Customer " + custName + " not found");
		}
		return customer;
	}

	@Transactional
	@Override
	public void delete(long id)
	{
		if (custRepos.findById(id).isPresent())
		{
			custRepos.deleteById(id);
		}
		else
		{
			throw new EntityNotFoundException(Long.toString(id));
		}
	}

	@Override
	public Customers save(Customers customer)
	{
		Customers newCustomer = new Customers();
		newCustomer.setCustname(customer.getCustname());
		newCustomer.setWorkingarea(customer.getWorkingarea());
		newCustomer.setCustcity(customer.getCustcity());
		newCustomer.setCustcountry(customer.getCustcountry());
		newCustomer.setGrade(customer.getGrade());
		newCustomer.setOpeningamt(customer.getOpeningamt());
		newCustomer.setReceiveamt(customer.getReceiveamt());
		newCustomer.setPaymentamt(customer.getPaymentamt());
		newCustomer.setOutstandingamt(customer.getOutstandingamt());
		newCustomer.setPhone(customer.getPhone());
		newCustomer.setAgentcode(customer.getAgentcode());

		for (Orders o : customer.getCustomerorders())
		{
			newCustomer.getCustomerorders().add(new Orders(o.getOrderamt(), o.getAdvanceamt(), o.getCustcode(), o.getAgentcode(), o.getOrddescription()));
		}

		return custRepos.save(newCustomer);
	}


	@Transactional
	@Override
	public Customers update(Customers customer, long custcode)
	{
		Customers currentRestaurant = custRepos.findById(custcode)
				.orElseThrow(() -> new EntityNotFoundException(Long.toString(custcode)));
		System.out.println(currentRestaurant);

		if (customer.getCustname() != null)
		{
			currentRestaurant.setCustname(customer.getCustname());
		}

		if (customer.getWorkingarea() != null)
		{
			currentRestaurant.setWorkingarea(customer.getWorkingarea());
		}

		if (customer.getCustcity() != null)
		{
			currentRestaurant.setCustcity(customer.getCustcity());
		}

		if (customer.getCustcountry() != null)
		{
			currentRestaurant.setCustcountry(customer.getCustcountry());
		}

		if (customer.getGrade() != null)
		{
			currentRestaurant.setGrade(customer.getGrade());
		}

		if (customer.getOpeningamt() > 0)
		{
			currentRestaurant.setOpeningamt(customer.getOpeningamt());
		}

		if (customer.getReceiveamt() > 0)
		{
			currentRestaurant.setReceiveamt(customer.getReceiveamt());
		}

		if (customer.getPaymentamt() > 0)
		{
			currentRestaurant.setPaymentamt(customer.getPaymentamt());
		}

		if (customer.getOutstandingamt() > 0)
		{
			currentRestaurant.setOutstandingamt(customer.getOutstandingamt());
		}

		if (customer.getPhone() != null)
		{
			currentRestaurant.setPhone(customer.getPhone());
		}

		if (customer.getAgentcode() != null)
		{
			currentRestaurant.setAgentcode(customer.getAgentcode());
		}

		return custRepos.save(currentRestaurant);
	}
}
