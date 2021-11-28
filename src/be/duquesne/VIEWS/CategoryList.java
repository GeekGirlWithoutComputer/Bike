package be.duquesne.VIEWS;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import be.duquesne.POJO.Category;
import be.duquesne.POJO.Person;

public class CategoryList extends JFrame 
{

	private JPanel contentPane;
	
	private List<Category> all = new ArrayList<Category>();
	private JComboBox<Category> sp_cm;
	private Category lacat;
	private JTextField un;
	private JTextField deux;
	private JTextField date;
	private JTextField nb;
	private JTextField sp;
	
	private JTextField spp;
	private CategoryList activity;
	private JButton btnNewButton;
	private Person personne;
	public CategoryList(Person p) 
	{
		activity=this;
		this.personne=p;
		List();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		sp_cm = new JComboBox<Category>();
		sp_cm.setBounds(10, 24, 403, 32);
		contentPane.add(sp_cm);
		
		 un = new JTextField();
		 un.setBounds(10, 86, 264, 32);
		 contentPane.add(un);
		 un.setColumns(10);
		    
		 deux = new JTextField();
		 deux.setBounds(10, 129, 264, 28);
		 contentPane.add(deux);
		 deux.setColumns(10);
		    
		 btnNewButton = new JButton("Choisir");
		 btnNewButton.addActionListener(new ActionListener() 
		 {
		 	public void actionPerformed(ActionEvent e) 
		 	{
		 		Boolean oki=p.updateCategory();
		 	
		 		if(oki)
				{
					JOptionPane.showMessageDialog(null, "catégorie mise à jour  ");
					
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "catégorie inchangée ");
					
				}
				activity.dispose();
		 	}
		 });
		 btnNewButton.setBounds(185, 227, 182, 23);
		 contentPane.add(btnNewButton);
		
		createCombobox();
	}
	public void List() 
	{
		Category ct = new Category();
		all = ct.findAll();
	}
	public Category createCombobox() 
	{
		Category ct = new Category();
		ct.findAll();
		sp_cm.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				activity.setId();
			}
		});
		
		for (Category  sp:all) 
		{
			sp_cm.addItem(sp);
		};

		return lacat =(Category) sp_cm.getSelectedItem();
	}
	
	public void setId()
	{
		Category ct = new Category();
		ct= (Category) sp_cm.getSelectedItem();
		un.setText("no  : "+ct.getCodeCat());
		deux.setText("nom : "+ ct.getType());
		
	}	
}
