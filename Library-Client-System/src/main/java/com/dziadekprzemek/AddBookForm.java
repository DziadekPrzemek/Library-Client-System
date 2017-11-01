package com.dziadekprzemek;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;


public class AddBookForm extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField titleTextField;
	private JTextField authorTextField;
	private JTextField isbnTextField;
	private JTextField pagesTextField;
	private JTextField yearTextField;
	private JTextField publisherTextField;

	
	public AddBookForm() {
		getContentPane().setLayout(null);
		ImageIcon img = new ImageIcon("H:\\Dev\\Projekty\\Library-Client-System\\src\\main\\java\\Images\\book-ico.png");
		setIconImage(img.getImage());
		setTitle("Add book");
		
		JLabel lblTitle = new JLabel("Title: ");
		lblTitle.setBounds(10, 38, 71, 14);
		getContentPane().add(lblTitle);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(10, 79, 71, 14);
		getContentPane().add(lblAuthor);
		
		JLabel lblIsbn = new JLabel("ISBN: ");
		lblIsbn.setBounds(10, 122, 71, 14);
		getContentPane().add(lblIsbn);
		
		JLabel lblPages = new JLabel("Pages: ");
		lblPages.setBounds(10, 163, 71, 14);
		getContentPane().add(lblPages);
		
		JLabel lblYearOfPublishing = new JLabel("Year: ");
		lblYearOfPublishing.setBounds(196, 163, 54, 14);
		getContentPane().add(lblYearOfPublishing);
		
		JLabel lblPublisher = new JLabel("Publisher: ");
		lblPublisher.setBounds(10, 210, 90, 14);
		getContentPane().add(lblPublisher);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(10, 243, 104, 14);
		getContentPane().add(lblDescription);
		
		titleTextField = new JTextField();
		titleTextField.setBounds(72, 35, 262, 20);
		getContentPane().add(titleTextField);
		titleTextField.setColumns(10);
		
		authorTextField = new JTextField();
		authorTextField.setBounds(72, 76, 262, 20);
		getContentPane().add(authorTextField);
		authorTextField.setColumns(10);
		
		isbnTextField = new JTextField();
		isbnTextField.setBounds(72, 119, 262, 20);
		getContentPane().add(isbnTextField);
		isbnTextField.setColumns(10);
		
		pagesTextField = new JTextField();
		pagesTextField.setBounds(72, 160, 86, 20);
		getContentPane().add(pagesTextField);
		pagesTextField.setColumns(10);
		
		yearTextField = new JTextField();
		yearTextField.setBounds(248, 160, 86, 20);
		getContentPane().add(yearTextField);
		yearTextField.setColumns(10);
		
		publisherTextField = new JTextField();
		publisherTextField.setBounds(72, 204, 262, 20);
		getContentPane().add(publisherTextField);
		publisherTextField.setColumns(10);
		
		final JTextPane descriptionTextField = new JTextPane();
		descriptionTextField.setBounds(102, 243, 232, 84);
		getContentPane().add(descriptionTextField);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String title = titleTextField.getText();
				String author = authorTextField.getText();
				int year = Integer.parseInt(yearTextField.getText());
				int pages = Integer.parseInt(pagesTextField.getText());
				String description = descriptionTextField.getText();
				String isbn = isbnTextField.getText();
				String publisher = publisherTextField.getText();
				
				AddBook addbook = new AddBook();
				addbook.updateBookList('i', null, null, isbn, title, author, pages, publisher, year, description);
				
			}
		});
		btnAdd.setBounds(25, 352, 89, 23);
		getContentPane().add(btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(231, 352, 89, 23);
		getContentPane().add(btnCancel);

	}
	
		
		
		
	
}
