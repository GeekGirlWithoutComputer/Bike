package be.duquesne.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import be.duquesne.POJO.Member;
import be.duquesne.POJO.Person;
import be.duquesne.POJO.Category;
import be.duquesne.POJO.Category.TypesVtt;

public class PersonDAO implements DAO<Person>
{
		protected Connection con_ = null;
		private String sql;
		// injection de dependance pour le systeme de connexion 
		public PersonDAO(Connection con) 
		{
			con_ = con;
		}
		@Override
		public boolean create(Person obj) 
		{
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean create(Person obj, int id)
		{
			// TODO Auto-generated method stub
			return false;
		}
		
		
		@Override
		public boolean delete(Person obj) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean update(Person obj) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public Person find(Person p) 
		{
			
try {
				

				ResultSet result = this.con_
						.createStatement()
						.executeQuery("SELECT * FROM PERSON_ WHERE EMAIL = "
								+ "'" + p.getEmail() +"'" );
				// test de depart 
								//+ " =  AND statut = '"+personne.getStatut()
								//+ "'AND \"Mdp\" = '" + personne.getMdp()+"'" );
				
				if(result.next()) 
				{
					return new Person(result.getInt(1),
	            			result.getString(2),
	            			result.getString(3), 
	            			result.getString(4),
	            			result.getString(5), 
	            			result.getString(6),
	            			result.getString(7), 
	            			result.getString(8)
	            			
	            			
	            			
	            			
	            			
	            			
	            			
	            			);  
					}
				
			} catch (SQLException e) 
			{
				e.printStackTrace();
				return null;
			}
			return null;
		}
		public Person findMember(Member p) 
		{
			try {
				

				ResultSet result = this.con_
						.createStatement()
						.executeQuery("SELECT * FROM PERSON WHERE EMAIL = "
								+ "'" + p.getEmail() +"'" );
				// test de depart 
								//+ " =  AND statut = '"+personne.getStatut()
								//+ "'AND \"Mdp\" = '" + personne.getMdp()+"'" );
				
				if(result.next()) 
				{
					return new Member(result.getInt(1),
	            			result.getString(2),
	            			result.getString(3), 
	            			result.getString(4),
	            			result.getString(5), 
	            			result.getString(6),
	            			result.getString(7), 
	            			result.getString(8)
	            			
	            			
	            			
	            			
	            			
	            			
	            			
	            			);  
					}
				
			} catch (SQLException e) 
			{
				e.printStackTrace();
				return null;
			}
			return null;
		}
		@Override
		public List<?> findAll(Person p) 
		{
			List<Person> liste = new ArrayList<Person>();
			
			Statement stm = null;
			ResultSet rs = null;
			
			try
			{
				String sql ="select * from person_ inner join category_ on person_.numcategory=category_.numcategory";
				rs=this.con_.createStatement().executeQuery(sql);
				while(rs.next())
				{
					int idP= Integer.parseInt(rs.getString(1));
					String psw = rs.getString(2);
					String  statut =rs.getString(3);
					String adress = rs.getString(4);
					String  tel =rs.getString(5);
					String email = rs.getString(6);
					String  name =rs.getString(7);
					String fn=rs.getString(8);
				
					//id cat de pers j affiche pas 
					int idCat=  Integer.parseInt(rs.getString(9));
					String nameCat =rs.getString(11);
					Category cat= new Category(idCat,nameCat);
					p=new Member(idP,psw,statut,adress,tel,email,name,fn,cat);
					liste.add(p);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return liste;
		}
		
		public boolean login(Person p) 
		{
			try 
			{
				ResultSet result = this.con_.createStatement()
						.executeQuery("SELECT * FROM PERSON_ WHERE EMAIL = '" 
						+ p.getEmail()
						+ "' AND statut ='" 
						+ p.getStatut()
						+ "'AND password = '" + p.getPassword()
						+ "'"
					);
				if (result.next()) 
				{
					return true;
				}

			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return false;
		}
		/*INSERT INTO "STUDENT03_27"."PERSON_" 
		 * (PASSWORD, STATUT, ADRESS, TELEPHON, EMAIL, NAME, FIRSTNAME, NUMCATEGORY) VALUES ('test', 'MEMBER', 'ze', '04578', 'test', 'ttt', 'ttt', '34')
*/
		
		// (PASSWORD, STATUT, ADRESS, TELEPHON, EMAIL, NAME, FIRSTNAME) VALUES ('ffffffffffffffffff', 'zzzzzzzzzzzzzzzz', 'zzzzzzzzzzzzzzzz', 'zzzzzzzzzzzzzz', 'aaaaaaaaaaaaaaaaa', 'aaaaaaaaaaaaaaa', 'aaaa')

		 public boolean create(Member m)
		  { 
		        try
		        {
		                      
		        	PreparedStatement state = con_.prepareStatement
		        			("INSERT INTO PERSON(PASSWORD, STATUT, ADRESS, TELEPHON, EMAIL, NAME, FIRSTNAME)"
		        					+ "VALUES (?,?,?,?,?,?,?)");
		        	
		            state.setString(1, m.getPassword());
		          
		            state.setString(2, "MEMBER");
		            
		            state.setString(3, m.getAdress());
		      
		            state.setString(4, m.getTelephon());
		            state.setString(5, m.getEmail());
		            state.setString(6, m.getName());
		            state.setString(7, m.getFirstname());
		           
		            
		            state.execute();
		            return true;
		        }

		        catch(SQLException e)
		        {
		            e.printStackTrace();
		        }
		       
		        return false;
		    }
		 
		
		 public boolean create_(Member m)
		  {
			 
			
		        try
		        {
		                      
		        	PreparedStatement state = con_.prepareStatement
		        			("INSERT INTO PERSON_(PASSWORD, STATUT, ADRESS, TELEPHON, EMAIL, NAME, FIRSTNAME,NUMCATEGORY)"
		        					+ "VALUES (?,?,?,?,?,?,?,?)");
		        	
							
		            state.setString(1, m.getPassword());
		          
		            state.setString(2, "MEMBER");
		            
		            state.setString(3, m.getAdress());
		      
		            state.setString(4, m.getTelephon());
		            state.setString(5, m.getEmail());
		            state.setString(6, m.getName());
		            state.setString(7, m.getFirstname());
		            
		            state.setInt(8, m.getCat().getCodeCat());
		           
		            
		            state.execute();
		           
		            
		           
		            return true;
		        }

		        catch(SQLException e)
		        {
		            e.printStackTrace();
		        }
		        /*
		        JOptionPane.showMessageDialog(null,"get email  " + m.getEmail()); 
		        JOptionPane.showMessageDialog(null,"get cat  " + m.getCat().getCodeCat());
		        JOptionPane.showMessageDialog(null,"get type  " + m.getType());
		        JOptionPane.showMessageDialog(null,"get id cat   " + m.getCat().findId());
		        */
		        JOptionPane.showMessageDialog(null,"get cat dao " + m.getCat().getCodeCat());
		        return false;
		    }
		 
		// INSERT INTO "STUDENT03_27"."PERSON_"
		 //(PASSWORD, STATUT, ADRESS, TELEPHON, EMAIL, NAME, FIRSTNAME, NUMCATEGORY) 
		 //VALUES ('yyyyyyyyyy', 'fdp', 'mmm', 'mmmmm', 'mmmm', 'nnnnn', 'nnnn', '35')

		 
		@Override
		public int findByLast(Person s) 
		{
			// TODO Auto-generated method stub
			return 0;
		}
		 
		
}
