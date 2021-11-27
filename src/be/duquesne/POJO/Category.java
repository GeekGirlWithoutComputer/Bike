package be.duquesne.POJO;

import java.util.List;

import be.duquesne.DAO.AbstractDaoFactory;
import be.duquesne.DAO.CategoryDAO;
import be.duquesne.DAO.PersonDAO;

public  class Category 
{
	private final AbstractDaoFactory dao = AbstractDaoFactory.getFactory(AbstractDaoFactory.DAO_FACTORY);
	protected final CategoryDAO cDAO=(CategoryDAO) dao.getCategoryDAO();
	public enum TypesMember
	{
		CYCLO,
		VTT
	
	};
	public enum TypesVtt 
	{
		HIKER,
		TRIALIST,
		DESCENDER,
		CYCLO ,
		VTT;

		
	};
	private TypesVtt type;
	private TypesMember typeVelo;
	private int codeCat;
	private String name;
	public Category() 
	{
		
	}
	
	public Category( int codeCat,TypesVtt type) 
	{
		
		this.type = type;
		this.codeCat = codeCat;
	}
	public Category( int codeCat,String name) 
	{
		
		this.name=name;
		this.codeCat = codeCat;
	}

	public String getType() 
	{
		if(this.type.equals(this.type.CYCLO))
		{
			return this.type.toString() + " " + " velo sur route ";
		}
		else 	
		return this.type.toString()+ " " + "  velo VTT";
	}
	public void setType(TypesVtt type) 
	{
		this.type = type;
	}
	public TypesMember getTypeVelo() 
	{
		return typeVelo;
	}
	public void setTypeVelo(TypesMember typeVelo) 
	{
		this.typeVelo = typeVelo;
	}
	public int getCodeCat() 
	{
		return codeCat;
	}
	public void setCodeCat(int codeCat) 
	{
		this.codeCat = codeCat;
	}
	
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public List<Category> findAll ()
	{
		return (List<Category>) cDAO.findAll(this);
				
	}
	public Category find()  
	{
		return this.cDAO.find(this);
	}
	public int findId()  
	{
		return this.cDAO.id(this);
	}
	@Override
	public String toString()
	{
		return "  " +this.type;
	}
	
	
	
}
