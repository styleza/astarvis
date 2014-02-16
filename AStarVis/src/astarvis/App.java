package astarvis;

import astarvis.ds.Pair;
import astarvis.gui.AstarController;
import astarvis.gui.ComposerController;
import astarvis.gui.GUI;
import astarvis.helper.GraphBuilder;
import java.io.IOException;
import javax.swing.SwingUtilities;

/**
 *
 * @author ilri
 */
public class App {

    /**
     * @param args the command line arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        AstarController ctrl;
        if(args.length == 1){
            Pair d = GraphBuilder.buildFromImage(args[0]);
            if(d == null){
                System.out.println("Image is not valid, check endpoint and startpoint");
                return;
            }
            ctrl = new AstarController(d);
        } else {
            ctrl = new AstarController();
        }
        ComposerController cctrl = new ComposerController(ctrl);
        GUI gui = new GUI(ctrl,cctrl);
        SwingUtilities.invokeLater(gui);
 
        while (gui.getDrawer()== null || gui.getComposerDrawer() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Drawers not created");
            }
        }
        ctrl.setDrawer(gui.getDrawer());
        cctrl.setDrawer(gui.getComposerDrawer());
        ctrl.start();
        cctrl.start();
    }
    
}
