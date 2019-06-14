package com.lambdaschool.orders.repositories;

import com.lambdaschool.orders.model.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface OrdersRepository extends CrudRepository<Orders, Long>
{
	ArrayList<Orders> findAll();

	Orders findOrderById(long id);

	void delete(long id);

	Orders save(Orders order);

	Orders update(Orders order, long id);
}
