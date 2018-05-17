package uebung06;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

  public Aufgabe22a() {
	super("Aufgabe22a");
	this.setLayout(new GridLayout(3, 2, 4, 4));
	this.add(new Label("Vorname:"));
	this.add(nameField = new TextField());
	this.add(new Label("Nachname:"));
	this.add(lastnameField = new TextField());
	this.add(new Label("Ort"));
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
