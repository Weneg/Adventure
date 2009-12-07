/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adventure;
/**
 *
 * @author Timo Schrappe, Nils Preuschoff
 */
public class Main {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	Held kurt = new Held("kurt", 600);
        Gegenstand gs1 = new Gegenstand("Schwert", 50.0, 40.0, 200.0, 10, 1);
        Gegenstand gs2 = new Gegenstand("Hammer", 100.0, 40.0, 150.0, 50, 1);
        kurt.einpacken(gs1);
        kurt.einpacken(gs2);
        kurt.rucksackentfernen("Schwert");
        kurt.ausdemrucksackanlegen("Hammer");
    }

}
