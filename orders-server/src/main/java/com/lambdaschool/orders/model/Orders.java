package com.lambdaschool.orders.model;

import javax.persistence.*;

@Entity
@Table(name = "orderTable")
public class Orders
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderid;

	private double orderAmt;
	private double advanceAmt;


	// Connects to Customer and uses FK to associate
	@ManyToOne
	@JoinColumn(name = "customerOrders", nullable = false)
	private Customers custCode;

	// DONE
	// Connects to Agent and uses FK to associate
	@ManyToOne
	@JoinColumn(name = "agentOrders", nullable = false)
	private Agents agentCode;

	private String ordDescription;

	public Orders()
	{
	}

	public Orders(double orderAmt, double advanceAmt, Customers custCode, Agents agentCode, String ordDescription)
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

	public String getOrdDescription()
	{
		return ordDescription;
	}

	public void setOrdDescription(String ordDescription)
	{
		this.ordDescription = ordDescription;
	}
}
