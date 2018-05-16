package uebung02.Aufgabe7;

import uebung02.Aufgabe7.Hobby;
import java.util.zip.DataFormatException;

/**
 * <Aufgabe 7 a>
 * <p>
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */

/**
 * Attribute/Datenstrukturinvarianten der Klasse Hobby: Name:       2-20 Zeichen Priority:   Ziffern
 * von 1-5
 */
public class a7a {

  public static void main(String args[]) {
	try {
	  Hobby lesen = new Hobby("Lesen");
	  lesen.setPriority(lesen.getPriority() - 1);
	} catch (DataFormatException ex) {
	  System.err.println("Hobby operation has failed due to: " + (ex.getMessage()));
	}
  }
}