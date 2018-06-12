package uebung09.Aufgabe35;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

/**
 * <Mitarbeitercontainer - Aufgabe 35 c>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class MitarbeiterContainer implements Iterable<Mitarbeiter> {

  private List<Mitarbeiter> alleMitarbeiter;

  @Override
  public Iterator<Mitarbeiter> iterator() {
	return alleMitarbeiter.iterator();
  }
}
