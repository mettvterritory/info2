package bpss18.ss18bp08.gui;

import bpss18.ss18bp08.data.Colour;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Panel;
import java.util.Observable;
import java.util.Observer;

/**
 * <Filename>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class ColourDialog extends Dialog implements Observer {

  Panel ColorPanel;

  public ColourDialog(Frame owner) {
	super(owner);
	setSize(200, 100);
	add(ColorPanel = new Panel(), BorderLayout.CENTER);

	setUndecorated(true);
	setColor();

	Colour colour = Colour.instance();
	colour.addObserver(this);
	setColor();

	setVisible(true);

  }


  @Override
  public void update(Observable o, Object obj) {
	setColor();
  }


  private void setColor() {
	Colour colour = Colour.instance();
	Color c = colour.getColour();
	ColorPanel.setBackground(c);
  }


}
