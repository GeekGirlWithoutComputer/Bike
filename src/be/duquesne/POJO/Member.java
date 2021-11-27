package be.duquesne.POJO;

import java.util.List;

import be.duquesne.DAO.AbstractDaoFactory;
import be.duquesne.DAO.PersonDAO;
import be.duquesne.POJO.Category.TypesMember;
import be.duquesne.POJO.Category.TypesVtt;
public class Member extends Person
{
	private final AbstractDaoFactory dao = AbstractDaoFactory.getFactory(AbstractDaoFactory.DAO_FACTORY);
	
	protected final PersonDAO pDAO = dao.getPersonneDAO();
	/*on peut aussi travailler avec instanceof pour voir si c est un membre ou autre mais moi je choisis ce systeme*/
	public final static String statut = "MEMBER";
	// enlever liste ou ref a voir 
	private List<Category> categoryList;
	private Category cat;
	private TypesVtt type;
	private TypesMember typevelo;
	private Car theCar;
	private Double balance;
	
	

	public Member(int numPerson, String name, String firstname, String telephon, String password, String email) {
		super(numPerson, name, firstname, telephon, password, email);
		
	}
	

	public Member(String name, String firstname, String telephon, String password, String email,
			String statut, String adress, TypesVtt type) 
	{
		super(name, firstname, telephon, password, email, statut, adress);
		this.type=type;
		this.cat=new Category();//1511
		
	}
	public Member(String name, String firstname, String telephon, String password, String email,
			String statut, String adress) 
	{
		super(name, firstname, telephon, password, email, statut, adress);
		
		
	}

	public Member(int numPerson, String name, String firstname, String telephon, String password, String email,
			String statut, String adress) {
		super(numPerson, name, firstname, telephon, password, email, statut, adress);
		
	}
	public Member(int numPerson, String name, String firstname, String telephon, String password, String email,
			String statut, String adress,Category cat) {
		super(numPerson, name, firstname, telephon, password, email, statut, adress);
		this.cat=cat;//1611
		
	}
	public Member( String name, String firstname, String telephon, String password, String email,
			String statut, String adress,Category cat) {
		super( name, firstname, telephon, password, email, statut, adress);
		this.cat=cat;//1611  2e pas id
		
	}

	public Member(String password, String email) 
	{
		super(password, email);
		
	}
	public String getType() 
	{
		if(this.type == TypesVtt.CYCLO) 
			return "CYCLO";
		else if(this.type ==  TypesVtt.HIKER)
			return "HIKER";	
		else if(this.type ==  TypesVtt.DESCENDER)
			return "DESCENDER";	
		else if(this.type ==  TypesVtt.VTT)
			return "VTT";	
		else
			return "TRIALIST";
	}
	public void setType(TypesVtt type) {
		
	}
	
	public Category getCat() 
	{
		return this.cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}

	public List<Category> getCategoryList() 
	{
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) 
	{
		this.categoryList = categoryList;
	}
	
	
	public Double getBalance() 
	{
		return balance;
	}


	public void setBalance(Double balance) 
	{
		this.balance = balance;
	}

	public void balance()
	{
		
	}
	public void checkBalance()
	{
		
	}
	@Override
	public boolean register() 
	{
		return pDAO.create_(((Member) this));
	}
	@Override
	public boolean login() 
	{
		return this.pDAO.login((Member)this);
	}
	@Override
	public Person find()  
	{
		return this.pDAO.find((Member)this);
	}


	@Override
	public String toString() {
		return "   .." + cat + " "  + "nom" +" " + this.name + "  prenom "+ "  " + this.firstname +" "
	+ " email "+ this.email + " " + "tel" + this.telephon;
	}
	
	
}
