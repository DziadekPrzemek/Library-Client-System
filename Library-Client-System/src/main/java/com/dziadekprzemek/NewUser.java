package com.dziadekprzemek;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class NewUser {
	public void updateUserList(String loginUser, String passwodrUser, String lnameUser, String fnameUser, String adressUser, String cityUser, String postUser, String districtUser, String phoneUser, String emailUser){
		
	
		
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		
		try {
			
			ps = con.prepareStatement("INSERT INTO czytelnik (login, haslo, imie, nazwisko, adres, miasto, wojewodztwo, telefon, kod_pocztowy, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?)");
			
			ps.setString(1, loginUser);
			ps.setString(2, passwodrUser);
			ps.setString(3, fnameUser);
			ps.setString(4, lnameUser);
			ps.setString(5, adressUser);
			ps.setString(6, cityUser);
			ps.setString(7, districtUser);
			ps.setString(8, phoneUser);
			ps.setString(9, postUser);
			ps.setString(10, emailUser);
			
			if(ps.executeUpdate()>0) {
				
				JOptionPane.showMessageDialog(null, "User has been added!");
				
				
			}else {
				JOptionPane.showMessageDialog(null, "Error!");
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		
	}
	}