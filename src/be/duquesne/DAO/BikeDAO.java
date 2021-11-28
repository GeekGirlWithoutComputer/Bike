package be.duquesne.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import be.duquesne.POJO.Bike;
import be.duquesne.POJO.Car;

public class BikeDAO implements DAO<Bike>
{
	protected Connection con_ = null;
	private String sql;
	// injection de dependance pour le systeme de connexion 
	public BikeDAO(Connection con) 
	{
		con_ = con;
	}
	

	@Override
	public boolean create(Bike b) 
	{
		try 
		{
			PreparedStatement state = con_.prepareStatement
        			("INSERT INTO BIKE_(WEIGHT, LENGTHBIKE, TYPE, NUMCAR, NUMPERSON)"
        					+ "VALUES (?,?,?,?,?)");
        		state.setDouble(1, b.getWeight());
        		state.setDouble(2,b.getLength());
	            state.setString(3,b.getType());
	            state.setInt(4, b.getCar().getNumCar()) ;
	            state.setInt(5,b.getPerson().getNumPerson()) ;
	            
	            state.execute();

			
		}

		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}

		return true;
	}

	
	@Override
	public int findByLast(Bike s) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Bike obj) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Bike obj)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Bike find(Bike obj) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> findAll(Bike obj) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	

	


}
