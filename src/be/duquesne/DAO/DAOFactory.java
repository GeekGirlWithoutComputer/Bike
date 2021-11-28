package be.duquesne.DAO;

import java.sql.Connection;

import be.duquesne.POJO.Bike;
import be.duquesne.POJO.Calendar;
import be.duquesne.POJO.Car;
import be.duquesne.POJO.Category;
import be.duquesne.POJO.Registration;
import be.duquesne.POJO.Stroll;

public class DaoFactory extends AbstractDaoFactory
{
	protected static final Connection conn = be.duquesne.DAO.Connexion.getInstance();
		

	@Override
	public PersonDAO getPersonneDAO() 
	{
		return new PersonDAO(conn);
	}
	

	@Override
	public DAO<Bike> getBikeDAO() 
	{
		return new BikeDAO(conn);
	}
	

	@Override
	public DAO<Stroll> getStrollDAO() 
	{
		return new StrollDao(conn);
	}


	@Override
	public DAO<Calendar> getCalendarDAO() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAO<Car> getCarDAO() 
	{
		return new CarDAO(conn);
	}



	@Override
	public DAO<Category> getCategoryDAO() 
	{
		return new CategoryDAO(conn);
	}







}
