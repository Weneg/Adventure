
package adventure;
import java.awt.*;

/**
*
* @author Timo Schrappe, Nils Preuschoff
*/

public class Dungeon {
	Feld[][] f;
	Held hero;
	int appletHoehe;
	int appletBreite;
	
	public Dungeon(int w, int h) {
		f = new Feld[40][30];
		hero = new Held("Bloodsucker", 40);
		appletHoehe = h;
		appletBreite = w;
		
		int feldBreite = this.berechneFeldBreite(f.length, f[0].length);
		
		for(int y = 0; y < 30; y++)
			for(int x = 0; x < 40; x++) {
				if(y == 0 || x == 0 || x == 39 || y == 29 || x == 10 || x == 20 || x == 30 || y == 10 || y == 20) {
					if(x == 10 && (y == 4 || y == 13 || y == 25) || x == 20 && (y == 6 || y == 15 || y == 27) || x == 30 && (y == 2 || y == 15 || y == 23) || (y == 10 && x == 35) || (y == 20 && x == 28)) {
						f[x][y] = new Feld(x,y,0,feldBreite);
					} else {
						f[x][y] = new Feld(x,y,1,feldBreite);
					}
				} else {
					f[x][y] = new Feld(x,y,0,feldBreite);
				}
			}
	}
	
	public int berechneFeldBreite(int feldW, int feldH) {
		int feldBreite = appletBreite / feldW;
		int feldHoehe = appletHoehe / feldH;
		
		if(feldBreite < feldHoehe) {
			return feldBreite;
		} else {
			return feldHoehe;
		}
	}
	

	public void heldRechts() {
		if(f[hero.getXWert()+1][hero.getYWert()].istFrei()) {
			hero.setztePosition(hero.getXWert()+1, hero.getYWert());
		} else {
			hero.verringerLifeUmProzent(10);
		}
	}
	
	public void heldLinks() {
		if(f[hero.getXWert()-1][hero.getYWert()].istFrei()) {
			hero.setztePosition(hero.getXWert()-1, hero.getYWert());
		} else {
			hero.verringerLifeUmProzent(10);
		}
	}
	
	public void heldHoch() {
		if(f[hero.getXWert()][hero.getYWert()-1].istFrei()) {
			hero.setztePosition(hero.getXWert(), hero.getYWert()-1);
		} else {
			hero.verringerLifeUmProzent(10);
		}
	}
	
	public void heldRunter() {
		if(f[hero.getXWert()][hero.getYWert()+1].istFrei()) {
			hero.setztePosition(hero.getXWert(), hero.getYWert()+1);
		} else {
			hero.verringerLifeUmProzent(10);
		}
	}
	
	public void anzeigen(Graphics g) {
		for(int y = 0; y < 30; y++) {
			for(int x = 0; x < 40; x++) {
				f[x][y].anzeigen(g);
			}
		}
		hero.anzeigen(g, berechneFeldBreite(f.length, f[0].length));
	}
}
