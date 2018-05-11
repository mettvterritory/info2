package uebung03;
import java.util.zip.DataFormatException;
import uebung03.Contact;

/**
 * <Augfgabe 9 b>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class a9b {
	public static void main (String args[]){
	  if(args.length < 1){
	    System.err.println("Invalid parameters");
	    return;
	  }
	  try{
	    Contact c = new Contact(args[0]);
	    if(args.length > 1){
	      c.setBirthday(args[1]);
	      int i = 2;
	      while (i < args.length){
	        c.addTelephone(args[i++]);
		  }
		}
		int j = 0;
		while(j < c.getCountTelephone()){
	      System.out.println("Nummer "+ (j+1) + ": "+ c.getTelephone(j++));
		}
	  } catch (DataFormatException | IndexOutOfBoundsException | IllegalArgumentException ex){
	    System.err.println("Contact generation operation failed: "+ ex.getMessage());
	  }
	}
}
