package com.dziadekprzemek.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.security.auth.Refreshable;
import javax.swing.JOptionPane;

import com.dziadekprzemek.visual.MainWindow;

public class ReturnBook {
	
	public static void returnBook() {
	
	Connection con = MyConnection.getConnection();
	PreparedStatement ps;
	
	int index = MainWindow.returnRow();
	String value = "W wypo¿yczalni";
	
	try {
		
		
		ps = con.prepareStatement("UPDATE ksiazka SET Status = ?, numerCzytelnika = 'In library' WHERE id_ksiazka = ?");
		ps.setString(1, value);
		ps.setInt(2, index);
		
		
		if(ps.executeUpdate()>0) {
			
			JOptionPane.showMessageDialog(null, "Book has been returned!");
			
			
		}else {
			JOptionPane.showMessageDialog(null, "Error!");
		}
		con.close();
		
	}catch(SQLException ex) {
		ex.printStackTrace();
	}

		
	}};
