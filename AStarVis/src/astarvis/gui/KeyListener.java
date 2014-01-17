/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package astarvis.gui;

import java.awt.event.KeyEvent;

/**
 *
 * @author k020398
 */
public class KeyListener implements java.awt.event.KeyListener {
    private AstarController ctrl;
    public KeyListener(AstarController ctrl){
        this.ctrl = ctrl;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_M:
                ctrl.reset(false);
                break;
            case KeyEvent.VK_R:
                ctrl.reset(true);
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
