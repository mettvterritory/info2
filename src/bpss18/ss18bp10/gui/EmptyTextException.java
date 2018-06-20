package bpss18.ss18bp10.gui;

import java.awt.TextField;

public class EmptyTextException extends Exception {

  private static final long serialVersionUID = 1L;
    private TextField source;

    public EmptyTextException(TextField source) {
	super();
	this.source = source;
    }

    public TextField getSource() {
	return source;
    }
}