package uebung02.Aufgabe5;

/**
 * <Aufgabe 5 a>
 * <p>
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class a5a {
	public static void main(String args[]){
		if(args.length != 2){
			System.out.println("nicht ok");
			return;
		}
		if(args[0].compareTo("-o") != 0){
			System.out.println("nicht ok");
			return;
		}
	if(Character.isDigit(args[1].charAt(0))){
			System.out.println("ok");
			return;
	}else{
			System.out.println("nicht ok");
		}
	}




}
