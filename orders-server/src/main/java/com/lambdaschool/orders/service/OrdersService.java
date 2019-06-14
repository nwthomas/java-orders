package com.lambdaschool.orders.service;

import com.lambdaschool.orders.model.Orders;

import java.util.ArrayList;

public interface OrdersService
{
	ArrayList<Orders> findAll();

	Orders findOrderById(long id);

	void delete(long id);

	Orders save(Orders order);

	Orders update(Orders order, long id);
}
