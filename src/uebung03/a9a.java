package uebung03;

import java.util.zip.DataFormatException;
import uebung03.Circle;
import uebung03.Point;

/**
 * <Aufgabe 9 a>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class a9a {

  public static void main(String args[]) {
	if ((args.length % 3) != 0) {
	  System.err.println("Invalid parameters");
	  return;
	}
	try {
	  int i = 0;
	  while (i < args.length) {
		Point p = new Point(Double.parseDouble(args[i++]), Double.parseDouble(args[i++]));
		Circle c = new Circle(Double.parseDouble(args[i++]), p);
	  }
	  System.out.println("Erstellte Kreise: " + Circle.getCount());

	} catch (DataFormatException | NumberFormatException ex) {
	  System.err.println("Circle generation operation failed:  " + ex.getMessage());

	}
  }
}




