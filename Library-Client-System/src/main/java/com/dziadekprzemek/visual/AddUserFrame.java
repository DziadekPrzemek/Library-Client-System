package com.dziadekprzemek.visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.dziadekprzemek.logic.NewUser;

public class AddUserFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userLoginTextField;
	private JTextField fnameUserTextField;
	private JTextField lnameUserTextField;
	private JTextField adressUserTextField;
	private JPasswordField passwodrUsertTextField;
	private JTextField cityUserTextField;
	private JTextField districtUserTextField;
	private JTextField postUserTextField;

	private final JTextField textField_7 = new JTextField();
	private JTextField phoneUserTextField;
	private JTextField emailUserTextField;

	
	public AddUserFrame() {
		textField_7.setColumns(10);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Add User");
		setBounds(100, 100, 389, 219);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		logo();
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
		lblNazwisko.setBounds(10, 86, 80, 14);
		contentPane.add(lblNazwisko);
		
		JLabel lblAdres = new JLabel("Address:");
		lblAdres.setBounds(10, 111, 80, 14);
		contentPane.add(lblAdres);
		
		JLabel lblMiasto = new JLabel("City: ");
		lblMiasto.setBounds(213, 11, 46, 14);
		contentPane.add(lblMiasto);
		
		JLabel lblWojewdztwo = new JLabel("District: ");
		lblWojewdztwo.setBounds(213, 36, 60, 14);
		contentPane.add(lblWojewdztwo);
		
		JLabel lblPostalCode = new JLabel("Post code:");
		lblPostalCode.setBounds(213, 61, 60, 14);
		contentPane.add(lblPostalCode);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(213, 86, 46, 14);
		contentPane.add(lblPhone);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(213, 111, 46, 14);
		contentPane.add(lblEmail);
		
		userLoginTextField = new JTextField();
		userLoginTextField.setBounds(100, 11, 86, 20);
		contentPane.add(userLoginTextField);
		userLoginTextField.setColumns(10);
		
		fnameUserTextField = new JTextField();
		fnameUserTextField.setBounds(100, 61, 86, 20);
		contentPane.add(fnameUserTextField);
		fnameUserTextField.setColumns(10);
		
		lnameUserTextField = new JTextField();
		lnameUserTextField.setBounds(100, 86, 86, 20);
		contentPane.add(lnameUserTextField);
		lnameUserTextField.setColumns(10);
		
		adressUserTextField = new JTextField();
		adressUserTextField.setBounds(100, 111, 86, 20);
		contentPane.add(adressUserTextField);
		adressUserTextField.setColumns(10);
		
		passwodrUsertTextField = new JPasswordField();
		passwodrUsertTextField.setBounds(100, 39, 86, 20);
		contentPane.add(passwodrUsertTextField);
		
		cityUserTextField = new JTextField();
		cityUserTextField.setBounds(277, 11, 86, 20);
		contentPane.add(cityUserTextField);
		cityUserTextField.setColumns(10);
		
		districtUserTextField = new JTextField();
		districtUserTextField.setBounds(277, 36, 86, 20);
		contentPane.add(districtUserTextField);
		districtUserTextField.setColumns(10);
		
		postUserTextField = new JTextField();
		postUserTextField.setBounds(277, 61, 86, 20);
		contentPane.add(postUserTextField);
		postUserTextField.setColumns(10);
		
		phoneUserTextField = new JTextField();
		phoneUserTextField.setBounds(277, 86, 86, 20);
		contentPane.add(phoneUserTextField);
		phoneUserTextField.setColumns(10);
		
		emailUserTextField = new JTextField();
		emailUserTextField.setBounds(277, 111, 86, 20);
		contentPane.add(emailUserTextField);
		emailUserTextField.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUserFrame frame = new AddUserFrame();
				frame.setVisible(false);
				dispose();
				
			}
		});
		btnCancel.setBounds(10, 148, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userLoginTextField.setText("");
				passwodrUsertTextField.setText("");
				lnameUserTextField.setText("");
				fnameUserTextField.setText("");
				adressUserTextField.setText("");
				cityUserTextField.setText("");
				postUserTextField.setText("");
				districtUserTextField.setText("");
				phoneUserTextField.setText("");
				emailUserTextField.setText("");
				
			}
		});
		btnReset.setBounds(142, 148, 89, 23);
		contentPane.add(btnReset);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				NewUser user = new NewUser();
				String loginUser = userLoginTextField.getText();
				String passwodrUser = String.valueOf(passwodrUsertTextField.getPassword());
				String lnameUser = lnameUserTextField.getText();
				String fnameUser = fnameUserTextField.getText();
				 String adressUser = adressUserTextField.getText();
				 String cityUser = cityUserTextField.getText();
				 String postUser= postUserTextField.getText();
				 String districtUser = districtUserTextField.getText();
				 String phoneUser = phoneUserTextField.getText();
				 String emailUser = emailUserTextField.getText();
				
				 Random rand = new Random();
				 int cardNumber = rand.nextInt(1000000000-1000000+1)+1000000;
				 
				
				
				 
				user.updateUserList(loginUser, passwodrUser, lnameUser, fnameUser, adressUser, cityUser, postUser, districtUser, phoneUser, emailUser, cardNumber);
				dispose();
				
			}
		});
		btnAdd.setBounds(261, 148, 89, 23);
		contentPane.add(btnAdd);
	
		
		
		
	}

	private void logo() {
		ImageIcon img = new ImageIcon("H:\\Dev\\Projekty\\Library-Client-System\\src\\main\\java\\Images\\book-ico.png");
		setIconImage(img.getImage());
		setResizable(false);
	}
}
