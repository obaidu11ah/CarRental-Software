package java_car_rental;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.xdevapi.Statement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Main extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private final JPanel panel = new JPanel();
    private final JPanel panel_3 = new JPanel();
    private JTextField RegNumTb;
    private JTextField BrandTb;
    private JTextField ModelTb;
    private JTextField PriceTb;
    private JTable table_1;
    private static JTable table;

    /**
     * Launch the application.
     */
   
    Connection con=null;
    Statement st= null;
    static ResultSet Rs=null;
    static PreparedStatement pst=null;
    

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();
                    DisplayCars1();
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


	public Main() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 965, 595);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(204, 51, 51));
		panel.setBounds(-1, 184, 195, 274);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Customer   ");
		lblNewLabel_1.setBounds(47, 5, 101, 23);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				try {
			        customer cs = new customer();
			        customer.DisplayCars();
			        cs.setUndecorated(true);
			        cs.setVisible(true);
			    } catch (Exception ex) {
			        ex.printStackTrace();
			    }
				dispose();
			}
		});
		panel.setLayout(null);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Return  Car   ");
		lblNewLabel_1_1.setBounds(41, 33, 112, 23);
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
			       rent_car r = new rent_car();
			        r.DisplayCars1();
				    r.DisplayCars();
				    r.setUndecorated(true);
				    r.setVisible(true);
			       
			     
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
		lblNewLabel_1_2.setBounds(51, 66, 76, 23);
		lblNewLabel_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
			        return_ cs = new return_();
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
		Component panel_1;
		
		JLabel lblNewLabel = new JLabel("Amazing Service");
		contentPane.add(lblNewLabel);
		lblNewLabel.setLabelFor(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 250, 240));
		lblNewLabel.setBounds(10, 198, 195, 23);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 51, 51));
		panel_2.setBounds(-11, -36, 205, 232);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("Registration Num");
		lblNewLabel_2.setBounds(204, 82, 158, 29);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(204, 51, 51));
		lblNewLabel_2.setBackground(new Color(153, 153, 153));
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		JLabel lblNewLabel_1_3 = new JLabel("Mangae Cars");
		lblNewLabel_1_3.setBounds(467, 29, 146, 28);
		contentPane.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setForeground(new Color(204, 51, 51));
		lblNewLabel_1_3.setFont(new Font("Century Gothic", Font.BOLD, 22));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(180, 0, 744, 29);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(921, 0, 49, 29);
		contentPane.add(panel_4);
		
		
		JLabel lblNewLabel_3 = new JLabel("X");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);;
			}
		});
		panel_4.add(lblNewLabel_3);
		lblNewLabel_3.setBackground(new Color(240, 248, 255));
		lblNewLabel_3.setForeground(new Color(153, 0, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNewLabel_2_1 = new JLabel("Brand");
		lblNewLabel_2_1.setForeground(new Color(204, 51, 51));
		lblNewLabel_2_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_2_1.setBackground(new Color(153, 153, 153));
		lblNewLabel_2_1.setBounds(388, 82, 63, 29);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Model");
		lblNewLabel_2_2.setForeground(new Color(204, 51, 51));
		lblNewLabel_2_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_2_2.setBackground(new Color(153, 153, 153));
		lblNewLabel_2_2.setBounds(551, 82, 93, 29);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Status");
		lblNewLabel_2_3.setForeground(new Color(204, 51, 51));
		lblNewLabel_2_3.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_2_3.setBackground(new Color(153, 153, 153));
		lblNewLabel_2_3.setBounds(699, 82, 78, 29);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Price");
		lblNewLabel_2_4.setForeground(new Color(204, 51, 51));
		lblNewLabel_2_4.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_2_4.setBackground(new Color(153, 153, 153));
		lblNewLabel_2_4.setBounds(841, 82, 70, 29);
		contentPane.add(lblNewLabel_2_4);
		
		RegNumTb = new JTextField();
		RegNumTb.setBounds(204, 121, 134, 19);
		contentPane.add(RegNumTb);
		RegNumTb.setColumns(10);
		
		BrandTb = new JTextField();
		BrandTb.setColumns(10);
		BrandTb.setBounds(388, 121, 108, 19);
		contentPane.add(BrandTb);
		
		ModelTb = new JTextField();
		ModelTb.setColumns(10);
		ModelTb.setBounds(549, 121, 101, 19);
		contentPane.add(ModelTb);
		
		PriceTb = new JTextField();
		PriceTb.setColumns(10);
		PriceTb.setBounds(839, 121, 85, 19);
		contentPane.add(PriceTb);
		
		JComboBox StatusCb = new JComboBox();
		StatusCb.setForeground(new Color(139, 0, 0));
		StatusCb.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		StatusCb.setModel(new DefaultComboBoxModel(new String[] {"Booked", "Available"}));
		StatusCb.setBounds(699, 121, 101, 21);
		contentPane.add(StatusCb);
		
		JButton SaveBtn = new JButton("Save");
		SaveBtn.addActionListener(new ActionListener() {
			
			 void DisplayCars() {
			    try {
			        Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/manage car", "root", "");

			        pst = con.prepareStatement("SELECT * FROM car_rigistration");
			        Rs = pst.executeQuery();
			        ResultSetMetaData rsmd = (ResultSetMetaData) Rs.getMetaData();
			        int n = rsmd.getColumnCount();
			        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
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



			public void actionPerformed(ActionEvent e) {
				if(RegNumTb.getText().isEmpty() || PriceTb.getText().isEmpty() || BrandTb.getText().isEmpty() || ModelTb.getText().isEmpty() || StatusCb.getSelectedIndex()==-1) {

					 JOptionPane.showMessageDialog(null, "Missing Information");
				 }
				 else {
					 
					 DisplayCars();
				try {
				    Class.forName("com.mysql.cj.jdbc.Driver");
				    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/manage car", "root", "");

				    String priceText = PriceTb.getText();

				    if (!priceText.isEmpty()) {
				    	PreparedStatement add = con.prepareStatement("insert into `car_rigistration` values(?,?,?,?,?)");


				        add.setString(1, RegNumTb.getText());
				        add.setString(2, BrandTb.getText());
				        add.setString(3, ModelTb.getText());
				        add.setString(4, StatusCb.getSelectedItem().toString());

				     
				        add.setInt(5, Integer.parseInt(priceText));

				        int row = add.executeUpdate();

				        if (row > 0) {
				            JOptionPane.showMessageDialog(null, "Car Added Successfully");
				        } else {
				            JOptionPane.showMessageDialog(null, "Error adding car");
				        }
				    } else {
				      
				        JOptionPane.showMessageDialog(null, "Please enter a valid price");
				    }
				    

				} catch (SQLException e1) {
				    e1.printStackTrace();
				    JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
				} catch (ClassNotFoundException e1) {
				    e1.printStackTrace();
				}
				 }
			
				DisplayCars();
			
			}});
		SaveBtn.setForeground(new Color(178, 34, 34));
		SaveBtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
		SaveBtn.setBounds(326, 173, 101, 23);
		contentPane.add(SaveBtn);
		
		JButton Editbtn = new JButton("Edit");
		Editbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (RegNumTb.getText().isEmpty() || PriceTb.getText().isEmpty() || BrandTb.getText().isEmpty()
			            || ModelTb.getText().isEmpty() || StatusCb.getSelectedIndex() == -1) {
			        JOptionPane.showMessageDialog(null, "Select the car to be Updated");
			    } else {
			        Connection con = null;
			        try {
			            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/manage car", "root", "");
			            String q = "UPDATE User.car_registration SET BrandTb = ?, ModelTB = ?, StatusCb = ?, PriceTb = ? WHERE RegNumTb = ?";


			            PreparedStatement updateStatement = con.prepareStatement(q);


			            updateStatement.setString(1, BrandTb.getText());
			            updateStatement.setString(2, ModelTb.getText());
			            updateStatement.setString(3, StatusCb.getSelectedItem().toString());
			            updateStatement.setInt(4, Integer.parseInt(PriceTb.getText()));
			            updateStatement.setString(5, RegNumTb.getText());

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

			}});
		Editbtn.setForeground(new Color(178, 34, 34));
		Editbtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
		Editbtn.setBounds(437, 173, 101, 23);
		contentPane.add(Editbtn);
		
		JButton Deletebtn = new JButton("Delete");
		Deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();

		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(null, "Please select a row for deletion.");
		            return;
		        }

		        DefaultTableModel model = (DefaultTableModel) table.getModel();
		        String regNumValue = model.getValueAt(selectedRow, 0).toString(); // Assuming RegNumTb is the first column

		        String sql = "DELETE FROM car_rigistration WHERE RegNumTb = ?";

		        try {
		         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/manage car", "root", "");
		            pst = con.prepareStatement(sql);
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
		Deletebtn.setBounds(551, 173, 101, 23);
		contentPane.add(Deletebtn);
		
		JButton Resetbtn = new JButton("Reset");
		Resetbtn.addActionListener(new ActionListener() {
			private void Reset()
			{
			RegNumTb.setText("");
			ModelTb.setText("");
			BrandTb.setText("");
			StatusCb.setSelectedIndex(-1);
			PriceTb.setText("");}
			public void actionPerformed(ActionEvent e) {
				Reset();
			}
		});
		Resetbtn.setForeground(new Color(178, 34, 34));
		Resetbtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
		Resetbtn.setBounds(662, 173, 101, 23);
		contentPane.add(Resetbtn);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Cars list");
		lblNewLabel_1_3_1.setForeground(new Color(204, 51, 51));
		lblNewLabel_1_3_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_1_3_1.setBounds(498, 226, 146, 28);
		contentPane.add(lblNewLabel_1_3_1);
		
		
		
		JScrollPane CarTable = new JScrollPane();
		
		CarTable.setBounds(264, 278, 620, 218);
		contentPane.add(CarTable);
		
		table = new JTable();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int MyIndex=table.getSelectedRow();
				if (MyIndex != -1) {
		            RegNumTb.setText(model.getValueAt(MyIndex, 0).toString());
		            BrandTb.setText(model.getValueAt(MyIndex, 1).toString());
		            ModelTb.setText(model.getValueAt(MyIndex, 2).toString());
		            StatusCb.setSelectedItem(model.getValueAt(MyIndex, 3).toString());
		            PriceTb.setText(model.getValueAt(MyIndex, 4).toString());
		        }
			
			}
		});
		CarTable.setViewportView(table);
		
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"RegNumTb", "BrandTb", "ModelTb", "StatusCb", "PriceTb"
			}
			
		));
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(204, 51, 51));
		panel_1_1.setBounds(-1, 458, 195, 152);
		contentPane.add(panel_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("                  ");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		panel_1_1.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("                             ");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		panel_1_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("LOGOUT");
		lblNewLabel_1_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
			        java_car_rental cs = new java_car_rental();
			        cs.setVisible(true);
			    } catch (Exception ex) {
			        ex.printStackTrace();
			    }
				dispose();
			}
		});
		lblNewLabel_1_4_1.setForeground(Color.WHITE);
		lblNewLabel_1_4_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		panel_1_1.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("* NUMERIC VALUE");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_4_1.setBounds(204, 150, 236, 13);
		contentPane.add(lblNewLabel_4_1);
		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Dimension size = toolkit.getScreenSize();  
		setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
		
	}
	static void DisplayCars1() {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/manage car", "root", "");

	        pst = con.prepareStatement("SELECT * FROM car_rigistration");
	        Rs = pst.executeQuery();
	        ResultSetMetaData rsmd = (ResultSetMetaData) Rs.getMetaData();
	        int n = rsmd.getColumnCount();
	        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
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
}
