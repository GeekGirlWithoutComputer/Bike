package be.duquesne.POJO;

import be.duquesne.DAO.AbstractDaoFactory;
import be.duquesne.DAO.DAO;

public class Bike 
{
	private final AbstractDaoFactory dao = AbstractDaoFactory.getFactory(AbstractDaoFactory.DAO_FACTORY);
	private final DAO<Bike> bDAO =  dao.getBikeDAO();
	private int numbike;
	private Double weight;
	private Double length;
	private String type;
	private Car car;
	private Person person;
	public Bike()
	{
		
	}
	
	public Bike(int numbike, Double weight, Double length, String type) 
	{
		super();
		this.numbike = numbike;
		this.weight = weight;
		this.length = length;
		this.type = type;
	}
	public Bike(Double weight, Double length, String type) 
	{
		super();
		this.numbike = numbike;
		this.weight = weight;
		this.length = length;
		this.type = type;
	}
	public Bike(Double weight, Double length, String type,Car c,Person p) 
	{
		
		this.numbike = numbike;
		this.weight = weight;
		this.length = length;
		this.type = type;
		this.car=c;
		this.person=p;
	}

	public int getNumbike() 
	{
		return numbike;
	}

	public void setNumbike(int numbike) 
	{
		this.numbike = numbike;
	}

	public Double getWeight() 
	{
		return weight;
	}

	public void setWeight(Double weight) 
	{
		this.weight = weight;
	}

	public Double getLength() 
	{
		return length;
	}

	public void setLength(Double length) 
	{
		this.length = length;
	}

	public String getType() 
	{
		return type;
	}

	public void setType(String type) 
	{
		this.type = type;
	}

	public Car getCar() 
	{
		return car;
	}

	public void setCar(Car car) 
	{
		this.car = car;
	}

	public Person getPerson() 
	{
		return person;
	}

	public void setPerson(Person person) 
	{
		this.person = person;
	}
	
	public boolean addBike() 
	{
		return this.bDAO.create(this);
	}
	
	
	
}
