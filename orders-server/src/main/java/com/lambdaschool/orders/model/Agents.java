package com.lambdaschool.orders.model;

import javax.persistence.*;

@Entity
@Table(name = "agents")
public class Agents
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long agentid;

	@Column(nullable = false)
	private String agentName;

	private String workingArea;
	private double commission;
	private String phone;
	private String country;

	public Agents()
	{
	}

	public Agents(String agentName, String workingArea, double commission, String phone, String country)
	{
		this.agentName = agentName;
		this.workingArea = workingArea;
		this.commission = commission;
		this.phone = phone;
		this.country = country;
	}

	public long getMenuid()
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
}
