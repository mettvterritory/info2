package devpkg;

/**
 * Aufgabe 4a
 *
 * @author Samuel
 */
public class a4b {

  public static void main(String args[]) {
	int x = 9176863;
	if (x == 2) {
	  System.out.println("Nicht prim");
	  return;
	}
	if (x % 2 == 0) {
	  System.out.println("Nicht prim");
	  return;
	}
	for (int i = 3; i * i <= x; i += 2) {
	  if (x % i == 0) {
		System.out.println("Nicht prim");
		return;
	  }
	}
	System.out.println("Prim");
  }
}