
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
public class TestApplet extends JApplet implements KeyListener, Runnable, MouseListener {

	Dungeon d;
	Gegenstand g1;
	Thread timer;
	Infofenster info;
	
	String msg;
	
	/**
	 * Inizialisiert verschiedene Attribute verschiedener Klassen
	 */
	public void init() {
		setSize(800, 600);
		int h = getHeight();
		int w = getWidth();
		msg = "0 / 0";
		
		d = new Dungeon(w, h);
		g1 = new Gegenstand("Schwert", 50.0, 40.0, 200.0, 10, 1);
		d.f[4][4].aufDenBodenLegen(g1);
		
		addMouseListener(this);
		addKeyListener(this);
	}
	
	public void start() {
		if(timer == null) {
			timer = new Thread(this);
			timer.start();
		}
	}
	public void stop() {
		if(timer != null) {
			timer.stop();
			timer = null;		
		}
	}
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
	
	public void mouseClicked(MouseEvent e) {
		this.getFeldKoordinaten(e);		
		
		if(getFeldX(e) > d.hero.getXWert() && d.hero.getYWert() == getFeldY(e)) {
			d.heldRechts();
		} else if(getFeldX(e) < d.hero.getXWert() && d.hero.getYWert() == getFeldY(e)) {
			d.heldLinks();
		} else if(getFeldY(e) > d.hero.getYWert() && d.hero.getXWert() == getFeldX(e)) {
			d.heldRunter();
		} else if(getFeldY(e) < d.hero.getYWert() && d.hero.getXWert() == getFeldX(e)) {
			d.heldHoch();
		}
		
		if(d.istHeldFeld(getFeldX(e), getFeldY(e))) {
			d.infoHeldZeigen();
		}
		
		repaint();
	}
	
	public int getFeldX(MouseEvent e) {
		return e.getX() / d.f[0][0].getBreite();
	}
	
	public int getFeldY(MouseEvent e) {
		return e.getY() / d.f[0][0].getBreite();
	}
	
	public String getFeldKoordinaten(MouseEvent e) {
		return msg = getFeldX(e)+" / "+getFeldY(e);
	}
	
	public void mouseExited(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
	/**
	 * Zeichnet die Dangeon als Applet
	 * 
	 * @param g Objekt der Klasse Graphics
	 */
	public void paint(Graphics g) {
		d.anzeigen(g);
		g.drawString(msg, getWidth()-150, 15);
	}
}
