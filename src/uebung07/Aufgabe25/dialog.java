package Aufgabe25;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class dialog extends Frame implements ActionListener {

    	public static TextArea area;
    	//ArrayList<Double> liste2;
    	public dialog() {
    	    
    	    area = new TextArea();
    	    //liste2 = new ArrayList<>();
    	    
    	    //hijgkjhg
    	    
    	    
    	    this.setLayout(new GridLayout(1,1));
    	    this.setSize(100, 200);
    	    
    	    this.add(area);
    	    
    	    this.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
    			dispose();
    		}
            });
    	    
    	    this.setVisible(true);
    	}
    	
    	public static void anzeigen(ArrayList<Double> liste) {
    	

	    area.setText(String.valueOf(liste.get(0)));
	    
	    int s = liste.size();
	    
	    for(int i = 1; i < s ; i++) {
		
		area.append("\n" + String.valueOf(liste.get(i)));
		
	    }
    	}
    	
    	
	@Override
	public void actionPerformed(ActionEvent e) {
	    // TODO Auto-generated method stub
	    
	}
    	
}
