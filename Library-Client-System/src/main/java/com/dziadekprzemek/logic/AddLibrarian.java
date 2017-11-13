package com.dziadekprzemek;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class AddLibrarian {
	public void updateBookList(String login, String password){
		
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		
		try {
			
			ps = con.prepareStatement("INSERT INTO bibliotekarz (login, haslo) VALUES (?, ?)");
			
			ps.setString(1, login);
			ps.setString(2, password);
			
			
			if(ps.executeUpdate()>0) {
				
				JOptionPane.showMessageDialog(null, "New Librarian has been added!");
				
				
				
			}else {
				JOptionPane.showMessageDialog(null, "Error!");
			}
			con.close();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}
		
	}