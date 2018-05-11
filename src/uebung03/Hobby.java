package uebung03;
import java.util.Date;
import java.util.zip.DataFormatException;

/**
 * <Aufgabe 12 a>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
*/

public class Hobby {

    private String name;
    private int priority;

    public Hobby(String name) throws DataFormatException {
		setName(name);
		this.priority = 1;
    }
    public Hobby(String name, int prio) throws DataFormatException{
      setName(name);
      setPriority(prio);
	}

    public int getPriority() {
		return this.priority;
    }
    public String getName(){
      return this.name;
	}

    public void setPriority(int priority) throws DataFormatException {
		if (!checkPriority(priority))
	        throw new DataFormatException("Priority invalid");
		this.priority = priority;
    }

    private static boolean checkPriority(int priority) {
		return (priority > 0 && priority < 6);
    }

    private boolean setName(String name) {
		if (!checkName(name))
	      return false;
		this.name = name;
		return true;
    }

    private static boolean checkName(String name) {
		return (name.length() > 1 && name.length() < 21);
    }
}
