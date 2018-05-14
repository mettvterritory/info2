package uebung05;

/**
 * <Filename>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class Sphere extends Body {

  private int radius;

  public Sphere(int radius) {
	super();
	this.radius = radius;
  }

  public double getVolume() {
	return Math.PI * Math.pow(radius, 3);
  }

  @Override
  public boolean equals(Object input) {
	if (input == null) {
	  return false;
	}
	if (!(input instanceof Sphere)) {
	  return false;
	}
	Sphere t = (Sphere) input;
	return Math.PI * Math.pow(radius, 3) == (t.getVolume());
  }


}


