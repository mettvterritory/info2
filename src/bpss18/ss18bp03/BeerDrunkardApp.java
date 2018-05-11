package bpss18.ss18bp03;
import bpss18.ss18bp03.bottle;
import bpss18.ss18bp03.crate;

public class BeerDrunkardApp {

    private static bottle fillcrate(crate c) {
	bottle beer;
	do {
	    beer = new bottle();
	} while (c.putIn(beer));
	return beer;
    }
    public static void main(String[] args) {
	bottle beer = new bottle("Corona");
	beer.uncap();
	beer.takeSip();
	System.out.println("How much left: " + beer.howMuchLeft());

	while (!beer.isEmpty())
	    beer.takeSip();

	crate box = new crate(6);
	beer = fillcrate(box);
	beer.uncap();

	while (!beer.isEmpty()) {
	    beer.takeSip();
	    if (beer.isEmpty() && !box.isEmpty()) {
		beer = box.takeOut();
		beer.uncap();
	    }
	}
    }
}