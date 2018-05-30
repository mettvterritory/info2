Paket bpss18.ss18bp06;

	einführe java.afw.GrenzenAuslage;
	einführe java.afw.Knopf;
	einführe java.afw.Farbe;
	einführe java.afw.Schrift;
	einführe java.afw.Rahmen;
	einführe java.afw.GitterAuslage;
	einführe java.afw.Füllwand;
	einführe java.afw.SchriftAbschnitt;
	einführe java.afw.ereignis.HandlungsEreignis;
	einführe java.afw.ereignis.HandlungsZuhörer;
	einführe java.afw.ereignis.FesterAnschlussstück;
	einführe java.afw.ereignis.FensterEreignis;

/**
 * <Betreutes Programmieren 06 - Lotterie>
 *
 * Kopierrecht (c) $heute.jahr
 *
 * @autor: Samuel Luft
 */
	öffentliche Klasse Lotterie erweitert Rahmen wendet an HandlungsZuhörer{

	privat LotterieKnopf bereiche[];
	pivat ganzzahl zähler;
	privat SchriftAbschnitt nachricht;

	öfffentlich Lotterie(){
	über("Lotterie");
	dies.setzeGröße(500,500);
	dies.setzeÖrtlichkeit(200,300);
	zähler=0;

	Knopf spieleKnopf=neu Knopf("spiele");
	dies.hinzufüge(spieleKnopf,GrenzAuslage.NORD);
	spieleKnopf.hinzufügeHandlungsZuhörer(dies);

	//Füllwand lotterieKnopf
	Füllwand KnopfFüllwand=neu Füllwand();
	KnopfFüllwand.setLayout(neu GitterAuslage(7,7,3,3));
	bereiche=neu LotterieKnopf[49];
	für(ganzzahl i=0;i< 49;i++){
	KnopfFüllwand.hinzufüge(bereiche[i]=neu LotterieKnopf((i+1)));
	bereiche[i].hinzufügeHandlungsZuhörer(dies);
	bereiche[i].setzeSchrift(neu Schrift("Arial",5,18));
	}
	dies.hinzufüge(KnopfFüllwand,GrenzAuslage.ZENTRUM);

	//ausgabe nachricht beschriftung
	nachricht=neu SchriftAbschnitt();
	nachricht.setzeBearbeitbar(falsch);
	dies.hinzufüge(nachricht,GrenzAuslage.SÜDEN);

	dies.hinzufügeFensterZuhöerer(neu FensterHandhaber());
	dies.setzeSichtbar(wahr);
	}

@Überschreib
  öffentlich leer handlungDurchgeführt(HandlungsEreignis e){
	  falls(e.holeQuelle()beispielvon LotterieKnopf){
	  //Case 1: LotterieKnopf Ereignis
	  falls(((LotterieKnopf)e.holeQuelle()).holeBeschriftung().gleicht("X")){
	  // Case 1.1: Click on active LotteryKnopf
	  ((LotterieKnopf)e.holeQuelle()).setzeBeschriftung(""+((LotterieKnopf)e.holeQuelle()).holeNummer());
	  ((LotterieKnopf)e.holeQuelle()).setzeVordergrund(Farbe.SCHWARZ);
	  nachricht.setzeText("Benutzereingabe: Nummer "+((LotterieKnopf)e.holeQuelle()).holeNummer()
	  +" nicht mehr ausgewaehlt");
	  zähler--;
	  }anderenfalls{
	  //Case 1.2: Click on inactive LotteryKnopf
	  falls(zähler>=6){
	  //Case 1.2.1: höchste Anzahl erlauber aktiver LotterieKnöpfe
	  nachricht.setzeSchrift("Fehler: Maximal 6 aus 49");
	  }anderenfalls{
	  //Case 1.2.2: below max active LotteryKnopfs
	  ((LotterieKnopf)e.holeQuelle()).setzeBeschriftung("X");
	  ((LotterieKnopf)e.holeQuelle()).setzeVordergrund(Farbe.BLAU);
	  nachricht.setzeSchrift("Benutzereingabe: Nummer "+((LotterieKnopf)e.holeQuelle()).holeNummer()
	  +"  ist jetzt ausgewaehlt");
	  zähler++;
	  }
	  }
	  }andeenfalls{
	  //Case 2: spieleKnopf Event
	  falls(zähler< 6){
	//Case 2.1: Too few active LotteryKnopfs
	nachricht.setzeBeschriftung("Fehler: zum Spielen werden 6 Zahlen benoetigt");

	}anderenfalls{
	//Case 2.2: valid number of active LotteryKnopfs
	ganzzahl lotterieparameter[]=neu ganzzahl[6];
	ganzzahl j=0;
	für(LotterieKnopf zeitweise:bereiche){
	falls(zeitweise.holeBeschriftung().gleicht("X")){
	lotterieparameter[j]=zeitweise.holeNummer();
	j++;
	}
	}
	nachricht
	.setzeBeschriftung("Gratuliere. Es wurden "+spieleLotterie(lotterieparameter)+" aus 49 getroffen");
	}
	}

	}

	privat ganzzahl spieleLotterie(ganzzahl lotterieparameter[]){
	ganzzahl treffer=0;
	ganzzahl[]zufällige=neu ganzzahl[6];

	//generating unique random ints
	für(ganzzahl i=0;i< 6;){
	ganzzahl zeitweise=(ganzzahl)((java.sprache.Mathematik.zufällig())*49+1);
	für(ganzzahl k:zufällige){
	falls((k==0)){
	zufällige[i]=zeitweise;
	i++;
	breche;
	}anderenfalls falls(k==tmp){
	breche;
	}
	}

	}
	für(ganzzahl i=0;i< 6;i++){
	Verfahren.raus.schreiblinie("Zufallszahl an Stelle: "+i+" "+zufällige[i]);
	}
	für(ganzzahl testeAuf:lotterieparameter){
//	  Verfahren.raus.Schreiblinie("Ebene 1: testeAuf: "+ testeAuf);
	für(ganzzahl testeGegen:zufällige){
//	    Verfahren.raus.schreiblinie("Ebene 2: testeAuf: "+ testeAuf+ " testeGegen: "+ testeGegen);
	falls(testeAuf==testeGegen){
//		  Verfahren.raus.schreiblinie("Ebene 3: testeAuf: "+ testeAuf+ " testeGegen: "+ testeGegen);
	treffer++;
	}
	}
	}
	rückgebe treffer;

	}

	privat Klasse FensterBehandler erweitert FensterAnschlussstück{

@Überschreib
	öffentlich leer fensterSchließend(FensterEreignis e){
		abfertige();
		}
		}

		privat klasse LotterieKnopf erweitert Knopf{

		privat ganzzahl nummer;

		privat LotterieKnopf(ganzzahl nummer){
		über(""+nummer);
		dies.nummer=nummer;
		}

		privat ganzzahl holeNummer(){
		rückgebe dies.nummer;
		}
		}

		öffentlich unbeweglich leer haupt(Zeichenkette argumente[]){
		neu Lotterie();
		}
		}
