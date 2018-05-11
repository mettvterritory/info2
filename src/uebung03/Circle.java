/*
 * 
 * @Circle.java 03 24.04.2018 (Robert Lorenz)
 * 
 * Copyright (c) 2017 Lehrprofessur für Informatik, Universität Augsburg
 * 
 */

package uebung03;

import java.util.zip.DataFormatException;

/**
 * Durch seinen Radius spezifizierter Kreis
 * 
 * @author lorenzro
 */
public class Circle {

	private double radius;
	private Point position;
	private static int count = 0;

	/**
	 * Erzeugt einen neuen Kreis mit Radius 1.0
	 * 
	 * @param position
	 *            Position
	 */
	public Circle(Point position) {
		this.radius = 1.0;
		this.setPosition(position);
		++count;
	}

	/**
	 * Erzeugt einen neuen Kreis mit übergebenem Radius
	 * 
	 * @param position
	 *            Position
	 * @param radius
	 *            übergebener Radius
	 * @throws DataFormatException falls ungültige Daten übergeben wurden
	 */
	public Circle(double radius, Point position) throws DataFormatException {
		this.setRadius(radius);
		this.setPosition(position);
		++count;
	}

	/**
	 * Gibt die Anzahl aller erzeugten Circle-Objkete zurück
	 * 
	 * @return count Anzahl aller erzeugten Circle-Objkete
	 */
	public static int getCount() {
		return count;
	}

	/**
	 * Gibt den Radius zurück
	 * 
	 * @return Radius des Kreises
	 */
	public double getRadius() {
		return this.radius;
	}

	/**
	 * Gibt die Position zurück
	 * 
	 * @return Position des Kreises
	 */
	public Point getPosition() {
		return this.position;
	}

	private static boolean checkRadius(double radius) {
		return (radius >= 0);
	}

	/**
	 * Setzt den Radius, falls ein gültiger Wert übergeben wird. Gültig sind
	 * positive Zahlen.
	 * 
	 * @param radius
	 *            Radius
	 * @throws DataFormatException falls ungültige Daten übergeben wurden
	 */
	public void setRadius(double radius) throws DataFormatException {
		if (!checkRadius(radius))
			throw new DataFormatException("Objekt Circle: Radius ungueltig");
		this.radius = radius;
	}

	/**
	 * Setzt die Position.
	 * 
	 * @param position
	 *            Position
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	/**
	 * Berechnet die Fläche des Kreises
	 * 
	 * @return Kreisflaeche
	 */
	public double getArea() {
		return Math.PI * this.radius * this.radius;
	}

}
