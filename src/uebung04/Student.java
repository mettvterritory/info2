package uebung04;

import com.sun.xml.internal.fastinfoset.util.StringArray;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.zip.DataFormatException;
import uebung04.Studiengang;

/**
 * <Aufgabe 15a, 15b, 16a>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class Student {

  private ArrayList<Studiengang> Studiengang;

  public Student(Studiengang studiengang) throws DataFormatException {
	this.linkStudiengang(studiengang);
  }

  public void linkStudiengang(Studiengang s) throws DataFormatException {
	if (this.Studiengang.contains(s)) {
	  throw new DataFormatException("Studeingang bereits vorhanden");
	} else {
	  this.Studiengang.add(s);
	}
  }

}
