package be.duquesne.VIEWS;

import java.awt.BorderLayout;


import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import be.duquesne.POJO.*;


import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame
{
	
	

	private JPanel contentPane;
	/*l connexion se fait sur un email et un mdp*/
	private JTextField email;
	private JTextField password;

	/* soit un membre soit le tresorerie c est pourquoi il faut les dissocier afin d afficher le menu adapte a celui
	 * qui va se connecter */
	public Login(String statut) 
	{
		
		Login activity = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 431);
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
								.getResource("/be/duquesne/IMG/c.jpg")
								);
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panel.setBounds(0, 2, 682, 390);
		contentPane.add(panel);
		panel.setLayout(null);

		email = new JTextField();
		email.setBounds(178, 100, 325, 35);
		panel.add(email);
		email.setColumns(10);

		JLabel lblNewLabel = new JLabel("\tEMAIL");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(178, 77, 139, 13);
		panel.add(lblNewLabel);

		JLabel lblMotDePasse = new JLabel("MOT DE PASSE");
		lblMotDePasse.setForeground(new Color(255, 255, 0));
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMotDePasse.setBounds(178, 145, 139, 13);
		panel.add(lblMotDePasse);

		password = new JTextField();
		password.setColumns(10);
		password.setBounds(178, 168, 325, 35);
		panel.add(password);

		JButton btnConnect = new JButton("    CONNEXION    ");
		btnConnect.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				
				Person personne = new Person();
				boolean oki= false;
				
				
				try
				{
					personne.setEmail(email.getText());
					personne.setStatut(statut);
					personne.setPassword(password.getText());
					oki = personne.login();
				} 
				catch (Exception e1) 
				{
					e1.printStackTrace();
				}
				
				if (oki) 
				{
					Person find = personne.find();
					find.setStatut(statut);
					Menu menu  = new Menu(find);
					menu.setVisible(true);
					activity.dispose();
				} 
				else 
				{

					//JOptionPane.showMessageDialog(null, password.getText());
					//JOptionPane.showMessageDialog(null, email.getText());
					//JOptionPane.showMessageDialog(null, statut);
					JOptionPane.showMessageDialog(null, "log incorrects ");
				}

			
						
						
					
			}
		});
		btnConnect.setForeground(Color.WHITE);
		btnConnect.setBackground(Color.DARK_GRAY);
		btnConnect.setBounds(178, 221, 322, 35);
		panel.add(btnConnect);

		JButton btnRetour = new JButton("RETOUR AU MENU ");
		btnRetour.setBackground(Color.DARK_GRAY);
		btnRetour.setForeground(Color.WHITE);
		btnRetour.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				StartActivity page = new StartActivity();
				page.setVisible(true);
				activity.dispose(); 
			}
		});
		
		btnRetour.setBounds(368, 314, 281, 41);
		panel.add(btnRetour);
	}

}
