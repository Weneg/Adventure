
package adventure;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
* Klasse TestApplet zum testen der Anwendung auf Applet-Ebene
*
* @author Timo Schrappe, Nils Preuschoff
* 
*/
public class TestApplet extends JApplet implements KeyListener {

	Dungeon d;
	Gegenstand g1;
	Held h1;
	
	/**
	 * Inizialisiert verschiedene Attribute verschiedener Klassen
	 */
	public void init() {
		setSize(800, 600);
		int h = getHeight();
		int w = getWidth();
		
		h1 = new Held("Bloodsucker", 40);
		d = new Dungeon(w, h);
		g1 = new Gegenstand("Schwert", 50.0, 40.0, 200.0, 10, 1);
		d.f[4][4].aufDenBodenLegen(g1);
		addKeyListener(this);
	}
	
	public void keyPressed(KeyEvent event) {
		switch(event.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				d.heldLinks(h1);
				repaint();
				break;
			case KeyEvent.VK_RIGHT:
				d.heldRechts(h1);
				repaint();
				break;
			case KeyEvent.VK_UP:
				d.heldHoch(h1);
				repaint();
				break;
			case KeyEvent.VK_DOWN:
				d.heldRunter(h1);
				repaint();
				break;
		}
	}
	
	public void keyReleased(KeyEvent event) {}
	public void keyTyped(KeyEvent event) {}
	
	/**
	 * Zeichnet die Dangeon als Applet
	 * 
	 * @param g Objekt der Klasse Graphics
	 */
	public void paint(Graphics g) {
		d.anzeigen(g);
		h1.anzeigen(g, 20);
	}
}
