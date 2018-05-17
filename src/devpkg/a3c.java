package devpkg;

/**
 * Aufgabe 3c
 *
 * @author Samuel
 */
public class a3c {

  public static void main(String args[]) {
	int i = args.length, j = 0;
	while (i > 0) {
	  i--;
	  j = j + args[i].length();
	  System.out.println(j);
	}
	System.out.println("Summe aller Parameter: " + j);
  }

}
