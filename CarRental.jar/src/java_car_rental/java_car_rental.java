package java_car_rental;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class java_car_rental extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(() -> {
	        try {
	            java_car_rental frame = new java_car_rental();
	            frame.setUndecorated(true);
	            frame.setVisible(true);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    });
	}

	

	/**
	 * Create the frame.
	 */
	public java_car_rental() {
		setTitle("CAR RENTAL login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 387);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.setBounds(188, 21, 384, 371);
		panel_3.setBackground(new Color(204, 204, 204));
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(155, 201, 173, 19);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("USER NAME");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(178, 34, 34));
		lblNewLabel.setBounds(44, 202, 103, 13);
		panel_3.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(178, 34, 34));
		lblNewLabel_1.setBounds(44, 239, 91, 13);
		panel_3.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(new Color(204, 51, 51));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       
		        String username = textField.getText();
		        String pass = new String(passwordField.getPassword());

		        if (username.equals("obaid") && pass.equals("12345")) {
		            
		            JOptionPane.showMessageDialog(null, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

		      
		            SwingUtilities.invokeLater(() -> {
		                Main m = new Main();
		                Main.DisplayCars1();
		                m.setUndecorated(true);
		                m.setVisible(true);
		                dispose();
		            });
		        } else {
		          
		            JOptionPane.showMessageDialog(null, "Username and password do not match", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});


		btnNewButton.setBounds(198, 267, 91, 28);
		panel_3.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setText("");
		ImageIcon img2 =new ImageIcon(this.getClass().getResource("/WhatsApp Image 2023-12-01 at 22.30.37_66ee60e8 (1).jpg"));
		lblNewLabel_2.setIcon(img2);
		
		
		lblNewLabel_2.setBounds(106, 78, 183, 107);
		panel_3.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(155, 238, 172, 19);
		panel_3.add(passwordField);
		
		JLabel lblNewLabel_1_3 = new JLabel("Car Rental Software");
		lblNewLabel_1_3.setForeground(new Color(204, 51, 51));
		lblNewLabel_1_3.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblNewLabel_1_3.setBounds(86, 24, 221, 28);
		panel_3.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(253, 323, 146, 240);
		contentPane.add(lblNewLabel_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 51, 51));
		panel_2.setBounds(0, -26, 189, 162);
		contentPane.add(panel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 51, 51));
		panel.setBounds(0, 133, 189, 430);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Amazing service");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Security");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Responsivness");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_3 = new JLabel("X");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);;
			}
		});
		lblNewLabel_3.setBounds(526, 0, 13, 22);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(new Color(153, 0, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBackground(new Color(240, 248, 255));
		
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Dimension size = toolkit.getScreenSize();  
		setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
	}
}
