package bpss18.ss18bp05;

import java.util.Comparator;

public class TaskComparator implements Comparator<Task> {

    @Override
    public int compare(Task o1, Task o2) {
	if (o1.getPriorityType() == o2.getPriorityType()) {
	    if (o1.getPriority() == o2.getPriority())
		return 0;
	    else if (o1.getPriority() < o2.getPriority())
		return -1;
	} else if (o1.getPriorityType() < o2.getPriorityType())
	    return -1;
	return 1;
    }
}