package electronicsShopping;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
@SuppressWarnings("serial")
public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Electronics Shopping - Home");
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ELECTRONICS SHOPPING");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(SystemColor.textHighlight);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 0, 784, 66);
		contentPane.add(lblNewLabel);
		
		JLabel lblFooter = new JLabel("COPYRIGHT © 2022");
		lblFooter.setForeground(SystemColor.text);
		lblFooter.setOpaque(true);
		lblFooter.setBackground(SystemColor.textHighlight);
		lblFooter.setFont(new Font("Cambria", Font.PLAIN, 15));
		lblFooter.setHorizontalAlignment(SwingConstants.CENTER);
		lblFooter.setBounds(0, 536, 784, 25);
		contentPane.add(lblFooter);
		
		JButton btnCustomer = new JButton("CUSTOMER");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer ct = new Customer();
				ct.setVisible(true);
				dispose();
			}
		});
		btnCustomer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCustomer.setForeground(SystemColor.text);
		btnCustomer.setBackground(SystemColor.textHighlight);
		btnCustomer.setFont(new Font("Cambria", Font.PLAIN, 20));
		btnCustomer.setBounds(66, 153, 173, 100);
		contentPane.add(btnCustomer);
		
		JButton btnProduct = new JButton("ITEMS");
		btnProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item pd = new Item();
				pd.setVisible(true);
				dispose();
			}
		});
		btnProduct.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProduct.setForeground(Color.WHITE);
		btnProduct.setFont(new Font("Cambria", Font.PLAIN, 20));
		btnProduct.setBackground(SystemColor.textHighlight);
		btnProduct.setBounds(305, 153, 173, 100);
		contentPane.add(btnProduct);
		
		JButton btnAccessories = new JButton("ACCESSORIES");
		btnAccessories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accessories ac=new Accessories();
				ac.setVisible(true);
				dispose();
			}
		});
		btnAccessories.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAccessories.setForeground(Color.WHITE);
		btnAccessories.setFont(new Font("Cambria", Font.PLAIN, 20));
		btnAccessories.setBackground(SystemColor.textHighlight);
		btnAccessories.setBounds(544, 153, 173, 100);
		contentPane.add(btnAccessories);
		
		JButton btnStocks = new JButton("STOCKS");
		btnStocks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stocks st=new Stocks();
				st.setVisible(true);
				dispose();
			}
		});
		btnStocks.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStocks.setForeground(Color.WHITE);
		btnStocks.setFont(new Font("Cambria", Font.PLAIN, 20));
		btnStocks.setBackground(SystemColor.textHighlight);
		btnStocks.setBounds(66, 307, 173, 100);
		contentPane.add(btnStocks);
		
		JButton btnBrands = new JButton("BRANDS");
		btnBrands.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Brands bd=new Brands();
				bd.setVisible(true);
				dispose();
			}
		});
		btnBrands.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBrands.setForeground(Color.WHITE);
		btnBrands.setFont(new Font("Cambria", Font.PLAIN, 20));
		btnBrands.setBackground(SystemColor.textHighlight);
		btnBrands.setBounds(305, 307, 173, 100);
		contentPane.add(btnBrands);
		
		JButton btnBranches = new JButton("BRANCHES");
		btnBranches.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Branches bh=new Branches();
				bh.setVisible(true);
				dispose();
			}
		});
		btnBranches.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBranches.setForeground(Color.WHITE);
		btnBranches.setFont(new Font("Cambria", Font.PLAIN, 20));
		btnBranches.setBackground(SystemColor.textHighlight);
		btnBranches.setBounds(544, 307, 173, 100);
		contentPane.add(btnBranches);
	}
}
