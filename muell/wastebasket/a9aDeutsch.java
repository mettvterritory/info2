paket uebung03;
einführe java.werk.reissverschluss.AngabenAufbauAusnahme;
einführe uebung03.Kreis;
einführe uebung03.Punkt;

/**
 * <Aufgabe 9 a>
 *
 * Kopierrecht (c) $heute.jahr
 *
 * @Autor: Samuel
 */
öffentlich klasse a9a {
  öffentlich unbeweglich leer haupt (Zeichenkette behauptungen[]){
	falls((behauptungen.länge ganzzahligTeilbarDurch 3) != 0) {
	  Verfahren.fehler.schreibzeile("Ungültige eingaben");
	  zurückgebe;
	}
	versuche{
	  ganzzahl i = 0;
	  während(i < behauptungen.länge){
		Punkt p = neuer Punkt(Doppel.zergliedereDoppel(behauptungen[i++]), Doppel.zergliedereDoppel(behauptungen[i++]));
		Kreis c = neuer Kreis (Doppel.zergliedereDoppel(behauptungen[i++]), p);
	  }
	  Verfahren.raus.schreibzeile("Erstellte Kreise: "+ Kreis.holeZähler());

	}fange(AngabenAufbauAusnahme | NummerAufbauAusnahme ex){
	  Verfahren.fehler.schreibzeile("Kreis wurde nicht gemacht:  " + ex.holeNachricht());

	}
  }
}




