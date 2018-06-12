package uebung09.Aufgabe33;

/**
 * <A1 - Singleton - Aufgabe 33a>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class A1 {

  private static A1 unique = null;

  private A1() {

  }

  public A1 instance() {
	if (unique == null) {
	  unique = new A1();
	}
	return unique;
  }

}
