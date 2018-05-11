package bpss18.ss18bp04;

import bpss18.ss18bp04.TaskComparator;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.zip.DataFormatException;

/**
 * <TaskManager - BO04SS18>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class TaskManager {

  private PriorityQueue<Task> tasks;

  public TaskManager() {
	TaskComparator taskSorting = new TaskComparator();
	tasks = new PriorityQueue<Task>(taskSorting);
  }

  public void addTask(Task task) throws DataFormatException {
	for (Task checker : tasks) {
	  if (task == null || checker.equals(task)) {
		throw new DataFormatException("Task already in qeue");
	  }
	}
	tasks.add(task);
  }

  public Task getMostUrgent() {
	return tasks.poll();
  }


}
