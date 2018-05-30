package bpss18.ss18bp07;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <Betreutes Programmieren 07>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class CreateEmployee extends Frame {

  private TextField number, name, begin, status;
  private Button insertButton;
  Connection c;
  private final static String connector = "jdbc:mysql://educos-srv01.informatik.uni-augsburg.de:3306/theDatabase?useSSL=false&serverTimezone=Europe/Berlin";
  private final static String user = "student";
  private final static String key = "inFormatik2";
  private final static String driver = "com.mysql.cj.jdbc.Driver";

  public CreateEmployee() {
	super("Insert New Employee");
	this.setSize(600, 300);
	Panel knecht = new Panel();
	knecht.setLayout(new GridLayout());
	knecht.add(new Label("Number:", Label.RIGHT));
	knecht.add(number = new TextField(30));
	knecht.add(new Label("Name:", Label.RIGHT));
	knecht.add(name = new TextField(30));
	knecht.add(new Label("Begin:", Label.RIGHT));
	knecht.add(begin = new TextField(30));

	this.add(knecht, BorderLayout.NORTH);
	this.add(insertButton = new Button("Insert Employee"), BorderLayout.CENTER);

	insertButton.addActionListener(new ActionListener() {
	  @Override
	  public void actionPerformed(ActionEvent e) {
		save();
	  }
	});
	this.add(status = new TextField(), BorderLayout.SOUTH);
	status.setEditable(false);

	this.addWindowListener(new WindowAdapter() {
	  @Override
	  public void windowClosing(WindowEvent e) {
		try {
		  if (!(c.isClosed())) {
			c.close();
		  }
		} catch (SQLException ex) {
		  status.setText("Verbindungsfehler: " + ex.getMessage());
		}
		dispose();
	  }
	});

	connect();
	pack();
	this.setVisible(true);


  }

  private void save() {
	try {
	  Statement save = c.createStatement();
	  save.executeUpdate(
		  "INSERT INTO Angestellter VALUES (" + number.getText() + ",'" + name.getText() + "','"
			  + begin.getText() + "',null, false,null)");
	  name.setText("");
	  number.setText("");
	  begin.setText("");
	  status.setText("Erfolg");
	} catch (SQLException ex) {
	  status.setText("Fehlermeldung: " + ex.getMessage());

	}
  }

  private void connect() {
	try {
	  Class.forName(driver);
	  c = DriverManager.getConnection(connector, user, key);
	} catch (ClassNotFoundException | SQLException ex) {
	  status.setText("Verbindungsfehler: " + ex.getMessage());
	  //CreateEmployee.this.setVisible(false);
	  name.setEnabled(false);
	  number.setEnabled(false);
	  begin.setEnabled(false);
	  insertButton.setEnabled(false);
	}

  }


  public static void main(String args[]) {
	new CreateEmployee();
  }

}
