package be.duquesne.VIEWS;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.duquesne.POJO.Person;
import be.duquesne.POJO.Stroll;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;

public class StrollRegistration extends JFrame 
{

	private JPanel contentPane;
	private JPanel panel;
	private Stroll str;
	private Person personne;
	private StrollRegistration activity;
	private JTextField txtNom;
	private JTextField txtLieu;
	private JButton btnRetourChoixBalade;
	private ButtonGroup choix = new ButtonGroup();
	private ButtonGroup choix2 = new ButtonGroup();
	private JTextField txtForfait;
	private JButton btnCarList;
	private JRadioButton rdbtnDriver;

	public StrollRegistration(Stroll stroll,Person personne) 
	{
		this.str=stroll;
		this.personne=personne;
		activity=this;
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
								.getResource("/be/duquesne/IMG/vl.jpg")
								);
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panel.setBounds(0, 11, 434, 250);
		contentPane.add(panel);
		panel.setLayout(null);

		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBounds(21, 227, 191, 23);
		panel.add(btnNewButton);
		
		txtNom = new JTextField();
		txtNom.setBounds(21, 21, 210, 20);
		panel.add(txtNom);
		txtNom.setColumns(10);
		txtNom.setText("nom  : "+stroll.getPlaceOfDepartune());
		
		txtLieu = new JTextField();
		txtLieu.setBounds(21, 46, 210, 20);
		panel.add(txtLieu);
		txtLieu.setColumns(10);
		txtLieu.setText("Lieu  : "+stroll.getNameStroll());
		
		btnRetourChoixBalade = new JButton("Retour choix balade");
		btnRetourChoixBalade.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				StrollList frame = new StrollList(personne);
				frame.setVisible(true);
				activity.dispose();
			}
		});
		btnRetourChoixBalade.setBounds(249, 227, 162, 23);
		panel.add(btnRetourChoixBalade);
		
		JLabel lblNewLabel = new JLabel("Etes vous :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblNewLabel.setBounds(21, 98, 162, 14);
		panel.add(lblNewLabel);
		
		JRadioButton rdbtnPassager = new JRadioButton("Passager");
		rdbtnPassager.setBounds(21, 120, 145, 23);
		panel.add(rdbtnPassager);
		
		JLabel lblNewLabel_1 = new JLabel("Avez vous un v\u00E9lo?");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblNewLabel_1.setBounds(249, 23, 162, 18);
		panel.add(lblNewLabel_1);
		
		JRadioButton rdbtnYes = new JRadioButton("OUI");
		rdbtnYes.setBounds(249, 45, 65, 23);
		panel.add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("NON");
		rdbtnNo.setBounds(346, 45, 65, 23);
		panel.add(rdbtnNo);
		/*
		 * essentiel de faire cela car sinon on peut sélectionner oui et non en même temps donc on les regroupe pour n'autoriser
		 * qu un seul choix           */
		choix.add(rdbtnYes);
		choix.add(rdbtnNo);
		
		txtForfait = new JTextField();
		txtForfait.setText("no  : <dynamic>");
		txtForfait.setColumns(10);
		txtForfait.setBounds(21, 67, 213, 20);
		panel.add(txtForfait);
		txtForfait.setText("forfait  : "+stroll.getCost());
		
		btnCarList = new JButton("Liste des voiture pour covoiturage");
		btnCarList.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				CarList page = new CarList (personne);
				page.setVisible(true);
				activity.dispose();
			}
		});
		btnCarList.setBounds(145, 193, 279, 23);
		panel.add(btnCarList);
		
		rdbtnDriver = new JRadioButton("Conducteur");
		rdbtnDriver.setBounds(21, 146, 109, 23);
		panel.add(rdbtnDriver);
		choix2.add(rdbtnDriver);
		choix2.add(rdbtnDriver);
	}
}
