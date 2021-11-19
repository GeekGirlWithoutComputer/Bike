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
import javax.swing.JSpinner;



public class AddStroll extends JFrame {

	private JPanel contentPane;
	private JTextField textFName;
	private JTextField textFLieu;
	private JTextField textFDate;
	private Stroll stroll;
	private JCalendar date;
	private   JSpinner JSprix;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStroll frame = new AddStroll();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddStroll() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom de la balade:");
		lblNewLabel.setBounds(10, 37, 178, 30);
		contentPane.add(lblNewLabel);
		
		textFName = new JTextField();
		textFName.setBounds(245, 42, 146, 20);
		contentPane.add(textFName);
		textFName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Lieu de depart:");
		lblNewLabel_1.setBounds(10, 11, 138, 14);
		contentPane.add(lblNewLabel_1);
		
		textFLieu = new JTextField();
		textFLieu.setBounds(245, 11, 146, 20);
		contentPane.add(textFLieu);
		textFLieu.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cout:");
		lblNewLabel_2.setBounds(10, 79, 108, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date de depart:");
		lblNewLabel_3.setBounds(10, 131, 121, 14);
		contentPane.add(lblNewLabel_3);
		
		
		
		JButton btnOki = new JButton("VALIDER");
		btnOki.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				addStroll();
				
			}
		});
		btnOki.setBounds(2, 205, 176, 23);
		contentPane.add(btnOki);
		
		JButton btnBack = new JButton("Retour");
		btnBack.setBounds(10, 239, 153, 23);
		contentPane.add(btnBack);
		
		date = new JCalendar();
		date.setBounds(245, 124, 185, 146);
		contentPane.add(date);
		date.addPropertyChangeListener(new PropertyChangeListener() {
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
		contentPane.add(textFDate);
		textFDate.setColumns(10);
		textFDate.setText("aujourd'hui "+date.getDate().toString());
		
		JSprix = new JSpinner();
		JSprix .setModel(new SpinnerNumberModel(new Double(0), null, null, new Double(1)));//** prob flot
		JSprix.setBounds(255, 76, 82, 20);
		contentPane.add(JSprix);
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
