package bpss18.ss18bp08.data;

import java.awt.Color;
import java.util.Observable;

/**
 * <Observable Colo(u)r Singleton>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class Colour extends Observable {

  private int red = 0;
  private int green = 0;
  private int blue = 0;
  private static Colour unique = null;

  private Colour() {
  }

  public void setGreen(int green) {
	this.green = green;
	setChanged();
	notifyObservers();

  }

  public void setRed(int red) {
	this.red = red;
	setChanged();
	notifyObservers();
  }

  public void setBlue(int blue) {
	this.blue = blue;
	setChanged();
	notifyObservers();
  }

  public Color getColour() {
	return new Color(red, green, blue);
  }

  public static Colour instance() {
	if (unique == null) {
	  unique = new Colour();
	}
	return unique;

  }
}
