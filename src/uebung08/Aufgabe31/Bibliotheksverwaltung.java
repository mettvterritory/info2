package uebung08.Aufgabe31;

import java.awt.*;
import java.awt.event.*;

public class Bibliotheksverwaltung extends Frame implements ActionListener {

  public Bibliotheksverwaltung() {
	Button close = new Button("Close");
	close.addActionListener(this);
	this.add(close, BorderLayout.CENTER);
	try {
	  Object container = BuchContainer.instance();
	} catch (LoadSaveException e) {
	  dispose();
	}
	setVisible(true);
  }
}
