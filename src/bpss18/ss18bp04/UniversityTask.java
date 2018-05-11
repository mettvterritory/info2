package bpss18.ss18bp04;
import java.util.zip.DataFormatException;

/**
 * <UNiversityTask - BP04SS18>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class UniversityTask extends Task {
  private static int PRIORITY_TYPE = 1;

  public UniversityTask(String description, int priority) throws DataFormatException {
    super(description,priority);
  }

  @Override
  public int getPriorityType() {
	return PRIORITY_TYPE;
  }
}
