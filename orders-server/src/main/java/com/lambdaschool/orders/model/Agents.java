package com.lambdaschool.orders.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agentTable")
public class Agents
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long agentid;

	private String agentname;
	private String workingarea;
	private double commission;
	private String phone;
	private String country;

	// DONE
	// Connects to Customer and collects all associated customers via FK into List
	@OneToMany(mappedBy = "agentcode", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties({"customerorders", "agentcode"})
	private List<Customers> customers = new ArrayList<>();

	// DONE
	// Connects to Orders and collects all associated orders via FK into List
	@OneToMany(mappedBy = "agentcode", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties({"agentcode", "custcode"})
	private List<Orders> agentorders = new ArrayList<>();

	public Agents()
	{
	}

	public Agents(String agentname, String workingarea, double commission, String phone, String country)
	{
		this.agentname = agentname;
		this.workingarea = workingarea;
		this.commission = commission;
		this.phone = phone;
		this.country = country;
	}

	public long getAgentid()
	{
		return agentid;
	}

	public String getAgentname()
	{
		return agentname;
	}

	public void setAgentname(String agentname)
	{
		this.agentname = agentname;
	}

	public String getWorkingarea()
	{
		return workingarea;
	}

	public void setWorkingarea(String workingarea)
	{
		this.workingarea = workingarea;
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

	public List<Customers> getCustomers()
	{
		return customers;
	}

	public void setCustomers(List<Customers> customers)
	{
		this.customers = customers;
	}

	public List<Orders> getAgentorders()
	{
		return agentorders;
	}

	public void setAgentorders(List<Orders> agentorders)
	{
		this.agentorders = agentorders;
	}
}
