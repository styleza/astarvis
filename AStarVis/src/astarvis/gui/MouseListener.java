/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package astarvis.gui;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Mouse listener for AstarVis Composer
 * @author k020398
 */
public class MouseListener implements java.awt.event.MouseListener {
    private ComposerController ctrl;
    private boolean pressed;
    
    /**
     * Initialize mouse listener with Composer controller
     * @param ctrl 
     */
    public MouseListener(ComposerController ctrl){
        this.ctrl = ctrl;
        pressed = false;
    }

    /**
     * On mouse is clicked
     * @param e 
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == java.awt.event.MouseEvent.BUTTON1){
            ctrl.changeWeigth(e.getX(),e.getY());
        } else {
            ctrl.setStartEnd(e.getX(),e.getY());
        }
    }

    /**
     * On mouse gets pressed
     * @param e 
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == java.awt.event.MouseEvent.BUTTON1)
            pressed = true;
    }

    /**
     * On mouse gets released
     * @param e 
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == java.awt.event.MouseEvent.BUTTON1)
            pressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    
    
  
}
