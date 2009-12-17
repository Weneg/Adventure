package adventure;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;

public class RucksackFenster extends JFrame implements ActionListener {
	
	Inventar rucksack;
	Button schliessenButton;
	Formen form;

	public RucksackFenster(Inventar rucks) {
		super("Rucksack");
		
		rucksack = rucks;
		
		form = new Formen();
		
		setSize(290,380);
		setVisible(true);
		setLayout(null);
		
		schliessenButton = new Button("Schlie§en");
		add(schliessenButton);
		schliessenButton.setBounds(20,320,60,20);
		schliessenButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == schliessenButton) {
			setVisible(false);
		}
		repaint();
	}
	
	public void paint(Graphics g) {
		form.rechteck3D(g, 10, 30, 270, 290, Color.WHITE);
		
		g.drawString("Name", 20, 50);
		g.drawString("Angr.", 95, 50);
		g.drawString("Vert.", 150, 50);
		g.drawString("Gold", 205, 50);
		
		for(int i = 0; i < rucksack.gibAnzahl(); i++) {
			if(rucksack.gibInhalt()[i] != null) {
				form.textkasten3D(g, rucksack.gibInhalt()[i].gibName(), 20, 55+(i*23), 70, Color.YELLOW);
				form.textkasten3D(g, Double.toString(rucksack.gibInhalt()[i].gibAngriffswert()), 95, 55+(i*23), 50, Color.YELLOW);
				form.textkasten3D(g, Double.toString(rucksack.gibInhalt()[i].gibVerteidigungswert()), 150, 55+(i*23), 50, Color.YELLOW);
				form.textkasten3D(g, Double.toString(rucksack.gibInhalt()[i].gibGoldwert()), 205, 55+(i*23), 50, Color.YELLOW);
			} else {
				g.setColor(Color.RED);
				g.drawString("Ihr Rucksack ist leer!", 50,150);
				break;
			}
		}
	}
	
}
