package adventure;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Infofenster extends JFrame implements MouseListener, ActionListener {

	Person pers;
	Formen form;
	Button schliessenButton, rucksackButton;
	RucksackFenster rucksack;
	
	public Infofenster(Person pers) {
		super("Held");
		
		this.pers = pers;
		form = new Formen();
		
		schliessenButton = new Button("Schlie§en");
		rucksackButton = new Button("Rucksack");
		add(schliessenButton);
		add(rucksackButton);
		schliessenButton.setBounds(14, 160, 80, 20);
		rucksackButton.setBounds(200, 20, 100, 100);
		schliessenButton.addActionListener(this);
		rucksackButton.addActionListener(this);
		
		setLayout(null);
		setSize(330,220);
		setVisible(true);
	}
	
	public void mouseClicked(MouseEvent e) {
		repaint();
	}
	public void mouseExited(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == rucksackButton) {
			rucksack = new RucksackFenster(pers.getInventar());
		} else if(e.getSource() == schliessenButton) {
			this.setVisible(false);
		}
		repaint();
	}
}
