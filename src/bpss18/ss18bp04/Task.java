package bpss18.ss18bp04;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.util.zip.DataFormatException;

/**
 * <Task - BP04SS18>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public abstract class Task {

  private String description;
  private int priority;

  public Task(String description, int priority) throws DataFormatException {
	if (!(setDescription(description))) {
	  throw new DataFormatException("Invalid parameters for initialisation");
	}
	setPriority(priority);
  }

  private Boolean setDescription(String description) {
	if (!(description == null) || description.length() > 0) {
	  this.description = description;
	  return true;
	}
	return false;
  }

  private void setPriority(int priority) {
	if (priority < 1) {
	  this.priority = 1;
	} else if (priority > 5) {
	  this.priority = 5;
	} else {
	  this.priority = priority;
	}
  }

  @Override
  public boolean equals(Object input) {
	if (input == null) {
	  return false;
	}
	if (!(input instanceof Task)) {
	  return false;
	}
	Task t = (Task) input;
	return this.description.equalsIgnoreCase(t.description);
  }

  public String getDescription() {
	return description;
  }

  public int getPriority() {
	return priority;
  }

  public abstract int getPriorityType();


}


