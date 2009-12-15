package adventure;
import java.awt.*;

public class Formen {
	public void rechteck3D(Graphics g, int x, int y, int breite, int hoehe, Color farbe) {
		g.setColor(farbe);
		g.fillRect(x, y, breite, hoehe);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, breite, hoehe);
		g.drawRect(x, y, breite+1, hoehe+1);
	}
	
	public void textkasten3D(Graphics g, String text, int x, int y, int breite, Color farbe) {
		rechteck3D(g, x, y, breite, 18, farbe);
		g.drawString(text, x+5, y+14);
	}
}
