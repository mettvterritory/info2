package uebung09.Aufgabe33;

import java.util.Observable;
import java.util.Observer;

/**
 * <A2 - Observer - Augfabe 33 b>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class A2 implements Observer {

  private int countChanges = 0;
  private B b;

  public A2(B b) {
	this.b = b;
	b.addObserver(this);

  }

  @Override
  public void update(Observable o, Object obj) {
	countChanges++;
  }

}
