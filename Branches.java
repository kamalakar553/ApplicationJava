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
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
@SuppressWarnings("serial")
public class Branches extends JFrame {

	public static final String SOURCE = "./src/main/java/electronicsShopping/";
    public static final String BRANCH = "http://www.semanticweb.org/kamalakar/ontologies/2022/10/untitled-ontology-302#";
    private JScrollPane sp=new JScrollPane();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Branches frame = new Branches();
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
	public Branches() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Electronics Shopping - Branches");
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
		
		JLabel lblBranches = new JLabel("BRANCHES");
		lblBranches.setOpaque(true);
		lblBranches.setHorizontalAlignment(SwingConstants.CENTER);
		lblBranches.setForeground(SystemColor.textHighlight);
		lblBranches.setFont(new Font("Cambria", Font.BOLD, 24));
		lblBranches.setBackground(new Color(240, 255, 255));
		lblBranches.setBounds(306, 77, 171, 25);
		contentPane.add(lblBranches);
		
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
		
		JButton btnShowAll = new JButton("SHOW ALL");
		btnShowAll.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				OntModel m = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
				
				FileManager.get().readModel( m, SOURCE + "ElectronicStore.owl" );
				
				String prefix = "prefix ed: <" + BRANCH + ">\n" +     
						"prefix rdfs: <" + RDFS.getURI() + ">\n" +
						"prefix owl: <" + OWL.getURI() + ">\n";
				
				String query_text=  prefix +
						"select ?BName ?BrandName ?PurchasedItem ?TotalNOStaffs ?Location  where {" + 
					"?e a ed:Branch. ?e  ed:BName  ?BName. ?e  ed:BrandName ?BrandName. ?e ed:PurchasedItem ?PurchasedItem. ?e ed:TotalNOStaffs ?TotalNOStaffs. ?e ed:Location  ?Location.\n\r";
				
				query_text += " }";
				System.out.println(query_text); 
				
				Query query = QueryFactory.create( query_text );
		        QueryExecution qexec = QueryExecutionFactory.create( query, m );
		        
		        List<String> columns = new ArrayList<String>();
		        List<String[]> values = new ArrayList<String[]>();

		        columns.add("NAME");
		        columns.add("BRANDS");
		        columns.add("PURCHASED ITEM");	
		        columns.add("NO OF STAFFS");
		        columns.add("LOCATION");
		        try {
					ResultSet results = qexec.execSelect();
				    @SuppressWarnings("unused")
					int i = 0;
				    while ( results.hasNext() ) {
				    	QuerySolution qs = results.next();
				               //arr.add(qs.get("name").toString());
				        values.add(new String[] { qs.get("?BName").toString(), qs.get("?BrandName").toString(), qs.get("?PurchasedItem").toString(), qs.get("?TotalNOStaffs").toString(), qs.get("?Location").toString()});
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
		btnShowAll.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnShowAll.setForeground(Color.WHITE);
		btnShowAll.setFont(new Font("Cambria", Font.BOLD, 16));
		btnShowAll.setBackground(SystemColor.textHighlight);
		btnShowAll.setBounds(335, 129, 114, 33);
		contentPane.add(btnShowAll);
		
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
