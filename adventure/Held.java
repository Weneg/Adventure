
package adventure;
import java.awt.*;
/**
*
* @author Timo Schrappe, Nils Preuschoff
*/

public class Held extends Person {
	
	public Held(String n, int kraft) {
		super(n, kraft);
	}
	
	public void anzeigen(Graphics g, int feldbreite) {
		g.setColor(new Color(255,0,0));
		
		int x = xPos*feldbreite; 
		int y = yPos*feldbreite;
		
		g.fillOval(x, y, feldbreite+2, feldbreite+2);
		
		super.anzeigen(g,feldbreite);
	}
}
