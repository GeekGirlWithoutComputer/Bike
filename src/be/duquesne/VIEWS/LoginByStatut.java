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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import be.duquesne.POJO.Member;
import be.duquesne.POJO.Person;
import be.duquesne.POJO.Responsible;
import be.duquesne.POJO.Treasurer;

public class LoginByStatut extends JFrame 
{

	private JPanel contentPane;

	public LoginByStatut() 
	{
		LoginByStatut activity=this;
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 263);
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// creation d un panel pour taper une photo en background 
		JPanel panel_1 = new JPanel() 
		{
			public void paintComponent(Graphics g) 
			{
				Image img = Toolkit.getDefaultToolkit()
						.getImage(MainActivity.class
								.getResource("/be/duquesne/IMG/cx.jpg")
								);
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panel_1.setBounds(10, 0, 434, 331);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		
		
		
		panel_1.setBounds(22, 10, 662, 371);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		/***********************************************************************************************************
		 * 
		 * 
		 * pour se connecter il faudra choisir son statut 
		 * si la personne se trompe mais quelle rentre qd meme des infos presentes ds la db ca ne marchera pas 
		 * car on verif sur le mail, le mdp et le statut 
		 * 
		 * 
		 * 
		 * **********************************************************************************************************/
		
		JButton btnMember = new JButton("MEMBER");
		btnMember.setForeground(UIManager.getColor("CheckBox.focus"));
		btnMember.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 15));
		btnMember.setBackground(Color.DARK_GRAY);
		btnMember.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Login page = new Login(Member.statut);
				page.setVisible(true);
				activity.dispose();
			}
		});
		btnMember.setBounds(98, 168, 147, 65);
		panel_1.add(btnMember);
		
		
		
		JButton btnRetour = new JButton("RETOUR MENU PRINCIPAL");
		btnRetour.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnRetour.setBounds(141, 319, 485, 48);
		btnRetour.setBackground(Color.RED);
		btnRetour.setForeground(UIManager.getColor("CheckBox.darkShadow"));
		btnRetour.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				StartActivity page = new StartActivity();
				page.setVisible(true);
				activity.dispose();
			}
		});
		panel_1.add(btnRetour);
		
		panel_1.setBounds(10, 11, 694, 390);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Connexion en tant que :");
		lblNewLabel.setBackground(UIManager.getColor("Button.light"));
		lblNewLabel.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(31, 17, 598, 72);
		panel_1.add(lblNewLabel);
		
		JButton btnTreasurer = new JButton("TREASURER");
		btnTreasurer.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Login page = new Login(Treasurer.statut);
				page.setVisible(true);
				activity.dispose();
			}
		});
		btnTreasurer.setBackground(Color.DARK_GRAY);
		btnTreasurer.setForeground(UIManager.getColor("CheckBox.focus"));
		btnTreasurer.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 15));
		btnTreasurer.setBounds(462, 168, 147, 65);
		panel_1.add(btnTreasurer);
		
		JButton btnResponsible = new JButton("RESPONSIBLE");
		btnResponsible.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Login page = new Login(Responsible.statut);
				page.setVisible(true);
				activity.dispose();
			}
		});
		btnResponsible.setForeground(UIManager.getColor("CheckBox.focus"));
		btnResponsible.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 15));
		btnResponsible.setBackground(Color.DARK_GRAY);
		btnResponsible.setBounds(273, 168, 147, 65);
		panel_1.add(btnResponsible);
		
		
		
		
		
		

		
		}	
	}
