package com.dziadekprzemek;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AddBook {
	public void updateBookList(char operation, Integer bookId, Integer categoryId, String isbn, String title, String author, Integer pages, String publisher, Integer year, String description){
		
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		
		try {
			
			ps = con.prepareStatement("INSERT INTO ksiazka (isbn, tytul, autor, stron, wydawnictwo, rok_wydania, opis) VALUES (?, ?, ?, ?, ?, ?, ?)");
			
			ps.setString(1, isbn);
			ps.setString(2, title);
			ps.setString(3, author);
			ps.setInt(4, pages);
			ps.setString(5, publisher);
			ps.setInt(6, year);
			ps.setString(7, description);
			
			if(ps.executeUpdate()>0) {
				
				JOptionPane.showConfirmDialog(null, "Book has been added!");
				
			}else {
				JOptionPane.showMessageDialog(null, "Error!");
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		
		
	}
	public static void fillBookTable(JTable table, String valueToSearch) {
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		
		try {
		ps = con.prepareStatement("SELECT * FROM ksiazka WHERE CONCAT(isbn, tytul, autor, stron, wydawnictwo, rok_wydania) LIKE ?");
		ps.setString(1, "%"+valueToSearch+"%");
		
		ResultSet rs = ps.executeQuery();
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		
		Object[] row;
		
		while(rs.next()) {
			row = new Object[9];
			row[0] =rs.getInt(1);
			row[1] =rs.getInt(2);
			row[2] =rs.getString(3);
			row[3] =rs.getString(4);
			row[4] =rs.getString(5);
			row[5] =rs.getInt(6);
			row[6] =rs.getString(7);
			row[7] =rs.getInt(8);
			row[8] =rs.getString(9);
			model.addRow(row);
		}
			
		
		
		}catch(SQLException e) {
			e.setNextException(null);
			
		}
		
		
		
	}
	
	

}
