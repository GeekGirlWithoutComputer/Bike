package be.duquesne.VIEWS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import be.duquesne.POJO.Category;
import be.duquesne.POJO.Category.TypesMember;
import be.duquesne.POJO.Category.TypesVtt;
import be.duquesne.POJO.Member;
import be.duquesne.POJO.Person;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
/**/
public class Register extends JFrame 
{

	private JPanel contentPane;
	private JPanel panel_1;
	private JTextField name;
	private JTextField firstname;
	private JTextField email;
	private JTextField password;
	private JComboBox comboBox;
	private List<Person> all = new ArrayList<Person>();
	private JTextField adress;
	private JTextField telephon;
	private TypesVtt place = TypesVtt.CYCLO;
	private TypesMember p;
	ButtonGroup bG = new ButtonGroup();
	private String choose;
	private Member m;
	private Category cat ;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_4;
	private JTextField textField_3;
	private JLabel lblNewLabel_5;
	private Category lacat;
	private JTextField un;
	private JTextField deux;
	private Register activity;
	
	private List<Category> allC = new ArrayList<Category>();
	private JComboBox<Category> sp_cm;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblMotDePasse;
	private JTextField textField_6;
	private JLabel lblNewLabel_6;
	private JTextField textField_7;
	private JLabel lblTelephone;
	private JTextField textField_8;
	private JLabel lblAdresse;

	
	public Register()
	{
		List();
		this.cat= new Category();
		
		 activity=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	    panel_1 = new JPanel() 
	    {
			public void paintComponent(Graphics g) 
			{
				Image img = Toolkit.getDefaultToolkit()
						.getImage(MainActivity.class
								.getResource("/be/duquesne/IMG/R.jpg")
								);
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panel_1.setBounds(22, 10, 662, 371);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		name = new JTextField();
		name.setBounds(18, 25, 185, 25);
		panel_1.add(name);
		name.setColumns(10);

		sp_cm = new JComboBox<Category>();
		sp_cm.setBounds(324, 210, 292, 33);
		panel_1.add(sp_cm);
		firstname = new JTextField();
		firstname.setColumns(10);
		firstname.setBounds(22, 75, 185, 33);
		panel_1.add(firstname);

		
		
		JLabel lblCat = new JLabel("De quelle categorie d\u00E9sirez vous faire partie ?");
		lblCat.setBounds(10, 203, 353, 33);
		panel_1.add(lblCat);
		
		

		un = new JTextField();
	    un.setBounds(11, 266, 226, 32);
	    panel_1.add(un);
	    un.setColumns(10);
	    
	    deux = new JTextField();
	    deux.setBounds(12, 298, 226, 32);
	    panel_1.add(deux);
	    deux.setColumns(10);
	    
	    JLabel lblName = new JLabel("NOM");
	    lblName.setHorizontalAlignment(SwingConstants.CENTER);
	    lblName.setBounds(22, 10, 185, 14);
	    panel_1.add(lblName);
	    
	    JLabel lblFirstname = new JLabel("PRENOM");
	    lblFirstname.setHorizontalAlignment(SwingConstants.CENTER);
	    lblFirstname.setBounds(20, 53, 185, 22);
	    panel_1.add(lblFirstname);
	    
	    password = new JTextField();
	    password.setColumns(10);
	    password.setBounds(297, 103, 185, 33);
	    panel_1.add(password);
	    
	    lblMotDePasse = new JLabel("MOT DE PASSE");
	    lblMotDePasse.setHorizontalAlignment(SwingConstants.CENTER);
	    lblMotDePasse.setBounds(297, 74, 185, 22);
	    panel_1.add(lblMotDePasse);
	    
	    email= new JTextField();
	    email.setColumns(10);
	    email.setBounds(297, 38, 185, 33);
	    panel_1.add(email);
	    
	    lblNewLabel_6 = new JLabel("EMAIL");
	    lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_6.setBounds(297, 6, 185, 28);
	    panel_1.add(lblNewLabel_6);
	    
	    telephon = new JTextField();
	    telephon.setBounds(22, 135, 186, 32);
	    panel_1.add(telephon);
	    telephon.setColumns(10);
	    
	    lblTelephone = new JLabel("TELEPHONE");
	    lblTelephone.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTelephone.setBounds(24, 111, 185, 22);
	    panel_1.add(lblTelephone);
	    
	    adress = new JTextField();
	    adress.setBounds(256, 159, 354, 29);
	    panel_1.add(adress);
	    adress.setColumns(10);
	    
	    lblAdresse = new JLabel("ADRESSE");
	    lblAdresse.setHorizontalAlignment(SwingConstants.CENTER);
	    lblAdresse.setBounds(257, 136, 349, 22);
	    panel_1.add(lblAdresse);
	    
	  
		
		
		
		
	    createCombobox();
	    createChoise() ;
		
		
		
	}
	
	
	
	
	
	private void createChoise() 
	{
		 
		
		 
		 JButton btnNewButton_1 = new JButton("enregistrer votre vehicule");
		 btnNewButton_1.setBounds(66, 487, 299, 23);
		 panel_1.add(btnNewButton_1);
		 
		 JButton btnRegis = new JButton("Valider");
		 btnRegis.addActionListener(new ActionListener() 
		 {
		 	public void actionPerformed(ActionEvent e) 
		 	{
		 		/*on suppose qu il n y a que des membres qui s inscrivent , le tresorier a ses logs differemment vu sa position */
		 		String statut = "MEMBER";
		 		
		 		Person membre;
		 		
		 		int id=cat.findId();
		 		membre= new Member 
		 				(name.getText(),
		 		firstname.getText(),
		 		telephon.getText(),
		 		password.getText(),
		 		email.getText(),
		 				 		statut, adress.getText(),
		 				 		createCombobox() );
		 				 		//place);
		 		Person oki = membre.find();
		 		
		 		if(oki == null) 
				{
					Boolean oki2=membre.register();
							
					
					//JOptionPane.showMessageDialog(null, "register  ??:"+oki2);
					JOptionPane.showMessageDialog(null, "find id  ??:"+id);
					JOptionPane.showMessageDialog(null, "cat   ??:"+cat );
					JOptionPane.showMessageDialog(null, "combo box   ??:"+ createCombobox()  );
					
					if(oki2) 
					{
						JOptionPane.showMessageDialog(null, "Compte crée avec succes !");

						Registery page = new Registery();
						
						page.setVisible(true);
						activity.dispose();
					}
					
					else 
					{
						JOptionPane.showMessageDialog(null, "Erreur lors de la création du compte.");
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Utilisateur  deja existant.");
				}
				
		 		
		 		
		 	}
		 });
		 btnRegis.setBounds(330, 361, 149, 33);
		 panel_1.add(btnRegis);
		
		
		 
	
	}
	
	

	
	
	
	public TypesMember setId3() 
	{
		Category ct = new Category();
		
		un.setText("no  : "+ct.getCodeCat());
		deux.setText("nom : "+ ct.getType());
		return p= (TypesMember) comboBox.getSelectedItem();

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
		//JOptionPane.showMessageDialog(null, "taille radio ."+ size.toString());
		
		for (Category  sp:
			allC) 
		{
			sp_cm.addItem(sp);
		}		
		// JOptionPane.showMessageDialog( null,"item id ."+currentSpectacle); // test
		
		;
	
		return ct =(Category) sp_cm.getSelectedItem();
	}
	public void setId()
	{
		Category ct = new Category();
		ct= (Category) sp_cm.getSelectedItem();
		
		un.setText("no  : "+ct.getCodeCat());
		deux.setText("nom : "+ ct.getType());
		
		
		
		
		
		
		
	}	
	
	public void List_() 
	{
		
		Person pt = new Person();
		all = pt.findAll();
	}
	public void List() 
	{
		Category ct = new Category();
		allC = ct.findAll();
	}
}


