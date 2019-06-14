package com.lambdaschool.orders.repositories;

import com.lambdaschool.orders.model.Agents;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AgentsRepository extends CrudRepository<Agents, Long>
{
	ArrayList<Agents> findAll();

	Agents findAgentById(long id);

	Agents findAgentsByName(String name);

	void delete(long id);

	Agents save(Agents agent);

	Agents update(Agents agent, long id);
}
