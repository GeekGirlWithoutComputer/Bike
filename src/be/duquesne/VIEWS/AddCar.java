package be.duquesne.VIEWS;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.duquesne.POJO.Car;
import be.duquesne.POJO.Person;
import be.duquesne.POJO.Stroll;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCar extends JFrame 
{

	private JPanel contentPane;
	private JPanel panel;
	private JTextField txtImma;
	private JSpinner JSNbPass,JSVelo;
	private Car car;
	private Person person;
	private AddCar activity;

	
	public AddCar(Person person) 
	{
		this.person=person;
		activity=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel() 
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
		
		JLabel lblNewLabel = new JLabel("Nombre de places passagers:");
		lblNewLabel.setBounds(10, 70, 188, 24);
		panel.add(lblNewLabel);
		
		JLabel lblNombreDePlaces = new JLabel("Nombre de places v\u00E9lo:");
		lblNombreDePlaces.setBounds(10, 105, 188, 24);
		panel.add(lblNombreDePlaces);
		
		JButton btnNewButton = new JButton("Ajouter ");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				addCar();
			}
		});
		btnNewButton.setBounds(38, 192, 160, 49);
		panel.add(btnNewButton);
		
		JLabel lblImmatriculation = new JLabel("Immatriculation");
		lblImmatriculation.setBounds(10, 35, 188, 24);
		panel.add(lblImmatriculation);
		
		txtImma = new JTextField();
		txtImma.setBounds(218, 37, 194, 20);
		txtImma.setColumns(10);
		panel.add(txtImma);
		
		JSNbPass = new JSpinner();
		JSNbPass.setBounds(218, 72, 89, 20);
		panel.add(JSNbPass);
		
		JSVelo = new JSpinner();
		JSVelo.setBounds(218, 107, 89, 20);
		panel.add(JSVelo);
		
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
	
	private boolean addCar() 
	{
		int nbP=(int) JSNbPass.getValue();
		int nbV=(int) JSVelo.getValue();
		
		String imm= txtImma.getText();
		
		car= new Car(imm,nbV,nbP,person);
		Boolean oki= car.addCar();
		if(oki)
		{
			JOptionPane.showMessageDialog(null, "oki ");
			return true;
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "no");
			return false;
		}
		
	}
}
