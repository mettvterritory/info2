package uebung08.Aufgabe31;

import java.util.zip.*;

public class BuchContainer {

	public void linkBuch(Buch buch) throws DataFormatException {
		if(this.alleBuecher.contains(buch))
			throw new DataFormatException("schon vorhanden");
		alleBuecher.add(buch);
	}
}
