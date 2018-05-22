package uebung06;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * <Aufgabe 24b>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class Aufgabe24b extends Frame implements ActionListener {

  private Panel palceholder;
  private Button increment;
  private Button decrement;

  public Aufgabe24b() {
	super("Omegasizechanger");
	this.setSize(600, 600);
	Panel buttonPanel = new Panel();
	Panel placeholder = new Panel();
	placeholder.setSize(1, this.getHeight() / 3);
	buttonPanel.add(decrement = new Button("-"), BorderLayout.WEST);
	buttonPanel.add(increment = new Button("+"), BorderLayout.EAST);
	this.add(buttonPanel, BorderLayout.CENTER);decrement.setSize(100, 100);
	increment.addActionListener(this);
	decrement.addActionListener(this);
	this.setVisible(true);
	this.addWindowListener(new WindowAdapter() {
	  @Override
	  public void windowClosing(WindowEvent e) {
		dispose();
	  }
	});
  }

  @Override
  public void actionPerformed(ActionEvent e) {
	if (e.getSource() == increment) {
	  this.setSize((this.getWidth() / 10) * 11, (this.getHeight() / 10) * 11);
	} else {
	  this.setSize((this.getWidth() / 10) * 9, (this.getHeight() / 10) * 9);
	}
  }
}
