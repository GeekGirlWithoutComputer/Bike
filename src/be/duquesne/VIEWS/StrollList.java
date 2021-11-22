package be.duquesne.VIEWS;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import be.duquesne.POJO.Person;
import be.duquesne.POJO.Stroll;
import javax.swing.JTextField;

public class StrollList extends JFrame 
{

	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{	
					StrollList frame = new StrollList();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	private JPanel contentPane;
	private DefaultListModel<String> listModelArt = new DefaultListModel<>();
	private DefaultListModel<Stroll> listModelRep = new DefaultListModel<>();
	private JScrollPane scrollPane;
	private JList<String> jListArt;
	private JList<Stroll> jListRepresentation;
	private JButton btnClose;
	private JLabel genre;
	private StrollList activity;
	
	
	
	private Stroll s = new Stroll();
	private Person personne;
	
	
	private JComboBox<Stroll> Spp;
	
	
	private   JLabel libel,test;
	private TextArea txydescr;

	public StrollList() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JPanel panel_1 = new JPanel() 
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
		panel_1.setBounds(0, 0, 664, 562);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		Spp = new JComboBox<Stroll>();
		Spp.setBackground(Color.LIGHT_GRAY);
		Spp.setBounds(10, 11, 404, 30);
		panel_1.add(Spp);
		
		
	         
	         
	         
	        JButton btnRetour = new JButton("RETOUR MENU PRINCIPAL");
	 		btnRetour.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
	 		btnRetour.setBounds(310, 504, 320, 36);
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
	 		
	 		btnNewButton = new JButton("...");
	 		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 12));
	 		btnNewButton.addActionListener(new ActionListener() {
	 			public void actionPerformed(ActionEvent e) 
	 			{
	 				
	 			}
	 		});
	 		btnNewButton.setBounds(249, 221, 143, 30);
	 		panel_1.add(btnNewButton);
	 		
	 		JLabel lblName = new JLabel("Nom balade: ");
	 		lblName.setForeground(Color.WHITE);
	 		lblName.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 13));
	 		lblName.setBounds(22, 77, 117, 21);
	 		panel_1.add(lblName);
	 		
	 		JLabel lblDate = new JLabel("Date :");
	 		lblDate.setForeground(Color.WHITE);
	 		lblDate.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 13));
	 		lblDate.setBounds(22, 109, 117, 21);
	 		panel_1.add(lblDate);
	 		
	 		JLabel lblLieuDeDpart = new JLabel("Lieu de d\u00E9part");
	 		lblLieuDeDpart.setForeground(Color.WHITE);
	 		lblLieuDeDpart.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 13));
	 		lblLieuDeDpart.setBounds(22, 141, 117, 21);
	 		panel_1.add(lblLieuDeDpart);
	 		
	 		JLabel lblPrix = new JLabel("Prix:");
	 		lblPrix.setForeground(Color.WHITE);
	 		lblPrix.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 13));
	 		lblPrix.setBounds(22, 173, 117, 21);
	 		panel_1.add(lblPrix);
	 		
	 		textFName = new JTextField();
	 		textFName.setBounds(219, 78, 151, 20);
	 		panel_1.add(textFName);
	 		textFName.setColumns(10);
	 		
	 		textFDate = new JTextField();
	 		textFDate.setColumns(10);
	 		textFDate.setBounds(219, 110, 151, 20);
	 		panel_1.add(textFDate);
	 		
	 		textFLieu = new JTextField();
	 		textFLieu.setColumns(10);
	 		textFLieu.setBounds(219, 142, 151, 20);
	 		panel_1.add(textFLieu);
	 		
	 		textPrix = new JTextField();
	 		textPrix.setColumns(10);
	 		textPrix.setBounds(219, 174, 151, 20);
	 		panel_1.add(textPrix);
	 		
	 		btndelete = new JButton("Supprimer");
	 		btndelete.addActionListener(new ActionListener() 
	 		{
	 			public void actionPerformed(ActionEvent e) 
	 			{
	 				Stroll choose= (Stroll) Spp.getSelectedItem();
	 						//createCombobox() ;
	 				boolean oki=choose.deleteSroll();
	 				Spp.removeItem(Spp.getSelectedItem());// ça enleve direct de la combo
	 				if(oki) 
	 				{
	 					
	 					JOptionPane.showMessageDialog(null, "Suppressionéffectuée !");
	 					
	 				}
	 				else
	 				{
	 					JOptionPane.showMessageDialog(null, "Suppression échouée !");
	 				}
	 					
	 			}
	 		});
	 		btndelete.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 12));
	 		btndelete.setBounds(10, 221, 161, 27);
	 		panel_1.add(btndelete);
			
			activity = this;
			
			init();
			
			
			createCombobox() ;
			
	}
	private List<Stroll> allS = new ArrayList<Stroll>();
	private JButton btnNewButton;
	private JTextField textFName;
	private JTextField textFDate;
	private JTextField textFLieu;
	private JTextField textPrix;
	private JButton btndelete;
	public Stroll  createCombobox() 
	{
		Spp.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				activity.setId();
			}
		});
	
		for (Stroll  sp: allS) 
		{
			Spp.addItem(sp);
			
		};		
	
		return s =(Stroll) Spp.getSelectedItem();
	}
	
	public void setId()
	{
	
		s= (Stroll) Spp.getSelectedItem();
		textFName.setText("  "+s.getPlaceOfDepartune());
		textFDate.setText("  "+s.getDateOfDepartune());
		textFLieu.setText("  "+s.getNameStroll());
		textPrix.setText("  "+s.getCost());
		
		
	}
	public void init() 
	{
		Stroll balade= new Stroll();
		allS = balade.findAll();
	}
}
