package uebung05;

/**
 * <Property - Uebung 05>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public abstract class Property {

  private double price;

  protected Property(double price) {
  }

  public double getPrice() {
	return price;
  }
}
