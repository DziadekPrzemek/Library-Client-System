package com.dziadekprzemek;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookList {
	
	ResultSet rs = null;
	Statement smt = null;
	MyConnection con = null;
	public BookList() throws SQLException {
		con = new MyConnection();
		smt = MyConnection.getConnection().createStatement();
		update_table();
	}
	void update_table() throws SQLException {
		rs=smt.executeQuery("SELECT * from ksiazki");
		
	}

}
