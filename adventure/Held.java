
package adventure;
import java.awt.Color;
import java.awt.Graphics;

/**
*
* @author Timo Schrappe, Nils Preuschoff
*/

public class Held extends Person {
	
	private int xPos;
	private int yPos;
	
	public Held(String n, int kraft) {
		super(n, kraft);
		xPos = 1;
		yPos = 1;
	}
	
	public int getXWert() {
		return xPos;
	}
	
	public int getYWert() {
		return yPos;
	}
	
	public void setztePosition(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	public void anzeigen(Graphics g, int b) {
		g.setColor(new Color(255,0,255));
    	g.fillOval(b*xPos+2, b*yPos+2, b-3, b-3);
	}
}
