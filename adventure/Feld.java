
package adventure;

import java.awt.Color;
import java.awt.Graphics;

/**
*
* @author Timo Schrappe, Nils Preuschoff
*/

public class Feld {
	int xPos, yPos, typ;
	
	public Feld(int x, int y, int t) {
		xPos = x;
		yPos = y;
		typ = t;
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
	}
}
