package uebung05;

/**
 * <Filename>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public abstract class Property {
  private double price;

  protected Property(double price){}

  public double getPrice() {
	return price;
  }
}
