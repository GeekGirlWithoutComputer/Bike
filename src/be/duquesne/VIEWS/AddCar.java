package be.duquesne.VIEWS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
	private JTextField txtImma;
	private JSpinner JSNbPass,JSVelo;
	private Car car;
	private Person person;

	
	public AddCar(Person person) 
	{
		this.person=person;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre de places passagers:");
		lblNewLabel.setBounds(10, 70, 188, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombreDePlaces = new JLabel("Nombre de places v\u00E9lo:");
		lblNombreDePlaces.setBounds(10, 105, 188, 24);
		contentPane.add(lblNombreDePlaces);
		
		JButton btnNewButton = new JButton("Ajouter ");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				addCar();
			}
		});
		btnNewButton.setBounds(245, 211, 136, 39);
		contentPane.add(btnNewButton);
		
		JLabel lblImmatriculation = new JLabel("Immatriculation");
		lblImmatriculation.setBounds(10, 35, 188, 24);
		contentPane.add(lblImmatriculation);
		
		txtImma = new JTextField();
		txtImma.setBounds(218, 37, 194, 20);
		contentPane.add(txtImma);
		txtImma.setColumns(10);
		
		JSNbPass = new JSpinner();
		JSNbPass.setBounds(218, 72, 89, 20);
		contentPane.add(JSNbPass);
		
		JSVelo = new JSpinner();
		JSVelo.setBounds(218, 107, 89, 20);
		contentPane.add(JSVelo);
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
