package myform1;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import javax.swing.JLabel;


public class form1 {

	private JFrame frame;
	private JTextField txtLink;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form1 window = new form1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public form1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("btn");
		
		btnNewButton.setBackground(new Color(106, 90, 205));
		btnNewButton.setBounds(98, 186, 231, 42);
		frame.getContentPane().add(btnNewButton);
		
		txtLink = new JTextField();
		txtLink.setText("http://");
		txtLink.setBounds(98, 114, 231, 49);
		frame.getContentPane().add(txtLink);
		txtLink.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ლინკის სახელი...");
		lblNewLabel.setBounds(147, 87, 130, 15);
		frame.getContentPane().add(lblNewLabel);
		btnNewButton.addActionListener(new ActionListener() {
			private Scanner s;

			public void actionPerformed(ActionEvent arg0) {
				String input = txtLink.getText();
				URL url1;
				try {
					url1 = new URL(input);
					s = new Scanner(url1.openStream());
					String tmp = "";
					while(s.hasNext()) {
						tmp += s.nextLine() + System.getProperty("line.separator");
					}
					// hala madrid y nada mas!!!
					File file = new File("src/myform1/zura.txt");
			         try (OutputStreamWriter bufferedWriter = 
			                 new OutputStreamWriter(
			                 new FileOutputStream(file,false))) {
			             bufferedWriter.write(tmp+System.getProperty("line.separator"));
				}} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
