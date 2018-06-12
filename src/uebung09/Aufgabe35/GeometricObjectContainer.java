package uebung09.Aufgabe35;

import java.util.Iterator;
import java.util.List;

/**
 * <GeometricObject Container - Aufgabe 35 a>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class GeometricObjectContainer implements Iterable<GeometricObject> {

  private static GeometricObjectContainer unique = null;
  private List<GeometricObject> allObjects;

  private GeometricObjectContainer() {
  }

  public GeometricObjectContainer instance() {
	if (unique == null) {
	  unique = new GeometricObjectContainer();
	}
	return unique;
  }

  @Override
  public Iterator<GeometricObject> iterator() {
	return allObjects.iterator();
  }
}
