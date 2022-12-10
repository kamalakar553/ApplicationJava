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
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Cursor;
import javax.swing.border.BevelBorder;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
@SuppressWarnings("serial")
public class Accessories extends JFrame {

	public static final String SOURCE = "./src/main/java/electronicsShopping/";
    public static final String ACC = "http://www.semanticweb.org/kamalakar/ontologies/2022/10/untitled-ontology-302#";
    private JScrollPane sp=new JScrollPane();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLayeredPane layeredPane;
	private JPanel panel;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accessories frame = new Accessories();
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
	public Accessories() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setTitle("Electronics Shoppings - Accessories");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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
		
		JLabel lblNewLabel_1_1 = new JLabel("COPYRIGHT © 2022");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Cambria", Font.PLAIN, 15));
		lblNewLabel_1_1.setBackground(SystemColor.textHighlight);
		lblNewLabel_1_1.setBounds(0, 536, 784, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home hm = new Home();
				hm.setVisible(true);
				dispose();;
			}
		});
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setFont(new Font("Cambria", Font.PLAIN, 15));
		lblHome.setBounds(728, 64, 56, 25);
		contentPane.add(lblHome);
		
		JLabel lblAccessories = new JLabel("ACCESSORIES");
		lblAccessories.setOpaque(true);
		lblAccessories.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccessories.setForeground(SystemColor.textHighlight);
		lblAccessories.setFont(new Font("Cambria", Font.BOLD, 24));
		lblAccessories.setBackground(new Color(240, 255, 255));
		lblAccessories.setBounds(394, 77, 171, 25);
		contentPane.add(lblAccessories);
		
		JButton btnName = new JButton("NAME");
		btnName.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				panel.show();
				panel_1.hide();
			}
		});
		btnName.setForeground(Color.WHITE);
		btnName.setFont(new Font("Cambria", Font.BOLD, 14));
		btnName.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnName.setBackground(SystemColor.textHighlight);
		btnName.setBounds(10, 114, 155, 30);
		contentPane.add(btnName);
		
		JButton btnPrice = new JButton("PRICE");
		btnPrice.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				panel.hide();
				panel_1.show();
			}
		});
		btnPrice.setForeground(Color.WHITE);
		btnPrice.setFont(new Font("Cambria", Font.BOLD, 14));
		btnPrice.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnPrice.setBackground(SystemColor.textHighlight);
		btnPrice.setBounds(10, 155, 155, 30);
		contentPane.add(btnPrice);
		
		JLabel lblNewLabel_2 = new JLabel("SEARCH BY");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD, 18));
		lblNewLabel_2.setBackground(SystemColor.textHighlight);
		lblNewLabel_2.setBounds(0, 75, 175, 450);
		contentPane.add(lblNewLabel_2);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(185, 114, 589, 411);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "SEARCH BY ACCESSORY PRICE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(240, 248, 255));
		layeredPane.add(panel, "name_94147394581900");
		panel.setLayout(null);
		
		JLabel lblTypeAccessoriesName = new JLabel("Type Accessories Name in the search box");
		lblTypeAccessoriesName.setHorizontalAlignment(SwingConstants.LEFT);
		lblTypeAccessoriesName.setForeground(Color.GRAY);
		lblTypeAccessoriesName.setFont(new Font("Cambria", Font.PLAIN, 15));
		lblTypeAccessoriesName.setBounds(137, 26, 264, 25);
		panel.add(lblTypeAccessoriesName);
		
		textField = new JTextField();
		textField.setFont(new Font("Cambria", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBackground(new Color(240, 255, 255));
		textField.setBounds(137, 57, 212, 33);
		panel.add(textField);
		
		JButton btnDisplay = new JButton("DISPLAY");
		btnDisplay.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				String add = textField.getText().toString().toLowerCase();
				
				OntModel m = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
				
				FileManager.get().readModel( m, SOURCE + "ElectronicStore.owl" );
				
				String prefix = "prefix ed: <" + ACC + ">\n" +     
						"prefix rdfs: <" + RDFS.getURI() + ">\n" +
						"prefix owl: <" + OWL.getURI() + ">\n";
				
				String query_text=  prefix +
						"select ?AName ?Aprice ?AcessoryCategory ?BrandName where {" + 
					"?e a ed:Acessory. ?e  ed:AName  ?AName. ?e  ed:Aprice ?Aprice. ?e ed:AcessoryCategory ?AcessoryCategory . ?e ed:BrandName ?BrandName.\n\r";
				
				if(add != null && !add.isEmpty()) {
					query_text += "FILTER(regex(str(?AName),\""+add+"\",\"i\")) ";
				}

				query_text += " }";
				query_text += "ORDER BY ASC (?AName)";
				System.out.println(query_text); 
				
				Query query = QueryFactory.create( query_text );
		        QueryExecution qexec = QueryExecutionFactory.create( query, m );
		        
		        List<String> columns = new ArrayList<String>();
		        List<String[]> values = new ArrayList<String[]>();

		        columns.add("ACCESSORY");
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
				        values.add(new String[] { qs.get("?AName").toString(), qs.get("?Aprice").toString(), qs.get("?AcessoryCategory").toString(), qs.get("?BrandName").toString()});
				        i++;
				    }			    
				    TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
				    JTable table = new JTable(tableModel);
				    table.setForeground(Color.DARK_GRAY);
				    table.setBackground(Color.WHITE);
				    table.setRowHeight(35);		
				    sp.setViewportView(table);		           
				    sp.setBounds(25, 100, 550, 300);
				    panel.add(sp);
				    panel.repaint();
		        }
		        finally {
		            qexec.close();
		        }
			}
		});
		btnDisplay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDisplay.setForeground(Color.WHITE);
		btnDisplay.setFont(new Font("Cambria", Font.BOLD, 16));
		btnDisplay.setBackground(SystemColor.textHighlight);
		btnDisplay.setBounds(354, 57, 114, 33);
		panel.add(btnDisplay);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "SEARCH BY ACCESSORY PRICE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(240, 248, 255));
		layeredPane.add(panel_1, "name_94624064749500");
		
		JLabel lblTypeAccessoriesName_1 = new JLabel("Type Accessories Price in the search box");
		lblTypeAccessoriesName_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblTypeAccessoriesName_1.setForeground(Color.GRAY);
		lblTypeAccessoriesName_1.setFont(new Font("Cambria", Font.PLAIN, 15));
		lblTypeAccessoriesName_1.setBounds(137, 26, 264, 25);
		panel_1.add(lblTypeAccessoriesName_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Cambria", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(240, 255, 255));
		textField_1.setBounds(137, 57, 212, 33);
		panel_1.add(textField_1);
		
		JButton btnDisplay_1 = new JButton("DISPLAY");
		btnDisplay_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDisplay_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				String add = textField_1.getText().toString().toLowerCase();
				
				OntModel m = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
				
				FileManager.get().readModel( m, SOURCE + "ElectronicStore.owl" );
				
				String prefix = "prefix ed: <" + ACC + ">\n" +     
						"prefix rdfs: <" + RDFS.getURI() + ">\n" +
						"prefix owl: <" + OWL.getURI() + ">\n";
				
				String query_text=  prefix +
						"select ?AName ?Aprice ?AcessoryCategory ?BrandName where {" + 
					"?e a ed:Acessory. ?e  ed:AName  ?AName. ?e  ed:Aprice ?Aprice. ?e ed:AcessoryCategory ?AcessoryCategory . ?e ed:BrandName ?BrandName.\n\r";
				
				if(add != null && !add.isEmpty()) {
					query_text += "FILTER(regex(str(?Aprice),\""+add+"\",\"i\")) ";
				}

				query_text += " }";
				query_text += "ORDER BY ASC (?BrandName)";
				System.out.println(query_text); 
				
				Query query = QueryFactory.create( query_text );
		        QueryExecution qexec = QueryExecutionFactory.create( query, m );
		        
		        List<String> columns = new ArrayList<String>();
		        List<String[]> values = new ArrayList<String[]>();

		        columns.add("ACCESSORY");
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
				        values.add(new String[] { qs.get("?AName").toString(), qs.get("?Aprice").toString(), qs.get("?AcessoryCategory").toString(), qs.get("?BrandName").toString()});
				        i++;
				    }			    
				    TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
				    JTable table = new JTable(tableModel);
				    table.setForeground(Color.DARK_GRAY);
				    table.setBackground(Color.WHITE);
				    table.setRowHeight(35);		
				    sp.setViewportView(table);		           
				    sp.setBounds(25, 100, 550, 300);
				    panel_1.add(sp);
				    panel.repaint();
		        }
		        finally {
		            qexec.close();
		        }
			}
		});
		btnDisplay_1.setForeground(Color.WHITE);
		btnDisplay_1.setFont(new Font("Cambria", Font.BOLD, 16));
		btnDisplay_1.setBackground(SystemColor.textHighlight);
		btnDisplay_1.setBounds(354, 57, 114, 33);
		panel_1.add(btnDisplay_1);
	}

}
