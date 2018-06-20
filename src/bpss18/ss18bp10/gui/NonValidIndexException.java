package bpss18.ss18bp10.gui;

import java.awt.Choice;

public class NonValidIndexException extends Exception {
    private static final long serialVersionUID = 1L;
    private Choice source;

    public NonValidIndexException(Choice source) {
	super();
	this.source = source;
    }

    public Choice getSource() {
	return source;
    }
}