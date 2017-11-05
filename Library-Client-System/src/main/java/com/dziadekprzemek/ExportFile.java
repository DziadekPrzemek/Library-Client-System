package com.dziadekprzemek;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ExportFile extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pathField;
	
	
	public ExportFile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 109);
		setTitle("Export CSV file");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		pathField = new JTextField();
		pathField.setBounds(123, 11, 192, 20);
		contentPane.add(pathField);
		pathField.setColumns(10);
		
		
		
		JButton exportBtn = new JButton("Export");
		exportBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Connection con = MyConnection.getConnection();
				PreparedStatement ps;
				
				
				try {
					
					PrintWriter fw = new PrintWriter(pathField.getText());
		            	 ps = con.prepareStatement("SELECT isbn, tytul, autor, stron, wydawnictwo, rok_wydania, opis FROM ksiazka");
		            	 ResultSet rs = ps.executeQuery();
		            	 while(rs.next()) {
		            		 
		            		 fw.append(rs.getString(1));
		            		 fw.append(",");
		            		 fw.append(rs.getString(2));
		            		 fw.append(",");
		            		 fw.append(rs.getString(3));
		            		 fw.append(",");
		            		 fw.append(rs.getString(4));
		            		 fw.append(",");
		            		 fw.append(rs.getString(5));
		            		 fw.append(",");
		            		 fw.append(rs.getString(6));
		            		 fw.append(",");
		            		 fw.append(rs.getString(7));
		            		 fw.append("\r\n");
		            		 
		            		 
		            		 
		            	 }
		            	fw.flush();
		            	fw.close();         	
		         
		             JOptionPane.showMessageDialog(null, "Export has been successfully finished!");
		             
		             dispose();
		                
		           
				
				
				}catch(Exception exc) {
					JOptionPane.showMessageDialog(null, "Export error!");
				};
				
				
			}

		});
		exportBtn.setBounds(226, 42, 89, 23);
		contentPane.add(exportBtn);
		
		JButton CancelBtn = new JButton("Cancel");
		CancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		CancelBtn.setBounds(121, 42, 89, 23);
		contentPane.add(CancelBtn);
		
		JButton saveBtn = new JButton("Save");
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				JFileChooser chooser = new JFileChooser();
	            chooser.showOpenDialog(null);	          
	                File file = chooser.getSelectedFile();
	                pathField.setText(file.getPath());
	                
				
				
				
			}
		});
		saveBtn.setBounds(10, 10, 89, 23);
		contentPane.add(saveBtn);
	}
	
	
}
