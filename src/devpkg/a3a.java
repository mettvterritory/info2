package devpkg;

/**
 * Aufgabe 3a
 *
 * @author Samuel
 */
public class a3a {

  public static void main(String args[]) {
	if (args.length == 1) {
	  System.out.println(args[args.length - 1]);
	} else {
	  System.err.println("Fehler");
	}
  }
}


