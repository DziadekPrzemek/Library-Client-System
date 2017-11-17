package com.dziadekprzemek.visual;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.dziadekprzemek.logic.MyConnection;

public class RentWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public RentWindow() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 971, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Rent Book");
		logo();
		JPanel panel = new JPanel();
		panel.setBounds(10, 31, 935, 306);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 935, 306);
		panel.add(scrollPane);
	
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"User number", "First Name", "Last Name", "Address", "City", "District", "Phone", "Post code", "Email"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, false, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		initComponents();
		
		JButton btnRent = new JButton("Rent");
		btnRent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				getRentedBookUserID(String.valueOf(table.getValueAt(table.getSelectedRow(), 0)));		
				MainWindow.RefreshTable();
			}
		});
		btnRent.setBounds(10, 350, 89, 23);
		contentPane.add(btnRent);
		
		JButton btnAddUser = new JButton("Add user");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUserFrame newUser = new AddUserFrame();
				newUser.setVisible(true);
			}
		});
		btnAddUser.setBounds(109, 350, 89, 23);
		contentPane.add(btnAddUser);
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnCancel.setBounds(216, 350, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel lblChooseUser = new JLabel("Choose user:");
		lblChooseUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblChooseUser.setBounds(10, 6, 158, 23);
		contentPane.add(lblChooseUser);
			
	}

	private void logo() {
		ImageIcon img = new ImageIcon("H:\\Dev\\Projekty\\Library-Client-System\\src\\main\\java\\Images\\book-ico.png");
		setIconImage(img.getImage());
		setResizable(false);
	}
	
private void initComponents() {
	RentWindow.fillUsersTable(table,"");
	
}

private static void fillUsersTable(JTable table, String valueToSearch) {
	Connection con = MyConnection.getConnection();
	PreparedStatement ps;
	
	try {
	ps = con.prepareStatement("SELECT * FROM czytelnik WHERE CONCAT(kod_czytelnika, imie, nazwisko, adres, miasto, wojewodztwo, telefon, kod_pocztowy, email) LIKE ?");
	ps.setString(1, "%"+valueToSearch+"%");
	
	ResultSet rs = ps.executeQuery();
	DefaultTableModel model = (DefaultTableModel) table.getModel();
	
	Object[] row;
	
	while(rs.next()) {
		
		row = new Object[9];
		
		row[0] =rs.getInt(12);
		row[1] =rs.getString(4);
		row[2] =rs.getString(5);
		row[3] =rs.getString(6);
		row[4] =rs.getString(7);
		row[5] =rs.getString(8);
		row[6] =rs.getString(9);
		row[7] =rs.getString(10);
		row[8] =rs.getString(11);		
		
		model.addRow(row);
	}
	
	
	}catch(SQLException e) {
		e.setNextException(null);
		
	}
	
} 

private void getRentedBookUserID(String UserID) {
	
	Connection con = MyConnection.getConnection();
	PreparedStatement ps;
	
	int index = MainWindow.returnRow();
	String status = "Wypo¿yczono";
	
	try {
		ps = con.prepareStatement("UPDATE ksiazka SET Status = ?, numerCzytelnika = ? WHERE id_ksiazka = ?");
		ps.setString(1, status);
		ps.setString(2, UserID);
		ps.setInt(3, index);
		
		if(ps.executeUpdate()>0) {
			
			JOptionPane.showMessageDialog(null, "Book has been rented!");
			dispose();
				
		}else {
			JOptionPane.showMessageDialog(null, "Error!");
		}
		con.close();
		
	}catch(SQLException ex) {
		ex.printStackTrace();
		JOptionPane.showMessageDialog(null, "Error!");
	}
	
	}

}




