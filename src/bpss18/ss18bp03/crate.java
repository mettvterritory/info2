package bpss18.ss18bp03;

import bpss18.ss18bp03.bottle;
import java.util.ArrayDeque;

/**
 * <Betreutes 03 - Crate>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class crate {

  private int capacity;
  private ArrayDeque<bottle> bottles = new ArrayDeque<bottle>();


  public crate(int qty) {
	if (qty <= 6) {
	  this.capacity = 6;
	} else if (qty <= 10) {
	  this.capacity = 10;
	} else {
	  this.capacity = 20;
	}
	System.out.println("A crate for " + this.capacity + " bottles of beer!");
  }

  public boolean isEmpty() {
	return bottles.isEmpty();
  }

  public int howMuchLeft() {
	return bottles.size();
  }

  public bottle takeOut() {
	return bottles.pollFirst();
  }

  public boolean putIn(bottle b) {
	if (this.bottles.size() >= this.capacity) {
	  System.out.println("Crate at or over capacity");
	  return false;
	} else {
	  bottles.addLast(b);
	  return true;
	}
  }

}
