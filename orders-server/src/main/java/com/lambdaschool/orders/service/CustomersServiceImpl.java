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
		Customers customer = custRepos.findByCustName(custName);
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
		newCustomer.setCustName(customer.getCustName());
		newCustomer.setWorkingArea(customer.getWorkingArea());
		newCustomer.setCustCity(customer.getCustCity());
		newCustomer.setCustCountry(customer.getCustCountry());
		newCustomer.setGrade(customer.getGrade());
		newCustomer.setOpeningAmt(customer.getOpeningAmt());
		newCustomer.setReceiveAmt(customer.getReceiveAmt());
		newCustomer.setPaymentAmt(customer.getPaymentAmt());
		newCustomer.setOutstandingAmt(customer.getOutstandingAmt());
		newCustomer.setPhone(customer.getPhone());
		newCustomer.setAgentCode(customer.getAgentCode());

		for (Orders o : customer.getOrders())
		{
			newCustomer.getOrders().add(new Orders(o.getOrderAmt(), o.getAdvanceAmt(), o.getCustCode(), o.getAgentCode(), o.getOrdDescription()));
		}

		return custRepos.save(newCustomer);
	}


	@Transactional
	@Override
	public Customers update(Customers customer, long id)
	{
		Customers currentRestaurant = custRepos.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

		if (customer.getCustName() != null)
		{
			currentRestaurant.setCustName(customer.getCustName());
		}

		if (customer.getWorkingArea() != null)
		{
			currentRestaurant.setWorkingArea(customer.getWorkingArea());
		}

		if (customer.getCustCity() != null)
		{
			currentRestaurant.setCustCity(customer.getCustCity());
		}

		if (customer.getCustCountry() != null)
		{
			currentRestaurant.setCustCountry(customer.getCustCountry());
		}

		if (customer.getGrade() != null)
		{
			currentRestaurant.setGrade(customer.getGrade());
		}

		if (customer.getOpeningAmt() > 0)
		{
			currentRestaurant.setOpeningAmt(customer.getOpeningAmt());
		}

		if (customer.getReceiveAmt() > 0)
		{
			currentRestaurant.setReceiveAmt(customer.getReceiveAmt());
		}

		if (customer.getPaymentAmt() > 0)
		{
			currentRestaurant.setPaymentAmt(customer.getPaymentAmt());
		}

		if (customer.getOutstandingAmt() > 0)
		{
			currentRestaurant.setOutstandingAmt(customer.getOutstandingAmt());
		}

		if (customer.getPhone() != null)
		{
			currentRestaurant.setPhone(customer.getPhone());
		}

		if (customer.getAgentCode() != null)
		{
			currentRestaurant.setAgentCode(customer.getAgentCode());
		}

		return custRepos.save(currentRestaurant);
	}
}
