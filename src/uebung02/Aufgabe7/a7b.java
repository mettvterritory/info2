package uebung02.Aufgabe7;
import uebung02.Aufgabe7.Matrix;

import java.util.zip.DataFormatException;

/**
 * <Filenameufgabe 7 b>
 * <p>
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */

/**
 *  Attribute/Datenstrukturinvarianten der Klasse Matrix:
 *      rowDimension groeßer als 0
 *      columnDimension groeßer als 0
 */

public class a7b {
	public static void main (String args[]){
		try{
			Matrix m = new Matrix(2,3);
			for(int i = 0; i < 2; i++){
				for(int j = 0; j < 3; j++){
					m.setValue( i, j,1);
				}
			}
		}catch(DataFormatException ex){
			System.err.println("Matrix operation has failed due to: " + (ex.getMessage()));
		}
	}
}
