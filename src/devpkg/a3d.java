package devpkg;
/**
 * Aufgabe 3d
 *
 * @author Samuel
 */
public class a3d {
	public static void main (String args[]){
		if (args.length == 1) {
				if(args[0].startsWith("Warnung")){
					System.out.println("Diese Eingabe warnt.");
				}else{

					System.out.println("Diese Eingabe warnt nicht.");
				}
		} else {
			System.err.println("Fehler err");
		}
	}
}
