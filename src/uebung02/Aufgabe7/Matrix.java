package uebung02.Aufgabe7;

import java.util.zip.DataFormatException;

public class Matrix {

  private int rowDimension;
  private int columnDimension;
  private int values[][];

  public Matrix(int rowDimension, int columnDimension)
	  throws DataFormatException {
	setRowDimension(rowDimension);
	setColumnDimension(columnDimension);
	values = new int[rowDimension][columnDimension];
  }

  private void setRowDimension(int rowDimension) throws DataFormatException {
	if (!checkRowDimension(rowDimension)) {
	  throw new DataFormatException("RowDimension invalid");
	}
	this.rowDimension = rowDimension;
  }

  private static boolean checkRowDimension(int rowDimension) {
	return (rowDimension > 0);
  }

  private void setColumnDimension(int columnDimension)
	  throws DataFormatException {
	if (!checkColumnDimension(columnDimension)) {
	  throw new DataFormatException("ColumnDimension invalid");
	}
	this.columnDimension = columnDimension;
  }

  private static boolean checkColumnDimension(int columnDimension) {
	return (columnDimension > 0);
  }

  public void setValue(int row, int column, int value) {
	values[row][column] = value;
  }

}
