package bpss18.ss18bp04;

import java.util.zip.DataFormatException;

/**
 * <PrivateTask - BP04SS18>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class PrivateTask extends Task {

  private static int PRIORITY_TYPE = 2;

  public PrivateTask(String description, int priority) throws DataFormatException {
	super(description, priority);
  }

  @Override
  public int getPriorityType() {
	return PRIORITY_TYPE;
  }
}
