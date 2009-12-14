/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure;
import java.awt.*;

/**
 *
 * @author Timo Schrappe, Nils Preuschoff
 */
public class Gegenstand {
    private String name;
    private double angriffswert;
    private double verteidigungswert;
    private double goldwert;
    private double zustand;
    private int gewicht;
    private int typ;

    public Gegenstand(String name, double angriffswert, double verteidigungswert, double goldwert, int gewicht, int typ) {
        this.name = name;
        this.angriffswert = angriffswert;
        this.verteidigungswert = verteidigungswert;
        this.goldwert = goldwert;
        this.zustand = 100;
        this.gewicht = gewicht;
        this.typ = typ;
    }

    public double gibAngriffswert() {
        return angriffswert;
    }
    
    public void setAngriffswert(double angw) {
    	this.angriffswert = angw;
    }

    public double gibVerteidigungswert() {
        return verteidigungswert;
    }
    
    public void setVerteidigungswert(double vertw) {
    	this.verteidigungswert = vertw;
    }

    public double gibGoldwert() {
        return goldwert;
    }
    
    public void setGoldwert(double goldw) {
    	this.goldwert = goldw;
    }

    public double gibZustand() {
        return zustand;
    }

    public int gibGewicht() {
        return gewicht;
    }
    
    public void setGewicht(int gew) {
    	this.gewicht = gew;
    }

    public void beschaedigen(int schaden) {
        this.angriffswert = this.angriffswert - (this.angriffswert / 100) * schaden;
        this.verteidigungswert = this.verteidigungswert - (this.verteidigungswert / 100) * schaden;
        this.goldwert = this.goldwert - (this.goldwert / 100) * schaden;
        this.zustand = this.zustand - (this.zustand / 100) * schaden;
        System.out.println("Der Angriffswert wurde beschaedigt, er beträgt nun "+this.angriffswert);
        System.out.println("Der Verteidigungswert wurde beschaedigt, er beträgt nun "+this.verteidigungswert);
        System.out.println("Der Goldwert ist gesunken, er beträgt nun "+this.goldwert);
        System.out.println("Der Zustand ist nun auf "+this.zustand+"%");
    }

    public void reparieren() {
        this.angriffswert = this.angriffswert + (this.angriffswert / this.zustand ) * (100 - this.zustand);
        this.verteidigungswert = this.verteidigungswert + (this.verteidigungswert / this.zustand) * (100 - this.zustand);
        this.goldwert = this.goldwert + (this.goldwert / this.zustand) * (100 - this.zustand);
        this.zustand = 100;
        System.out.println("Angriffswert ist nun "+this.angriffswert);
        System.out.println("Verteidigungswert ist nun "+this.verteidigungswert);
        System.out.println("Goldwert ist nun "+this.goldwert);
        System.out.println("Zustand ist nun "+this.zustand);
    }

    @Override
    public String toString() {
        return this.name;
    }
    public int gibTyp() {
    	return typ;
    }
    public boolean istWaffe() {
    	if(typ == 1) {
    		return true;
    	}
    	else  {
    		return false;
    	}
    }
    public boolean istSchild() {
    	if(typ == 2) {
    		return true;
    	}
    	else  {
    		return false;
    	}
    }
    
    public void anzeigen(Graphics g, int x, int y, int b) {
    	g.setColor(new Color(0,0,255));
    	g.fillRect(b*x+2, b*y+2, b-3, b-3);
    }
}
