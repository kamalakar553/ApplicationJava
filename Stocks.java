package electronicsShopping;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
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

import javax.swing.border.EtchedBorder;
@SuppressWarnings("serial")
public class Stocks extends JFrame {

	public static final String SOURCE = "./src/main/java/electronicsShopping/";
    public static final String STOCK = "http://www.semanticweb.org/kamalakar/ontologies/2022/10/untitled-ontology-302#";
    private JScrollPane sp=new JScrollPane();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField2;
	private JLayeredPane layeredPane;
	private JPanel panel1;
	private JPanel panel2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stocks frame = new Stocks();
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
	public Stocks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setTitle("Electronics Shopping - Stocks");
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
		
		JLabel lblStocks = new JLabel("STOCKS");
		lblStocks.setOpaque(true);
		lblStocks.setHorizontalAlignment(SwingConstants.CENTER);
		lblStocks.setForeground(SystemColor.textHighlight);
		lblStocks.setFont(new Font("Cambria", Font.BOLD, 24));
		lblStocks.setBackground(new Color(240, 255, 255));
		lblStocks.setBounds(394, 77, 171, 25);
		contentPane.add(lblStocks);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		lblHome.setBounds(728, 64, 56, 25);
		contentPane.add(lblHome);
		
		JLabel lblNewLabel_1_1 = new JLabel("COPYRIGHT © 2022");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Cambria", Font.PLAIN, 15));
		lblNewLabel_1_1.setBackground(SystemColor.textHighlight);
		lblNewLabel_1_1.setBounds(0, 536, 784, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnName = new JButton("NAME");
		btnName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnName.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				panel1.show();
				panel2.hide();
			}
		});
		btnName.setForeground(Color.WHITE);
		btnName.setFont(new Font("Cambria", Font.BOLD, 14));
		btnName.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnName.setBackground(SystemColor.textHighlight);
		btnName.setBounds(10, 121, 155, 30);
		contentPane.add(btnName);
		
		JButton btnName_1 = new JButton("BRANCH");
		btnName_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnName_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				panel1.hide();
				panel2.show();
			}
		});
		btnName_1.setForeground(Color.WHITE);
		btnName_1.setFont(new Font("Cambria", Font.BOLD, 14));
		btnName_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnName_1.setBackground(SystemColor.textHighlight);
		btnName_1.setBounds(10, 162, 155, 30);
		contentPane.add(btnName_1);
		
		JLabel lblNewLabel_2 = new JLabel("SEARCH BY");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD, 18));
		lblNewLabel_2.setBackground(SystemColor.textHighlight);
		lblNewLabel_2.setBounds(0, 77, 175, 450);
		contentPane.add(lblNewLabel_2);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(185, 121, 589, 404);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panel1 = new JPanel();
		panel1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "SEARCH STOCKS BY NAME", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel1.setBackground(new Color(240, 248, 255));
		panel1.setLocation(97, 0);
		layeredPane.add(panel1, "name_260728746939800");
		panel1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(140, 55, 212, 33);
		panel1.add(textField);
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
				
				String prefix = "prefix ed: <" + STOCK + ">\n" +     
						"prefix rdfs: <" + RDFS.getURI() + ">\n" +
						"prefix owl: <" + OWL.getURI() + ">\n";
				
				String query_text=  prefix +
						"select ?AName ?Aprice ?Stock ?BName where {" + 
					"?e a ed:ProductItem. ?e  ed:AName  ?AName. ?e  ed:Aprice ?Aprice. ?e ed:Stock ?Stock . ?e ed:BName ?BName.\n\r";
				
				if(add != null && !add.isEmpty()) {
					query_text += "FILTER(regex(str(?AName),\""+add+"\",\"i\")) ";
				}

				query_text += " }";
				System.out.println(query_text); 
				
				Query query = QueryFactory.create( query_text );
		        QueryExecution qexec = QueryExecutionFactory.create( query, m );
		        
		        List<String> columns = new ArrayList<String>();
		        List<String[]> values = new ArrayList<String[]>();

		        columns.add("ACCESSORY");
		        columns.add("PRICE");
		        columns.add("STOCKS");	
		        columns.add("BRANCH");
		        try {
					ResultSet results = qexec.execSelect();
				    @SuppressWarnings("unused")
					int i = 0;
				    while ( results.hasNext() ) {
				    	QuerySolution qs = results.next();
				               //arr.add(qs.get("name").toString());
				        values.add(new String[] { qs.get("?AName").toString(), qs.get("?Aprice").toString(), qs.get("?Stock").toString(), qs.get("?BName").toString()});
				        i++;
				    }			    
				    TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
				    JTable table = new JTable(tableModel);
				    table.setForeground(Color.DARK_GRAY);
				    table.setBackground(Color.WHITE);
				    table.setRowHeight(35);		
				    sp.setViewportView(table);		           
				    sp.setBounds(25, 100, 550, 300);
				    panel1.add(sp);
				    panel1.repaint();
		        }
		        finally {
		            qexec.close();
		        }
			}
		});
		btnDisplay.setBounds(357, 55, 114, 33);
		panel1.add(btnDisplay);
		btnDisplay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDisplay.setForeground(Color.WHITE);
		btnDisplay.setFont(new Font("Cambria", Font.BOLD, 16));
		btnDisplay.setBackground(SystemColor.textHighlight);
		
		JLabel lblTypeAccessoriesName = new JLabel("Type Accessories Name in the search box");
		lblTypeAccessoriesName.setHorizontalAlignment(SwingConstants.LEFT);
		lblTypeAccessoriesName.setForeground(Color.GRAY);
		lblTypeAccessoriesName.setFont(new Font("Cambria", Font.PLAIN, 15));
		lblTypeAccessoriesName.setBounds(140, 26, 264, 25);
		panel1.add(lblTypeAccessoriesName);
		
		panel2 = new JPanel();
		panel2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "SEARCH STOCKS BY  BRANCH", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel2.setLayout(null);
		panel2.setBackground(new Color(240, 248, 255));
		layeredPane.add(panel2, "name_260883958832500");
		
		textField2 = new JTextField();
		textField2.setFont(new Font("Cambria", Font.PLAIN, 16));
		textField2.setColumns(10);
		textField2.setBackground(new Color(240, 255, 255));
		textField2.setBounds(139, 56, 212, 33);
		panel2.add(textField2);
		
		JButton btnDisplay2 = new JButton("DISPLAY");
		btnDisplay2.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String add = textField2.getText().toString().toLowerCase();
				
				OntModel m = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
				
				FileManager.get().readModel( m, SOURCE + "ElectronicStore.owl" );
				
				String prefix = "prefix ed: <" + STOCK + ">\n" +     
						"prefix rdfs: <" + RDFS.getURI() + ">\n" +
						"prefix owl: <" + OWL.getURI() + ">\n";
				
				String query_text=  prefix +
						"select ?AName ?Aprice ?Stock ?BName where {" + 
					"?e a ed:ProductItem. ?e  ed:AName  ?AName. ?e  ed:Aprice ?Aprice. ?e ed:Stock ?Stock . ?e ed:BName ?BName.\n\r";
				
				if(add != null && !add.isEmpty()) {
					query_text += "FILTER(regex(str(?BName),\""+add+"\",\"i\")) ";
				}

				query_text += " }";
				System.out.println(query_text); 
				
				Query query = QueryFactory.create( query_text );
		        QueryExecution qexec = QueryExecutionFactory.create( query, m );
		        
		        List<String> columns = new ArrayList<String>();
		        List<String[]> values = new ArrayList<String[]>();

		        columns.add("BRANCH");
		        columns.add("ACCESSORY");
		        columns.add("PRICE");	
		        columns.add("STOCK");
		        try {
					ResultSet results = qexec.execSelect();
				    @SuppressWarnings("unused")
					int i = 0;
				    while ( results.hasNext() ) {
				    	QuerySolution qs = results.next();
				               //arr.add(qs.get("name").toString());
				        values.add(new String[] { qs.get("?BName").toString(), qs.get("?AName").toString(), qs.get("?Aprice").toString(), qs.get("?Stock").toString()});
				        i++;
				    }			    
				    TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
				    JTable table = new JTable(tableModel);
				    table.setForeground(Color.DARK_GRAY);
				    table.setBackground(Color.WHITE);
				    table.setRowHeight(35);		
				    sp.setViewportView(table);		           
				    sp.setBounds(25, 100, 550, 300);
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
		btnDisplay2.setBounds(356, 56, 114, 33);
		panel2.add(btnDisplay2);
		
		JLabel lblTypeAccessoriesName_1 = new JLabel("Type Branch Name in the search box");
		lblTypeAccessoriesName_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblTypeAccessoriesName_1.setForeground(Color.GRAY);
		lblTypeAccessoriesName_1.setFont(new Font("Cambria", Font.PLAIN, 15));
		lblTypeAccessoriesName_1.setBounds(139, 27, 264, 25);
		panel2.add(lblTypeAccessoriesName_1);
	}
}
