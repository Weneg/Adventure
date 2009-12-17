
package adventure;

import java.awt.Color;
import java.awt.Graphics;

/**
*
* @author Timo Schrappe, Nils Preuschoff
*/

public abstract class Person {
	private String  name;
	private int	kraft;
	private double life;

	private Inventar rucksack;
	private Gegenstand handL, handR;
	
	private double angriffswert;
	private double verteidigungswert;
	
	protected int xPos;
	protected int yPos;
	

	Infofenster info;

	/**
	 * Konstruktor der Klasse Person
	 * @param n
	 * @param k
	 */
	public Person(String n, int k) {
		name = n;
		kraft = k;
		rucksack = new Inventar(k);
		handL = null;
		handR = null;
		life = 100;
		xPos = 1;
		yPos = 1;
	}
	
	public void infoZeigen() {
		info = new Infofenster(this);
	}
	
	/**
	 * Gibt den X-Wert fuer das Feld zurueck.
	 * 
	 * @return int
	 */
	public int getXWert() {
		return xPos;
	}
	
	/**
	 * Gibt den Y-Wert fuer das Feld zurueck.
	 * 
	 * @return int
	 */
	public int getYWert() {
		return yPos;
	}
	
	/**
	 * Setzt die Position fuer xPos und yPos
	 * 
	 * @param x int
	 * @param y int
	 */
	public void setztePosition(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	
	/**
	 * Gibt name als String zurueck
	 * 
	 * @return String
	 */
	public String gibName() {
		return name;
	}
	
	/**
	 * Gibt kraft als int zurueck
	 * 
	 * @return int
	 */
	public int gibKraft() {
		return kraft;
	}
	
	/**
	 * Gibt angriffswert als double zurueck
	 * 
	 * @return double
	 */
	public double gibAngriffswert() {
		return angriffswert;
	}
	
	/**
	 * Gibt verteidigungswert als double zurueck
	 * 
	 * @return double
	 */
	public double gibVerteidigungswert() {
		return verteidigungswert;
	}
	
	/**
	 * Gibt life als double zurueck
	 * 
	 * @return double
	 */
	public double gibLife() {
		return life;
	}
	/**
	 * Verringert das Life der Person um den uebergebenen Wert 
	 * Dieser Wert ist als prozentzahl zu verstehen
	 * @param l
	 * @return double
	 */
	public double verringerLifeUmProzent(int l) {
		life = life - ((life/100) * l);
		System.out.println(life);
		return life;
	}
	
	/**
	 * Legt geg der Klasse Gegenstand in die rechte oder linke Hand.
	 * Die linke Hand kann auch ein Schild aufnehmen.
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
	 * Legt den Gegenstand geg in rucksack der Klasse Inventar zurueck.
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
	
	/**
	 * Legt den Gegenstand in hand ab und liefert diesen als Rueckgabewert.
	 * 
	 * @param hand
	 * @return Gegenstand
	 */
	public Gegenstand ablegen(int hand) {
		Gegenstand geg = null;
		if(hand == 1) {
			geg = handR;
			handR = null;
            angriffswert = angriffswert - geg.gibAngriffswert();
		}
		else if(hand == 2) {
			geg = handL;
			handL = null;
            angriffswert = angriffswert - geg.gibAngriffswert();
            verteidigungswert = verteidigungswert - geg.gibVerteidigungswert();
		}
		return geg;
	}
	
	/**
	 * Verstaut den Gegenstand aus der Hand hand in den rucksack der Klasse Inventar zurueck.
	 * 
	 * @param hand
	 */
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
		rucksack.einpacken(geg);
	}
	
	/**
	 * Legt n aus rucksack der Klasse Inventar in eine Hand
	 * 
	 * @param n
	 * @return boolean
	 */
	public boolean ausDemRucksackAnlegen(String n) {
		if(rucksack.istImInventar(n)) {
			Gegenstand geg = null;
			geg = rucksack.auspacken(n);
			anlegen(geg);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Entfernt n aus rucksack der Klasse Inventar und gibt diesen zurueck.
	 * 
	 * @param n
	 * @return Gegenstand
	 */
	public Gegenstand rucksackEntfernen(String n) {
		Gegenstand geg = null;
        geg = rucksack.auspacken(n);
        System.out.println("Gegenstand "+geg.toString()+" wurde ausgepackt.");
		return geg;
	}
	
	/**
	 * Prueft ob geg anlegbar ist. Wenn rucksack.gewicht + geg.gewicht kleiner oder gleich maximalgewicht ist, ist geg anlegbar.
	 * 
	 * @param geg
	 * @return boolean
	 */
	public boolean anlegbar(Gegenstand geg) {
		boolean ergebnis = false;
        if(rucksack.getMaximalgewicht() >= (rucksack.gibGewicht() + geg.gibGewicht())) {
        	ergebnis = true;
        }
        else {
            ergebnis = false;
        }
        return ergebnis;
	}
	
	/**
	 * Gibt den Gegenstad der linken Hand aus.
	 * 
	 * @return String
	 */
	public String getHandL() {
		if(handL != null) {
			return handL.gibName();
		} else {
			return "none";
		}
	}
	
	/**
	 * Gibt den Gegenstand der rechten Hand aus.
	 * 
	 * @return String
	 */
	public String getHandR() {
		if(handR != null) {
			return handR.gibName();
		} else {
			return "none";
		}
	}
	
	/**
	 * Zeichnet eine Person
	 * 
	 * @param g
	 */
	public void anzeigen(Graphics g, int b) {
		
		double rot = (100-gibLife())*2.55;
		double gruen = gibLife()*2.55;
		
		g.setColor(new Color((int)rot,(int)gruen,0));
		
    	g.fillOval(b*xPos+2, b*yPos+2, b-3, b-3);
	}
	
	public Inventar getInventar() {
		return rucksack;
	}
}
