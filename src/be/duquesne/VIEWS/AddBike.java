package be.duquesne.VIEWS;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import be.duquesne.POJO.Bike;
import be.duquesne.POJO.Car;
import be.duquesne.POJO.Person;

public class AddBike extends JFrame 
{

	private JPanel contentPane;
	private JPanel panel;
	private AddBike activity;
	private Person personne;
	private Car car;
	private JSpinner pds,lg;
	private JTextField type;
	private Bike bike;
	

	public AddBike(Person p, Car c) 
	{
		activity=this;
		this.personne=p;
		this.car=c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel() 
		{
			public void paintComponent(Graphics g) 
			{
				Image img = Toolkit.getDefaultToolkit()
						.getImage(MainActivity.class
								.getResource("/be/duquesne/IMG/bk.jpg")
								);
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panel.setBounds(0, 2, 424, 259);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel poids = new JLabel("Poids du v\u00E9lo");
		poids.setBounds(10, 70, 188, 24);
		panel.add(poids);
		
		JLabel longueur = new JLabel("Longueur du v\u00E9lo");
		longueur.setBounds(10, 105, 188, 24);
		panel.add(longueur);
		
		JButton btnNewButton = new JButton("Ajouter ");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				addBike();
			}
		});
		btnNewButton.setBounds(38, 192, 160, 49);
		panel.add(btnNewButton);
		
		JLabel lblImmatriculation = new JLabel("Type de v\u00E9lo");
		lblImmatriculation.setBounds(10, 35, 188, 24);
		panel.add(lblImmatriculation);
		
		type = new JTextField();
		type.setBounds(218, 37, 194, 20);
		type.setColumns(10);
		panel.add(type);
		
		pds = new JSpinner();
		pds.setBounds(218, 72, 89, 20);
		pds.setModel(new SpinnerNumberModel(new Double(0), null, null, new Double(1)));//** prob flot
		panel.add(pds);
		
		lg = new JSpinner();
		lg.setBounds(218, 107, 89, 20);
		lg.setModel(new SpinnerNumberModel(new Double(0), null, null, new Double(1)));//** prob flot
		panel.add(lg);
		
		JButton btnNewButton_1 = new JButton("Quitter");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				activity.dispose();
			}
		});
		btnNewButton_1.setBounds(218, 192, 159, 49);
		panel.add(btnNewButton_1);
	}
	
	private boolean addBike() 
	{
		Double wgt=(Double) pds.getValue();
		Double lgt=(Double) lg.getValue();
		
		String typeV= type.getText();
		
		bike=new Bike(wgt,lgt,typeV,car,personne);
		
		JOptionPane.showMessageDialog(null,"no voit "+ car.getNumCar());
		JOptionPane.showMessageDialog(null,"no personne "+ personne.getNumPerson());
		Boolean oki= bike.addBike();
		if(oki)
		{
			JOptionPane.showMessageDialog(null, "vélo ajouté ");
			return true;
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "problème lors de l'ajout");
			return false;
		}
		
	}

}
