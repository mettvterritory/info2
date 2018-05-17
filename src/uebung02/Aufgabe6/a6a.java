package uebung02.Aufgabe6;

/**
 * <Aufgabe 6 a>
 * <p>
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class a6a {

  public static void main(String args[]) {
	Double x, y;
	if (args.length != 2) {
	  System.out.println("Incorrect number of Arguments");
	  return;
	}
	try {
	  x = Double.parseDouble(args[0]);
	  y = Double.parseDouble(args[1]);
	} catch (NumberFormatException e) {
	  System.err.println("Parsing Error");
	  return;
	}
	System.out.println(x * y);
  }
}

