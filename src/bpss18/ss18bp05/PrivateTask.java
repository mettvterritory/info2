package bpss18.ss18bp05;

import java.util.zip.DataFormatException;

public class PrivateTask extends Task {

  private static final int PRIORITY_TYPE = 2;

  public PrivateTask(String description, int priority) throws DataFormatException {
	super(description, priority);
  }

  public int getPriorityType() {
	return PRIORITY_TYPE;
  }
}