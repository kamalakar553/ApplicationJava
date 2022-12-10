package electronicsShopping;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
@SuppressWarnings("serial")
public class Item extends JFrame {
	
	public static final String SOURCE = "./src/main/java/electronicsShopping/";
    public static final String ITEM = "http://www.semanticweb.org/kamalakar/ontologies/2022/10/untitled-ontology-302#";
    private JScrollPane sp=new JScrollPane();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField1;
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private JLayeredPane layeredPane;
	private JTextField textField2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Item frame = new Item();
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
	public Item() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setTitle("Electronics Shopping - Items");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setFont(new Font("Cambria", Font.PLAIN, 15));
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home hm=new Home();
				hm.setVisible(true);
				dispose();
			}
		});
		lblHome.setBounds(728, 64, 56, 25);
		contentPane.add(lblHome);
		
		JLabel lblHeader = new JLabel("ELECTRONICS SHOPPING");
		lblHeader.setOpaque(true);
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setFont(new Font("Cambria", Font.BOLD, 30));
		lblHeader.setBackground(SystemColor.textHighlight);
		lblHeader.setBounds(0, 0, 784, 66);
		contentPane.add(lblHeader);
		
		JLabel lblNewLabel_1_1 = new JLabel("COPYRIGHT © 2022");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Cambria", Font.PLAIN, 15));
		lblNewLabel_1_1.setBackground(SystemColor.textHighlight);
		lblNewLabel_1_1.setBounds(0, 536, 784, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblProducts = new JLabel("PURCHASED ITEMS");
		lblProducts.setOpaque(true);
		lblProducts.setHorizontalAlignment(SwingConstants.CENTER);
		lblProducts.setForeground(SystemColor.textHighlight);
		lblProducts.setFont(new Font("Cambria", Font.BOLD, 24));
		lblProducts.setBackground(new Color(240, 255, 255));
		lblProducts.setBounds(386, 77, 212, 25);
		contentPane.add(lblProducts);
		
		JButton btnName = new JButton("NAME");
		btnName.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				panel.show();
				panel1.hide();
				panel2.hide();
			}
		});
		btnName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnName.setForeground(Color.WHITE);
		btnName.setFont(new Font("Cambria", Font.BOLD, 14));
		btnName.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnName.setBackground(SystemColor.textHighlight);
		btnName.setBounds(22, 110, 155, 30);
		contentPane.add(btnName);
		
		JButton btnBrands = new JButton("BRANDS");
		btnBrands.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				panel.hide();
				panel1.show();
				panel2.hide();
			}
		});
		btnBrands.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBrands.setForeground(Color.WHITE);
		btnBrands.setFont(new Font("Cambria", Font.BOLD, 14));
		btnBrands.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnBrands.setBackground(SystemColor.textHighlight);
		btnBrands.setBounds(22, 151, 155, 30);
		contentPane.add(btnBrands);
		
		JButton btnCategory = new JButton("CATEGORY");
		btnCategory.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				panel.hide();
				panel1.hide();
				panel2.show();
			}
		});
		btnCategory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCategory.setForeground(Color.WHITE);
		btnCategory.setFont(new Font("Cambria", Font.BOLD, 14));
		btnCategory.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnCategory.setBackground(SystemColor.textHighlight);
		btnCategory.setBounds(22, 192, 155, 30);
		contentPane.add(btnCategory);
		
		JLabel lblNewLabel = new JLabel("SEARCH BY");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(SystemColor.textHighlight);
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 77, 201, 448);
		contentPane.add(lblNewLabel);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(211, 113, 563, 412);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "SEARCH ITEM BY NAME", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(240, 248, 255));
		layeredPane.add(panel, "name_97572153622700");
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(130, 47, 212, 33);
		panel.add(textField);
		textField.setFont(new Font("Cambria", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBackground(new Color(240, 255, 255));
		
		JButton btnDisplay = new JButton("DISPLAY");
		btnDisplay.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				String add = textField.getText().toString().toLowerCase();
				
				OntModel m = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
				
				FileManager.get().readModel( m, SOURCE + "ElectronicStore.owl" );
				
				String prefix = "prefix ed: <" + ITEM + ">\n" +     
						"prefix rdfs: <" + RDFS.getURI() + ">\n" +
						"prefix owl: <" + OWL.getURI() + ">\n";
				
				String query_text=  prefix +
						"select ?AName ?Aprice ?Category ?BrandName where {" + 
					"?e a ed:ProductItem. ?e  ed:AName  ?AName. ?e  ed:Aprice ?Aprice. ?e ed:Category ?Category . ?e ed:BrandName ?BrandName.\n\r";
				
				if(add != null && !add.isEmpty()) {
					query_text += "FILTER(regex(str(?AName),\""+add+"\",\"i\")) ";
				}
				query_text += " }";
				query_text += "ORDER BY ASC (?BrandName)";
				System.out.println(query_text); 
				
				Query query = QueryFactory.create( query_text );
		        QueryExecution qexec = QueryExecutionFactory.create( query, m );
		        
		        List<String> columns = new ArrayList<String>();
		        List<String[]> values = new ArrayList<String[]>();

		        columns.add("PRODUCT / ITEM");
		        columns.add("PRICE");
		        columns.add("CATEGORY");	
		        columns.add("BRAND");
		        try {
					ResultSet results = qexec.execSelect();
				    @SuppressWarnings("unused")
					int i = 0;
				    while ( results.hasNext() ) {
				    	QuerySolution qs = results.next();
				               //arr.add(qs.get("name").toString());
				        values.add(new String[] { qs.get("?AName").toString(), qs.get("?Aprice").toString(), qs.get("?Category").toString(), qs.get("?BrandName").toString()});
				        i++;
				    }
				    TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
				    JTable table = new JTable(tableModel);
				    table.setForeground(Color.DARK_GRAY);
				    table.setBackground(Color.WHITE);
				    table.setRowHeight(35);		
				    sp.setViewportView(table);		           
				    sp.setBounds(20, 100, 525, 300);
				    panel.add(sp);
				    panel.repaint();
		        }
		        finally {
		            qexec.close();
		        }
			}
		});
		btnDisplay.setBounds(347, 47, 114, 33);
		panel.add(btnDisplay);
		btnDisplay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDisplay.setForeground(Color.WHITE);
		btnDisplay.setFont(new Font("Cambria", Font.BOLD, 16));
		btnDisplay.setBackground(SystemColor.textHighlight);
		
		JLabel lblTypeItemName = new JLabel("Type Item Name in the search box");
		lblTypeItemName.setHorizontalAlignment(SwingConstants.LEFT);
		lblTypeItemName.setForeground(Color.GRAY);
		lblTypeItemName.setFont(new Font("Cambria", Font.PLAIN, 15));
		lblTypeItemName.setBounds(130, 21, 238, 25);
		panel.add(lblTypeItemName);
		
		panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "SEARCH ITEM BY BRANDS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel1.setBackground(new Color(240, 248, 255));
		layeredPane.add(panel1, "name_98908598951300");
		
		textField1 = new JTextField();
		textField1.setFont(new Font("Cambria", Font.PLAIN, 16));
		textField1.setColumns(10);
		textField1.setBackground(new Color(240, 255, 255));
		textField1.setBounds(130, 47, 212, 33);
		panel1.add(textField1);
		
		JButton btnDisplay1 = new JButton("DISPLAY");
		btnDisplay1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDisplay1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				String add = textField1.getText().toString().toLowerCase();
				
				OntModel m = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
				
				FileManager.get().readModel( m, SOURCE + "ElectronicStore.owl" );
				
				String prefix = "prefix ed: <" + ITEM + ">\n" +     
						"prefix rdfs: <" + RDFS.getURI() + ">\n" +
						"prefix owl: <" + OWL.getURI() + ">\n";
				
				String query_text=  prefix +
						"select ?AName ?Aprice ?Category ?BrandName where {" + 
					"?e a ed:ProductItem. ?e  ed:AName  ?AName. ?e  ed:Aprice ?Aprice. ?e ed:Category ?Category . ?e ed:BrandName ?BrandName.\n\r";
				
				if(add != null && !add.isEmpty()) {
					query_text += "FILTER(regex(str(?BrandName),\""+add+"\",\"i\")) ";
				}
				query_text += " }";
				query_text += "ORDER BY ASC (?BrandName)";
				System.out.println(query_text); 
				
				Query query = QueryFactory.create( query_text );
		        QueryExecution qexec = QueryExecutionFactory.create( query, m );
		        
		        List<String> columns = new ArrayList<String>();
		        List<String[]> values = new ArrayList<String[]>();

		        columns.add("BRAND");
		        columns.add("PRODUCT / ITEM");
		        columns.add("CATEGORY");	
		        columns.add("PRICE");
		        try {
					ResultSet results = qexec.execSelect();
				    @SuppressWarnings("unused")
					int i = 0;
				    while ( results.hasNext() ) {
				    	QuerySolution qs = results.next();
				               //arr.add(qs.get("name").toString());
				        values.add(new String[] { qs.get("?BrandName").toString(), qs.get("?AName").toString(), qs.get("?Category").toString(), qs.get("?Aprice").toString()});
				        i++;
				    }			    
				    TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
				    JTable table = new JTable(tableModel);
				    table.setForeground(Color.DARK_GRAY);
				    table.setBackground(Color.WHITE);
				    table.setRowHeight(35);		
				    sp.setViewportView(table);		           
				    sp.setBounds(20, 100, 525, 300);
				    panel1.add(sp);
				    panel1.repaint();
		        }
		        finally {
		            qexec.close();
		        }
			}
		});
		btnDisplay1.setForeground(Color.WHITE);
		btnDisplay1.setFont(new Font("Cambria", Font.BOLD, 16));
		btnDisplay1.setBackground(SystemColor.textHighlight);
		btnDisplay1.setBounds(347, 47, 114, 33);
		panel1.add(btnDisplay1);
		
		JLabel lblTypeItemName1 = new JLabel("Type Item Brand Name in the search box");
		lblTypeItemName1.setHorizontalAlignment(SwingConstants.LEFT);
		lblTypeItemName1.setForeground(Color.GRAY);
		lblTypeItemName1.setFont(new Font("Cambria", Font.PLAIN, 15));
		lblTypeItemName1.setBounds(130, 21, 294, 25);
		panel1.add(lblTypeItemName1);
		
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "SEARCH BY CATEGORY", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel2.setBackground(new Color(240, 248, 255));
		layeredPane.add(panel2, "name_99472214997700");
		
		JButton btnDisplay2 = new JButton("DISPLAY");
		btnDisplay2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDisplay2.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				String add = textField2.getText().toString().toLowerCase();
				
				OntModel m = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
				
				FileManager.get().readModel( m, SOURCE + "ElectronicStore.owl" );
				
				String prefix = "prefix ed: <" + ITEM + ">\n" +     
						"prefix rdfs: <" + RDFS.getURI() + ">\n" +
						"prefix owl: <" + OWL.getURI() + ">\n";
				
				String query_text=  prefix +
						"select ?AName ?Aprice ?Category ?BrandName where {" + 
					"?e a ed:ProductItem. ?e  ed:AName  ?AName. ?e  ed:Aprice ?Aprice. ?e ed:Category ?Category . ?e ed:BrandName ?BrandName.\n\r";
				
				if(add != null && !add.isEmpty()) {
					query_text += "FILTER(regex(str(?Category),\""+add+"\",\"i\")) ";
				}
				query_text += " }";
				query_text += "ORDER BY ASC (?BrandName)";
				System.out.println(query_text); 
				
				Query query = QueryFactory.create( query_text );
		        QueryExecution qexec = QueryExecutionFactory.create( query, m );
		        
		        List<String> columns = new ArrayList<String>();
		        List<String[]> values = new ArrayList<String[]>();

		        columns.add("CATEGORY");
		        columns.add("BRAND");
		        columns.add("PRODUCT / ITEM");	
		        columns.add("PRICE");
		        try {
					ResultSet results = qexec.execSelect();
				    @SuppressWarnings("unused")
					int i = 0;
				    while ( results.hasNext() ) {
				    	QuerySolution qs = results.next();
				               //arr.add(qs.get("name").toString());
				        values.add(new String[] { qs.get("?Category").toString(), qs.get("?BrandName").toString(), qs.get("?AName").toString(), qs.get("?Aprice").toString()});
				        i++;
				    }			    
				    TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
				    JTable table = new JTable(tableModel);
				    table.setForeground(Color.DARK_GRAY);
				    table.setBackground(Color.WHITE);
				    table.setRowHeight(35);		
				    sp.setViewportView(table);		           
				    sp.setBounds(20, 100, 525, 300);
				    panel2.add(sp);
				    panel2.repaint();
		        }
		        finally {
		            qexec.close();
		        }
			}
		});
		btnDisplay2.setForeground(Color.WHITE);
		btnDisplay2.setFont(new Font("Cambria", Font.BOLD, 16));
		btnDisplay2.setBackground(SystemColor.textHighlight);
		btnDisplay2.setBounds(347, 47, 114, 33);
		panel2.add(btnDisplay2);
		
		JLabel lblTypeItemName2 = new JLabel("Type Item Category in the search box");
		lblTypeItemName2.setHorizontalAlignment(SwingConstants.LEFT);
		lblTypeItemName2.setForeground(Color.GRAY);
		lblTypeItemName2.setFont(new Font("Cambria", Font.PLAIN, 15));
		lblTypeItemName2.setBounds(130, 21, 294, 25);
		panel2.add(lblTypeItemName2);
		
		textField2 = new JTextField();
		textField2.setFont(new Font("Cambria", Font.PLAIN, 16));
		textField2.setColumns(10);
		textField2.setBackground(new Color(240, 255, 255));
		textField2.setBounds(130, 47, 212, 33);
		panel2.add(textField2);
	}
}
