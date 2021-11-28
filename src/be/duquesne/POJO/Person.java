package be.duquesne.POJO;

import java.util.List;

import be.duquesne.DAO.AbstractDaoFactory;
import be.duquesne.DAO.PersonDAO;

public  class Person 
{
	private final AbstractDaoFactory dao = AbstractDaoFactory.getFactory(AbstractDaoFactory.DAO_FACTORY);
	
	protected final PersonDAO pDAO = dao.getPersonneDAO();
	//    attributes
	protected int numPerson;
	protected String name;
	protected String firstname;
	protected String telephon;
	protected String password;
	protected String email;
	protected String statut;
	protected String adress;
	//getters setters 
	public int getNumPerson() 
	{
		return numPerson;
	}
	public void setNumPerson(int numPerson) 
	{
		this.numPerson = numPerson;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getFirstname() 
	{
		return firstname;
	}
	public void setFirstname(String firstname) 
	{
		this.firstname = firstname;
	}
	public String getTelephon() 
	{
		return telephon;
	}
	public void setTelephon(String telephon) 
	{
		this.telephon = telephon;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) 
	{
		this.statut = statut;
	}
	//builders
	public Person() {}
	public Person(String password, String email) 
	{
		this.password = password;
		this.email = email;
	}
	
	public String getAdress() 
	{
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public Person( String name, String firstname, String telephon, String password, String email,
			String statut, String adress) 
	{
		
		
		this.name = name;
		this.firstname = firstname;
		this.telephon = telephon;
		this.password = password;
		this.email = email;
		this.statut = statut;
		this.adress = adress;
	}
	public Person(int numPerson, String name, String firstname, String telephon, String password, String email,
			String statut, String adress) {
		
		this.numPerson = numPerson;
		this.name = name;
		this.firstname = firstname;
		this.telephon = telephon;
		this.password = password;
		this.email = email;
		this.statut = statut;
		this.adress = adress;
	}
	//(PASSWORD, STATUT, ADRESS, TELEPHON, EMAIL, NAME, FIRSTNAME)
	public Person(int numPerson, String name, String firstname, String telephon, String password, String email) 
	{
		
		this.numPerson = numPerson;
		this.name = name;
		this.firstname = firstname;
		this.telephon = telephon;
		this.password = password;
		this.email = email;
	}
	public boolean login() 
	{
		return this.pDAO.login(this);
	}
	@Override
	public String toString() 
	{
		return "Person [name=" + name + ", firstname=" + firstname + ", telephon=" + telephon + ", password=" + password
				+ ", email=" + email + "]";
	}
	 
	public boolean register() 
	{
		return false;
	}
	
	public Person find()  
	{
		return this.pDAO.find(this);
	}
	public boolean updateCategory()  
	{
		return this.pDAO.update(this);
	}
	public List< Person> findAll()  
	{
		return (List<Person>) this.pDAO.findAll(this);
	}
	 
	
	
	
	
	
}
