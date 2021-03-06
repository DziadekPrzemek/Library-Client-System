package com.dziadekprzemek.visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.dziadekprzemek.logic.AddLibrarian;

public class AddLibrarianWindow extends JFrame {

	private JPanel contentPane;
	private JTextField LibrarianLoginTextField;
	private JPasswordField passwordLibrarianField;

	
	public AddLibrarianWindow() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 236, 140);
		setTitle("Add librarian");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		logo();
		JLabel lblAddLogin = new JLabel("Add login:");
		lblAddLogin.setBounds(7, 11, 62, 14);
		contentPane.add(lblAddLogin);
		
		JLabel lblAddPassword = new JLabel("Add password:");
		lblAddPassword.setBounds(7, 36, 93, 14);
		contentPane.add(lblAddPassword);
		
		LibrarianLoginTextField = new JTextField();
		LibrarianLoginTextField.setBounds(100, 8, 86, 20);
		contentPane.add(LibrarianLoginTextField);
		LibrarianLoginTextField.setColumns(10);
		
		passwordLibrarianField = new JPasswordField();
		passwordLibrarianField.setBounds(100, 33, 86, 20);
		contentPane.add(passwordLibrarianField);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(17, 68, 83, 23);
		contentPane.add(btnCancel);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String login = LibrarianLoginTextField.getText();
				String password = String.valueOf(passwordLibrarianField.getPassword());
				
				if(login.length() > 2 && password.length() > 3) {
				AddLibrarian librarian = new AddLibrarian();
				librarian.updateBookList(login, password);
				dispose();
				System.gc();
				}else {
					JOptionPane.showMessageDialog(null, "Login and password have to be min. 3 char long!");
				}
			}
		});
		btnOk.setBounds(110, 68, 76, 23);
		contentPane.add(btnOk);
	}


	private void logo() {
		ImageIcon img = new ImageIcon("H:\\Dev\\Projekty\\Library-Client-System\\src\\main\\java\\Images\\book-ico.png");
		setIconImage(img.getImage());
		setResizable(false);
	}
}
