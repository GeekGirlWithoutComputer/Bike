package be.duquesne.POJO;

import java.util.List;

import be.duquesne.DAO.AbstractDaoFactory;
import be.duquesne.DAO.CarDAO;
import be.duquesne.DAO.DAO;
import be.duquesne.DAO.PersonDAO;

public class Car 
{
private final AbstractDaoFactory dao = AbstractDaoFactory.getFactory(AbstractDaoFactory.DAO_FACTORY);
	
private final DAO<Car> cDAO =  dao.getCarDAO();
	private int numCar;
	private String immatriculation;
	private int numberPlaceBike;
	private int numberPlacePeople;
	private Person person;
	public Car() 
	{
		
	}
	public Car(int numCar, String immatriculation, int numberPlaceBike, int numberPlacePeople) 
	{
		
		this.numCar = numCar;
		this.immatriculation = immatriculation;
		this.numberPlaceBike = numberPlaceBike;
		this.numberPlacePeople = numberPlacePeople;
	}
	public Car(int numCar, String immatriculation, int numberPlaceBike, int numberPlacePeople,Person p) 
	{
		
		this.numCar = numCar;
		this.immatriculation = immatriculation;
		this.numberPlaceBike = numberPlaceBike;
		this.numberPlacePeople = numberPlacePeople;
		this.person=p;
	}
	public Car( String immatriculation, int numberPlaceBike, int numberPlacePeople,Person p) 
	{
		
		
		this.immatriculation = immatriculation;
		this.numberPlaceBike = numberPlaceBike;
		this.numberPlacePeople = numberPlacePeople;
		this.person=p;
	}
	public Car( int numberPlaceBike, int numberPlacePeople) 
	{
		
		this.numberPlaceBike = numberPlaceBike;
		this.numberPlacePeople = numberPlacePeople;
	}
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public int getNumCar() {
		return numCar;
	}
	public void setNumCar(int numCar) {
		this.numCar = numCar;
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	public int getNumberPlaceBike() {
		return numberPlaceBike;
	}
	public void setNumberPlaceBike(int numberPlaceBike) {
		this.numberPlaceBike = numberPlaceBike;
	}
	public int getNumberPlacePeople() {
		return numberPlacePeople;
	}
	public void setNumberPlacePeople(int numberPlacePeople) {
		this.numberPlacePeople = numberPlacePeople;
	}
	@Override
	public String toString() {
		return "nom :" +person.getFirstname() + " " + "immatr:"+ this.getImmatriculation();
				//"Car [numCar=" + numCar + ", immatriculation=" + immatriculation + ", numberPlaceBike=" + numberPlaceBike
				//+ ", numberPlacePeople=" + numberPlacePeople + "]";
	}
	
	public int display_place_bike()
    {
        
        if(this.numberPlaceBike>0)
        {
        	return this.numberPlacePeople;
        }
        else
        {
            return 0;
        }
    }
	public int display_place_passenger()
    {
        if(this.numberPlacePeople > 0  )
        {
            return this.numberPlacePeople;
        }
       
        else
        {
            return 0;
        }
    }
	public boolean addCar() 
	{
		return this.cDAO.create(this);
	}
	
	public boolean addPassenger() 
	{
		if(display_place_passenger()!=0)
		{
			//ajout pass
		}
		return true;
	}
	
	public boolean addBike() 
	{
		if(display_place_bike()!=0)
		{
			//ajout velo
		}
		return true;
	}
	
	public void calculPlace()
	{
		int nbre=0;
	}
	
	public boolean placeUpadate()
	{
		return true;
	}
	public List< Car> findAll()  
	{
		return (List<Car>) this.cDAO.findAll(this);
	}
	
	
}
