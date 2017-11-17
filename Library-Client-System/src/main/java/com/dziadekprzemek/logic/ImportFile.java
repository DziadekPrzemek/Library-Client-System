package com.dziadekprzemek.logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.dziadekprzemek.visual.MainWindow;

public class ImportFile extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pathField;

	public ImportFile() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 381, 109);
		setTitle("Add CSV file");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		logo();
		pathField = new JTextField();
		pathField.setBounds(123, 11, 192, 20);
		contentPane.add(pathField);
		pathField.setColumns(10);
		
		JButton importBtn = new JButton("Import");
		importBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			importBooksToTable();		
			MainWindow.RefreshTable();
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
	private void logo() {
		ImageIcon img = new ImageIcon("H:\\Dev\\Projekty\\Library-Client-System\\src\\main\\java\\Images\\book-ico.png");
		setIconImage(img.getImage());
		setResizable(false);
	}
	private void importBooksToTable() {
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		
		try {
             BufferedReader br = new BufferedReader(new FileReader(pathField.getText()));
             String line;
             while((line=br.readLine())!=null) {
            	 
            	 String[] value = line.split(",");
            	 ps = con.prepareStatement("INSERT INTO ksiazka (isbn,tytul,autor,stron,wydawnictwo,rok_wydania,opis,Status,numerCzytelnika) VALUE("+value[0]+",'"+value[1]+"','"+value[2]+"',"+value[3]+",'"+value[4]+"',"+value[5]+",'"+value[6]+"','"+value[7]+"','"+value[8]+"')");
            	 ps.executeUpdate();
            	   	 
             }
             
             JOptionPane.showMessageDialog(null, "Import has been successfully finished!");
             br.close();
             dispose();
 
		}catch(Exception exc) {
			JOptionPane.showMessageDialog(null, "Import error!");
			
		};
	}
	
}
