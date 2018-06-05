package uebung08;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <Aufgabe 29/30>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class Aufgabe2930 extends Frame {

  private final static String CONNECTOR = "jdbc:mysql://educos-srv01.informatik.uni-augsburg.de:3306/theDatabase?useSSL=false&serverTimezone=Europe/Berlin";
  // private final static String USER = "student";
  // private final static String KEY = "inFormatik2";
  private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
  private Connection c;
  private Button connectButton;
  private Button loadButton;
  private TextField status;

  public Aufgabe2930() {
	super("Datenbankanwendung");
	this.setSize(400, 300);
	this.setLocation(700, 400);
	this.add(status = new TextField(), BorderLayout.SOUTH);
	status.setEditable(false);
	Panel buttonPanel = new Panel();
	buttonPanel.setLayout(new FlowLayout());
	buttonPanel.add(connectButton = new Button("connect"));
	connectButton.addActionListener(new ActionListener() {
	  @Override
	  public void actionPerformed(ActionEvent e) {
		new PopupDialog(Aufgabe2930.this);
	  }
	});
	buttonPanel.add(loadButton = new Button("load"));
	loadButton.setEnabled(false);
	loadButton.addActionListener(new ActionListener() {
	  @Override
	  public void actionPerformed(ActionEvent e) {
		load();
	  }
	});
	this.add(buttonPanel, BorderLayout.CENTER);
	this.addWindowListener(new WindowAdapter() {
	  @Override
	  public void windowClosing(WindowEvent e) {
		if (c != null) {
		  try {
			c.close();
		  } catch (SQLException ex) {
			System.err.println(ex.getMessage());
		  }
		}
		dispose();
	  }
	});

	this.setVisible(true);
  }

  private void load() {
	try {
	  Statement load = c.createStatement();
	  ResultSet bigData = load.executeQuery("SELECT * FROM Angestellter");
	  new PopupDialog(this, bigData);
	} catch (SQLException ex) {
	  status.setText("Abfragefehler: " + ex.getMessage());
	}
  }

  private void connect(String userInput, String keyInput) {
	try {
	  Class.forName(DRIVER);
	  c = DriverManager.getConnection(CONNECTOR, userInput, keyInput);
	  loadButton.setEnabled(true);
	} catch (ClassNotFoundException | SQLException ex) {
	  status.setText("Verbindungsfehler: " + ex.getMessage());
	}
	if (c != null) {
	  status.setText("Verbindung erfolgreich aufgebaut");
	}
  }

  private class PopupDialog extends Dialog {

	TextField userField;
	TextField keyField;
	Button connectDButton;

	public PopupDialog(Aufgabe2930 owner) {
	  super(owner, "Database Login", true);
	  this.setLocation(owner.getLocationOnScreen());
	  Panel userInputPanel = new Panel();
	  userInputPanel.setLayout(new GridLayout(2, 2));
	  userInputPanel.add(new Label("User: "));
	  userInputPanel.add(userField = new TextField(20));
	  userInputPanel.add(new Label("Password: "));
	  userInputPanel.add(keyField = new TextField(20));
	  this.add(userInputPanel, BorderLayout.CENTER);
	  this.add(connectDButton = new Button("connect"), BorderLayout.SOUTH);
	  connectDButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		  connect(userField.getText(), keyField.getText());
		  dispose();
		}
	  });
	  this.pack();
	  this.setVisible(true);
	}

	public PopupDialog(Aufgabe2930 owner, ResultSet data) {
	  super(owner, "Database Output", true);
	  this.setLocation(owner.getLocationOnScreen());
	  TextArea largeText = new TextArea();
	  largeText.setEditable(false);
	  try {
		while (data.next()) {
		  largeText.append(
			  data.getInt(1) + " " + data.getString(2) + " " + data.getString(3) + " " + data
				  .getString(4) + " " + data.getBoolean(5) + data.getInt(6) + "\n");

		}
	  } catch (SQLException ex) {
		status.setText("Lesefehler: " + ex.getMessage());
	  }
	  this.add(largeText);
	  pack();
	  this.setVisible(true);
	  this.addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
		  dispose();
		}
	  });


	}
  }

  public static void main(String[] args) {
	new Aufgabe2930();
  }


}
