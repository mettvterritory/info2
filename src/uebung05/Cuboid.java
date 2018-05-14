package uebung05;

/**
 * <Cuboid - Uebung 05>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class Cuboid extends Body {

  private int length, width, height;

  public Cuboid(int length, int width, int height) {
	super();
	this.length = length;
	this.width = width;
	this.height = height;
  }

  public double getVolume() {
	return length * width * height;
  }

  public int getHeight() {
	return height;
  }

  public int getLength() {
	return length;
  }

  public int getWidth() {
	return width;
  }

  @Override
  public boolean equals(Object input) {
	if (input == null) {
	  return false;
	}
	if (!(input instanceof Cuboid)) {
	  return false;
	}
	Cuboid tmp = (Cuboid) input;
	return (this.width == tmp.getWidth() && this.height == tmp.getHeight() && this.length == tmp.getLength());
  }
}



