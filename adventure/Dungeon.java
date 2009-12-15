
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
	/**
	 *  Konstruktor der Klasse Dungeon
	 * @param w
	 * @param h
	 */
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
	/**
	 * Berechnet die Feldgroesse aufgrund der Appletgroesse
	 * @param feldW
	 * @param feldH
	 * @return int
	 */
	public int berechneFeldBreite(int feldW, int feldH) {
		int feldBreite = appletBreite / feldW;
		int feldHoehe = appletHoehe / feldH;
		
		if(feldBreite < feldHoehe) {
			return feldBreite;
		} else {
			return feldHoehe;
		}
	}
	
	/**
	 * Laesst den Held ein Feld nach rechts gehen wenn dieses keine Mauer ist 
	 * Sollte es eine Mauer sein sorgt sie für eine Verringerung des Lifes
	 */
	public void heldRechts() {
		if(f[hero.getXWert()+1][hero.getYWert()].istFrei()) {
			hero.setztePosition(hero.getXWert()+1, hero.getYWert());
		} else {
			hero.verringerLifeUmProzent(10);
		}
	}
	
	/**
	 * Laesst den Held ein Feld nach links gehen wenn dieses keine Mauer ist 
	 * Sollte es eine Mauer sein sorgt sie für eine Verringerung des Lifes
	 */	
	public void heldLinks() {
		if(f[hero.getXWert()-1][hero.getYWert()].istFrei()) {
			hero.setztePosition(hero.getXWert()-1, hero.getYWert());
		} else {
			hero.verringerLifeUmProzent(10);
		}
	}
	/**
	 * Laesst den Held ein Feld hoch gehen wenn dieses keine Mauer ist 
	 * Sollte es eine Mauer sein sorgt sie für eine Verringerung des Lifes
	 */	
	public void heldHoch() {
		if(f[hero.getXWert()][hero.getYWert()-1].istFrei()) {
			hero.setztePosition(hero.getXWert(), hero.getYWert()-1);
		} else {
			hero.verringerLifeUmProzent(10);
		}
	}
	/**
	 * Laesst den Held ein Feld runter gehen wenn dieses keine Mauer ist 
	 * Sollte es eine Mauer sein sorgt sie für eine Verringerung des Lifes
	 */
	public void heldRunter() {
		if(f[hero.getXWert()][hero.getYWert()+1].istFrei()) {
			hero.setztePosition(hero.getXWert(), hero.getYWert()+1);
		} else {
			hero.verringerLifeUmProzent(10);
		}
	}
	/**
	 * Laesst das Monster sich zufällig bewegen 
	 * und laesst Gegenstaende aufheben sollte einer auf dem Feld liegen
	 */
	public void monsterBewegen() {
		Gegenstand geg = null;
		for(int i = 0; i < 2; i++) {
			int x = m[i].getXWert();
			int y = m[i].getYWert();
			
			boolean rechts = f[x+1][y].istFrei();
			boolean links = f[x-1][y].istFrei();
			boolean hoch	= f[x][y-1].istFrei();
			boolean runter = f[x][y+1].istFrei();
			m[i].bewegen(links,rechts,hoch,runter);
			if(f[x][y].hatGegenstand()) {
				geg = f[x][y].vomBodenAufheben();
				if(m[i].einpacken(geg)) {
				} else {
					f[x][y].aufDenBodenLegen(geg);
				}
			}
		}
	}
	/**
	 * Zeichnet das Dungeon und loest das zeichnen des Helden und der Monster aus
	 * @param g
	 */
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
	/**
	 * Laesst den Helden Gegenstaende aufsammeln, falls auf dem Feld einer liegt wo er steht und er diesen auch tragen kann
	 * @return
	 */
	public boolean heldAufsammeln() {
		Gegenstand geg = null;
		int x =hero.getXWert();
		int y = hero.getYWert();
		if(f[x][y].hatGegenstand()) {
			geg = f[x][y].vomBodenAufheben();
			if(hero.einpacken(geg)) {
				return true;
			} else {
				f[x][y].aufDenBodenLegen(geg);
				return false;
			}
		} else {
			return false;
		}
	}
}
