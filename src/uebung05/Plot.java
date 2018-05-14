package uebung05;

/**
 * <Plot - Uebung 05>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class Plot extends Property {

  private int area;

  public Plot(double price, int area) {
	super(price);
	this.area = area;
  }

  public int getArea() {
	return area;
  }

  public String toString() {
	return ("Preis: " + this.getPrice() + " Wohnflaeche: " + this.area);
  }

  @Override
  public double getPrice() {
	return super.getPrice();
  }
}
