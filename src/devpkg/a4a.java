package devpkg;

/**
 * Aufgabe 4a
 *
 * @author Samuel
 */

public class a4a {
	public static void main(String args[]){
		int x = 9999, e = 0, i = 0;
		while(i <= x){
			e = e + i;
			i++;
			System.out.println(i+ " --> " + e);
		}
		System.out.println("Gauss-summe der Natuerlichen Zahlen bis "+ x +" ist "+ e);
	}
}
