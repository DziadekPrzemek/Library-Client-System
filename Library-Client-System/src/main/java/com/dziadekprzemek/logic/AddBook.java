package com.dziadekprzemek.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class AddBook {
	public void updateBookList(String isbn, String title, String author, Integer pages, String publisher, Integer year, String description){
		
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		String Status = "W wypo¿yczalni";
		
		try {
			
			ps = con.prepareStatement("INSERT INTO ksiazka (isbn, tytul, autor, stron, wydawnictwo, rok_wydania, opis, Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			
			ps.setString(1, isbn);
			ps.setString(2, title);
			ps.setString(3, author);
			ps.setInt(4, pages);
			ps.setString(5, publisher);
			ps.setInt(6, year);
			ps.setString(7, description);
			ps.setString(8, Status);
			
			if(ps.executeUpdate()>0) {
				
				JOptionPane.showMessageDialog(null, "Book has been added!");
				
				
			}else {
				JOptionPane.showMessageDialog(null, "Error!");
			}
			con.close();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		
		
	}
	
}
;