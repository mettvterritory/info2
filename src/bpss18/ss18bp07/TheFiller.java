package bpss18.ss18bp07;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
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
 * <Datenbankfüller für schlecht gesicherte Datenbanken>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class TheFiller extends Frame {

  private TextField start, end, status;
  private Button fillButton;
  Connection c;
  private final static String connector = "jdbc:mysql://educos-srv01.informatik.uni-augsburg.de:3306/theDatabase?useSSL=false&serverTimezone=Europe/Berlin";
  private final static String user = "student";
  private final static String key = "inFormatik2";
  private final static String driver = "com.mysql.cj.jdbc.Driver";

  public TheFiller() {
	super("FillerWindow");
	this.setSize(600, 300);
	start = new TextField(20);
	end = new TextField(20);
	Panel inputPanel = new Panel();
	inputPanel.setLayout(new FlowLayout());
	inputPanel.add(new Label("Startindex: ", Label.RIGHT));
	inputPanel.add(start);
	inputPanel.add(new Label("Endindex: ", Label.RIGHT));
	inputPanel.add(end);
	Panel buttonPanel = new Panel();
	fillButton = new Button("Datenbank füllen? ");
	buttonPanel.setLayout(new GridLayout(2, 1));
	Label warning = new Label("Warnung: hohe Füllmargen führen zu langen Bearbeitungszeiten",
		Label.CENTER);
	warning.setFont(new Font("Arial", 5, 18));
	warning.setForeground(Color.RED);
	buttonPanel.add(warning);
	buttonPanel.add(fillButton);
	this.add(inputPanel, BorderLayout.NORTH);
	this.add(buttonPanel, BorderLayout.CENTER);

	fillButton.addActionListener(new ActionListener() {
	  @Override
	  public void actionPerformed(ActionEvent e) {
		fill(Integer.parseInt(start.getText()), Integer.parseInt(end.getText()));
	  }
	});
	this.add(status = new TextField(), BorderLayout.SOUTH);
	status.setEditable(false);

	this.addWindowListener(new WindowAdapter() {
	  @Override
	  public void windowClosing(WindowEvent e) {
		try {
		  c.close();
		} catch (NullPointerException | SQLException ex) {
		  status.setText("Verbindungsfehler: " + ex.getMessage());
		}
		dispose();
	  }
	});

	connect();
	this.setVisible(true);


  }

  private void fill(int startIndex, int endIndex) {
	int counter = startIndex;
	while (counter < endIndex) {
	  try {
		Statement save = c.createStatement();
		save.executeUpdate(
			"INSERT INTO Angestellter VALUES (" + counter
				+ ",'John Cena','30.05.2018',null, false,null)");
		status.setText("Erfolg " + counter);
		counter++;
	  } catch (SQLException ex) {
		status.setText("Fehlermeldung: " + ex.getMessage());
		counter++;
	  }
	}
	status.setText("es wurden " + (endIndex - startIndex) + " plätze in der Datenbank gefüllt");
  }

  private void connect() {
	try {
	  Class.forName(driver);
	  c = DriverManager.getConnection(connector, user, key);
	  status.setText("verbindung erfolgreich");
	} catch (ClassNotFoundException | SQLException ex) {
	  status.setText("Verbindungsfehler: " + ex.getMessage());
	  //CreateEmployee.this.setVisible(false);
	  fillButton.setEnabled(false);
	}

  }


  public static void main(String args[]) {
	new TheFiller();
  }

}



