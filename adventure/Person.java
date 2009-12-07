
package adventure;

/**
*
* @author Timo Schrappe, Nils Preuschoff
*/

public abstract class Person {
	private String  name;
	private int	kraft;
	private Inventar rucksack;
	private Gegenstand handL, handR;
	private double angriffswert;
	private double verteidigungswert;
	private double life;
	
	
	public Person(String n, int k) {
		name = n;
		kraft = k;
		rucksack = new Inventar();
		handL = null;
		handR = null;
		life = 100.00;
	}
	public String gibName() {
		return name;
	}
	public int gibKraft() {
		return kraft;
	}
	public double gibAngriffswert() {
		return angriffswert;
	}
	public double gibVerteidigungswert() {
		return verteidigungswert;
	}
	public double gibLife() {
		return life;
	}
	public void anlegen(Gegenstand geg) {
        if(anlegbar(geg)) {
        	if(handR == null && geg.istWaffe()) {
        		handR = geg;
        		angriffswert = angriffswert +geg.gibAngriffswert();
        		System.out.println("Gegenstand "+geg.toString()+" wurde angelegt.");
        	}
        	else if(handL == null && (geg.istWaffe() || geg.istSchild())) {
        		handL = geg;
        		angriffswert = angriffswert +geg.gibAngriffswert();
        		verteidigungswert = verteidigungswert +geg.gibVerteidigungswert();
        		System.out.println("Gegenstand "+geg.toString()+" wurde angelegt.");
        	}
        	else {
        	}
        }
        else {
            System.out.println("Gegenstand "+geg.toString()+" wurde nicht angelegt.");
        }
	}
	public void einpacken(Gegenstand geg) {
		rucksack.einpacken(geg);
	}
	public Gegenstand ablegen(int hand) {
		Gegenstand geg = null;
		if(hand == 1) {
			geg = handR;
			handR = null;
            angriffswert = angriffswert +geg.gibAngriffswert();
		}
		else if(hand == 2) {
			geg = handL;
			handL = null;
            angriffswert = angriffswert +geg.gibAngriffswert();
            verteidigungswert = verteidigungswert +geg.gibVerteidigungswert();
		}
		else {
			
		}
		return geg;
	}	
	public void verstauen(int hand) {
		Gegenstand geg = null;
		if(hand == 1) {
			geg = handR;
			handR = null;
		}
		else if(hand == 2) {
			geg = handL;
			handL = null;
		}
		else {	
		}
		rucksack.einpacken(geg);
	}
	public void ausdemrucksackanlegen(String n) {
		Gegenstand geg = null;
		geg = rucksack.auspacken(n);
		anlegen(geg);
	}
	public Gegenstand rucksackentfernen(String n) {
		Gegenstand geg = null;
        geg = rucksack.auspacken(n);
        System.out.println("Gegenstand "+geg.toString()+" wurde ausgepackt.");
		return geg;
	}
	public boolean anlegbar(Gegenstand geg) {
		boolean ergebnis = false;
        if(rucksack.getMaximalgewicht()>= (rucksack.gibGewicht()+geg.gibGewicht())) {
        	ergebnis = true;
        }
        else {
            ergebnis = false;
        }
        return ergebnis;
	}
}
