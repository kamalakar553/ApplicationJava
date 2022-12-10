package electronicsShopping;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.OWL;
import org.apache.jena.vocabulary.RDFS;

import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.BevelBorder;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
@SuppressWarnings("serial")
public class Customer extends JFrame {

	public static final String SOURCE = "./src/main/java/electronicsShopping/";
    public static final String CUST = "http://www.semanticweb.org/kamalakar/ontologies/2022/10/untitled-ontology-302#";
    private JScrollPane sp=new JScrollPane();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textFieldItem;
	private JPanel panelCustName;
	private JLayeredPane layeredPane;
	private JPanel panelPurchase;
	private JPanel panelDisplayAll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer frame = new Customer();
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
	public Customer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Electronics Shopping - Customer");
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeader = new JLabel("ELECTRONICS SHOPPING");
		lblHeader.setOpaque(true);
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setFont(new Font("Cambria", Font.BOLD, 30));
		lblHeader.setBackground(SystemColor.textHighlight);
		lblHeader.setBounds(0, 0, 784, 66);
		contentPane.add(lblHeader);
		
		JLabel lblNewLabel_1 = new JLabel("COPYRIGHT © 2022");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Cambria", Font.PLAIN, 15));
		lblNewLabel_1.setBackground(SystemColor.textHighlight);
		lblNewLabel_1.setBounds(0, 536, 784, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCustomer = new JLabel("CUSTOMER");
		lblCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomer.setOpaque(true);
		lblCustomer.setForeground(SystemColor.textHighlight);
		lblCustomer.setBackground(new Color(240, 255, 255));
		lblCustomer.setFont(new Font("Cambria", Font.BOLD, 24));
		lblCustomer.setBounds(412, 77, 135, 25);
		contentPane.add(lblCustomer);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblHome.setForeground(SystemColor.textText);
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home hm=new Home();
				hm.setVisible(true);
				dispose();
			}
		});
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setFont(new Font("Cambria", Font.PLAIN, 15));
		lblHome.setBounds(729, 66, 55, 19);
		contentPane.add(lblHome);
		
		JButton btnName = new JButton("NAME");
		btnName.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				panelCustName.show();
				panelPurchase.hide();
				panelDisplayAll.hide();
			}
		});
		btnName.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnName.setBackground(SystemColor.textHighlight);
		btnName.setForeground(SystemColor.text);
		btnName.setFont(new Font("Cambria", Font.BOLD, 14));
		btnName.setBounds(10, 113, 155, 30);
		contentPane.add(btnName);
		
		JButton btnPurchasedItem = new JButton("NO OF ITEMS PURCHASED");
		btnPurchasedItem.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				panelCustName.hide();
				panelPurchase.show();
				panelDisplayAll.hide();
			}
		});
		btnPurchasedItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPurchasedItem.setForeground(Color.WHITE);
		btnPurchasedItem.setFont(new Font("Cambria", Font.BOLD, 14));
		btnPurchasedItem.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnPurchasedItem.setBackground(SystemColor.textHighlight);
		btnPurchasedItem.setBounds(10, 154, 155, 30);
		contentPane.add(btnPurchasedItem);
		
		JButton btnDisplayAll = new JButton("DISPLAY ALL");
		btnDisplayAll.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				panelCustName.hide();
				panelPurchase.hide();
				panelDisplayAll.show();
			}
		});
		btnDisplayAll.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDisplayAll.setForeground(Color.WHITE);
		btnDisplayAll.setFont(new Font("Cambria", Font.BOLD, 14));
		btnDisplayAll.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDisplayAll.setBackground(SystemColor.textHighlight);
		btnDisplayAll.setBounds(10, 195, 155, 30);
		contentPane.add(btnDisplayAll);
		
		JLabel lblNewLabel_2 = new JLabel("SEARCH BY");
		lblNewLabel_2.setForeground(SystemColor.text);
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD, 18));
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(SystemColor.textHighlight);
		lblNewLabel_2.setBounds(0, 76, 175, 450);
		contentPane.add(lblNewLabel_2);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(185, 113, 589, 412);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panelCustName = new JPanel();
		panelCustName.setBackground(new Color(240, 248, 255));
		panelCustName.setBorder(new TitledBorder(null, "SEARCH BY CUSTOMER NAME", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		layeredPane.add(panelCustName, "name_89600255125800");
		panelCustName.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(129, 60, 212, 33);
		panelCustName.add(textField);
		textField.setBackground(new Color(240, 255, 255));
		textField.setFont(new Font("Cambria", Font.PLAIN, 16));
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Type Customer Name in the search box");
		lblNewLabel.setBounds(129, 29, 264, 25);
		panelCustName.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Cambria", Font.PLAIN, 15));
		
		JButton btnDisplay = new JButton("DISPLAY");
		btnDisplay.setBounds(346, 60, 114, 33);
		panelCustName.add(btnDisplay);
		btnDisplay.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				String add = textField.getText().toString().toLowerCase();
				
				OntModel m = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
				
				FileManager.get().readModel( m, SOURCE + "ElectronicStore.owl" );
				
				String prefix = "prefix ed: <" + CUST + ">\n" +     
						"prefix rdfs: <" + RDFS.getURI() + ">\n" +
						"prefix owl: <" + OWL.getURI() + ">\n";
				
				String query_text=  prefix +
						"select ?CName ?address ?NoOfitempurchased where {" + 
					"?e a ed:Customer. ?o ed:CName ?CName. ?o ed:address ?address. ?e ed:NoOfitempurchased ?NoOfitempurchased.\n\r";
				
				if(add != null && !add.isEmpty()) {
					query_text += "FILTER(regex(str(?CName),\""+add+"\",\"i\")) ";
				}

				query_text += " }";
				System.out.println(query_text); 
				
				Query query = QueryFactory.create( query_text );
		        QueryExecution qexec = QueryExecutionFactory.create( query, m );
		        
		        List<String> columns = new ArrayList<String>();
		        List<String[]> values = new ArrayList<String[]>();

		        columns.add("NAME");
		        columns.add("ADDRESS");
		        columns.add("NO OF ITEMS PURCHASED");	        
		        try {
					ResultSet results = qexec.execSelect();
				    @SuppressWarnings("unused")
					int i = 0;
				    while ( results.hasNext() ) {
				    	QuerySolution qs = results.next();
				               //arr.add(qs.get("name").toString());
				        values.add(new String[] { qs.get("?CName").toString(), qs.get("?address").toString(), qs.get("?NoOfitempurchased").toString()});
				        i++;
				    }			    
				    TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
				    JTable table = new JTable(tableModel);
				    table.setForeground(Color.DARK_GRAY);
				    table.setBackground(Color.WHITE);
				    table.setRowHeight(35);		
				    sp.setViewportView(table);		           
				    sp.setBounds(25, 100, 550, 300);
				    panelCustName.add(sp);
				    panelCustName.repaint();
		        }
		        finally {
		            qexec.close();
		        }
			}
		});
		btnDisplay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDisplay.setForeground(SystemColor.text);
		btnDisplay.setBackground(SystemColor.textHighlight);
		btnDisplay.setFont(new Font("Cambria", Font.BOLD, 16));
		
		panelPurchase = new JPanel();
		panelPurchase.setLayout(null);
		panelPurchase.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "SEARCH BY NO OF ITEMS PURCHASED", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPurchase.setBackground(new Color(240, 248, 255));
		layeredPane.add(panelPurchase, "name_91228509640100");
		
		textFieldItem = new JTextField();
		textFieldItem.setFont(new Font("Cambria", Font.PLAIN, 16));
		textFieldItem.setColumns(10);
		textFieldItem.setBackground(new Color(240, 255, 255));
		textFieldItem.setBounds(129, 60, 212, 33);
		panelPurchase.add(textFieldItem);
		
		JLabel lblTypeNoOf = new JLabel("Type no. of items purchased in the search box");
		lblTypeNoOf.setHorizontalAlignment(SwingConstants.LEFT);
		lblTypeNoOf.setForeground(Color.GRAY);
		lblTypeNoOf.setFont(new Font("Cambria", Font.PLAIN, 15));
		lblTypeNoOf.setBounds(129, 29, 292, 25);
		panelPurchase.add(lblTypeNoOf);
		
		JButton btnProdDisplay = new JButton("DISPLAY");
		btnProdDisplay.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				String add = textFieldItem.getText().toString().toLowerCase();
				
				OntModel m = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
				
				FileManager.get().readModel( m, SOURCE + "ElectronicStore.owl" );
				
				String prefix = "prefix ed: <" + CUST + ">\n" +     
						"prefix rdfs: <" + RDFS.getURI() + ">\n" +
						"prefix owl: <" + OWL.getURI() + ">\n";
				
				String query_text=  prefix +
						"select ?CName ?address ?NoOfitempurchased where {" + 
					"?e a ed:Customer. ?o ed:CName ?CName. ?o ed:address ?address. ?e ed:NoOfitempurchased ?NoOfitempurchased.\n\r";
				
				if(add != null && !add.isEmpty()) {
					query_text += "FILTER(regex(str(?NoOfitempurchased),\""+add+"\",\"i\")) ";
				}

				query_text += " }";
				System.out.println(query_text); 
				
				Query query = QueryFactory.create( query_text );
		        QueryExecution qexec = QueryExecutionFactory.create( query, m );
		        
		        List<String> columns = new ArrayList<String>();
		        List<String[]> values = new ArrayList<String[]>();

		        columns.add("NAME");
		        columns.add("ADDRESS");
		        columns.add("NO OF ITEMS PURCHASED");	        
		        try {
					ResultSet results = qexec.execSelect();
				    @SuppressWarnings("unused")
					int i = 0;
				    while ( results.hasNext() ) {
				    	QuerySolution qs = results.next();
				               //arr.add(qs.get("name").toString());
				        values.add(new String[] { qs.get("?CName").toString(), qs.get("?address").toString(), qs.get("?NoOfitempurchased").toString()});
				        i++;
				    }			    
				    TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
				    JTable table = new JTable(tableModel);
				    table.setForeground(Color.DARK_GRAY);
				    table.setBackground(Color.WHITE);
				    table.setRowHeight(35);		
				    sp.setViewportView(table);		           
				    sp.setBounds(25, 100, 550, 300);
				    panelPurchase.add(sp);
				    panelPurchase.repaint();
		        }
		        finally {
		            qexec.close();
		        }
			}
		});
		btnProdDisplay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProdDisplay.setForeground(Color.WHITE);
		btnProdDisplay.setFont(new Font("Cambria", Font.BOLD, 16));
		btnProdDisplay.setBackground(SystemColor.textHighlight);
		btnProdDisplay.setBounds(346, 60, 114, 33);
		panelPurchase.add(btnProdDisplay);
		
		panelDisplayAll = new JPanel();
		panelDisplayAll.setLayout(null);
		panelDisplayAll.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "DISPLAY ALL CUSTOMER", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDisplayAll.setBackground(new Color(240, 248, 255));
		layeredPane.add(panelDisplayAll, "name_91833990477600");
		
		JLabel lblNewLabelTitle = new JLabel("Click on display button to display all customer detail");
		lblNewLabelTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabelTitle.setForeground(Color.GRAY);
		lblNewLabelTitle.setFont(new Font("Cambria", Font.PLAIN, 15));
		lblNewLabelTitle.setBounds(124, 29, 340, 25);
		panelDisplayAll.add(lblNewLabelTitle);
		
		JButton btnDisplayall = new JButton("DISPLAY");
		btnDisplayall.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
							
				OntModel m = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
				
				FileManager.get().readModel( m, SOURCE + "ElectronicStore.owl" );
				
				String prefix = "prefix ed: <" + CUST + ">\n" +     
						"prefix rdfs: <" + RDFS.getURI() + ">\n" +
						"prefix owl: <" + OWL.getURI() + ">\n";
				
				String query_text=  prefix +
						"select ?CName ?address ?NoOfitempurchased where {" + 
					"?e a ed:Customer. ?o ed:CName ?CName. ?o ed:address ?address. ?e ed:NoOfitempurchased ?NoOfitempurchased.\n\r";
				
				query_text += " }";
				System.out.println(query_text); 
				
				Query query = QueryFactory.create( query_text );
		        QueryExecution qexec = QueryExecutionFactory.create( query, m );
		        
		        List<String> columns = new ArrayList<String>();
		        List<String[]> values = new ArrayList<String[]>();

		        columns.add("NAME");
		        columns.add("ADDRESS");
		        columns.add("NO OF ITEMS PURCHASED");	        
		        try {
					ResultSet results = qexec.execSelect();
				    @SuppressWarnings("unused")
					int i = 0;
				    while ( results.hasNext() ) {
				    	QuerySolution qs = results.next();
				               //arr.add(qs.get("name").toString());
				        values.add(new String[] { qs.get("?CName").toString(), qs.get("?address").toString(), qs.get("?NoOfitempurchased").toString()});
				        i++;
				    }			    
				    TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
				    JTable table = new JTable(tableModel);
				    table.setForeground(Color.DARK_GRAY);
				    table.setBackground(Color.WHITE);
				    table.setRowHeight(35);		
				    sp.setViewportView(table);		           
				    sp.setBounds(25, 100, 550, 300);
				    panelDisplayAll.add(sp);
				    panelDisplayAll.repaint();
		        }
		        finally {
		            qexec.close();
		        }
			}
		});
		btnDisplayall.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDisplayall.setForeground(Color.WHITE);
		btnDisplayall.setFont(new Font("Cambria", Font.BOLD, 16));
		btnDisplayall.setBackground(SystemColor.textHighlight);
		btnDisplayall.setBounds(235, 59, 114, 33);
		panelDisplayAll.add(btnDisplayall);
	}
}
