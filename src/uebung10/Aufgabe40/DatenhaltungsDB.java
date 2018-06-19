package uebung10.Aufgabe40;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatenhaltungsDB {

  private static DatenhaltungsDB unique = null;
  private Connection con;

  private DatenhaltungsDB(String driver, String connector, String user, String password) {
	try {
	  Class.forName(driver);
	  con = DriverManager.getConnection(connector, user, password);
	} catch (ClassNotFoundException | SQLException ex) {
	  //Aufgabenstellung fordert keine Anhaltspunkte zum gewünschten Exception HandlingException Handling
	}
  }

  public void add(Buch buch) throws LoadSaveException {
	try {
	  Statement save = con.createStatement();
	  save.executeUpdate(
		  "INSERT INTO Buch VALUES (" + buch.getIsbn() + ",'" + buch.getTitel() + ")");
	} catch (SQLException ex) {
	  //Aufgabenstellung gibt keine Anhaltspunkte zum gewünschten Exception Handling
	}
  }


  public void delete(Buch buch) throws LoadSaveException {
	try {
	  Statement save = con.createStatement();
	  save.execute(
		  "DELETE FROM Buch WHERE isbn = " + buch.getIsbn() + ")");
	} catch (SQLException ex) {
	  throw new LoadSaveException(ex.getMessage());
	}
  }

  public ResultSet loadAll() throws LoadSaveException {
	ResultSet data = null;
	try {
	  Statement load = con.createStatement();
	  data = load.executeQuery("SELECT * FROM Buch");
	} catch (SQLException ex) {
	  throw new LoadSaveException(ex.getMessage());
	}
	return data;
  }

  public ResultSet loadSpecific(String argument) throws LoadSaveException {
	ResultSet data = null;
	try {
	  Statement load = con.createStatement();
	  data = load.executeQuery(argument);
	} catch (SQLException ex) {
	  throw new LoadSaveException(ex.getMessage());
	}
	return data;
  }

  public void disconnect() {
	if (con != null) {
	  try {
		con.close();
	  } catch (SQLException ex) {
		//Aufgabenstellung gibt keine Anhaltspunkte zum gewünschten Exception Handling
	  }
	}
  }

  private DatenhaltungsDB instance(String driver, String connector, String user, String password) {
	if (unique == null) {
	  unique = new DatenhaltungsDB(driver, connector, user, password);
	}
	return unique;
  }
}
