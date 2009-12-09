
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
	
	/**
	 *
	 * Rueckgabewert von void auf boolean geaendert.
	 * Check das mal!
	 *
	 * @param geg
	 * @return boolean
	 */
	public boolean anlegen(Gegenstand geg) {
        if(anlegbar(geg)) {
        	if(handR == null && geg.istWaffe()) {
        		handR = geg;
        		angriffswert = angriffswert + geg.gibAngriffswert();
        		
        		// Kontroll-Ausgabe
        		System.out.println("Gegenstand "+geg.toString()+" wurde angelegt.");
        		
        		return true;
        	}
        	else if(handL == null && (geg.istWaffe() || geg.istSchild())) {
        		handL = geg;
        		angriffswert = angriffswert + geg.gibAngriffswert();
        		verteidigungswert = verteidigungswert + geg.gibVerteidigungswert();

        		// Kontroll-Ausgabe
        		System.out.println("Gegenstand "+geg.toString()+" wurde angelegt.");
        		
        		return true;
        	} else {
        		return false;
        	}
        } else {
        	// Kontroll-Ausgabe
            System.out.println("Gegenstand "+geg.toString()+" wurde nicht angelegt.");
            
        	return false;
        }
	}
	
	/**
	 * 
	 * Rueckgabewert von void auf boolean geaendert.
	 * 
	 * Check das mal!
	 * 
	 * @param geg
	 * @return boolean
	 */
	public boolean einpacken(Gegenstand geg) {
		if(rucksack.einpacken(geg)) {
			return true;
		} else {
			return false;
		}
	}
	public Gegenstand ablegen(int hand) {
		Gegenstand geg = null;
		if(hand == 1) {
			geg = handR;
			handR = null;
			
			// Nicht angriffswert - geg.gitAnngriffswert()?
            angriffswert = angriffswert +geg.gibAngriffswert();
		}
		else if(hand == 2) {
			geg = handL;
			handL = null;
			
			// Siehe oben!
            angriffswert = angriffswert +geg.gibAngriffswert();
            verteidigungswert = verteidigungswert +geg.gibVerteidigungswert();
		}
		
		// Warum immer diese leeren else-Klauseln? :D
		// Kšnnen die nicht wegfallen?
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
	
	// Wuerde ich auch mit boolean realisieren. Was sagst du?
	public void ausDemRucksackAnlegen(String n) {
		Gegenstand geg = null;
		geg = rucksack.auspacken(n);
		anlegen(geg);
	}
	
	public Gegenstand rucksackEntfernen(String n) {
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
