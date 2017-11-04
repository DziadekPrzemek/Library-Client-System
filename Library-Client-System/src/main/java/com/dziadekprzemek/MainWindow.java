package com.dziadekprzemek;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JTable table;
	private static JTextField findTextField;

	
	
	
	public MainWindow() {
		getContentPane().setForeground(new Color(255, 239, 213));
		

		setVisible(true);
		getContentPane().setLayout(null);
		setTitle("Library Managament System");
		ImageIcon img = new ImageIcon("H:\\Dev\\Projekty\\Library-Client-System\\src\\main\\java\\Images\\book-ico.png");
		setIconImage(img.getImage());
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 21, 1004, 321);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 984, 321);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
		table.addMouseListener(new MouseAdapter() {
		
		});
		
		scrollPane.setViewportView(table);
		
		table.setModel(new DefaultTableModel(
				
			new Object[][] { },
			
			new String[] {"Book ID", "ISBN", "Title", "Author", "Pages", "Publisher", "Year", "Description"}));
		


		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1004, 21);
		getContentPane().add(menuBar);
		
		JMenu SystemMenu = new JMenu("System");
		menuBar.add(SystemMenu);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) { System.exit(0);	}});
		
		JMenuItem mntmRefresh = new JMenuItem("Refresh");
		mntmRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RefreshTable();
			}
		});
		SystemMenu.add(mntmRefresh);
		SystemMenu.add(mntmExit);
		
		JMenu mnAction = new JMenu("Action");
		menuBar.add(mnAction);
		
		JMenuItem mntmAddLibrarian = new JMenuItem("Add librarian");
		mntmAddLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddLibrarianWindow window = new AddLibrarianWindow();
				
			}
		});
		mnAction.add(mntmAddLibrarian);
		
		JMenuItem mntmAddBook = new JMenuItem("Add book");
		mntmAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBookForm addBookForm = new AddBookForm();
				addBookForm.setVisible(true);
				addBookForm.setResizable(false);
				addBookForm.setBounds(0, 0, 365, 420);
			}
		});
		mnAction.add(mntmAddBook);
		
		JMenu mnData = new JMenu("Data");
		menuBar.add(mnData);
		
		JMenuItem mntmImport = new JMenuItem("Import");
		mntmImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ImportFile file = new ImportFile();
				file.setVisible(true);
				
				
				
				
			}
		});
		mnData.add(mntmImport);
		
		JMenuItem mntmExport = new JMenuItem("Export");
		mnData.add(mntmExport);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Author: Przemys³aw Dziadek");
			}
		});
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
		btnAddBook.setBounds(10, 364, 89, 23);
		getContentPane().add(btnAddBook);
		
		JButton btnAddUser = new JButton("Add user");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUserFrame userFrame = new AddUserFrame();
				userFrame.setVisible(true);
			}
		});
		btnAddUser.setBounds(251, 364, 89, 23);
		getContentPane().add(btnAddUser);
		
		JButton btnRemoveBook = new JButton("Remove book");
		btnRemoveBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				removeSelectedRows(table);
				
			
			}
		});
		btnRemoveBook.setBounds(118, 364, 112, 23);
		getContentPane().add(btnRemoveBook);
		
		findTextField = new JTextField();
		findTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				RefreshTable();
			}
		});
		findTextField.setBounds(797, 365, 197, 20);
		getContentPane().add(findTextField);
		findTextField.setColumns(10);
		
		JLabel lblSearchBook = new JLabel("Search book:");
		lblSearchBook.setBounds(698, 368, 89, 14);
		getContentPane().add(lblSearchBook);
		
		JButton btnRent = new JButton("Rent");
		btnRent.setBounds(350, 364, 89, 23);
		getContentPane().add(btnRent);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBounds(449, 364, 89, 23);
		getContentPane().add(btnReturn);
		
		
		
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
			
			row[1] =rs.getString(2);
			row[2] =rs.getString(3);
			row[3] =rs.getString(4);
			row[4] =rs.getInt(5);
			row[5] =rs.getString(6);
			row[6] =rs.getInt(7);
			row[7] =rs.getString(8);
			model.addRow(row);
		}
		
		
		
		}catch(SQLException e) {
			e.setNextException(null);
			
		}
		
		
		
	}
	
	public void removeSelectedRows(JTable table){
		
			
		int answer = JOptionPane.showConfirmDialog(null, "Do you want to remove book?", "Confirm",JOptionPane.YES_NO_CANCEL_OPTION);
		
		if(answer == JOptionPane.YES_OPTION) {
		int text = (int)table.getValueAt(Integer.valueOf(table.getSelectedRow()), 0);
		RemoveBook rb = new RemoveBook();
		rb.removeFromBookList(text);
		
	    
		   DefaultTableModel model = (DefaultTableModel) this.table.getModel();
		   int[] rows = table.getSelectedRows();
		   for(int i=0;i<rows.length;i++){
		     model.removeRow(rows[i]-i);
		   }}else {
			   JOptionPane.showMessageDialog(null, "Removing has been canceled!");
		   }
		   
		   
		     
		   }

	
	public static void RefreshTable(){
		table.setModel(new DefaultTableModel(null, new Object[] {"Book ID", "ISBN", "Title", "Author", "Pages","Publisher","Year","Description"}));
		fillBookTable(table, findTextField.getText());
	}
}
