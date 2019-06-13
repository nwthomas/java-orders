package com.lambdaschool.orders.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ordersid;

	private double orderAmt;
	private double advanceAmt;

	@OneToMany
	@JoinColumn(name = "customerid", nullable = false)
	private Customers custCode;

	@OneToMany
	@JoinColumn(name = "agentid", nullable = false)
	private Agents agentCode;

	private String orderDescription;

	public Orders()
	{
	}

	public Orders(double orderAmt, double advanceAmt, Customers custCode, Agents agentCode, String orderDescription)
	{
		this.orderAmt = orderAmt;
		this.advanceAmt = advanceAmt;
		this.custCode = custCode;
		this.agentCode = agentCode;
		this.orderDescription = orderDescription;
	}

	public long getOrdersid()
	{
		return ordersid;
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

	public Customers getCustCode()
	{
		return custCode;
	}

	public void setCustCode(Customers custCode)
	{
		this.custCode = custCode;
	}

	public Agents getAgentCode()
	{
		return agentCode;
	}

	public void setAgentCode(Agents agentCode)
	{
		this.agentCode = agentCode;
	}

	public String getOrderDescription()
	{
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription)
	{
		this.orderDescription = orderDescription;
	}
}
