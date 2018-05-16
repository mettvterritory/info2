package uebung02.Aufgabe8;

import javafx.scene.input.DataFormat;
import java.util.zip.DataFormatException;

/**
 * <Aufgabe 8>
 * <p>
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class Immobilie {

  private double price;
  private int area;
  private static double provision = 3.45;
  private double comission;

  public Immobilie(double price, int area)
	  throws DataFormatException {
	setPrice(price);
	setArea(area);
	comission = (price * provision) / 100;
  }

  public void setPrice(double price) throws DataFormatException {
	if (!(checkPrice(price))) {
	  throw new DataFormatException("invalid Price");
	}
	this.price = price;
  }

  public void setArea(int area) throws DataFormatException {
	if (!(checkArea(area))) {
	  throw new DataFormatException("invalid Area");
	}
	this.area = area;
  }

  public double getPrice() {
	return this.price;
  }

  public int getArea() {
	return this.area;
  }

  public static double getProvision() {
	return provision;
  }

  public double getComission() {
	return this.comission;
  }

  private static boolean checkPrice(double price) {
	return (price > 0);
  }

  private static boolean checkArea(int area) {
	return (area > 0);
  }
}

