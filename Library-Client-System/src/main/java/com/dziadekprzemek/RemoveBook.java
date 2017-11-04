package com.dziadekprzemek;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class RemoveBook {
	public void removeFromBookList(int index){
		
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		
	
		
		
		try {
			
			
		
			ps = con.prepareStatement("DELETE FROM ksiazka WHERE id_ksiazka =?");
			ps.setInt(1, index);
			
			
	
			
			if(ps.executeUpdate()>0) {
				
				JOptionPane.showMessageDialog(null, "Book has been removed!");
				
				
			}else {
				JOptionPane.showMessageDialog(null, "Error!");
			}
			con.close();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		}
		
		
	
	
}