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
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
@SuppressWarnings("serial")
public class Brands extends JFrame {

	public static final String SOURCE = "./src/main/java/electronicsShopping/";
    public static final String BRANDS = "http://www.semanticweb.org/kamalakar/ontologies/2022/10/untitled-ontology-302#";
    private JScrollPane sp=new JScrollPane();
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Brands frame = new Brands();
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
	public Brands() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
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
		
		JLabel lblBrands = new JLabel("BRANDS");
		lblBrands.setOpaque(true);
		lblBrands.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrands.setForeground(SystemColor.textHighlight);
		lblBrands.setFont(new Font("Cambria", Font.BOLD, 24));
		lblBrands.setBackground(new Color(240, 255, 255));
		lblBrands.setBounds(306, 77, 171, 25);
		contentPane.add(lblBrands);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home hm=new Home();
				hm.setVisible(true);
				dispose();
			}
		});
		lblHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setFont(new Font("Cambria", Font.PLAIN, 15));
		lblHome.setBounds(728, 64, 56, 25);
		contentPane.add(lblHome);
		
		textField = new JTextField();
		textField.setFont(new Font("Cambria", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBackground(new Color(240, 255, 255));
		textField.setBounds(249, 129, 212, 33);
		contentPane.add(textField);
		
		JButton btnDisplay = new JButton("DISPLAY");
		btnDisplay.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				String add = textField.getText().toString().toLowerCase();
				
				OntModel m = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
				
				FileManager.get().readModel( m, SOURCE + "ElectronicStore.owl" );
				
				String prefix = "prefix ed: <" + BRANDS + ">\n" +     
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
				    sp.setBounds(25, 200, 750, 300);
				    contentPane.add(sp);
				    contentPane.repaint();
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
		btnDisplay.setBounds(466, 129, 114, 33);
		contentPane.add(btnDisplay);
		
		JLabel lblNewLabel_1_1 = new JLabel("COPYRIGHT © 2022");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Cambria", Font.PLAIN, 15));
		lblNewLabel_1_1.setBackground(SystemColor.textHighlight);
		lblNewLabel_1_1.setBounds(0, 536, 784, 25);
		contentPane.add(lblNewLabel_1_1);
	}

}
