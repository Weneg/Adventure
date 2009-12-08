
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
			for(int x = 0; x < 40; x++) {
				if(y == 0 || x == 0 || x == 39 || y == 29 || x == 10 || x == 20 || x == 30 || y == 10 || y == 20) {
					if(x == 10 && (y == 4 || y == 13 || y == 25) || x == 20 && (y == 6 || y == 15 || y == 27) || x == 30 && (y == 2 || y == 15 || y == 23) || (y == 10 && x == 35) || (y == 20 && x == 28)) {
						f[x][y] = new Feld(x,y,0,0);
					} else {
						f[x][y] = new Feld(x,y,1,0);
					}
				} else {
					f[x][y] = new Feld(x,y,0,0);
				}
			}
	}
	
	public void anzeigen(Graphics g) {
		for(int y = 0; y < 30; y++)
			for(int x = 0; x < 40; x++)
				f[x][y].anzeigen(g);
	}
}
