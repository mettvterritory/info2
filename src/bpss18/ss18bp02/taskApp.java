package bpss18.ss18bp02;

import bpss18.ss18bp02.task;
import java.util.zip.DataFormatException;

/**
 * <TaskApp>
 * Programm zur Erzeugung von Tasks und Demonstration der Fehlerfaelle.
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class taskApp {

  public static void main(String args[]) {
	try {
	  task putzen = new task("Putzen");
	  System.out.println("Task: " + putzen.getName());
	  putzen.setPriority(2);
	  System.out.println("Prioritaet: " + putzen.getPriority());
	} catch (DataFormatException ex) {
	  System.err.println("Task operation failed due to " + ex.getMessage());
	}
	try {
	  task uebungsblatt = new task("Uebungsblatt", 5);
	  uebungsblatt.setName("Uebungsblatt loesen");
	  System.out.println(
		  "Task: " + uebungsblatt.getName() + ", Prioritaet: " + uebungsblatt.getPriority());
	} catch (DataFormatException ex) {
	  System.err.println("Task operation failed due to " + ex.getMessage());
	}

	try {
	  task nameTooShort = new task("");
	} catch (DataFormatException ex) {
	  System.err.println("Task operation failed due to " + ex.getMessage());
	}
	try {
	  task priorityTooLarge = new task("priorityTooLarge", 4);
	  priorityTooLarge.setPriority(9);
	} catch (DataFormatException ex) {
	  System.err.println("Task operation failed due to " + ex.getMessage());
	}
  }
}


