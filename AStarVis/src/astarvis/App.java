package astarvis;

import astarvis.gui.AstarController;
import astarvis.gui.ComposerController;
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
        ComposerController cctrl = new ComposerController(ctrl);
        GUI gui = new GUI(ctrl,cctrl);
        SwingUtilities.invokeLater(gui);
 
        while (gui.getDrawer()== null || gui.getComposerDrawer() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Piirtoalustaa ei ole vielä luotu.");
            }
        }
        ctrl.setDrawer(gui.getDrawer());
        cctrl.setDrawer(gui.getComposerDrawer());
        ctrl.start();
        cctrl.start();
    }
    
}
