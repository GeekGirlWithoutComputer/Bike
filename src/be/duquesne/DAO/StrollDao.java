package be.duquesne.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import be.duquesne.POJO.Person;
import be.duquesne.POJO.Stroll;

public class StrollDao implements DAO<Stroll>
{
	protected Connection con_ = null;
	private String sql;
	

	public StrollDao(Connection con) 
	{
		con_ = con;
		
	}
//INSERT INTO "STUDENT03_27"."STROLL_" (NAME, COST, PLACEOFDEPARTUNE, DATEOFDEPARTUNE) VALUES ('hello', '5', 'huy', TO_DATE('2021-12-30 02:32:49', 'YYYY-MM-DD HH24:MI:SS'))


	@Override
	public boolean create(Stroll s) 
	{
		try 
		{
			PreparedStatement state = con_.prepareStatement
        			("INSERT INTO Stroll_(NAME, COST, PLACEOFDEPARTUNE, DATEOFDEPARTUNE)"
        					+ "VALUES (?,?,?,?)");
        		state.setString(1, s.getNameStroll());
        		state.setDouble(2,s.getCost());
	            state.setString(3,s.getPlaceOfDepartune());
	            state.setDate(4, s.getDateOfDepartune());
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
	public boolean create(Stroll obj, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int findByLast(Stroll s) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Stroll s) 
	{
		try
		{
			PreparedStatement state = con_.prepareStatement("DELETE FROM STROLL_ WHERE numStroll = " + s.getNumStroll());		
			state.execute();
			return true;
		}
		
		catch(SQLException e)
		{
			System.out.println("Catch stroll  " + e.getMessage());
			e.printStackTrace();
		}
    	
    	return false;
		
	}

	@Override
	public boolean update(Stroll obj) 
	{
		
		return false;
	}

	@Override
	public Stroll find(Stroll obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> findAll(Stroll obj) 
	{
		List<Stroll> liste = new ArrayList<Stroll>();
		
			Statement stm = null;
			ResultSet rs = null;
			//Date date = Date.valueOf(result.getString("date"));
			
			try
			{
				 sql = "Select * From STROLL_ ";
				
				rs=this.con_.createStatement().executeQuery(sql);
				while(rs.next())
				{
				// on peut bosser avec le nom des champs aussi c est au choix
					liste.add(new Stroll(
							
							
							
							rs.getInt(1),
							rs.getString(2),
							rs.getDouble(3),
							
							rs.getString(4),
							rs.getDate(5)
							
							)
							);		
					
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			// test debbug
			for(Stroll cf : liste) 
	        {
	        	
	        	//JOptionPane.showMessageDialog(null,"list    " +cf);
	        		
	        }
			return liste;
	}

}
