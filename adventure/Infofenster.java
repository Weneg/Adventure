package adventure;
import javax.swing.*;
import java.awt.*;

public class Infofenster extends JFrame {

	Person pers;
	Formen form;
	JButton lButton;
	
	public Infofenster(Person pers) {
		super("Held");
		
		this.pers = pers;
		form = new Formen();
		
		lButton = new JButton("Schlie§en");
		add(lButton);
		lButton.setBounds(14, 160, 80, 20);
		setLayout(null);
		setSize(185,220);
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		form.rechteck3D(g, 10, 30, 160, 137, Color.WHITE);
		
		form.textkasten3D(g, "Name", 14, 34, 60, Color.YELLOW);
		form.textkasten3D(g, pers.gibName(), 80, 34, 85, Color.YELLOW);
		
		form.textkasten3D(g, "Kraft", 14, 56, 60, Color.YELLOW);
		form.textkasten3D(g,Integer.toString(pers.gibKraft()), 80, 56, 85, Color.YELLOW);
		
		form.textkasten3D(g, "Leben", 14, 78, 60, Color.YELLOW);
		form.textkasten3D(g, Double.toString(pers.gibLife()), 80, 78, 85, Color.YELLOW);
		
		form.textkasten3D(g, "Angrfw.", 14, 100, 60, Color.YELLOW);
		form.textkasten3D(g, Double.toString(pers.gibAngriffswert()), 80, 100, 85, Color.YELLOW);
		
		form.textkasten3D(g, "Vertgw.", 14, 122, 60, Color.YELLOW);
		form.textkasten3D(g, Double.toString(pers.gibVerteidigungswert()), 80, 122, 85, Color.YELLOW);
		
		form.textkasten3D(g, pers.getHandL(), 14, 144, 60, Color.YELLOW);
		
		form.textkasten3D(g, pers.getHandR(), 80, 144, 85, Color.YELLOW);

	}
}
