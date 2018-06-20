package bpss18.ss18bp10.store;

/**
 * <StoreException - BP10>
 *
 * Copyright (c) 20/06/2018
 *
 * @author: Samuel Luft
 */
public class StoreException extends Exception {

  private static final long serialVersionUID = 1L;

  public StoreException(String msg, Throwable exc) {
	super(msg, exc);
  }

}
