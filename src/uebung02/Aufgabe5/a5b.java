package uebung02.Aufgabe5;

/**
 * <Aufgabe 5 b>
 * <p>
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class a5b {

  public static void main(String args[]) {
	StringBuilder s = new StringBuilder();
	for (String t : args) {
	  s.append(t);
	}
	System.out.println(s.length());
  }
}
