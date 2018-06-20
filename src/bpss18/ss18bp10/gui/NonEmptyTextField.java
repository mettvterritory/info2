package bpss18.ss18bp10.gui;

import java.awt.TextField;

public class NonEmptyTextField extends TextField {
    private static final long serialVersionUID = 1L;

    public NonEmptyTextField(int width) {
	super(width);
    }

    public String getCheckedText() throws EmptyTextException {
	String tmp = super.getText();
	if (tmp.equals(""))
	    throw new EmptyTextException(this);
	return tmp;
    }

    public void setEmptyText() {
	super.setText("");
    }
}
