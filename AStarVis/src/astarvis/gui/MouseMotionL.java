package astarvis.gui;

import astarvis.ds.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Mouse motion listener for Astar Composer GUI
 * @author Ilari
 */
public class MouseMotionL implements MouseMotionListener {
    private ComposerController ctrl;
    private Point pp;


    /**
     * Initialize new Composer Mouse listener
     * @param ctrl 
     */
    public MouseMotionL(ComposerController ctrl){
        this.ctrl = ctrl;
        pp = new Point();
    }
    
    /**
     * On drag event
     * @param e 
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        Point x = ctrl.convertToScale(e.getX(), e.getY());
        if(x != null && !x.equals(pp)){
            pp = ctrl.changeWeigth(e.getX(), e.getY());
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
}
