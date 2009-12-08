
package adventure;
import java.awt.*;
import javax.swing.*;

/**
*
* @author Timo Schrappe, Nils Preuschoff
*/

public class TestApplet extends JApplet {
	Dungeon d;
	Gegenstand g1;
	
	public void init() {
		d = new Dungeon();
		g1 = new Gegenstand("Schwert", 50.0, 40.0, 200.0, 10, 1);
		d.f[4][4].aufDenBodenLegen(g1);
		System.out.println(getHeight());
	}
	
	public void paint(Graphics g) {
		d.anzeigen(g);
	}
}
