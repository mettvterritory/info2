package uebung02.Aufgabe8;

import uebung02.Aufgabe8.Immobilie;

import java.util.zip.DataFormatException;

public class Aufgabe08 {

  public static void main(String args[]) {
	try {
	  Immobilie p = new Immobilie(100000.0, 34);
	  p.setPrice(p.getPrice() * 1.1);
	  System.out.println("Fee: " + p.getPrice() * Immobilie.getProvision() / 100);
	} catch (DataFormatException e) {
	  System.err.println(e.getMessage());


	}

  }
}
