package uebung10.Aufgabe40;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Datenbank {

  private Connection con;

  public void add(Buch buch) throws LoadSaveException {
	try {
	  Statement save = con.createStatement();
	  save.executeUpdate(
		  "INSERT INTO Buch VALUES (" + buch.getIsbn() + ",'" + buch.getTitel() + ")");
	} catch (SQLException ex) {
	  //Aufgabenstellung fordert kein Exception Handling
	}
  }


  public void delete(Buch buch) throws LoadSaveException {
	try {
	  Statement save = con.createStatement();
	  save.executeUpdate(
		  "DELETE FROM Buch WHERE isbn = " + buch.getIsbn() + ")");
	} catch (SQLException ex) {
	  //Aufgabenstellung fordert kein Exception Handling
	}
  }
}
