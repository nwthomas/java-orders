package com.lambdaschool.orders.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "orderTable")
public class Order
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderid;

	private double orderAmt;
	private double advanceAmt;


	// Connects to Customer and uses FK to associate
	@ManyToOne
	@JoinColumn(name = "customerOrders", nullable = false)
	private Customer custCode;

	// DONE
	// Connects to Agent and uses FK to associate
	@ManyToOne
	@JoinColumn(name = "agentOrders", nullable = false)
	private Agent agentCode;

	private String ordDescription;

	public Order()
	{
	}

	public Order(double orderAmt, double advanceAmt, Customer custCode, Agent agentCode, String ordDescription)
	{
		this.orderAmt = orderAmt;
		this.advanceAmt = advanceAmt;
		this.custCode = custCode;
		this.agentCode = agentCode;
		this.ordDescription = ordDescription;
	}

	public long getOrderid()
	{
		return orderid;
	}

	public double getOrderAmt()
	{
		return orderAmt;
	}

	public void setOrderAmt(double orderAmt)
	{
		this.orderAmt = orderAmt;
	}

	public double getAdvanceAmt()
	{
		return advanceAmt;
	}

	public void setAdvanceAmt(double advanceAmt)
	{
		this.advanceAmt = advanceAmt;
	}

	public Customer getCustCode()
	{
		return custCode;
	}

	public void setCustCode(Customer custCode)
	{
		this.custCode = custCode;
	}

	public Agent getAgentCode()
	{
		return agentCode;
	}

	public void setAgentCode(Agent agentCode)
	{
		this.agentCode = agentCode;
	}

	public String getOrdDescription()
	{
		return ordDescription;
	}

	public void setOrdDescription(String ordDescription)
	{
		this.ordDescription = ordDescription;
	}
}
