package be.duquesne.POJO;

import java.sql.Date;
import java.util.List;

import be.duquesne.DAO.AbstractDaoFactory;
import be.duquesne.DAO.DAO;
import be.duquesne.DAO.PersonDAO;
import be.duquesne.DAO.StrollDao;

public class Stroll 
{
	private final AbstractDaoFactory dao = AbstractDaoFactory.getFactory(AbstractDaoFactory.DAO_FACTORY);
	private final DAO<Stroll> sDAO =  dao.getStrollDAO();
	
	private int numStroll;
	private String placeOfDepartune;
	private Double cost;
	
	private Date dateOfDepartune;
	private String nameStroll;
	
	public Stroll() 
	{
		
	}
	public Stroll( int numStroll,String placeOfDepartune, Double cost, String nameStroll, Date dateOfDepartune) 
	{
		
		this.numStroll=numStroll;
		this.placeOfDepartune = placeOfDepartune;
		this.cost = cost;
		this.dateOfDepartune = dateOfDepartune;
		this.nameStroll = nameStroll;
	}
	public Stroll( String placeOfDepartune, Double cost, String nameStroll, Date d) 
	{
		
		
		this.placeOfDepartune = placeOfDepartune;
		this.cost = cost;
		this.dateOfDepartune = d;
		this.nameStroll = nameStroll;
	}
	public int getNumStroll() {
		return numStroll;
	}
	public void setNumStroll(int numStroll) 
	{
		this.numStroll = numStroll;
	}
	public String getPlaceOfDepartune() {
		return placeOfDepartune;
	}
	public void setPlaceOfDepartune(String placeOfDepartune) {
		this.placeOfDepartune = placeOfDepartune;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Date getDateOfDepartune() {
		return dateOfDepartune;
	}
	public void setDateOfDepartune(Date dateOfDepartune) {
		this.dateOfDepartune = dateOfDepartune;
	}
	public String getNameStroll() {
		return nameStroll;
	}
	public void setNameStroll(String nameStroll) {
		this.nameStroll = nameStroll;
	}
	@Override
	public String toString() 
	{
		return "Ballade :  " +  this.getNameStroll()// +  "   " + placeOfDepartune + " " + cost + "€" + " " + "le : "+this.dateOfDepartune
				;
	}
	
	public boolean AddStroll() 
	{
		return this.sDAO.create(this);
	}
	public boolean deleteSroll() 
	{
		return this.sDAO.delete(this);
	}
	
	public List<Stroll> findAll()
	{
		return (List<Stroll>) sDAO.findAll(this);
				
	}
	public boolean AddParticipant() 
	{
		return false;
	}
	
	public boolean GetPlaceMembersFree() 
	{
		return false;
	}
	public boolean GetPlaceBikeFree() 
	{
		return false;
	}
	
	
}
