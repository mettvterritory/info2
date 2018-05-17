package devpkg;

/**
 * Aufgabe 3b
 *
 * @author Samuel
 */
public class a3b {

  public static void main(String args[]) {
	if (args.length == 1) {
	  if (args[0].compareTo("Hello") == 0) {
		System.out.println("Entered String is 'Hello'");
	  } else {
		System.out.println("Entered String is not 'Hello'");
	  }
	} else {
	  System.err.println("Fehler");
	}
  }
}





