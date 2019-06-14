package com.lambdaschool.orders.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agentTable")
public class Agent
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long agentid;

	private String agentName;
	private String workingArea;
	private double commission;
	private String phone;
	private String country;

	// DONE
	// Connects to Customer and collects all associated customers via FK into List
	@OneToMany(mappedBy = "agentCode", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties("agentCode")
	private List<Customer> customers = new ArrayList<>();

	// DONE
	// Connects to Orders and collects all associated orders via FK into List
	@OneToMany(mappedBy = "agentCode", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties("agentCode")
	private List<Order> agentOrders = new ArrayList<>();

	public Agent()
	{
	}

	public Agent(String agentName, String workingArea, double commission, String phone, String country)
	{
		this.agentName = agentName;
		this.workingArea = workingArea;
		this.commission = commission;
		this.phone = phone;
		this.country = country;
	}

	public long getAgentid()
	{
		return agentid;
	}

	public String getAgentName()
	{
		return agentName;
	}

	public void setAgentName(String agentName)
	{
		this.agentName = agentName;
	}

	public String getWorkingArea()
	{
		return workingArea;
	}

	public void setWorkingArea(String workingArea)
	{
		this.workingArea = workingArea;
	}

	public double getCommission()
	{
		return commission;
	}

	public void setCommission(double commission)
	{
		this.commission = commission;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public List<Customer> getCustomers()
	{
		return customers;
	}

	public void setCustomers(List<Customer> customers)
	{
		this.customers = customers;
	}

	public List<Order> getOrders()
	{
		return agentOrders;
	}

	public void setOrders(List<Order> orders)
	{
		this.agentOrders = orders;
	}
}
