package uebung06;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * <Aufgabe 23b>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class Aufgabe23a extends Frame implements KeyListener {

  public Aufgabe23a() {
	super();
	this.setLocation(400, 300);
	this.setSize(200, 200);
	this.addKeyListener(this);
	this.setVisible(true);

  }

  @Override
  public void keyPressed(KeyEvent e) {
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyReleased(KeyEvent e) {
	if (e.getKeyCode() == KeyEvent.VK_X) {
	  dispose();
	}
  }
}