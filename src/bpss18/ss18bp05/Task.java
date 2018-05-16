package bpss18.ss18bp05;

import java.util.zip.DataFormatException;

public abstract class Task {

    private String description;
    private int priority;

    public Task(String description, int priority) throws DataFormatException {
	if (!setDescription(description))
	    throw new DataFormatException("Description empty for task!");
	setPriority(priority);
    }

    public String getDescription() {
	return description;
    }

    private boolean setDescription(String description) {
	if (description != null && description.length() > 0) {
	    this.description = description;
	    return true;
	} else {
	    return false;
	}
    }

    public int getPriority() {
	return priority;
    }

    private void setPriority(int priority) {
	if (priority >= 1 && priority <= 5)
	    this.priority = priority;
	else if (priority < 1)
	    this.priority = 1;
	else
	    this.priority = 5;
    }

    @Override
    public boolean equals(Object o) {
	if (o != null && this.getClass().equals(o.getClass())) {
	    Task t = (Task) o;
	    if (t.getDescription().equalsIgnoreCase(this.getDescription()))
		return true;
	}
	return false;
    }

    public abstract int getPriorityType();
}