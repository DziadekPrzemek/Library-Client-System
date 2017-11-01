package com.dziadekprzemek;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class AddUserFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	/**
	 * @wbp.nonvisual location=-39,289
	 */
	private final JTextField textField_7 = new JTextField();
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUserFrame frame = new AddUserFrame();
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
	public AddUserFrame() {
		textField_7.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login: ");
		lblLogin.setBounds(10, 11, 80, 14);
		contentPane.add(lblLogin);
		
		JLabel lblHaso = new JLabel("Password:");
		lblHaso.setBounds(10, 36, 80, 14);
		contentPane.add(lblHaso);
		
		JLabel lblImi = new JLabel("First name:");
		lblImi.setBounds(10, 61, 80, 14);
		contentPane.add(lblImi);
		
		JLabel lblNazwisko = new JLabel("Last name: ");
		lblNazwisko.setBounds(10, 86, 60, 14);
		contentPane.add(lblNazwisko);
		
		JLabel lblAdres = new JLabel("Address:");
		lblAdres.setBounds(10, 111, 46, 14);
		contentPane.add(lblAdres);
		
		JLabel lblMiasto = new JLabel("City: ");
		lblMiasto.setBounds(170, 11, 46, 14);
		contentPane.add(lblMiasto);
		
		JLabel lblWojewdztwo = new JLabel("District: ");
		lblWojewdztwo.setBounds(170, 36, 60, 14);
		contentPane.add(lblWojewdztwo);
		
		JLabel lblPostalCode = new JLabel("Post code:");
		lblPostalCode.setBounds(170, 61, 60, 14);
		contentPane.add(lblPostalCode);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(170, 86, 46, 14);
		contentPane.add(lblPhone);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(170, 111, 46, 14);
		contentPane.add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(74, 8, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(74, 58, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(74, 83, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(74, 108, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(74, 36, 86, 20);
		contentPane.add(passwordField);
		
		textField_4 = new JTextField();
		textField_4.setBounds(236, 8, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(236, 33, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(236, 58, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(236, 83, 86, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(236, 108, 86, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(10, 157, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(127, 157, 89, 23);
		contentPane.add(btnReset);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(233, 157, 89, 23);
		contentPane.add(btnAdd);
	}
}
