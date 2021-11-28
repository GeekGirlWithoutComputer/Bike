package be.duquesne.VIEWS;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.duquesne.POJO.Person;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JRadioButton;

public class Payement extends JFrame
{

	private JPanel contentPane;
	private Person personne;
	
	private Payement activity;
	
	private JPanel panel;
	private ButtonGroup modeDeLivraison = new ButtonGroup();
	private ButtonGroup modeDePaiement = new ButtonGroup();
	private JLabel lblPrix;
	private JLabel lblPrixValue;
	private JLabel lblNewLabel_1;
	private boolean isClicked = false;
	private JButton btnRetou;
	
	int nbrBronze, nbrArgent, nbrOr , nbrDiamant , nbrBase;
	public Payement() 
	{
		
		activity = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 383);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 60, 431, 276);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnAcheter = new JButton("PAYER");
		btnAcheter.setBackground(Color.DARK_GRAY);
		btnAcheter.setForeground(Color.WHITE);
		btnAcheter.setBounds(142, 201, 138, 40);
		btnAcheter.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null, "Paiement effectué");
				payer();
				
			}
		});
		panel.add(btnAcheter);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		panel_1.setBounds(0, 0, 451, 43);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel labelTitre = new JLabel("Paiement");
		labelTitre.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitre.setBounds(10, 0, 429, 39);
		labelTitre.setFont(new Font("Tahoma", Font.PLAIN, 32));
		labelTitre.setForeground(UIManager.getColor("ToggleButton.highlight"));
		panel_1.add(labelTitre);
		
		btnRetou = new JButton("Quitter");
		btnRetou.setBackground(Color.DARK_GRAY);
		btnRetou.setForeground(Color.WHITE);
		btnRetou.setBounds(353, 15, 88, 26);
		btnRetou.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				activity.dispose();
			}
		});
		panel_1.add(btnRetou);
		
		lblPrix = new JLabel("Prix :   20 \u20AC");
		lblPrix.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrix.setBounds(122, 120, 138, 40);
		panel.add(lblPrix);
		
		lblPrixValue = new JLabel("");
		lblPrixValue.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrixValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrixValue.setBounds(208, 163, 90, 21);
		panel.add(lblPrixValue);
	
		
		lblNewLabel_1 = new JLabel("( +5 \u20AC par cat\u00E9gorie suppl\u00E9mentaire)");
		lblNewLabel_1.setBounds(40, 181, 257, 13);
		panel.add(lblNewLabel_1);
		
	}

	public void payer() 
	{
		
		Register page= new Register();
		page.setVisible(true);
		activity.dispose();
	}
	
	
}

