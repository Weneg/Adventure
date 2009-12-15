
package adventure;
import java.util.Random;

/**
*
* @author Timo Schrappe, Nils Preuschoff
*/

public class Monster extends Person {
	Random rand;
	/**
	 * Konstruktor der Klasse Monster
	 * @param n
	 * @param kraft
	 */
	public Monster(String n, int kraft) {
		super(n, kraft);
		rand = new Random();
	}
	/**
	 * Loest eine zufaellige Bewegung auf ein benachbartes Feld aus
	 * @param links
	 * @param rechts
	 * @param oben
	 * @param unten
	 */
	public void bewegen(boolean links, boolean rechts, boolean oben, boolean unten) {
		int richtung = rand.nextInt(4)+1;
		switch(richtung) {
		case 1: if(links)	setztePosition(xPos-1, yPos); break;
		case 2: if(rechts)	setztePosition(xPos+1, yPos); break;
		case 3: if(oben)	setztePosition(xPos, yPos-1); break;
		case 4: if(unten)	setztePosition(xPos, yPos+1); break;
		}
	}
}
