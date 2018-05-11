/*
 * 
 * @Point.java 02 24.04.2018 (Robert Lorenz)
 * 
 * Copyright (c) 2017 Lehrprofessur für Informatik, Universität Augsburg
 * 
 */

package uebung03;

/**
 * Punkt mit jeweils reelwertiger x- und y-Koordinate
 * 
 * @author lorenzro
 *
 */
public class Point {
	
	private double x;
	private double y;
		
	/**
	 * Erzeugt einen Punkt mit den übergebenen x- und y-Koordinaten. 
	 * 
	 * @param x der Wert der x-Koordinate des erzeugten Punktes
	 * @param y der Wert der y-Koordinate des erzeugten Punktes
	 * 
	 */
	public Point(double x, double y)  {
	    setX(x);
	    setY(y);
	}
		

	/**
	 * Setzt Wert der x-Koordinate
	 * 
	 * @param x der neue Wert der x-Koordinate
	 * 
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Setzt Wert der y-Koordinate
	 * 
	 * @param y der neue Wert der y-Koordinate
	 * 
	 */
	public void setY(double y) {
		this.y = y;
	}

	
	/**
	 * Gibt Wert der x-Koordinate zurück
	 * 
	 * @return Wert der x-Koordinate
	 */
	public double getX() {
		return this.x;
	}
	
	/**
	 * Gibt Wert der y-Koordinate zurück
	 * 
	 * @return Wert der y-Koordinate
	 */
	public double getY() {
		return this.y;
	}
	
}
