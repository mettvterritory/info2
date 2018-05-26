package Aufgabe25;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class fenster extends Frame implements ActionListener {
	
	public fenster () {
			
			ArrayList<Double> liste = new ArrayList<>();
			Button random = new Button("random");
			Button history = new Button("history");
			TextField feld = new TextField();
			
			this.setLayout(new FlowLayout());
			
			random.addActionListener(this);
			feld.setEditable(false);
			history.addActionListener(this);
			
			this.add(random);
			this.add(feld);
			this.add(history);
			pack();
			this.setVisible(true);
			
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					dispose();
				}
			});
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(random)) {
			Random zufall = new Random();
			liste.add(zufall.nextDouble());
			feld.setText(String.valueOf(liste.get (liste.size() - 1) ));
		}
		
	}
}