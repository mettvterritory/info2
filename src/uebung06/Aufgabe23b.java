package uebung06;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * <Aufgabe 23b>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class Aufgabe23b extends Frame implements ItemListener {

  private Choice boolChoice;
  private Panel topHalf;
  private Panel bottomHalf;
  private TextField commentBox;

  public Aufgabe23b() {
	super();
	topHalf = new Panel();
	bottomHalf = new Panel();
	topHalf.add(new Label("Bemerkung:"), BorderLayout.WEST);
	boolChoice = new Choice();
	boolChoice.add("Ja");
	boolChoice.add("Nein");
	boolChoice.select("Nein");
	boolChoice.addItemListener(this);
	topHalf.add(boolChoice, BorderLayout.EAST);
	bottomHalf.add(commentBox = new TextField(), BorderLayout.CENTER);
	this.add(topHalf, BorderLayout.NORTH);
	this.add(bottomHalf, BorderLayout.SOUTH);
	pack();
	bottomHalf.setVisible(false);
	this.setVisible(true);
	this.addWindowListener(new WindowAdapter() {
	  @Override
	  public void windowClosing(WindowEvent e) {
		dispose();
	  }
	});
  }

  @Override
  public void itemStateChanged(ItemEvent e) {
	if (boolChoice.getSelectedIndex() == 0) {
	  bottomHalf.setVisible(true);
	} else {
	  bottomHalf.setVisible(false);
	}


  }
}
