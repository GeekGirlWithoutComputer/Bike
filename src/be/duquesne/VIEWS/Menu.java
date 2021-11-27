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
import javax.swing.UIManager;

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
	private JButton btnNewButton;
	private JButton btnVerifierPaiementDu;
	private JButton btnVerifierPaiementDu_1;
	
	
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
		panel.setBounds(20, -11, 662, 392);
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
		+" " + personne.getStatut() + "  " +  personne.getAdress() 
		
														
		           );
		lblType.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 15));
		lblType.setForeground(Color.WHITE);
		lblType.setBounds(31, 47, 563, 74);
		panel.add(lblType);
		
		loadMenu() ;
		
	}
	
	public void loadMenu() 
	{
		switch (personne.getStatut()) 
		{
			case "MEMBER":
				memberMenu();
				break;
			case "TREASURER":
				treasurerMenu();
				
				break;
			case "RESPONSIBLE":
				responsibleMenu();
				break;
			
		}
	}
	public void memberMenu()
	{
		btnReserverUneBalade = new JButton("Reserver une balade");
		btnReserverUneBalade.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				StrollList frame = new StrollList(personne);
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
		
		btnAjouterUnVehicule = new JButton("Ajouter votre vehicule");
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
	
	public void responsibleMenu()
	{
		
	}
	public void treasurerMenu()
	{
		btnNewButton = new JButton("Verifier paiement cotisation");
		btnNewButton.setForeground(UIManager.getColor("CheckBox.focus"));
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBounds(41, 132, 287, 36);
		panel.add(btnNewButton);
		
		btnVerifierPaiementDu = new JButton("Verifier paiement du covoiturage");
		btnVerifierPaiementDu.setForeground(Color.BLACK);
		btnVerifierPaiementDu.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 15));
		btnVerifierPaiementDu.setBounds(41, 190, 287, 36);
		panel.add(btnVerifierPaiementDu);
		
		btnVerifierPaiementDu_1 = new JButton("Verifier paiement du covoiturage");
		btnVerifierPaiementDu_1.setForeground(Color.BLACK);
		btnVerifierPaiementDu_1.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 15));
		btnVerifierPaiementDu_1.setBounds(41, 236, 287, 36);
		panel.add(btnVerifierPaiementDu_1);
	}
}
