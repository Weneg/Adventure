
package adventure;
import java.awt.*;

/**
*
* @author Timo Schrappe, Nils Preuschoff
*/

public class Dungeon {
	Feld[][] f;
	
	public Dungeon() {
		f = new Feld[40][30];
		
		for(int y = 0; y < 30; y++)
			for(int x = 0; x < 40; x++)
				f[x][y] = new Feld(x,y,0);
	}
	
	public void anzeigen(Graphics g) {
		for(int y = 0; y < 30; y++)
			for(int x = 0; x < 40; x++)
				f[x][y].anzeigen(g);
	}
}
