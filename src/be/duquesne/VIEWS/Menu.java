package be.duquesne.VIEWS;

import java.awt.BorderLayout;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;




import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.JComboBox;

import be.duquesne.POJO.Person;

import javax.swing.JButton;

public class Menu extends JFrame 
{

	private JPanel contentPane;
	private JPanel panel;
	private Person personne;
	private JButton btnReserverUneBalade;
	private JButton btnAjouterDesDisponibilits;
	private JButton btnAjouterUnVehicule;
	private JButton btnChoisirUneAutre;
	private Menu activity;
	
	
	public Menu(Person personne)  
	{
		this.personne = personne;
		activity = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel() 
		{
			public void paintComponent(Graphics g) 
			{
				Image img = Toolkit.getDefaultToolkit()
						.getImage(MainActivity
						.class.getResource("/be/duquesne/IMG/s2.jpg"));
						g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panel.setBounds(20, 0, 662, 392);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnRetour = new JButton("DECONNEXION");
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRetour.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				StartActivity  page = new StartActivity () ;
				page.setVisible(true);
				activity.dispose();
			}
		});
		btnRetour.setForeground(Color.BLACK);
		btnRetour.setBackground(Color.RED);
		btnRetour.setBounds(445, 322, 207, 57);
		panel.add(btnRetour);
		
		
		JLabel lblType = new JLabel("BONJOUR  : " 
		+" " + personne.getStatut() + "  "
		+" " +personne.getEmail()
														
		           );
		lblType.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 15));
		lblType.setForeground(Color.WHITE);
		lblType.setBounds(92, 11, 563, 74);
		panel.add(lblType);
		
		MemberMenu();
		JOptionPane.showMessageDialog(null,"dmail: "+personne.getEmail());
	}
	
	public void loadMenu() 
	{
		switch (personne.getStatut()) 
		{
			case "MEMBER":
				
				break;
			case "TREASURER":
	
				
				break;
			case "RESPONSIBLE":
				
				break;
			
		}
	}
	public void MemberMenu()
	{
		btnReserverUneBalade = new JButton("Reserver une balade");
		btnReserverUneBalade.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				StrollList frame = new StrollList();
				frame.setVisible(true);
				activity.dispose();
			}
		});
		btnReserverUneBalade.setForeground(Color.BLACK);
		btnReserverUneBalade.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReserverUneBalade.setBackground(Color.RED);
		btnReserverUneBalade.setBounds(10, 125, 357, 44);
		panel.add(btnReserverUneBalade);
		
		btnAjouterDesDisponibilits = new JButton("Ajouter des disponibilit\u00E9s de covoiturage");
		btnAjouterDesDisponibilits.setForeground(Color.BLACK);
		btnAjouterDesDisponibilits.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAjouterDesDisponibilits.setBackground(Color.RED);
		btnAjouterDesDisponibilits.setBounds(10, 180, 357, 44);
		panel.add(btnAjouterDesDisponibilits);
		
		btnAjouterUnVehicule = new JButton("Ajouter un vehicule");
		btnAjouterUnVehicule.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				AddCar page = new AddCar(personne);
				page.setVisible(true);
				activity.dispose();
			}
		});
		btnAjouterUnVehicule.setForeground(Color.BLACK);
		btnAjouterUnVehicule.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAjouterUnVehicule.setBackground(Color.RED);
		btnAjouterUnVehicule.setBounds(10, 235, 357, 44);
		panel.add(btnAjouterUnVehicule);
		btnChoisirUneAutre = new JButton("Choisir une autre categorie de type de balade");
		btnChoisirUneAutre.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//le membre s inscrit pr 20 euros il a une categorie fixe s il choisit une autre un update de la categorie se 
				// fait et il paie 5e en plus 
			}
		});
		btnChoisirUneAutre.setForeground(Color.BLACK);
		btnChoisirUneAutre.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnChoisirUneAutre.setBackground(Color.RED);
		btnChoisirUneAutre.setBounds(10, 290, 357, 44);
		panel.add(btnChoisirUneAutre);
	}

}
