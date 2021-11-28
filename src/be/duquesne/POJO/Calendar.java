package be.duquesne.POJO;

import java.util.ArrayList;
import java.util.List;

public class Calendar 
{
	

	public List<Stroll> strollList;

    private static Calendar _instance = null;
    private Calendar()
    {
        this.strollList = new ArrayList<Stroll>();
    }
    
    public static Calendar Instance()
    {
        if(_instance == null)
        {
            _instance = new Calendar();
        }
        return _instance;
    }

    public void AddStroll(Stroll stroll)
    {
       
        stroll.AddStroll();
    }

    public List<Stroll> GetStroll(Stroll stroll)
    {
       
        return stroll.findAll();
    }
   

}
