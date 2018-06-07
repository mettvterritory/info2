package bpss18.ss18bp08.gui;

import bpss18.ss18bp08.data.Colour;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * <Colo(u)r App>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class ControllerFrame extends Frame implements AdjustmentListener {

  private Scrollbar redBar;
  private Scrollbar greenBar;
  private Scrollbar blueBar;

  public ControllerFrame() {
	super("ColourObserverGame");
	//setUndecorated(true);

	this.setLayout(new GridLayout(3, 1, 5, 5));

	this.add(redBar = new Scrollbar(Scrollbar.HORIZONTAL, 0, 25, 0, 280));
	redBar.addAdjustmentListener(this);
	this.add(greenBar = new Scrollbar(Scrollbar.HORIZONTAL, 0, 25, 0, 280));
	greenBar.addAdjustmentListener(this);
	this.add(blueBar = new Scrollbar(Scrollbar.HORIZONTAL, 0, 25, 0, 280));
	blueBar.addAdjustmentListener(this);

	WindowAdapter windowHandler = new WindowAdapter() {
	  @Override
	  public void windowClosing(WindowEvent e) {
		dispose();
	  }
	};
	this.addWindowListener(windowHandler);

	StringDialog sd = new StringDialog(this);
	sd.setLocation(600, 160);
	ColourDialog cd = new ColourDialog(this);
	cd.setLocation(60, 160);
	this.setLocation(280, 160);
	this.setSize(300, 100);

	this.setVisible(true);


  }

  @Override
  public void adjustmentValueChanged(AdjustmentEvent e) {
	Colour colour = Colour.instance();

	if (e.getSource() == redBar) {
	  colour.setRed(e.getValue());
	}

	if (e.getSource() == greenBar) {
	  colour.setGreen(e.getValue());
	}

	if (e.getSource() == blueBar) {
	  colour.setBlue(e.getValue());
	}

  }
/*
  private class WindowHandler extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {
	  dispose();
	}
  }
*/
}
