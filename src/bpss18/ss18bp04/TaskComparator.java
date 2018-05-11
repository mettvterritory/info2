package bpss18.ss18bp04;

import bpss18.ss18bp04.Task;
import java.util.Comparator;

/**
 * <TaskComparator - BP04SS18>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class TaskComparator implements Comparator<Task> {

  public TaskComparator() {
  }

  public int compare(Task t1, Task t2) {
	if (t1.getPriorityType() != t2.getPriorityType()) {
	  if (t1.getPriorityType() < t2.getPriorityType()) {
		return -1;
	  } else if (t1.getPriorityType() > t2.getPriorityType()) {
		return 1;
	  } else {
		return 0;
	  }
	} else if (t1.getPriority() < t2.getPriority()) {
	  return -1;
	} else if (t1.getPriority() > t2.getPriority()) {
	  return 1;
	} else {
	  return 0;
	}
  }

}
