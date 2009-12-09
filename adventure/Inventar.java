/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adventure;

/**
 * @author Timo Schrappe, Nils Preuschoff
 */
public class Inventar {
	/**
	 * Maximale Anzahl der Gegenstand Objekte
	 */
    private static final int max = 32;
    
    private Gegenstand[] liste;
    private int anzahl;
    private int maximalgewicht;
    private int gewicht;
    
    public Inventar() {
        liste = new Gegenstand[max];
        anzahl = 0;
        maximalgewicht = 20;
        gewicht = 0;
    }
    
    /**
     * Entfernt den Gegenstand am index i aus der liste[]
     * 
     * @param i
     * @return boolean
     */
	private boolean entferne(int i) {
	    if(liste[i] != null) {
	        liste[i] = null;
	        return true;
	    } else {
	    	return false;
	    }
	}

	/**
	 * 
	 * Rueckgabewert auf boolean geaendert. 
	 * Noetig fŸr Person.einpacken(geg)
	 * 
	 * Check das mal!
	 * 
	 * @param geg
	 * @return boolean
	 */
    public boolean einpacken(Gegenstand geg) {
        liste[anzahl] = geg;
        anzahl = anzahl+1;
        gewicht = gewicht + geg.gibGewicht();
        return true;
    }

    /**
     * "Packt" den Gegenstand String s aus, setzt das gewicht und anzahl runter.
     * Gibt null zurueck wenn der Gegenstand nicht in liste[] ist.
     * 
     * @param s
     * @return Gegenstand
     */
    public Gegenstand auspacken(String s) {
        int pos = enthaelt(s);

        if(pos > -1) {
            Gegenstand temp = liste[pos];
            entferne(pos);
            for(int i = 0; i<=pos; i++) {
                liste[i] = liste[i+1];
            }
            gewicht = gewicht - temp.gibGewicht();
            anzahl --;
            return temp;
        } else {
        	// Kontroll-Ausgabe
            System.out.println(s+" ist nicht im Inventar");
            return null;
        }
    }
    
    /**
     * Sucht in liste[] nach String g und gibt den index wert als int zurueck
     * Wenn der Gegenstand nicht in liste[] ist gibt die Methode -1 zurueck
     * 
     * @param g
     * @return int
     */
    public int enthaelt(String g) {
        int pos = -1;
        for(int i = 0; i < liste.length; i++) {
            if(g == liste[i].toString()) {
                pos = i;
                break;
            } else {
                pos = -1;
                continue;
            }
        }
        return pos;
    }
    
    /**
     * 
     * Gibt einen boolschen Wert zurueck wenn der Gegenstand im Inventar ist
     * 
     * @param geg
     * @return boolean
     */
    public boolean istImInventar(String geg) {
    	boolean existiert = false;
    	for(int i = 0; i < liste.length; i++) {
    		if(geg == liste[i].toString()) {
    			existiert = true;
    			break;
    		} else {
    			existiert = false;
    			continue;
    		}
    	}
    	return existiert;
    }
    
    /**
     * Sortiert liste[] nach:
     * 1: Angriffswert
     * 2: Verteidigungswert
     * 3: Gewicht
     * 4: Goldwert
     * 
     * Bei 0 oder anderen Werten wird die Methode verlassen
     * 
     * @param modus
     */
    public void sortieren(int modus) {

        for(int i = 0; i < anzahl; i++) {
        		switch(modus) {
                // Absteigend nach Angriffswert
                case 1:
                	for(int in = 0; in < anzahl-1-i; in++) {
            			if(liste[in].gibAngriffswert() > liste[in+1].gibAngriffswert()) {
            				Gegenstand temp = liste[in];
            				liste[in] = liste[in+1];
            				liste[in+1] = temp;
            			}
            		}
                	break;
                // Absteigend nach Verteidigungswert
                case 2:
                	for(int in = 0; in < anzahl-1-i; in++) {
            			if(liste[in].gibVerteidigungswert() > liste[in+1].gibVerteidigungswert()) {
            				Gegenstand temp = liste[in];
            				liste[in] = liste[in+1];
            				liste[in+1] = temp;
            			}
            		}
                	break;
                // Absteigend nach Gewicht
                case 3:
                	for(int in = 0; in < anzahl-1-i; in++) {
            			if(liste[in].gibGewicht() > liste[in+1].gibGewicht()) {
            				Gegenstand temp = liste[in];
            				liste[in] = liste[in+1];
            				liste[in+1] = temp;
            			}
            		}
                	break;
            	// Absteigend nach Goldwert
                case 4:
                	for(int in = 0; in < liste.length; in++) {
            			if(liste[in].gibGoldwert() > liste[in+1].gibGoldwert()) {
            				Gegenstand temp = liste[in];
            				liste[in] = liste[in+1];
            				liste[in+1] = temp;
            			}
            		}
                	break;
                default:
                	break;
                }
        	}
        }
    
    /**
     * Setzt maximalgewicht
     * 
     * @param maximalgewicht Gewichtangabe als int
     */
    public void setMaximalgewicht(int maximalgewicht) {
        this.maximalgewicht = maximalgewicht;
    }
    
    /**
     * Gibt gewicht aus
     * 
     * @return int
     */
    public int gibGewicht() {
        return gewicht;
    }
    
    /**
     * Gibt maximalgewicht aus
     * 
     * @return int
     */
    public int getMaximalgewicht() {
        return maximalgewicht;
    }
}
