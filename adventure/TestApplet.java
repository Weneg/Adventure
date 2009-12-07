
package adventure;
import java.awt.*;
import javax.swing.*;

/**
*
* @author Timo Schrappe, Nils Preuschoff
*/

public class TestApplet extends JApplet {
	Dungeon d;
	
	public void init() {
		d = new Dungeon();
	}
	
	public void paint(Graphics g) {
		d.anzeigen(g);
	}
}
