
package adventure;
import java.awt.*;
import javax.swing.*;

/**
* Klasse TestApplet zum testen der Anwendung auf Applet-Ebene
*
* @author Timo Schrappe, Nils Preuschoff
* 
*/
public class TestApplet extends JApplet {

	Dungeon d;
	Gegenstand g1;
	
	/**
	 * Inizialisiert verschiedene Attribute verschiedener Klassen
	 */
	public void init() {
		d = new Dungeon();
		g1 = new Gegenstand("Schwert", 50.0, 40.0, 200.0, 10, 1);
		d.f[4][4].aufDenBodenLegen(g1);
	}
	
	/**
	 * Zeichnet die Dangeon als Applet
	 * 
	 * @param g Objekt der Klasse Graphics
	 */
	public void paint(Graphics g) {
		d.anzeigen(g);
	}
}
