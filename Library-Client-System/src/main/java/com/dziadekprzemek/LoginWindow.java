package com.dziadekprzemek;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LoginWindow extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField loginTextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow frame = new LoginWindow();
					frame.setVisible(true);
					frame.setTitle("Login Window");
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 302, 218);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(154, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon img = new ImageIcon("H:\\Dev\\Projekty\\Library-Client-System\\src\\main\\java\\Images\\book-ico.png");
		setIconImage(img.getImage());
		setResizable(false);
		
		
		JLabel lblLibraryManagementSystem = new JLabel("Library Management System");
		lblLibraryManagementSystem.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
		lblLibraryManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibraryManagementSystem.setBounds(10, 11, 266, 31);
		contentPane.add(lblLibraryManagementSystem);
		
		JLabel lblLogin = new JLabel("Login: ");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLogin.setBounds(42, 53, 63, 22);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(26, 86, 79, 29);
		contentPane.add(lblPassword);
		
		loginTextField = new JTextField();
		loginTextField.setBounds(115, 55, 135, 22);
		contentPane.add(loginTextField);
		loginTextField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(115, 91, 135, 22);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("LogIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = MyConnection.getConnection();
				PreparedStatement ps;
				
				try {
					ps = con.prepareStatement("select * from bibliotekarz where login = ? and haslo = ?");
					ps.setString(1, loginTextField.getText());
					ps.setString(2, String.valueOf(passwordField.getPassword()));
					ResultSet rs = ps.executeQuery();
					
					if(rs.next()) {
						MainWindow mw = new MainWindow();
						mw.setVisible(true);
						mw.setResizable(false);
						mw.setBounds(0, 0, 1020, 440);
						dispose();
						
						
						
						
					}else {
						JOptionPane.showMessageDialog(null, "Wrong Login or Password!");
					}
				}
				catch(SQLException ex) {
					
				}
				
			}
		});
		btnLogin.setBounds(161, 137, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setBounds(26, 137, 89, 23);
		contentPane.add(btnCancel);
	}
}
