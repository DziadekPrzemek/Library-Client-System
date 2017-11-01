package com.dziadekprzemek;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;

	
	
	
	public MainWindow() {
		
			
		setVisible(true);
		getContentPane().setLayout(null);
		setTitle("Library Managament System");
		ImageIcon img = new ImageIcon("H:\\Dev\\Projekty\\Library-Client-System\\src\\main\\java\\Images\\book-ico.png");
		setIconImage(img.getImage());
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 23, 993, 330);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 997, 342);
		panel.add(scrollPane);
		
		table = new JTable();
		
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Book ID", "Category ID", "ISBN", "Title", "Author", "Pages", "Publisher", "Year", "Description"
			}
		));
		


		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1063, 21);
		getContentPane().add(menuBar);
		
		JMenu SystemMenu = new JMenu("System");
		menuBar.add(SystemMenu);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JMenuItem mntmRefresh = new JMenuItem("Refresh");
		SystemMenu.add(mntmRefresh);
		SystemMenu.add(mntmExit);
		
		JMenu mnAction = new JMenu("Action");
		menuBar.add(mnAction);
		
		JMenuItem mntmAddUser = new JMenuItem("Add user");
		mnAction.add(mntmAddUser);
		
		JMenuItem mntmAddAdmin = new JMenuItem("Add admin");
		mnAction.add(mntmAddAdmin);
		
		JMenuItem mntmAddBook = new JMenuItem("Add book");
		mnAction.add(mntmAddBook);
		
		JMenuItem mntmAddCategory = new JMenuItem("Add category");
		mnAction.add(mntmAddCategory);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		
		JButton btnAddBook = new JButton("Add book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddBookForm addBookForm = new AddBookForm();
				addBookForm.setVisible(true);
				addBookForm.setResizable(false);
				addBookForm.setBounds(0, 0, 365, 420);
			}
		});
		btnAddBook.setBounds(165, 369, 89, 23);
		getContentPane().add(btnAddBook);
		
		JButton btnAddUser = new JButton("Add user");
		btnAddUser.setBounds(264, 369, 89, 23);
		getContentPane().add(btnAddUser);
		
		JButton btnAddReservation = new JButton("Add reservation");
		btnAddReservation.setBounds(10, 369, 139, 23);
		getContentPane().add(btnAddReservation);
		
		initComponents();
		
		

	}


	private void initComponents() {
		MainWindow.fillBookTable(table,"");
		
	}


	public static void fillBookTable(JTable table, String valueToSearch) {
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		
		try {
		ps = con.prepareStatement("SELECT * FROM ksiazka WHERE CONCAT(isbn, tytul, autor, stron, wydawnictwo, rok_wydania ) LIKE ?");
		ps.setString(1, "%"+valueToSearch+"%");
		
		ResultSet rs = ps.executeQuery();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
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
