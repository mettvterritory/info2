package bpss18;

/**
 * Betreutes Programmieren 01
 * <p>
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class Palindrom {

  public static void main(String args[]) {
	if (args.length == 0) {
	  System.err.println("Wir brauchen mehr Parameter");
	  return;
	}
	for (String s : args) {
	  System.out.print("Wort: " + s + " Palindrom: ");
	  if (testPalindrom(s)) {
		System.out.println("Ja");
	  } else {
		System.out.println("Nein");
	  }
	}
  }

  private static boolean testPalindrom(String word) {
	int i = 0, len = word.length() - 1;
	while (i <= len / 2) {
	  if (Character.toLowerCase(word.charAt(i)) != Character.toLowerCase(word.charAt(len - i))) {
		return false;
	  }
	  i++;
	}
	return true;
  }
}