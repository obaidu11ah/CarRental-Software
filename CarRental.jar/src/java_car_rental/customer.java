package java_car_rental;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.xdevapi.Statement;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class customer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField CustIdTb;
	private JTextField CustNameTb;
	private JTextField CustAddTb;
	private JTextField CustPhoneTb;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customer frame = new customer();
					 frame.setUndecorated(true);
					frame.setVisible(true);
					DisplayCars();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public customer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 604);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.scrollbar);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 51, 51));
		panel.setBounds(0, 202, 195, 276);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Manage car");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
			        Main cs = new Main();
			        cs.DisplayCars1();
			        cs.setUndecorated(true);
			        cs.setVisible(true);
			        
			        
			    } catch (Exception ex) {
			        ex.printStackTrace();
			    }
				dispose();
			}
		});
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Return Car     ");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
			        rent_car frame = new rent_car();
					frame.DisplayCars();
					frame.DisplayCars1();
					frame.setUndecorated(true);
					frame.setVisible(true);
					
			        
			    } catch (Exception ex) {
			        ex.printStackTrace();
			    }
				dispose();
			}
		});
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Rent Car");
		lblNewLabel_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
			        return_ cs = new return_ ();
			        cs.DisplayCars();
			        cs.DisplayCars1();
			        cs.setUndecorated(true);
			        cs.setVisible(true);
			        
			    } catch (Exception ex) {
			        ex.printStackTrace();
			    }
				dispose();
				
			}
		});
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		panel.add(lblNewLabel_1_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 51, 51));
		panel_2.setBounds(-10, -25, 205, 232);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(189, 0, 744, 29);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(925, 0, 49, 29);
		contentPane.add(panel_4);
		
		JLabel lblNewLabel_3 = new JLabel("X");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);;
			}
		});
		lblNewLabel_3.setForeground(new Color(153, 0, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBackground(new Color(240, 248, 255));
		panel_4.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("Manage Customer");
		lblNewLabel_1_3.setForeground(new Color(204, 51, 51));
		lblNewLabel_1_3.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblNewLabel_1_3.setBounds(493, 49, 218, 28);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2 = new JLabel("Customer ID");
		lblNewLabel_2.setForeground(new Color(204, 51, 51));
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_2.setBackground(new Color(153, 153, 153));
		lblNewLabel_2.setBounds(222, 116, 158, 29);
		contentPane.add(lblNewLabel_2);
		
		CustIdTb = new JTextField();
		CustIdTb.setColumns(10);
		CustIdTb.setBounds(222, 150, 134, 19);
		contentPane.add(CustIdTb);
		
		JLabel lblNewLabel_2_1 = new JLabel("Customer Name");
		lblNewLabel_2_1.setForeground(new Color(204, 51, 51));
		lblNewLabel_2_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_2_1.setBackground(new Color(153, 153, 153));
		lblNewLabel_2_1.setBounds(391, 116, 158, 29);
		contentPane.add(lblNewLabel_2_1);
		
		CustNameTb = new JTextField();
		CustNameTb.setColumns(10);
		CustNameTb.setBounds(391, 150, 134, 19);
		contentPane.add(CustNameTb);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Address");
		lblNewLabel_2_1_1.setForeground(new Color(204, 51, 51));
		lblNewLabel_2_1_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_2_1_1.setBackground(new Color(153, 153, 153));
		lblNewLabel_2_1_1.setBounds(576, 116, 158, 29);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Phone NO.");
		lblNewLabel_2_1_1_1.setForeground(new Color(204, 51, 51));
		lblNewLabel_2_1_1_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_2_1_1_1.setBackground(new Color(153, 153, 153));
		lblNewLabel_2_1_1_1.setBounds(759, 116, 158, 29);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		CustAddTb = new JTextField();
		CustAddTb.setColumns(10);
		CustAddTb.setBounds(576, 150, 134, 19);
		contentPane.add(CustAddTb);
		
		CustPhoneTb = new JTextField();
		CustPhoneTb.setColumns(10);
		CustPhoneTb.setBounds(759, 150, 134, 19);
		contentPane.add(CustPhoneTb);
		
		JButton SaveBtn = new JButton("Save");
		SaveBtn.addActionListener(new ActionListener() {
			void DisplayCars() {
			    try {
			        Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/manage car","root","");
			        PreparedStatement pst = con.prepareStatement("SELECT * FROM customertbl");
			        ResultSet rs = pst.executeQuery();

			        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			        dtm.setRowCount(0);

			        while (rs.next()) {
			            Vector<String> row = new Vector<>();
			            row.add(rs.getString("CustId"));
			            row.add(rs.getString("CustName"));
			            row.add(rs.getString("CustAdd"));
			            row.add(rs.getString("CustPhone"));
			            dtm.addRow(row);
			        }

			        con.close();
			    } catch (SQLException | ClassNotFoundException e) {
			        e.printStackTrace();
			    }
			}

			
			public void actionPerformed(ActionEvent e) {
				try {
		            if (CustIdTb.getText().isEmpty() || CustNameTb.getText().isEmpty() || CustAddTb.getText().isEmpty() || CustPhoneTb.getText().isEmpty()) {
		                JOptionPane.showMessageDialog(null, "Missing Information");
		            } else {
							 
							 DisplayCars();
							 }
		                try {
							Class.forName("com.mysql.cj.jdbc.Driver");
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/manage car", "root", "");
		                PreparedStatement add = con.prepareStatement("INSERT INTO `customertbl` VALUES (?, ?, ?, ?)");

		                add.setString(1, CustIdTb.getText());
		                add.setString(2, CustNameTb.getText());
		                add.setString(3, CustAddTb.getText());
		                add.setString(4, CustPhoneTb.getText());
		            
		           
		                int rowsAffected = add.executeUpdate();

		                if (rowsAffected > 0) {
		                    JOptionPane.showMessageDialog(null, "Data inserted successfully");
		                } else {
		                    JOptionPane.showMessageDialog(null, "Failed to insert data");
		                }

		                con.close();
		            
				} catch (SQLException e2) {
	                e2.printStackTrace();
	            }
				DisplayCars();
			}
			
		});
		SaveBtn.setForeground(new Color(178, 34, 34));
		SaveBtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
		SaveBtn.setBounds(391, 202, 101, 23);
		contentPane.add(SaveBtn);
		
		JButton Deletebtn = new JButton("Delete");
		Deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Connection con=null;
				    Statement st= null;
				    ResultSet Rs=null;
				    PreparedStatement pst=null;
				int selectedRow = table.getSelectedRow();

		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(null, "Please select a row for deletion.");
		            return;
		        }

		        DefaultTableModel model = (DefaultTableModel) table.getModel();
		        String regNumValue = model.getValueAt(selectedRow, 0).toString(); 

		        String sql = "DELETE FROM customertbl WHERE CustId = ?";

		        try {
		         Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3307/manage car", "root", "");
		            pst = con1.prepareStatement(sql);
		            pst.setString(1, regNumValue);

		            int affectedRows = pst.executeUpdate();

		            if (affectedRows > 0) {
		                model.removeRow(selectedRow);
		                JOptionPane.showMessageDialog(null, "Delete Successfully");
		            } else {
		                JOptionPane.showMessageDialog(null, "Failed to delete the record.");
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error during deletion: " + ex.getMessage());
		        } finally {
		            // Close the PreparedStatement if needed
		            try {
		                if (pst != null) {
		                    pst.close();
		                }
		            } catch (SQLException ex) {
		                ex.printStackTrace();
		            }
		        }
		    }
		
		});
		Deletebtn.setForeground(new Color(178, 34, 34));
		Deletebtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
		Deletebtn.setBounds(519, 202, 101, 23);
		contentPane.add(Deletebtn);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Customer List\r\n");
		lblNewLabel_1_3_1.setForeground(new Color(204, 51, 51));
		lblNewLabel_1_3_1.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblNewLabel_1_3_1.setBounds(505, 251, 218, 28);
		contentPane.add(lblNewLabel_1_3_1);
		
		JScrollPane CustTbl = new JScrollPane();
		CustTbl.setBounds(262, 292, 620, 232);
		contentPane.add(CustTbl);
		
		table = new JTable();
		CustTbl.setViewportView(table);

		table.setModel(new DefaultTableModel(
		    new Object[][] {},
		    new String[] { "CustId", "CustName", "CustAddres", "CustPhone" }
		));
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 51, 51));
		panel_1.setBounds(0, 464, 195, 152);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("                  ");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		panel_1.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("                             ");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("LOGOUT");
		lblNewLabel_1_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
			        java_car_rental cs = new java_car_rental();
			        cs.setVisible(true);
			        cs.setUndecorated(true);
			    } catch (Exception ex) {
			        ex.printStackTrace();
			    }
				dispose();
			}
		});
		lblNewLabel_1_4_1.setForeground(Color.WHITE);
		lblNewLabel_1_4_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		panel_1.add(lblNewLabel_1_4_1);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addMouseListener(new MouseAdapter() {
			private void Reset()
			{
			CustIdTb.setText("");
			CustNameTb.setText("");
			CustAddTb.setText("");
			CustPhoneTb.setText("");}
			public void mouseClicked(MouseEvent e) {
				Reset();
			}
		});
		btnReset.setForeground(new Color(178, 34, 34));
		btnReset.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnReset.setBounds(647, 202, 101, 23);
		contentPane.add(btnReset);
		
		JLabel lblNewLabel_4 = new JLabel("* CNIC");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_4.setBounds(222, 179, 236, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("NOTE: If you want car first see which car you want from ....RENT CAR FRAME....  then register here ");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_4_1.setBounds(222, 534, 589, 13);
		contentPane.add(lblNewLabel_4_1);
		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Dimension size = toolkit.getScreenSize();  
		setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
		

	}
	static void DisplayCars() {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/manage car", "root", "");
	        PreparedStatement pst = con.prepareStatement("SELECT * FROM customertbl");
	        ResultSet rs = pst.executeQuery();

	        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
	        dtm.setRowCount(0);

	        while (rs.next()) {
	            Vector<String> row = new Vector<>();
	            row.add(rs.getString("CustId"));
	            row.add(rs.getString("CustName"));
	            row.add(rs.getString("CustAdd"));
	            row.add(rs.getString("CustPhone"));
	            dtm.addRow(row);
	        }

	        con.close();
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}
}
