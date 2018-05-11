package uebung04;
import java.util.ArrayList;
import java.util.zip.DataFormatException;
import uebung04.File;
import java.util.ArrayDeque;

/**
 * <Aufgabe 16b>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class Directory {
  private ArrayList<File> filelelement;
  private ArrayList<Directory> directoryelement;

  public File[] getlinkFileelement(){
    return this.filelelement.toArray(new File[filelelement.size()]);
  }
  public Directory[] getlinkDirectoryelement(){
    return this.directoryelement.toArray(new Directory[directoryelement.size()]);
  }
  public void linkFileelement(File file) throws DataFormatException{
    if(this.filelelement.contains(file)){
      throw new DataFormatException("No duplicate files allowed");
	}else{
      this.filelelement.add(file);
	}
  }
  public void linkDirectoryelement (Directory directory) throws DataFormatException {
	if (this.directoryelement.contains(directory)) {
	  throw new DataFormatException("No duplicate directories allowed");
	} else{
	  this.directoryelement.add(directory);
	}
  }
  public void unlinkFileelement (File file){
    if(this.filelelement.contains(file)){
      this.filelelement.remove(file);
	}
  }
  public void unlinkDirectoryelement (Directory directory){
    if(this.directoryelement.contains(directory)){
      this.directoryelement.remove(directory);
	}
  }
}
