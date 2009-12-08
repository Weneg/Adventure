
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
	
	public void aufDenBodenLegen(Gegenstand g) {
		geg = g;
	}
	
	public Gegenstand vomBodenAufheben() {
		if(hatGegenstand()) {
			Gegenstand temp = geg;
			geg = null;
			return temp;
		} else {
			return null;
		}
	}
	
	public boolean hatGegenstand() {
		return (geg != null);
	}

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
