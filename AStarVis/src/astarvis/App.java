package astarvis;

import astarvis.gui.AstarController;
import astarvis.gui.GUI;
import javax.swing.SwingUtilities;

/**
 *
 * @author ilri
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AstarController ctrl = new AstarController();
 
        GUI gui = new GUI(ctrl);
        SwingUtilities.invokeLater(gui);
 
        while (gui.getDrawer()== null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Piirtoalustaa ei ole vielä luotu.");
            }
        }
        ctrl.setDrawer(gui.getDrawer());
        ctrl.start();
    }
    
}
