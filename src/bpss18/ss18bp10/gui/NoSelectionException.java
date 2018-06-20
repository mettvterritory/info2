package bpss18.ss18bp10.gui;

import java.awt.List;

public class NoSelectionException extends Exception {
    private static final long serialVersionUID = 1L;
    private List source;

    public NoSelectionException(List source) {
	super();
	this.source = source;
    }

    public List getSource() {
	return source;
    }
}
