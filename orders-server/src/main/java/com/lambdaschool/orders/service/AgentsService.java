package com.lambdaschool.orders.service;

import com.lambdaschool.orders.model.Agents;

import java.util.ArrayList;

public interface AgentsService
{
	ArrayList<Agents> findAll();

	Agents findAgentById(long id);

	Agents findAgentsByName(String name);

	void delete(long id);

	Agents save(Agents agent);

	Agents update(Agents agent, long id);
}
