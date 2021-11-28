package be.duquesne.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import be.duquesne.POJO.Car;
import be.duquesne.POJO.Category;
import be.duquesne.POJO.Member;
import be.duquesne.POJO.Person;
import be.duquesne.POJO.Stroll;
public class CarDAO  implements DAO<Car>
{
	protected Connection con_ = null;
	private String sql;
	// injection de dependance pour le systeme de connexion 
	public CarDAO(Connection con) 
	{
		con_ = con;
	}

	@Override
	public boolean create(Car c) 
	{
		try 
		{
			PreparedStatement state = con_.prepareStatement
        			("INSERT INTO CAR_(IMMATRICULATION, NUMBERPLACEBIKE, NUMBERPLACEPEOPLE, NUMPERSON)"
        					+ "VALUES (?,?,?,?)");
        		state.setString(1, c.getImmatriculation());
        		state.setInt(2,c.getNumberPlaceBike());
	            state.setInt(3,c.getNumberPlacePeople());
	            state.setInt(4, c.getPerson().getNumPerson()) ;
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
	public int findByLast(Car s) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Car obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Car obj) 
	{
		// UPDATE car SET immatriculation = 'testupdate' WHERE numPerson = 2
				
		return false;
	}

	@Override
	public Car find(Car obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> findAll(Car c) 
	{
		
		List<Car> listeCar = new ArrayList<Car>();
		Statement stm = null;
		ResultSet rs = null;
		
		try
		{
			String sql ="select * from car_ inner join person_ on person_.numPerson=car_.numPerson";
			rs=this.con_.createStatement().executeQuery(sql);
			while(rs.next())
			{
				// table car 
				int idCar= Integer.parseInt(rs.getString(1));
				String imm = rs.getString(2);
				int velo =rs.getInt(3);
				int gens = rs.getInt(4);
				int idP=Integer.parseInt(rs.getString(5));
				// table pers
				//private final DAO<Stroll> sDAO =  dao.getStrollDAO();
				int idPers= Integer.parseInt(rs.getString(6));
				String psw = rs.getString(7);
				String  statut =rs.getString(8);
				String adress = rs.getString(9);
				String  tel =rs.getString(10);
				String email = rs.getString(11);
				String  name =rs.getString(12);
				String fn=rs.getString(13);
				Person p= new Person(idP,psw,statut,adress,tel,email,name,fn);
				c= new Car(idCar,imm,velo,gens,p);
				
				
				listeCar.add(c);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return listeCar;
	}
	/*
	INSERT INTO "STUDENT03_27"."CAR_" (IMMATRICULATION, NUMBERPLACEBIKE, NUMBERPLACEPEOPLE, NUMPERSON) VALUES ('1-ert-550', '2', '4', '70')

	Validation (commit) effectuée*/


}
