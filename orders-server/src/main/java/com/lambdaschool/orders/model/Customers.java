package com.lambdaschool.orders.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customerTable")
public class Customers
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private long customerid;

	@Column(nullable = false)
	private String custName;

	private String custCity;
	private String workingArea;
	private String custCountry;
	private String grade;
	private double openingAmt;
	private double receiveAmt;
	private double paymentAmt;
	private double outstandingAmt;
	private String phone;

	// DONE
	// Connects to Agent which collects this in a List
	@ManyToOne
	@JoinColumn(name = "customers", nullable = false)
	private Agents agentCode;


	// Collects all customers associated with the agent together in a List
	@OneToMany(mappedBy = "custCode", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties("custCode")
	private List<Orders> customerOrders = new ArrayList<>();


	public Customers()
	{
	}

	public Customers(String custName, String custCity, String workingArea, String custCountry, String grade, double openingAmt, double receiveAmt, double paymentAmt, double outstandingAmt, String phone, Agents agentCode)
	{
		this.custName = custName;
		this.custCity = custCity;
		this.workingArea = workingArea;
		this.custCountry = custCountry;
		this.grade = grade;
		this.openingAmt = openingAmt;
		this.receiveAmt = receiveAmt;
		this.paymentAmt = paymentAmt;
		this.outstandingAmt = outstandingAmt;
		this.phone = phone;
		this.agentCode = agentCode;
	}

	public long getCustomerid()
	{
		return customerid;
	}

	public String getCustName()
	{
		return custName;
	}

	public void setCustName(String custName)
	{
		this.custName = custName;
	}

	public String getCustCity()
	{
		return custCity;
	}

	public void setCustCity(String custCity)
	{
		this.custCity = custCity;
	}

	public String getWorkingArea()
	{
		return workingArea;
	}

	public void setWorkingArea(String workingArea)
	{
		this.workingArea = workingArea;
	}

	public String getCustCountry()
	{
		return custCountry;
	}

	public void setCustCountry(String custCountry)
	{
		this.custCountry = custCountry;
	}

	public String getGrade()
	{
		return grade;
	}

	public void setGrade(String grade)
	{
		this.grade = grade;
	}

	public double getOpeningAmt()
	{
		return openingAmt;
	}

	public void setOpeningAmt(double openingAmt)
	{
		this.openingAmt = openingAmt;
	}

	public double getReceiveAmt()
	{
		return receiveAmt;
	}

	public void setReceiveAmt(double receiveAmt)
	{
		this.receiveAmt = receiveAmt;
	}

	public double getPaymentAmt()
	{
		return paymentAmt;
	}

	public void setPaymentAmt(double paymentAmt)
	{
		this.paymentAmt = paymentAmt;
	}

	public double getOutstandingAmt()
	{
		return outstandingAmt;
	}

	public void setOutstandingAmt(double outstandingAmt)
	{
		this.outstandingAmt = outstandingAmt;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public Agents getAgentCode()
	{
		return agentCode;
	}

	public void setAgentCode(Agents agentCode)
	{
		this.agentCode = agentCode;
	}

	public List<Orders> getOrders()
	{
		return customerOrders;
	}

	public void setOrders(List<Orders> orders)
	{
		this.customerOrders = orders;
	}
}
