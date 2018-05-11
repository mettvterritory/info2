package bpss18.ss18bp04;

import bpss18.ss18bp04.Task;
import bpss18.ss18bp04.TaskComparator;
import bpss18.ss18bp04.TaskManager;
import java.util.zip.DataFormatException;

public class TaskTesterApp {

  public static void main(String[] args) {
	TaskManager tm = new TaskManager();
	try {
	  tm.addTask(new UniversityTask("Java Coding", 2));
	} catch (DataFormatException e) {
	  System.err.println(e);
	}
	try {
	  tm.addTask(new UniversityTask("Java Learning", 1));
	} catch (DataFormatException e) {
	  System.err.println(e);
	}
	try {
	  tm.addTask(new UniversityTask("Java Killing", 3));
	} catch (DataFormatException e) {
	  System.err.println(e);
	}
	try {
	  tm.addTask(new PrivateTask("Meeting", 4));
	} catch (DataFormatException e) {
	  System.err.println(e);
	}
	try {
	  tm.addTask(new PrivateTask("Cooking", 3));
	} catch (DataFormatException e) {
	  System.err.println(e);
	}
	try {
	  tm.addTask(new UniversityTask("java coding", 4));
	} catch (DataFormatException e) {
	  System.err.println(e);
	}
	try {
	  tm.addTask(new UniversityTask("", 5));
	} catch (DataFormatException e) {
	  System.err.println(e);
	}
	try {
	  tm.addTask(new UniversityTask("Java Learning", 6));
	} catch (DataFormatException e) {
	  System.err.println(e);
	}
	try {
	  tm.addTask(new UniversityTask("Java Exercising", 0));
	} catch (DataFormatException e) {
	  System.err.println(e);
	}
	try {
	  tm.addTask(new UniversityTask("Java Testing", 3));
	} catch (DataFormatException e) {
	  System.err.println(e);
	}
	try {
	  tm.addTask(new UniversityTask("Java Implementing", 5));
	} catch (DataFormatException e) {
	  System.err.println(e);
	}
	try {
	  tm.addTask(new PrivateTask("", 0));
	} catch (DataFormatException e) {
	  System.err.println(e);
	}
	try {
	  tm.addTask(new PrivateTask("Cooking", -1));
	} catch (DataFormatException e) {
	  System.err.println(e);
	}
	try {
	  tm.addTask(new PrivateTask("Sleeping", 10));
	} catch (DataFormatException e) {
	  System.err.println(e);
	}
	try {
	  tm.addTask(new PrivateTask("COOKING", 3));
	} catch (DataFormatException e) {
	  System.err.println(e);
	}
	try {
	  tm.addTask(new PrivateTask("Cleaning", 3));
	} catch (DataFormatException e) {
	  System.err.println(e);
	}
	try {
	  tm.addTask(new PrivateTask("cleaning", 1));
	} catch (DataFormatException e) {
	  System.err.println(e);
	}
	try {
	  tm.addTask(new PrivateTask("Java Coding", 2));
	} catch (DataFormatException e) {
	  System.err.println(e);
	}
	try {
	  tm.addTask(null);
	} catch (DataFormatException e) {
	  System.err.println(e);
	}
	try {
	  if (new PrivateTask("Test", 1).equals(null)) {
		System.out.println("This output should not happen...");
	  }
	} catch (DataFormatException e) {
	  System.err.println(e);
	}
	System.out.println("These are your tasks for today (starting with most urgent):");
	Task t = tm.getMostUrgent();
	if (t == null) {
	  System.out.println("This cannot be possible...");
	} else {
	  while (t != null) {
		System.out.println((t.getPriorityType() == 1 ? "University Task: " : "Private Task: ")
			+ t.getDescription() + " (" + t.getPriority() + ")");
		t = tm.getMostUrgent();
	  }
	  System.out.println("Everthing done!!!");
	}
  }
}