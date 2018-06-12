package uebung09.Aufgabe35;

/**
 * <Buchcontainer - Aufgabe 35b>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class 	BuchContainer {

  private static BuchContainer unique = null;

  private BuchContainer() {
  }

  public BuchContainer instance() {
	if (unique == null) {
	  unique = new BuchContainer();
	}
	return unique;
  }

}
