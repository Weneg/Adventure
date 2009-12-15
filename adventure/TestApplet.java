
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
public class TestApplet extends JApplet implements KeyListener, Runnable {

	Dungeon d;
	Gegenstand g1;
	Held h1;
	Thread timer;
	
	/**
	 * Inizialisiert verschiedene Attribute verschiedener Klassen
	 */
	public void init() {
		setSize(800, 600);
		int h = getHeight();
		int w = getWidth();
		
		d = new Dungeon(w, h);
		g1 = new Gegenstand("Schwert", 50.0, 40.0, 200.0, 10, 1);
		d.f[4][4].aufDenBodenLegen(g1);
		addKeyListener(this);
	}
	/**
	 * Ist fuer den Start des timers zustaending, sollte dieser nicht initiallisiert sein
	 */
	public void start() {
		if(timer == null) {
			timer = new Thread(this);
			timer.start();
		}
	}
	/**
	 * Stopt den Timer, sollte dieser nicht initiallisiert werden
	 */
	public void stop() {
		if(timer != null) {
			timer.stop();
			timer = null;		
		}
	}
	/**
	 * Loest eine Bewegung der Monster alle 200 Millisekunden aus
	 */
	public void run() {
		while(true) {
			d.monsterBewegen();
			repaint();
			try {
				Thread.sleep(200);
			}
			catch(InterruptedException e) {}
		}
	}
	/**
	 * Faengt Tastatureingaben ab
	 */
	public void keyPressed(KeyEvent event) {
		switch(event.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				d.heldLinks();
				repaint();
				break;
			case KeyEvent.VK_RIGHT:
				d.heldRechts();
				repaint();
				break;
			case KeyEvent.VK_UP:
				d.heldHoch();
				repaint();
				break;
			case KeyEvent.VK_DOWN:
				d.heldRunter();
				repaint();
				break;
			case KeyEvent.VK_ENTER:
				d.heldAufsammeln();
				repaint();
				break;
		}
	}
	
	public void keyReleased(KeyEvent event) {}
	public void keyTyped(KeyEvent event) {}
	
	/**
	 * Zeichnet das Dungeon als Applet
	 * 
	 * @param g Objekt der Klasse Graphics
	 */
	public void paint(Graphics g) {
		d.anzeigen(g);
	}
}
