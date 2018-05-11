package uebung05;

import uebung05.Property;

/**
 * <Flat - Uebung  05>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class Flat extends Property {

  private int area;

  public Flat(double price, int area) {
	super(price);
	this.area = area;
  }

  public int getArea() {
	return area;
  }

  public String toString(){
    return ("Preis: "+ this.getPrice()+ " Wohnflaeche: " + this.area);
  }

  @Override
  public double getPrice() {
	return super.getPrice();
  }
}
