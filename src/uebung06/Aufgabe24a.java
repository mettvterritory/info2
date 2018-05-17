package uebung06;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * <Aufgabe 24a>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class Aufgabe24a extends Frame {

  private int exitAttempts;

  public Aufgabe24a() {
	super();
	exitAttempts = 0;
	this.setLocation(400, 400);
	this.setSize(500, 50);
	this.setTitle("Exit Attempts: " + exitAttempts);
	this.addWindowListener(new WindowAdapter() {
	  @Override
	  public void windowClosing(WindowEvent e) {
		if (exitAttempts++ < 2) {
		  Aufgabe24a.this.setTitle("Exit Attempts: " + exitAttempts);
		} else {
		  dispose();
		}
	  }
	});

	this.setVisible(true);
  }

}
