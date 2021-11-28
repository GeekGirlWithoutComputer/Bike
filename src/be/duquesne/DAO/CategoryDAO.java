package be.duquesne.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import be.duquesne.POJO.Category;
import be.duquesne.POJO.Category.TypesVtt;
import be.duquesne.POJO.Person;

public class CategoryDAO implements DAO<Category>
{
	protected Connection con_ = null;
	private String sql;
	// injection de dependance pour le systeme de connexion 
	public CategoryDAO(Connection con) 
	{
		con_ = con;
	}

	@Override
	public boolean create(Category obj) 
	{
		return false;
	}

	

	@Override
	public int findByLast(Category s) 
	{
		return 0;
	}

	@Override
	public boolean delete(Category obj) 
	{
		return false;
	}

	@Override
	public boolean update(Category ct) 
	{
		
		          
		return true;
	}

	@Override
	public Category find(Category c) 
	{
		
		try
		{

			ResultSet rs = this.con_
					.createStatement()
					.executeQuery("SELECT numcategory FROM Category_ WHERE name = '" + c.getName() +"'"  );
			
			if(rs.next()) 
			{
				int id= rs.getInt(1);
				String name=rs.getString(2);
				 JOptionPane.showMessageDialog(null,"catdao id   " + id); 
				 JOptionPane.showMessageDialog(null,"cat dao  nom " +name); 
				return new Category(id,name);
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public int id(Category c) 
	{
		//select name from category_ where name= 'VTT'
		//select numcategory from category_ where name= 'VTT'
		try
		{

			ResultSet rs = this.con_
					.createStatement()
					.executeQuery("SELECT numcategory FROM Category_ WHERE catname = '" + c.getName() +"'" );
			
			if(rs.next()) 
			{
				int id= rs.getInt(1);
				String name=rs.getString(2);
				
				JOptionPane.showMessageDialog(null, "id cat !"+id);
				return id;
				
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return 0;
		}
		return 0;
	}

	/**************************************************************************************************
	 * lorsqu'on a des enums et des data ds la base de données il faut que l enum soit idem a ce qu'il 
	 * y a ds la bsd sinon erreur.
	 * 
	 * 
	 * 
	 * ***********************************************************************************************/
	@Override
	public List<Category> findAll(Category obj) 
	{
		
		List<Category> liste = new ArrayList<Category>();
		
			Statement stm = null;
			ResultSet rs = null;
			try
			{
				 sql = "Select * From CATEGORY_ ";
				
				
				rs=this.con_.createStatement().executeQuery(sql);
				while(rs.next())
				{
					
					//Categorie categorie = new Categorie(TypesCategorie.valueOf(categoriesResult.getString("type")),
							//prix, null, null);
					int id = rs.getInt(1);
					TypesVtt type= TypesVtt.
							valueOf( rs.getString(2));
				// **toString ds le get type 
					
						liste.add(new Category(id,type))	;	
					
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			// test debbug
			for(Category cf : liste) 
	        {
	        	
	        	//JOptionPane.showMessageDialog(null,"list  taille  " +liste.size()); a titre de test 
	        		
	        }
			return liste;
	}

}
