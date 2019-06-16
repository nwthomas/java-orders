package com.lambdaschool.orders.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "orderTable")
public class Orders
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderid;

	private double orderamt;
	private double advanceamt;


	// Connects to Customer and uses FK to associate
	@ManyToOne
	@JoinColumn(name = "customerid", nullable = false)
	@JsonIgnoreProperties({"customerorders", "agentcode"})
	private Customers custcode;

	// DONE
	// Connects to Agent and uses FK to associate
	@ManyToOne
	@JoinColumn(name = "agentid", nullable = false)
	@JsonIgnoreProperties({"customers", "agentorders"})
	private Agents agentcode;

	private String orddescription;

	public Orders()
	{
	}

	public Orders(double orderamt, double advanceamt, Customers custcode, Agents agentcode, String orddescription)
	{
		this.orderamt = orderamt;
		this.advanceamt = advanceamt;
		this.custcode = custcode;
		this.agentcode = agentcode;
		this.orddescription = orddescription;
	}

	public long getOrderid()
	{
		return orderid;
	}

	public double getOrderamt()
	{
		return orderamt;
	}

	public void setOrderamt(double orderamt)
	{
		this.orderamt = orderamt;
	}

	public double getAdvanceamt()
	{
		return advanceamt;
	}

	public void setAdvanceamt(double advanceamt)
	{
		this.advanceamt = advanceamt;
	}

	public Customers getCustcode()
	{
		return custcode;
	}

	public void setCustcode(Customers custcode)
	{
		this.custcode = custcode;
	}

	public Agents getAgentcode()
	{
		return agentcode;
	}

	public void setAgentcode(Agents agentcode)
	{
		this.agentcode = agentcode;
	}

	public String getOrddescription()
	{
		return orddescription;
	}

	public void setOrddescription(String orddescription)
	{
		this.orddescription = orddescription;
	}
}
