package uebung03;
import com.sun.xml.internal.fastinfoset.util.StringArray;
import java.util.ArrayList;
import java.util.zip.DataFormatException;
/**
 * <Filename>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class Student {
  private ArrayList<String> email;

  public Student(){}

  public void addEmail (String mail) throws DataFormatException{
    if(!checkEmail(mail)){
      throw new DataFormatException("Invalid mail adress");
	}
	if(this.email.contains(mail)){
      throw new DataFormatException("Mail adress aready in use");
	}
	this.email.add(mail);
  }
  public void deleteEmail (String mail){
    this.email.remove(mail);
  }
  public ArrayList<String> getEmail(){
    return this.email;
  }
  private static Boolean checkEmail(String mail){
    if(mail.matches("\\w+@\\w+.\\w\\w+")){
      return true;
	}
	return false;
  }
}

