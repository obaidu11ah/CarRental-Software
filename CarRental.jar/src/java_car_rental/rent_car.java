package java_car_rental;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.xdevapi.Statement;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class rent_car extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ReturnIdTb;
	private JTextField RegTb;
	private JTextField FineTb;
	private static JTable table;
	private JTable table_1;
	private static JTable table_2;
	private JTextField DelayTb;
	public JDateChooser ReturnDate ;

	/**
	 * Launch the application.
	 */

    Connection con=null;
    Statement st= null;
    static ResultSet Rs=null;
    static PreparedStatement pst=null;
    private JTextField CustName;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rent_car frame = new rent_car();
					frame.DisplayCars();
					frame.DisplayCars1();
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
	public rent_car() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 604);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 51, 51));
		panel.setBounds(0, 165, 195, 310);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Customer");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
			        customer cs = new customer();
			        cs.DisplayCars();
			        cs.setVisible(true);
			        cs.setUndecorated(true);
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
		
		JLabel lblNewLabel_1_4 = new JLabel("Rent Car");
		lblNewLabel_1_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
			        return_ cs = new return_ ();
			       cs.DisplayCars1();
			       cs.DisplayCars();
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
		panel_2.setBounds(-10, -62, 205, 232);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(192, 0, 744, 29);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(924, 0, 49, 29);
		contentPane.add(panel_4);
		
		JLabel lblNewLabel_3 = new JLabel("X"); 
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_3.setForeground(new Color(153, 0, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBackground(new Color(240, 248, 255));
		panel_4.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Return ID");
		lblNewLabel_2.setForeground(new Color(204, 51, 51));
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_2.setBackground(new Color(153, 153, 153));
		lblNewLabel_2.setBounds(205, 57, 158, 29);
		contentPane.add(lblNewLabel_2);
		
		ReturnIdTb = new JTextField();
		ReturnIdTb.setColumns(10);
		ReturnIdTb.setBounds(205, 84, 109, 19);
		contentPane.add(ReturnIdTb);
		
		JLabel lblNewLabel_2_1 = new JLabel("Registration");
		lblNewLabel_2_1.setForeground(new Color(204, 51, 51));
		lblNewLabel_2_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_2_1.setBackground(new Color(153, 153, 153));
		lblNewLabel_2_1.setBounds(205, 113, 158, 29);
		contentPane.add(lblNewLabel_2_1);
		
		RegTb = new JTextField();
		RegTb.setColumns(10);
		RegTb.setBounds(205, 141, 158, 19);
		contentPane.add(RegTb);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Return Date");
		lblNewLabel_2_1_1.setForeground(new Color(204, 51, 51));
		lblNewLabel_2_1_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_2_1_1.setBackground(new Color(153, 153, 153));
		lblNewLabel_2_1_1.setBounds(205, 238, 158, 29);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Delay");
		lblNewLabel_2_1_1_1.setForeground(new Color(204, 51, 51));
		lblNewLabel_2_1_1_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_2_1_1_1.setBackground(new Color(153, 153, 153));
		lblNewLabel_2_1_1_1.setBounds(205, 346, 158, 29);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Fine");
		lblNewLabel_2_2.setForeground(new Color(204, 51, 51));
		lblNewLabel_2_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_2_2.setBackground(new Color(153, 153, 153));
		lblNewLabel_2_2.setBounds(205, 417, 158, 29);
		contentPane.add(lblNewLabel_2_2);
		
		FineTb = new JTextField();
		FineTb.setColumns(10);
		FineTb.setBounds(205, 456, 109, 19);
		contentPane.add(FineTb);
		
		JButton ReturnBtn = new JButton("Return");
		ReturnBtn.addActionListener(new ActionListener() {
		    private void deleteRent(Connection con, String rentId) throws SQLException {
		        PreparedStatement deleteRent = con.prepareStatement("DELETE FROM renttbl WHERE RentId = ?");
		        deleteRent.setString(1, rentId);
		        int rowRent = deleteRent.executeUpdate();
		        if (rowRent > 0) {
		            System.out.println("Rent record deleted successfully");
		        } else {
		            System.out.println("Error deleting rent record");
		        }
		    }

		    public void actionPerformed(ActionEvent e) {
		        if (ReturnIdTb.getText().isEmpty() || RegTb.getText().isEmpty() || CustName.getText().isEmpty() || DelayTb.getText().isEmpty() || FineTb.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
		        } else {
		            Connection con = null;
		            try {
		                Class.forName("com.mysql.cj.jdbc.Driver");
		                con = DriverManager.getConnection("jdbc:mysql://localhost:3307/manage car", "root", "");

		                String sql = "INSERT INTO `returntbl` VALUES (?, ?, ?, ?, ?, ?)";
		                PreparedStatement add = con.prepareStatement(sql);

		                add.setString(1, ReturnIdTb.getText());
		                add.setString(2, RegTb.getText());
		                add.setString(3, CustName.getText());
		                java.util.Date returnDate = ReturnDate.getDate();
		                java.sql.Date sqlReturnDate = new java.sql.Date(returnDate.getTime());
		                add.setDate(4, sqlReturnDate);

		                add.setString(5, DelayTb.getText());

		                String fineAmount = FineTb.getText().replaceAll("\\D+", "");
		                add.setInt(6, Integer.valueOf(fineAmount));

		                int row = add.executeUpdate();
		                if (row > 0) {
		                    
		                    deleteRent(con, ReturnIdTb.getText());
		                    DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		                    int selectedRowIndex = table.getSelectedRow();
		                    if (selectedRowIndex != -1) {
		                        dtm.removeRow(selectedRowIndex);
		                    }

		                    DisplayCars();
		                    DisplayCars1();
		                    JOptionPane.showMessageDialog(null, "Record added to return and rent record deleted successfully");
		                }
		            } catch (SQLException | ClassNotFoundException ex) {
		                ex.printStackTrace();
		                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		            } finally {
		                try {
		                    if (con != null) {
		                        con.close();
		                    }
		                } catch (SQLException ex) {
		                    ex.printStackTrace();
		                }
		            }
		        }
		    }
		});

		ReturnBtn.setForeground(new Color(204, 51, 51));
		ReturnBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		ReturnBtn.setBounds(252, 492, 91, 28);
		contentPane.add(ReturnBtn);
		
		JLabel lblNewLabel = new JLabel("Generate");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			int Cost=0;
			public void mouseClicked(MouseEvent e) {
				
				 try {
	                    int delay = Integer.parseInt(DelayTb.getText());
	                    int fine = delay * 1000;
	                    FineTb.setText("Rs " + fine);
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(null, "Invalid or missing Return Date");
	                }
	            
		    
			}});
		lblNewLabel.setForeground(new Color(204, 51, 51));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel.setBounds(329, 457, 99, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_3 = new JLabel("Cars Rent List");
		lblNewLabel_1_3.setForeground(new Color(204, 51, 51));
		lblNewLabel_1_3.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblNewLabel_1_3.setBounds(559, 45, 218, 28);
		contentPane.add(lblNewLabel_1_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(440, 80, 496, 178);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
		    new Object[][] {
		    },
		    new String[] {
		        "Rent ID", "Car Registation", "Customer Name", "Rent Date", "Return Date","Fee"
		    }
		));

		table.addMouseListener(new MouseAdapter() {
		     int cost=0;
		    public void mouseClicked(MouseEvent e) {
		        DefaultTableModel model = (DefaultTableModel) table.getModel();
		        int myIndex = table.getSelectedRow();
		        if (myIndex != -1) {
		        	ReturnIdTb.setText(model.getValueAt(myIndex, 0).toString());
		            RegTb.setText(model.getValueAt(myIndex, 1).toString());
		            CustName.setText(model.getValueAt(myIndex, 2).toString());
		              cost=Integer.valueOf(model.getValueAt(myIndex, 5).toString());
		              
		            
		        }}
		});

		
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Car Return List");
		lblNewLabel_1_3_1.setForeground(new Color(204, 51, 51));
		lblNewLabel_1_3_1.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblNewLabel_1_3_1.setBounds(596, 290, 218, 28);
		contentPane.add(lblNewLabel_1_3_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(440, 334, 496, 172);
		contentPane.add(scrollPane_1);
		
		table_2 = new JTable();
		scrollPane_1.setViewportView(table_2);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Return ID", "Registration", "Customer", "Return Date", "Delay", "Fine"
			}
		));
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					table_2.print();
				}catch(Exception e1) {
					
				}
			}
		});
		btnPrint.setForeground(new Color(204, 51, 51));
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPrint.setBounds(642, 516, 91, 28);
		contentPane.add(btnPrint);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 51, 51));
		panel_1.setBounds(0, 447, 195, 152);
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
		
		 ReturnDate = new JDateChooser();
		    ReturnDate.setBounds(205, 317, 101, 19);
		    contentPane.add(ReturnDate);
		
		DelayTb = new JTextField();
		DelayTb.setColumns(10);
		DelayTb.setBounds(205, 388, 109, 19);
		contentPane.add(DelayTb);
		
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Customer Name");
		lblNewLabel_2_1_2.setForeground(new Color(204, 51, 51));
		lblNewLabel_2_1_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_2_1_2.setBackground(new Color(153, 153, 153));
		lblNewLabel_2_1_2.setBounds(205, 180, 158, 29);
		contentPane.add(lblNewLabel_2_1_2);
		
		CustName = new JTextField();
		CustName.setColumns(10);
		CustName.setBounds(205, 209, 158, 19);
		contentPane.add(CustName);
		
		JLabel lblNewLabel_4 = new JLabel("*If know what add in Delay btn then press ? btn ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_4.setBounds(203, 372, 236, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("*please add Date Carefully from Carlist and also check your ID");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_4_1.setBounds(205, 294, 305, 13);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("*Add those RetuenDate  when you applay for Rent");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_4_1_1.setBounds(205, 271, 236, 13);
		contentPane.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "If you Return Car within the specified time mention in ReturnDate, enter zero; otherwise, indicate the number of days.Then Press GENERATE");
				
			}
		});
		ImageIcon img2 =new ImageIcon(this.getClass().getResource("/pngaaa.com-1507493 (1).png"));
		lblNewLabel_5.setIcon(img2);
		lblNewLabel_5.setBounds(324, 385, 14, 22);
		contentPane.add(lblNewLabel_5);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Dimension size = toolkit.getScreenSize();  
		setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);}
		
		static void DisplayCars() {

			    try {
			        Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/manage car", "root", "");

			        pst = con.prepareStatement("SELECT * FROM  renttbl ");
			        Rs = pst.executeQuery();
			        ResultSetMetaData rsmd = (ResultSetMetaData) Rs.getMetaData();
			        int n = rsmd.getColumnCount();
			        DefaultTableModel dtm = (DefaultTableModel)table.getModel();
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
			    }
			    }
			    
		static void DisplayCars1() {
		    try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/manage car", "root", "");

		        String sql = "SELECT * FROM `returntbl`";
		        pst = con.prepareStatement(sql);

		        Rs = pst.executeQuery();

		        ResultSetMetaData rsmd = (ResultSetMetaData) Rs.getMetaData();
		        int n = rsmd.getColumnCount();
		        DefaultTableModel dtm = (DefaultTableModel) table_2.getModel();
		        dtm.setRowCount(0);
		        while (Rs.next()) {
		            Vector<String> v = new Vector();
		            // Match these column names EXACTLY with your database
		            v.add(Rs.getString("ReturnIdTb"));  
		            v.add(Rs.getString("RegTb"));       
		            v.add(Rs.getString("CustName"));
		            v.add(Rs.getString("ReturnDate"));  
		            v.add(Rs.getString("DelayTb"));     
		            v.add(Rs.getString("FineTb"));      
		            dtm.addRow(v);
		        }
		    } catch (SQLException | ClassNotFoundException e) {
		        e.printStackTrace();
		    }
		}

		 
	
}
			
		

