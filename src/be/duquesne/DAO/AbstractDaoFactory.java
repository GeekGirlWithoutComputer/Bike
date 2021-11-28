package be.duquesne.DAO;
import be.duquesne.POJO.*;

public abstract class  AbstractDaoFactory 
{
	// Liste des types DAO supportés par l'appli, on peut aussi commencer a '1' 
	
		public static final int DAO_FACTORY = 0;
		public static final int XML_DAO_FACTORY = 1;
		
		// une méthode pour chaque DAO qui peut être réaliser 

		

		public abstract PersonDAO getPersonneDAO();

		public abstract DAO<Stroll> getStrollDAO();
		public abstract DAO<Bike> getBikeDAO();
		public abstract DAO<Category> getCategoryDAO();

		public abstract DAO<Calendar> getCalendarDAO();
		public abstract DAO<Car> getCarDAO();

		

		

		public static AbstractDaoFactory  getFactory(int type) 
		{
			switch (type) 
			{
			case DAO_FACTORY:
				return new DaoFactory();
			case XML_DAO_FACTORY:
//		        return new XMLDAOFactory(); ici y en pas pas 
			default:
				return null;
			}
		}
}
