package com.dziadekprzemek;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class ImportFile extends JFrame {

	private JPanel contentPane;
	private JTextField pathField;
	
	
	public ImportFile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 109);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pathField = new JTextField();
		pathField.setBounds(123, 11, 192, 20);
		contentPane.add(pathField);
		pathField.setColumns(10);
		
		
		
		JButton importBtn = new JButton("Import");
		importBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Connection con = MyConnection.getConnection();
				PreparedStatement ps;
				
				try {
					
				
		             BufferedReader br = new BufferedReader(new FileReader(pathField.getText()));
		             String line;
		             while((line=br.readLine())!=null) {
		            	 
		            	 String[] value = line.split(",");
		            	 ps = con.prepareStatement("INSERT INTO ksiazka (isbn, tytul, autor, stron, wydawnictwo, rok_wydania, opis) VALUES "
		            	 		+ "('"+value[0]+"','"+value[1]+"','"+value[2]+"','"+value[3]+"','"+value[4]+"','"+value[5]+"','"+value[6]+"')");
		            	 ps.executeUpdate();
		            	
		            	
		         
		            
		            	   	 
		             }
		             
		             JOptionPane.showMessageDialog(null, "Import has been successfully finished!");
		             br.close();
		             dispose();
		                
		           
				
				
				}catch(Exception exc) {
					JOptionPane.showMessageDialog(null, "Import error!");
				};
				
				
			}

		});
		importBtn.setBounds(226, 42, 89, 23);
		contentPane.add(importBtn);
		
		JButton CancelBtn = new JButton("Cancel");
		CancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		CancelBtn.setBounds(121, 42, 89, 23);
		contentPane.add(CancelBtn);
		
		JButton AttachBtn = new JButton("Attach");
		AttachBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				JFileChooser chooser = new JFileChooser();
	            chooser.showOpenDialog(null);	          
	                File file = chooser.getSelectedFile();
	                pathField.setText(file.getPath());
	                
				
				
				
			}
		});
		AttachBtn.setBounds(10, 10, 89, 23);
		contentPane.add(AttachBtn);
	}
	
	
}
