package bpss18.ss18bp02;

import java.util.zip.DataFormatException;

/**
 * <Task>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class task {

  /**
   * Task, definiert durch Beschreibung und Priorität
   */
  private String name;
  private int priority;


  /**
   * Erzegt neuen Task mit uebergebenem Namen und Standard-prioritaet
   * @param name
   * @throws DataFormatException
   */
  public task (String name) throws DataFormatException {
    setName(name);
    this.priority = 1;
  }

  /**
   * Erzeugt neuen Task mit uebergebenem namen und uebergebener Prioritaet
   * @param name
   * @param prio
   * @throws DataFormatException
   */
  public task (String name, int prio) throws DataFormatException {
    setName(name);
    setPriority(prio);
  }

  /**
   * gibt Prioritaet zurueck
   * @return Prioritaet des Tasks
   */
  public int getPriority() {
    return this.priority;
  }

  /**
   * gibt Name zurueck
   * @return Name des Tasks
   */
  public String getName() {
    return this.name;
  }

  /**
   * Setzt Prioritaet falls ein gueltiger Wert uebergebe wird. Gueltig sind Zahlen von 1 bis 5.
   *
   * @param priority
   *              Prioritaet
   * @throws DataFormatException falls ungueltige Daten uebergeben werden
   */
  public void setPriority(int priority) throws DataFormatException {
    if (!checkPriority(priority))
      throw new DataFormatException("Priority invalid");
    this.priority = priority;
  }

  /**
   * Prueft ob uebergebene Daten geultig sind
   *
   * @param priority prioritaet
   * @return gueltigkeit übergebener Daten
   */
  private static boolean checkPriority(int priority) {
    return (priority > 0 && priority < 6);
  }

  /**
   * Setzt Name falls ein gueltiger Wert uebergeben wird. Gueltig sind nichtleere Zeichenketten.
   *
   * @param name Name
   * @throws DataFormatException falls ungueltige Daten uebergeben werden
   */
  public void setName(String name) throws DataFormatException {
    if (!checkName(name))
      throw new DataFormatException("Name invalid");
    this.name = name;
  }

  /**
   * Prueft ob uebergebene Daten gueltig sind
   * @param name Name
   * @return gueltigkeit der uebergebenen Daten
   */
  private static boolean checkName(String name) {
    if(name == null) return false;
    return (name.length() > 0);
  }



}




