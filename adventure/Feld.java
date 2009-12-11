
package adventure;

import java.awt.Color;
import java.awt.Graphics;

/**
*
* @author Timo Schrappe, Nils Preuschoff
*/

public class Feld {
	int xPos, yPos, typ, breite;
	Gegenstand geg;
	
	public Feld(int x, int y, int t, int b) {
		xPos = x;
		yPos = y;
		typ = t;
		geg = null;
		breite = b;
	}
	
	/**
	 * Legt g der Klasse Gegenstand auf dem Feld ab
	 * 
	 * @param g
	 * @return boolean
	 */
	public boolean aufDenBodenLegen(Gegenstand g) {
		if(g instanceof Gegenstand) {
			geg = g; 
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Liefert eine Instanz der Klasse Gegenstand zurueck und loescht anschliessend
	 * den Gegenstand von dem Feld.
	 * 
	 * @return Gegenstand
	 */
	public Gegenstand vomBodenAufheben() {
		if(hatGegenstand()) {
			Gegenstand temp = geg;
			geg = null;
			return temp;
		} else {
			return null;
		}
	}
	
	/**
	 * Prueft das Feld auf einem Gegenstand.
	 * @return
	 */
	public boolean hatGegenstand() {
		return (geg != null);
	}
	
	/**
	 * Zeichnet ein Feld. Die Farbe variiert nach typ.
	 * Hat das Feld ein Gegenstand zeichnet es diesen anschliežend ein.
	 * 
	 * @param g
	 */
	public void anzeigen(Graphics g) {
		if(typ == 0) {
			g.setColor(new Color(255,255,191));
		} else if(typ == 1) {
				g.setColor(new Color(91,91,91));
		} else {
			g.setColor(new Color(255,255,255));
		}
		
		g.fillRect(20*xPos, 20*yPos, 20, 20);
		
		g.setColor(new Color(0,0,0));
		g.drawRect(20*xPos, 20*yPos, 20, 20);
		
		if(hatGegenstand()) {
			geg.anzeigen(g, 4, 4);
		}
	}
}
