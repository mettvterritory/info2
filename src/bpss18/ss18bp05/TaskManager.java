package bpss18.ss18bp05;

import java.util.PriorityQueue;
import java.util.zip.DataFormatException;

public class TaskManager {

    private PriorityQueue<Task> tasks;

    public TaskManager() {
	tasks = new PriorityQueue<Task>(new TaskComparator());

    }

    public void addTask(Task task) throws DataFormatException {
	if (task != null)
	    if (tasks.contains(task))
		throw new DataFormatException("Duplicate task!");
	    else
		tasks.add(task);
	else
	    throw new DataFormatException("There is no task!");
    }

    public Task getMostUrgent() {
	return tasks.poll();
    }
}