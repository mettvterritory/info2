package uebung02.Aufgabe6;

import java.util.ArrayList;

/**
 * <Aufgabe 6 b>
 * <p>
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class a6b {
	public static void main(String args[]) {
		Double z = 0.0;
		ArrayList<Double> list = new ArrayList<>();
		int n = (int) (java.lang.Math.random() * 100000) + 1;
		for (int j = 0; j < n; j++) {
			try {
				Double tmp = Double.valueOf(Math.random());
				list.add(tmp);
			} catch (NumberFormatException f){
				System.err.println("Random number generation has failed");
				return;
			}
		}
		for (int j = 0; j < n; j++) {
			try {
				z += list.get(j);
			} catch (IndexOutOfBoundsException e) {
				System.err.println("List index out of bounds");
				return;
			}
		}
		z = z / n;
		System.out.println(z);
	}
}
