/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adventure;
/**
 *
 * @author metha101
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Gegenstand gs1 = new Gegenstand("Schwert", 110.0, 40.0, 200.0, 10);
        Gegenstand gs2 = new Gegenstand("Hammer", 100.0, 40.0, 150.0, 15);
        gs1.beschaedigen(20);
        gs1.reparieren();
        Inventar in = new Inventar();
        in.einpacken(gs1);
        in.einpacken(gs2);
        in.sortieren(5);
    }

}
