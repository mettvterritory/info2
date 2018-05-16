package bpss18.ss18bp03;

/**
 * <Betreutes 03 - Bottle>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class bottle {

  private String brand;
  private boolean uncapped;
  private double volume;

  public bottle() {
	brand = "guiness";
	uncapped = false;
	volume = 0.5;
	System.out.println("Freshly tapped beer! Cheers!");
  }

  public bottle(String brand) {
	this.brand = brand;
	uncapped = false;
	volume = 0.5;
	System.out.println("Freshly tapped beer! Cheers!");
  }

  public boolean isUncapped() {
	return uncapped;
  }

  public void uncap() {
	if (!(this.uncapped)) {
	  this.uncapped = true;
	  System.out.println("Uncapping good fresh " + this.brand);
	}
  }

  public boolean takeSip() {
	if (this.isUncapped() && !(isEmpty())) {
	  this.volume -= .1;
	  System.out.println("Swig");
	  return true;
	} else {
	  System.out.println("Bottle empty or uncapped");
	  return false;
	}
  }

  public boolean isEmpty() {
	if (this.howMuchLeft() < 0.1) {
	  return true;
	} else {
	  return false;
	}
  }

  public double howMuchLeft() {
	return this.volume;
  }
}
