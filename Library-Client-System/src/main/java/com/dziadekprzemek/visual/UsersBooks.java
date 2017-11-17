package com.dziadekprzemek.visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.dziadekprzemek.logic.MyConnection;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UsersBooks extends JFrame {

	private JPanel contentPane;
	private static JTable UserTable;
	private static JTable BookTable;

	public UsersBooks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 309, 351);
		contentPane.add(scrollPane);
		
		UserTable = new JTable();
		UserTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Last Name", "First Name"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		UserTable.getColumnModel().getColumn(0).setResizable(false);
		UserTable.getColumnModel().getColumn(0).setPreferredWidth(40);
		UserTable.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(UserTable);
		
		
		JLabel lblChooseUser = new JLabel("Choose User:");
		lblChooseUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChooseUser.setBounds(10, 11, 159, 14);
		contentPane.add(lblChooseUser);
		
		JScrollPane UserBookTable = new JScrollPane();
		UserBookTable.setBounds(329, 38, 538, 351);
		contentPane.add(UserBookTable);
		
		BookTable = new JTable();
		BookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Title", "Author", "ISBN", "User ID"
			}
		));
		BookTable.getColumnModel().getColumn(0).setPreferredWidth(36);
		BookTable.getColumnModel().getColumn(1).setPreferredWidth(257);
		BookTable.getColumnModel().getColumn(2).setPreferredWidth(204);
		UserBookTable.setViewportView(BookTable);
		initComponents();
		JLabel lblUserBookList = new JLabel("User book list:");
		lblUserBookList.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserBookList.setBounds(327, 9, 123, 19);
		contentPane.add(lblUserBookList);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnSelect.setBounds(10, 409, 89, 23);
		contentPane.add(btnSelect);
	}
private static int selectedUser() {
		
		int index = (int)UserTable.getValueAt(Integer.valueOf(UserTable.getSelectedRow()), 0);
		return index;
		
	}
private void initComponents() {
	UsersBooks.fillUsersTable(UserTable,"");
	UsersBooks.fillBookTable(BookTable, "");
	
}

private static void fillUsersTable(JTable UserTable, String valueToSearch) {
	Connection con = MyConnection.getConnection();
	PreparedStatement ps;
	
	try {
	ps = con.prepareStatement("SELECT * FROM czytelnik WHERE CONCAT(kod_czytelnika, nazwisko, imie) LIKE ?");
	ps.setString(1, "%"+valueToSearch+"%");
	
	ResultSet rs = ps.executeQuery();
	DefaultTableModel model = (DefaultTableModel) UserTable.getModel();
	
	Object[] row;
	
	while(rs.next()) {
		
		row = new Object[3];
		
		row[0] =rs.getInt(12);
		row[1] =rs.getString(5);
		row[2] =rs.getString(4);
				
		
		model.addRow(row);
	}
	
	
	}catch(SQLException e) {
		e.setNextException(null);
		
	}
	
} 
private static Integer getIdNumber() {

	Integer userId = (Integer)UserTable.getValueAt(Integer.valueOf(UserTable.getSelectedRow()), 0);

			return userId;
}

private static void fillBookTable(JTable BookTable, String valueToSearch) {
	Connection con = MyConnection.getConnection();
	PreparedStatement ps;
	
		
	try {
	ps = con.prepareStatement("SELECT * FROM ksiazka WHERE CONCAT(id_ksiazka, tytul, autor, isbn) LIKE ?");
	ps.setString(1, "%"+valueToSearch+"%");
	
	ResultSet rs = ps.executeQuery();
	DefaultTableModel model = (DefaultTableModel) BookTable.getModel();
	
	Object[] row;
	
	while(rs.next()) {
		
		row = new Object[5];
		
		row[0] =rs.getInt(1);
		row[1] =rs.getString(3);
		row[2] =rs.getString(4);
		row[3] =rs.getString(2);		
		row[4] =rs.getString(10);
		model.addRow(row);
	}
	
	
	}catch(SQLException e) {
		e.setNextException(null);
		
	}
	
} 
private static void RefreshTable(JTable BookTable, String valueToSearch){
	Connection con = MyConnection.getConnection();
	PreparedStatement ps;
	
	String index = String.valueOf(getIdNumber());
		
	try {
	ps = con.prepareStatement("SELECT * FROM ksiazka WHERE CONCAT(id_ksiazka, tytul, autor, isbn) LIKE =?");
	ps.setString(1, "%"+valueToSearch+"%");
	
	ResultSet rs = ps.executeQuery();
	DefaultTableModel model = (DefaultTableModel) BookTable.getModel();
	
	Object[] row;
	
	while(rs.next()) {
		
		row = new Object[5];
		
		row[0] =rs.getInt(1);
		row[1] =rs.getString(3);
		row[2] =rs.getString(4);
		row[3] =rs.getString(2);		
		row[4] =rs.getString(10);
		model.addRow(row);
	}
	
	
	}catch(SQLException e) {
		e.setNextException(null);
		
	}
	
}
}
