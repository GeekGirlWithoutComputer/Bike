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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.components.JSpinField;

import be.duquesne.POJO.Category;
import be.duquesne.POJO.Stroll;
import be.duquesne.POJO.Category.TypesMember;
import be.duquesne.POJO.Person;

import javax.swing.JSpinner;



public class AddStroll extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField textFName;
	private JTextField textFLieu;
	private JTextField textFDate;
	private Stroll stroll;
	private JCalendar date;
	private JSpinner JSprix;
	private AddStroll activity;
	private Person personne;
	
	public AddStroll(Person personne) 
	{
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
								.getResource("/be/duquesne/IMG/ss.jpg")
								);
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom de la balade:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 37, 178, 30);
		panel.add(lblNewLabel);
		
		textFName = new JTextField();
		textFName.setBounds(245, 42, 146, 20);
		panel.add(textFName);
		textFName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Lieu de depart:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 11, 138, 14);
		panel.add(lblNewLabel_1);
		
		textFLieu = new JTextField();
		textFLieu.setBounds(245, 11, 146, 20);
		panel.add(textFLieu);
		textFLieu.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cout:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 79, 108, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date de depart:");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 131, 121, 14);
		panel.add(lblNewLabel_3);
		
		
		
		JButton btnOki = new JButton("VALIDER");
		btnOki.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				addStroll();
				
			}
		});
		btnOki.setBounds(12, 205, 176, 23);
		panel.add(btnOki);
		
		JButton btnBack = new JButton("Retour");
		btnBack.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				StrollList page = new StrollList(personne);
 				page.setVisible(true);
 				activity.dispose();
			}
		});
		btnBack.setBounds(12, 227, 176, 23);
		panel.add(btnBack);
		
		date = new JCalendar();
		date.setBounds(245, 124, 185, 146);
		panel.add(date);
		date.addPropertyChangeListener(new PropertyChangeListener() 
		{
			@SuppressWarnings("deprecation")
			@Override
			public void propertyChange(PropertyChangeEvent evt) 
			{
				textFDate.setText(date.getDate().toLocaleString());
			}
			
		});
		textFDate = new JTextField();
		textFDate.setFont(new Font("Tahoma", Font.PLAIN, 9));
		textFDate.setBounds(10, 174, 225, 30);
		panel.add(textFDate);
		textFDate.setColumns(10);
		textFDate.setText("aujourd'hui "+date.getDate().toString());
		
		JSprix = new JSpinner();
		JSprix .setModel(new SpinnerNumberModel(new Double(0), null, null, new Double(1)));
		JSprix.setBounds(255, 76, 82, 20);
		panel.add(JSprix);
	}
	private Date getDate() 
	{
		java.util.Date day = date.getDate();
		return new java.sql.Date(day.getTime());
	}
	private boolean addStroll() 
	{
		Double cout=(Double) JSprix.getValue();
		
		String lieu= textFLieu.getText();
		String nomBalade=textFName.getText();
		java.util.Date u = date.getDate();
		
		
		java.sql.Date date = new java.sql.Date(u.getTime());
		stroll= new Stroll(lieu,cout,nomBalade, date);
		Boolean oki= stroll.AddStroll();
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
