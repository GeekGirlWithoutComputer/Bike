package be.duquesne.VIEWS;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import be.duquesne.POJO.Car;
import be.duquesne.POJO.Category;
import be.duquesne.POJO.Person;

public class CarList extends JFrame 
{

	private JPanel contentPane;
	private JPanel panel;
	
	private List<Car> all = new ArrayList<Car>();
	private JComboBox<Car> sp_cm;
	private Car car;
	private JTextField un;
	private JTextField deux;
	private JTextField date;
	private JTextField nb;
	private JTextField sp;
	
	private JTextField spp;
	private CarList activity;
	private JButton btnNewButton;
	private JTextField txtnbre;
	private JButton btnNewButton_1;
	private Person personne;
	private JTextField textnbrC;
	private JButton btnBike;
	

	public CarList(Person p) 
	{
		car=new Car();
		activity=this;
		this.personne=p;
		List();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel = new JPanel() 
		{
			public void paintComponent(Graphics g) 
			{
				Image img = Toolkit.getDefaultToolkit()
						.getImage(MainActivity.class
								.getResource("/be/duquesne/IMG/car.jpg")
								);
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panel.setBounds(0, 2, 424, 259);
		contentPane.add(panel);
		panel.setLayout(null);
		sp_cm = new JComboBox<Car>();
		sp_cm.setBounds(10, 11, 404, 32);
		panel.add(sp_cm);
		
		 	un = new JTextField();
		    un.setBounds(10, 98, 264, 32);
		    panel.add(un);
		    un.setColumns(10);
		    
		    btnNewButton = new JButton("Choisir pour covoiturer ");
		    btnNewButton.addActionListener(new ActionListener() 
		    {
		    	public void actionPerformed(ActionEvent e) 
		    	{
		    		//StrollRegistration page = new StrollRegistration (createCombobox(),personne);
					//page.setVisible(true);
					activity.dispose();
		    	}
		    });
		    btnNewButton.setBounds(10, 225, 227, 23);
		    panel.add(btnNewButton);
		    
		    txtnbre = new JTextField();
		    txtnbre.setBounds(10, 138, 140, 23);
		    panel.add(txtnbre);
		    txtnbre.setColumns(10);
		    
		    deux = new JTextField();
		    deux.setBounds(10, 70, 264, 28);
		    panel.add(deux);
		    deux.setColumns(10);
		    
		    btnNewButton_1 = new JButton("Quitter");
		    btnNewButton_1.addActionListener(new ActionListener() 
		    {
		    	public void actionPerformed(ActionEvent e) 
		    	{
		    		activity.dispose();
		    	}
		    	
		    });
		    btnNewButton_1.setBounds(267, 225, 134, 23);
		    panel.add(btnNewButton_1);
		    
		    textnbrC = new JTextField();
		    textnbrC.setBounds(10, 172, 140, 23);
		    panel.add(textnbrC);
		    textnbrC.setColumns(10);
		    
		    btnBike = new JButton("Ajouter votre v\u00E9lo");
		    btnBike.addActionListener(new ActionListener() 
		    {
		    	public void actionPerformed(ActionEvent e) 
		    	{
		    		
		    		AddBike page = new AddBike(personne,car);
	 				page.setVisible(true);
	 				activity.dispose();
		    	}
		    });
		    btnBike.setBounds(232, 156, 169, 23);
		    panel.add(btnBike);
		   
			
				 
			
		
		createCombobox();
	}
	public void List() 
	{
		
		all = car.findAll();
	}
	public Car createCombobox() 
	{
		
		List();
		sp_cm.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				activity.setId();
			}
		});

		for (Car  sp:all) 	
		{
			sp_cm.addItem(sp);
		};		
	
		return car =(Car) sp_cm.getSelectedItem();
	}
	
	public void setId()
	{
		
		car= (Car) sp_cm.getSelectedItem();
		un.setText("nom personne  : "+car.getPerson().getAdress());
		deux.setText("immatric: "+ car.getImmatriculation());
		txtnbre.setText("place velo : "+ car.display_place_bike());
		textnbrC.setText("place passager : "+ car.display_place_passenger());
		
		
		
		
	}	

}
