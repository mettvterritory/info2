package Aufgabe25;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class fenster extends Frame implements ActionListener {
	
    	public ArrayList<Double> liste;
    	Button random;
    	Button history;
    	TextField feld;
    	TextArea area;
    
	public fenster () {
			liste = new ArrayList<>();
			random = new Button("random");
			history = new Button("history");
			feld = new TextField();
			
			this.setLayout(new GridLayout(2,2));
			
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
		if(arg0.getSource().equals(this.random)) {
			Random zufall = new Random();
			
			this.liste.add(zufall.nextDouble());
			
			this.feld.setText(String.valueOf(this.liste.get (liste.size() - 1) ));
		}
		
		if(arg0.getSource().equals(this.history)) {
		    
		    dialog D = new dialog();
		    dialog.anzeigen(liste);
		}
		
	}
	
	public int getGroesse() {
    	    return liste.size();
    	}

}