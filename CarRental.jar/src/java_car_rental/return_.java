package java_car_rental;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import com.jgoodies.looks.common.ComboBoxEditorTextField;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.xdevapi.Statement;
import com.toedter.calendar.JDateChooser;


public class return_ extends JFrame {

	private static final long serialVersionUID = 1L;
	 private JDateChooser RentDate ;
	 private JDateChooser ReturnDateTb ;

	private JPanel contentPane;
	public JTextField RentIdTb;
	public JTextField RegNumTb;
	private JTextField FeeTb;
	private JTable table;
	private JTable table_1;
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					return_ frame = new return_();
					frame.setUndecorated(true);
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

    Connection con=null;
    Statement st= null;
    ResultSet Rs=null;
    PreparedStatement pst=null;
    private JTable table_2;
    
	public return_() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1042, 785);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 51, 51));
		panel.setBounds(0, 296, 195, 353);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Customer");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
			        customer cs = new customer();
			        cs.DisplayCars();
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
		
		JLabel lblNewLabel_1_1 = new JLabel("Manage car ");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
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
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_4 = new JLabel("Return Car");
		lblNewLabel_1_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
			        rent_car cs = new rent_car();
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
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Century Gothic", Font.BOLD, 18));
		panel.add(lblNewLabel_1_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 51, 51));
		panel_2.setBounds(-10, -32, 205, 334);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(191, 0, 787, 29);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(970, 0, 78, 29);
		contentPane.add(panel_4);
		
		JLabel lblNewLabel_3_1 = new JLabel("X");
		lblNewLabel_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_3_1.setForeground(new Color(153, 0, 0));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1.setBackground(new Color(240, 248, 255));
		panel_4.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_2 = new JLabel("Rent ID");
		lblNewLabel_2.setForeground(new Color(204, 51, 51));
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_2.setBackground(new Color(153, 153, 153));
		lblNewLabel_2.setBounds(205, 98, 158, 29);
		contentPane.add(lblNewLabel_2);
		
		RentIdTb = new JTextField();
		RentIdTb.setColumns(10);
		RentIdTb.setBounds(205, 137, 89, 19);
		contentPane.add(RentIdTb);
		
		JLabel lblNewLabel_2_1 = new JLabel("Registration");
		lblNewLabel_2_1.setForeground(new Color(204, 51, 51));
		lblNewLabel_2_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_2_1.setBackground(new Color(153, 153, 153));
		lblNewLabel_2_1.setBounds(336, 98, 158, 29);
		contentPane.add(lblNewLabel_2_1);
		
		RegNumTb = new JTextField();
		RegNumTb.setColumns(10);
		RegNumTb.setBounds(336, 137, 135, 19);
		contentPane.add(RegNumTb);
		
		JLabel lblNewLabel_2_2 = new JLabel("Customer Name");
		lblNewLabel_2_2.setForeground(new Color(204, 51, 51));
		lblNewLabel_2_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_2_2.setBackground(new Color(153, 153, 153));
		lblNewLabel_2_2.setBounds(504, 98, 158, 29);
		contentPane.add(lblNewLabel_2_2);
		
		comboBox = new JComboBox<String>();
		comboBox.setForeground(new Color(139, 0, 0));
		comboBox.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		comboBox.setBounds(504, 134, 124, 21);
		contentPane.add(comboBox);
		DisplayCars1();
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Rent Date");
		lblNewLabel_2_1_1.setForeground(new Color(204, 51, 51));
		lblNewLabel_2_1_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_2_1_1.setBackground(new Color(153, 153, 153));
		lblNewLabel_2_1_1.setBounds(665, 98, 135, 29);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_3 = new JLabel("Return Date");
		lblNewLabel_2_3.setForeground(new Color(204, 51, 51));
		lblNewLabel_2_3.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_2_3.setBackground(new Color(153, 153, 153));
		lblNewLabel_2_3.setBounds(787, 98, 158, 29);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Fee");
		lblNewLabel_2_4.setForeground(new Color(204, 51, 51));
		lblNewLabel_2_4.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_2_4.setBackground(new Color(153, 153, 153));
		lblNewLabel_2_4.setBounds(920, 98, 158, 29);
		contentPane.add(lblNewLabel_2_4);
		
		FeeTb = new JTextField();
		FeeTb.setColumns(10);
		FeeTb.setBounds(920, 137, 89, 19);
		contentPane.add(FeeTb);
		
		JLabel lblNewLabel_1_3 = new JLabel("Car Rent");
		lblNewLabel_1_3.setForeground(new Color(204, 51, 51));
		lblNewLabel_1_3.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblNewLabel_1_3.setBounds(521, 42, 218, 28);
		contentPane.add(lblNewLabel_1_3);
		
		JButton Savebtn = new JButton("Save");
		Savebtn.addActionListener(new ActionListener() {
			void DisplayCars() {
			    try {
			        Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/manage car", "root", "");

			        pst = con.prepareStatement("SELECT * FROM renttbl");
			        Rs = pst.executeQuery();
			        ResultSetMetaData rsmd = (ResultSetMetaData) Rs.getMetaData();
			        int n = rsmd.getColumnCount();
			        DefaultTableModel dtm = (DefaultTableModel) table_2.getModel();
			        dtm.setRowCount(0);
			        while (Rs.next()) {
			            Vector<String> v = new Vector();
			            for (int i = 1; i <= n; i++) {
			                v.add(Rs.getString("RentId"));
			                v.add(Rs.getString("CarReg"));
			                v.add(Rs.getString("CustName"));
			                v.add(Rs.getString("RentDate"));
			                v.add(Rs.getString("ReturnDate"));
			                v.add(Rs.getString("RentFee"));
			            }
			            dtm.addRow(v);
			        }

			    } catch (SQLException e) {
			        e.printStackTrace();
			    } catch (ClassNotFoundException e) {
			        e.printStackTrace();
			    }}
			private void deleteCar(Connection con, String regNum) throws SQLException {
		        PreparedStatement deleteCar = con.prepareStatement("DELETE FROM car_rigistration WHERE RegNumTb = ?");
		        deleteCar.setString(1, regNum);
		        int rowCar = deleteCar.executeUpdate();
		        if (rowCar > 0) {
		            System.out.println("Car deleted successfully");
		        } else {
		            System.out.println("Error deleting car");
		        }
		    }
			
			public void actionPerformed(ActionEvent e) {
				if (RegNumTb.getText().isEmpty() || FeeTb.getText().isEmpty() || RentIdTb.getText().isEmpty() || RentIdTb.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Missing Information");
		        } else {
		            try {
		                Class.forName("com.mysql.cj.jdbc.Driver");
		                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/manage car", "root", "");

		                PreparedStatement addRent = con.prepareStatement("insert into `renttbl` values(?,?,?,?,?,?)");
		                addRent.setInt(1, Integer.valueOf(RentIdTb.getText()));
		                addRent.setString(2, RegNumTb.getText());
		                addRent.setString(3, comboBox.getSelectedItem().toString());
		                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		                String date = sdf.format(RentDate.getDate());
		                String date1 = sdf.format(ReturnDateTb.getDate());
		                addRent.setString(4, date);
		                addRent.setString(5, date1);
		                addRent.setInt(6, Integer.valueOf(FeeTb.getText()));

		                int rowRent = addRent.executeUpdate();

		                if (rowRent > 0) {
		                   
		                    deleteCar(con, RegNumTb.getText());

		                    DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		                    int selectedRowIndex = table.getSelectedRow();
		                    if (selectedRowIndex != -1) {
		                        dtm.removeRow(selectedRowIndex);
		                    }

		                    JOptionPane.showMessageDialog(null, "Car Added to Rent and Removed from Available Cars");
		                    DisplayCars();
		                    DisplayCars11(); 
		                } else {
		                    JOptionPane.showMessageDialog(null, "Error adding car to rent");
		                }

		            } catch (SQLException e1) {
		                e1.printStackTrace();
		                JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
		            } catch (ClassNotFoundException e1) {
		                e1.printStackTrace();
		            }
		        }
		    

			
			}});
		Savebtn.setForeground(new Color(178, 34, 34));
		Savebtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
		Savebtn.setBounds(414, 195, 101, 23);
		contentPane.add(Savebtn);
		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Dimension size = toolkit.getScreenSize();  
		setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
		
		
		JButton EditBtn = new JButton("Edit");
		EditBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(RegNumTb.getText().isEmpty() || FeeTb.getText().isEmpty() || RentIdTb.getText().isEmpty() || RentIdTb.getText().isEmpty() ) { 
			        JOptionPane.showMessageDialog(null, "Select the rent to be Updated");
			    } else {
			        Connection con = null;
			        try {
			            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/manage car", "root", "");
			            String q = "UPDATE User.car_registration SET BrandTb = ?, ModelTB = ?, StatusCb = ?, PriceTb = ? WHERE RegNumTb = ?";

			            PreparedStatement updateStatement = con.prepareStatement(q);

			            updateStatement.setString(1, RegNumTb.getText());
			            updateStatement.setString(2, RentIdTb.getText());
			            updateStatement.setString(3, comboBox.getSelectedItem().toString());
			            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
				        String date=sdf.format(RentDate.getDate());
				        SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd");
				        String date1=sdf1.format(ReturnDateTb.getDate());
				        updateStatement.setString(4, date);
				        updateStatement.setString(5, date1);
				        updateStatement.setInt(6, Integer.valueOf(FeeTb.getText()));


			            int rowsAffected = updateStatement.executeUpdate();

			            if (rowsAffected > 1) {
			                JOptionPane.showMessageDialog(null, "Record updated successfully");
			            } else {
			                JOptionPane.showMessageDialog(null, "Failed to update the record");
			            }
			        } catch (SQLException e1) {
			            e1.printStackTrace();
			            JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
			        } finally {
			            try {
			                if (con != null) {
			                    con.close();
			                }
			            } catch (SQLException e2) {
			                e2.printStackTrace();
			            }
			        }
			    }

			}
		});
		EditBtn.setForeground(new Color(178, 34, 34));
		EditBtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
		EditBtn.setBounds(551, 195, 101, 23);
		contentPane.add(EditBtn);
		
		JButton ResetBtn = new JButton("Reset");
		ResetBtn.addActionListener(new ActionListener() {
			private  void Reset() {
				RegNumTb.setText("");
				RentIdTb.setText("");
				comboBox.setSelectedItem(0);
				FeeTb.setText("");
				
			}
			public void actionPerformed(ActionEvent e) {
				Reset();
			}
		});
		ResetBtn.setForeground(new Color(178, 34, 34));
		ResetBtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
		ResetBtn.setBounds(699, 195, 101, 23);
		contentPane.add(ResetBtn);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Car List");
		lblNewLabel_1_3_1.setForeground(new Color(204, 51, 51));
		lblNewLabel_1_3_1.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblNewLabel_1_3_1.setBounds(536, 263, 218, 28);
		contentPane.add(lblNewLabel_1_3_1);
		
		JScrollPane CarTable = new JScrollPane();
		CarTable.setBounds(247, 301, 718, 143);
		contentPane.add(CarTable);
		table = new JTable();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int MyIndex=table.getSelectedRow();
				
		            RegNumTb.setText(model.getValueAt(MyIndex, 0).toString());
		            
		        
			}
		});
		
		CarTable.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Car Registration","Brand","Model","Status","Price"
			}
		));
		DisplayCars();
		
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Car on Rent");
		lblNewLabel_1_3_1_1.setForeground(new Color(204, 51, 51));
		lblNewLabel_1_3_1_1.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblNewLabel_1_3_1_1.setBounds(521, 466, 218, 28);
		contentPane.add(lblNewLabel_1_3_1_1);
		
		
		table_1 = new JTable();
		JScrollPane scrollPane= new JScrollPane();
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
		    new Object[][] {},
		    new String[] {"RentId", "CarReg", "CustName", "RentDate", "ReturnDate", "RentFee"}
		));
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table_2.print();
				}catch(Exception e1) {
					
				}
			}
			
		});
		btnPrint.setForeground(new Color(178, 34, 34));
		btnPrint.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnPrint.setBounds(566, 712, 101, 23);
		contentPane.add(btnPrint);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 51, 51));
		panel_1.setBounds(0, 636, 195, 152);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("                  ");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		panel_1.add(lblNewLabel_1_2);
		
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
			        cs.setUndecorated(true);
			        cs.setVisible(true);
			    } catch (Exception ex) {
			        ex.printStackTrace();
			    }
				dispose();
			}
		});
		lblNewLabel_1_4_1.setForeground(Color.WHITE);
		lblNewLabel_1_4_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		panel_1.add(lblNewLabel_1_4_1);
		
		RentDate = new JDateChooser();
		RentDate.setBounds(666, 137, 101, 19);
		contentPane.add(RentDate);

		ReturnDateTb = new JDateChooser();
		ReturnDateTb.setBounds(787, 137, 101, 19);
		contentPane.add(ReturnDateTb);
		
		JScrollPane CarRentTb = new JScrollPane();
		CarRentTb.setBounds(257, 504, 701, 189);
		contentPane.add(CarRentTb);

		table_2 = new JTable();
		CarRentTb.setViewportView(table_2);
		DisplayCars();
		

		table_2.setModel(new DefaultTableModel(
		    new Object[][] {
		    },
		    new String[] {
		        "Rent ID", "Car Registration", "Customer Name", "RentDate", "ReturnDate", "Rent Fee "
		    }
		));
		
		JLabel lblNewLabel_4 = new JLabel("* CNIC of customer");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_4.setBounds(205, 166, 140, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("* car Registration");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_4_1.setBounds(336, 166, 140, 13);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_4_2.setBounds(908, 167, 140, 13);
		contentPane.add(lblNewLabel_4_2);

		table_2.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        DefaultTableModel model = (DefaultTableModel) table_2.getModel();
		        int myIndex = table_2.getSelectedRow();
		        if (myIndex != -1) {
		            RegNumTb.setText(model.getValueAt(myIndex, 1).toString());
		            RentIdTb.setText(model.getValueAt(myIndex, 0).toString());
		            comboBox.setSelectedItem(model.getValueAt(myIndex, 2).toString());
		            FeeTb.setText(model.getValueAt(myIndex, 5).toString());
		        }
		    }
		   
		});DisplayCars11();
	}
		 void DisplayCars() {
			 String CarStatus="Available";
			    try {
			        Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/manage car", "root", "");

			        pst = con.prepareStatement("SELECT * FROM car_rigistration WHERE StatusCb=?");
			        pst.setString(1, CarStatus);

			        Rs = pst.executeQuery();
			        ResultSetMetaData rsmd = (ResultSetMetaData) Rs.getMetaData();
			        int n = rsmd.getColumnCount();
			        DefaultTableModel dtm = (DefaultTableModel)table.getModel();
			        dtm.setRowCount(0);
			        while (Rs.next()) {
			            Vector<String> v = new Vector();
			            for (int i = 1; i <= n; i++) {
			                v.add(Rs.getString("RegNumTb"));
			                v.add(Rs.getString("BrandTb"));
			                v.add(Rs.getString("ModelTb"));
			                v.add(Rs.getString("StatusCb"));
			                v.add(Rs.getString("PriceTb"));
			            }
			            dtm.addRow(v);
			        }

			    } catch (SQLException e) {
			        e.printStackTrace();
			    } catch (ClassNotFoundException e) {
			        e.printStackTrace();
			    }
			

		 }
		 void DisplayCars1() {
			 try {
			        Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/manage car", "root", "");
			        String q = "SELECT * FROM customertbl";
			        PreparedStatement pst = con.prepareStatement(q);
			        ResultSet rs = pst.executeQuery();

			        comboBox.removeAllItems();

			        while (rs.next()) {
			            comboBox.addItem(rs.getString("CustName"));
			        }

			    } catch (SQLException e) {
			        e.printStackTrace();
			    } catch (ClassNotFoundException e) {
			        e.printStackTrace();
			    }
			}
		 void DisplayCars11() {
			    try {
			        Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/manage car", "root", "");

			        pst = con.prepareStatement("SELECT * FROM renttbl");
			        Rs = pst.executeQuery();
			        ResultSetMetaData rsmd = (ResultSetMetaData) Rs.getMetaData();
			        int n = rsmd.getColumnCount();
			        DefaultTableModel dtm = (DefaultTableModel) table_2.getModel();
			        dtm.setRowCount(0);
			        while (Rs.next()) {
			            Vector<String> v = new Vector();
			            for (int i = 1; i <= n; i++) {
			                v.add(Rs.getString("RentId"));
			                v.add(Rs.getString("CarReg"));
			                v.add(Rs.getString("CustName"));
			                v.add(Rs.getString("RentDate"));
			                v.add(Rs.getString("ReturnDate"));
			                v.add(Rs.getString("RentFee"));
			            }
			            dtm.addRow(v);
			        }

			    } catch (SQLException e) {
			        e.printStackTrace();
			    } catch (ClassNotFoundException e) {
			        e.printStackTrace();
			    }}
		
}

