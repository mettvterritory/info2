package uebung06;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * <Aufgabe 22b>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class Aufgabe22b extends Frame {

  private Choice numberChoice;

  public Aufgabe22b() {
	super("Aufgabe22b");
	this.add(new Label("Anzahl auswählen:"), BorderLayout.WEST);
	numberChoice = new Choice();
	for (int i = 1; i <= 9; i++) {
	  numberChoice.add(Integer.toString(i));
	}
	this.add(numberChoice, BorderLayout.EAST);
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

