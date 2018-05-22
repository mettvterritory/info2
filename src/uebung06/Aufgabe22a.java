package uebung06;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.GroupLayout.Alignment;

/**
 * <Aufgabe 22a>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class Aufgabe22a extends Frame {

  private TextField nameField;
  private TextField lastnameField;
  private TextField locationField;
  private Label nameLabel;
  private Label lastnameLabel;
  private Label locationLabel;

  public Aufgabe22a() {
	super("Aufgabe22a");
	this.setLayout(new GridLayout(3, 2, 4, 4));
	this.add(nameLabel = new Label("Vorname: "));
	nameLabel.setForeground(Color.BLUE);
	nameLabel.setAlignment(2);
	nameLabel.setFont(new Font("Arial", 1, 18));
	this.add(nameField = new TextField());
	this.add(lastnameLabel = new Label("Nachname: "));
	lastnameLabel.setFont(new Font("Arial", 1, 18));
	lastnameLabel.setForeground(Color.BLUE);
	lastnameLabel.setAlignment(2);
	this.add(lastnameField = new TextField());
	this.add(locationLabel = new Label("Ort: "));
	locationLabel.setForeground(Color.BLUE);
	locationLabel.setAlignment(2);
	locationLabel.setFont(new Font("Arial", 1, 18));
	this.add(locationField = new TextField());
	pack();
	this.setLocation(400, 400);
	this.setVisible(true);

	this.addWindowListener(new WindowAdapter() {
	  @Override
	  public void windowClosing(WindowEvent e) {
		dispose();
	  }
	});
  }
}