/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure;
import java.awt.*;

/**
 *
 * @author Timo Schrappe, Nils Preuschoff
 */
public class Gegenstand {
    private String name;
    private double angriffswert;
    private double verteidigungswert;
    private double goldwert;
    private double zustand;
    private double gewicht;
    private int typ;
    
    /**
     * Konstruktor der Klasse Gegenstand 
     * @param name
     * @param angriffswert
     * @param verteidigungswert
     * @param goldwert
     * @param gewicht
     * @param typ
     */
    public Gegenstand(String name, double angriffswert, double verteidigungswert, double goldwert, double gewicht, int typ) {
        this.name = name;
        this.angriffswert = angriffswert;
        this.verteidigungswert = verteidigungswert;
        this.goldwert = goldwert;
        this.zustand = 100;
        this.gewicht = gewicht;
        this.typ = typ;
    }
    /**
     * Gibt den Angriffwert zurueck
     * @return double
     */
    public double gibAngriffswert() {
        return angriffswert;
    }
    
    public String gibName() {
    	return name;
    }
    
	/**
	 * Setzt den Angriffswert auf einen anderen Wert
	 * @param angw
	 */
    public void setAngriffswert(double angw) {
    	this.angriffswert = angw;
    }
    /**
     * Gibt den Verteidigungswert zurueck
     * @return double
     */
    public double gibVerteidigungswert() {
        return verteidigungswert;
    }
    /**
     * Setzt den Verteidigungswert auf einen anderen Wert
     * @param vertw
     */
    public void setVerteidigungswert(double vertw) {
    	this.verteidigungswert = vertw;
    }
    /**
     * Gibt den Goldwert zurueck
     * @return double
     */
    public double gibGoldwert() {
        return goldwert;
    }
    /**
     * Setzt den Goldwert auf einen anderen Wert
     * @param goldw
     */
    public void setGoldwert(double goldw) {
    	this.goldwert = goldw;
    }
    /**
    * Gibt den Zustand zurueck
 	* @return double
 	*/
    public double gibZustand() {
        return zustand;
    }
    /**
    * Gibt das Gewicht zurueck
  	* @return double
  	*/
    public double gibGewicht() {
        return gewicht;
    }
    /**
    * Setzt das Gewicht auf einen anderen Wert
  	* @param gew
  	*/    
    public void setGewicht(double gew) {
    	this.gewicht = gew;
    }
    /**
     * Diese Methode beschaedigt den Gegenstand
     * @param schaden
     */
    public void beschaedigen(int schaden) {
        this.angriffswert = this.angriffswert - (this.angriffswert / 100) * schaden;
        this.verteidigungswert = this.verteidigungswert - (this.verteidigungswert / 100) * schaden;
        this.goldwert = this.goldwert - (this.goldwert / 100) * schaden;
        this.zustand = this.zustand - (this.zustand / 100) * schaden;
        System.out.println("Der Angriffswert wurde beschaedigt, er betrÃ¤gt nun "+this.angriffswert);
        System.out.println("Der Verteidigungswert wurde beschaedigt, er betrÃ¤gt nun "+this.verteidigungswert);
        System.out.println("Der Goldwert ist gesunken, er betrÃ¤gt nun "+this.goldwert);
        System.out.println("Der Zustand ist nun auf "+this.zustand+"%");
    }
    /**
     * Diese Methode repariert den Gegenstand
     */
    public void reparieren() {
        this.angriffswert = this.angriffswert + (this.angriffswert / this.zustand ) * (100 - this.zustand);
        this.verteidigungswert = this.verteidigungswert + (this.verteidigungswert / this.zustand) * (100 - this.zustand);
        this.goldwert = this.goldwert + (this.goldwert / this.zustand) * (100 - this.zustand);
        this.zustand = 100;
        System.out.println("Angriffswert ist nun "+this.angriffswert);
        System.out.println("Verteidigungswert ist nun "+this.verteidigungswert);
        System.out.println("Goldwert ist nun "+this.goldwert);
        System.out.println("Zustand ist nun "+this.zustand);
    }
    /**
     * Gibt den Namen des Objektes zurueck
     */
    @Override
    public String toString() {
        return this.name;
    }
    /**
     * Gibt den Typ des Gegentands zurueck
     * @return int
     */
    public int gibTyp() {
    	return typ;
    }
    /**
     * Gibt ueber einen Boolean zurück, ob es sich um eine Waffe handelt
     * @return boolean
     */
    public boolean istWaffe() {
    	if(typ == 1) {
    		return true;
    	}
    	else  {
    		return false;
    	}
    }
    /**
     * Gibt ueber einen Boolean zurück, ob es sich um einen Schild handelt
     * @return boolean
     */
    public boolean istSchild() {
    	if(typ == 2) {
    		return true;
    	}
    	else  {
    		return false;
    	}
    }
    /**
     * Zeichnet ein Zeichen für den Gegenstand auf das Feld
     * @param g
     * @param x
     * @param y
     * @param b
     */
    public void anzeigen(Graphics g, int x, int y, int b) {
    	g.setColor(new Color(0,0,255));
    	g.fillRect(b*x+2, b*y+2, b-3, b-3);
    }
}
