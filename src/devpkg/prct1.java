package devpkg;

/**
 * Aufgabe 2
 *
 * @author Samuel
 */

public class prct1 {
	public static void main(String[] args) {

	}

	public void PrintAllEmpty() {
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}

	}

	public void PintZitat() {
		System.out.println("Zitat");
	}


	public void ParameterCheck(String[] args) {
		if (args.length > 0) {
			System.out.println("Keine Parameter");
		} else {
			System.out.println("Es sind Parameter im Haus");
		}

	}
	public void RandomHalfToOne(){
		double i;
		i = ((java.lang.Math.random())+ 1 )* 0.5;
		System.out.println(i);
	}

	public void SqrtOnePointFive(){
		double i = 1.5, j;
		j = java.lang.Math.sqrt(i);
		System.out.println(j);
	}


}
