package be.duquesne.POJO;

import java.sql.Date;
import java.util.List;

public class Registration 
{
	private int numRegistration;
	private Date dateRegistration;
	private Double cotisation;
	private boolean passenger;
	private boolean bike;
	List<Stroll> strollList;
	public Registration() 
	{
		
	}
	public Registration(int numRegistration, Date dateRegistration, Double cotisation, boolean passenger, boolean bike,
			List<Stroll> strollList) 
	{
		
		this.numRegistration = numRegistration;
		this.dateRegistration = dateRegistration;
		this.cotisation = cotisation;
		this.passenger = passenger;
		this.bike = bike;
		this.strollList = strollList;
	}
	public Registration(Date dateRegistration, Double cotisation, boolean passenger, boolean bike,
			List<Stroll> strollList) 
	{
		this.dateRegistration = dateRegistration;
		this.cotisation = cotisation;
		this.passenger = passenger;
		this.bike = bike;
		this.strollList = strollList;
	}
	public int getNumRegistration() {
		return numRegistration;
	}
	public void setNumRegistration(int numRegistration) {
		this.numRegistration = numRegistration;
	}
	public Date getDateRegistration() {
		return dateRegistration;
	}
	public void setDateRegistration(Date dateRegistration) {
		this.dateRegistration = dateRegistration;
	}
	public Double getCotisation() {
		return cotisation;
	}
	public void setCotisation(Double cotisation) {
		this.cotisation = cotisation;
	}
	public boolean isPassenger() {
		return passenger;
	}
	public void setPassenger(boolean passenger) {
		this.passenger = passenger;
	}
	public boolean isBike() {
		return bike;
	}
	public void setBike(boolean bike) {
		this.bike = bike;
	}
	public List<Stroll> getStrollList() {
		return strollList;
	}
	public void setStrollList(List<Stroll> strollList) {
		this.strollList = strollList;
	}
	@Override
	public String toString() 
	{
		return "Registration [dateRegistration=" + dateRegistration + ", cotisation=" + cotisation + "]";
	}
	
	
	
	
	

}
