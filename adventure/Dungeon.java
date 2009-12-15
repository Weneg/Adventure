
package adventure;
import java.awt.*;

/**
*
* @author Timo Schrappe, Nils Preuschoff
*/

public class Dungeon {
	Feld[][] f;
	Held hero;
	Monster[] m;
	int appletHoehe;
	int appletBreite;
	
	public Dungeon(int w, int h) {
		f = new Feld[40][30];
		hero = new Held("Bloodsucker", 40);
		m = new Monster[10];
		
		appletHoehe = h;
		appletBreite = w;
		
		int feldBreite = this.berechneFeldBreite(f.length, f[0].length);
		
		Monster m1 = new Monster("Bloodsucker", 30);
		Monster m2 = new Monster("Timo", 40);
		
		m[0] = m1;
		m[1] = m2;
		
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
	
	public void monsterBewegen() {
		for(int i = 0; i < 2; i++) {
			int x = m[i].getXWert();
			int y = m[i].getYWert();
			
			boolean rechts = f[x+1][y].istFrei();
			boolean links = f[x-1][y].istFrei();
			boolean hoch	= f[x][y-1].istFrei();
			boolean runter = f[x][y+1].istFrei();
			m[i].bewegen(links,rechts,hoch,runter);
		}
	}
	
	public void anzeigen(Graphics g) {
		for(int y = 0; y < 30; y++) {
			for(int x = 0; x < 40; x++) {
				f[x][y].anzeigen(g);
			}
		}
		hero.anzeigen(g, berechneFeldBreite(f.length, f[0].length));
		for(int i = 0; i < 2; i++){
			m[i].anzeigen(g, berechneFeldBreite(f.length, f[0].length));
		}
	}
	public boolean heldAufsammeln() {
		Gegenstand geg = null;
		int x =hero.getXWert();
		int y = hero.getYWert();
		if(f[x][y].hatGegenstand()) {
			geg = f[x][y].vomBodenAufheben();
			return hero.einpacken(geg);
		} else {
			return false;
		}
	}
}
