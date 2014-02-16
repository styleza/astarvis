/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package astarvis.gui;

import java.awt.event.KeyEvent;
import javax.swing.JFrame;

/**
 * Key listener for AstarVis
 * @author k020398
 */
public class KeyListener implements java.awt.event.KeyListener {
    private AstarController ctrl;
    private JFrame composerFrame;
    private ComposerController cctrl;
    
    /**
     * Initialize key listener with Astar controller
     * @param ctrl 
     */
    public KeyListener(AstarController ctrl,JFrame composerFrame,ComposerController cctrl){
        this.ctrl = ctrl;
        this.composerFrame = composerFrame;
        this.cctrl = cctrl;
    }
    
    /**
     * Detects key presses
     * @param e 
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_M:
                ctrl.reset(false);
                break;
            case KeyEvent.VK_R:
                ctrl.reset(true);
                break;
            case KeyEvent.VK_C:
                cctrl.reset();
                composerFrame.setVisible(!composerFrame.isVisible());
                break;
            case KeyEvent.VK_N:
                ctrl.setSimpleHFunction();
                break;
            case KeyEvent.VK_D:
                ctrl.setDirectingHFunction();
                break;

                
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
