package astarvis.gui;
import astarvis.ds.Node;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.*;

/**
 * Draws GUI elements to screen
 * @author Ilari
 */
public class DrawerComposer extends JPanel {
    private int scale;
    private int w;
    private int h;
    private ComposerController ctrl;
    

    /**
     * Initilize Drawer
     * @param ctrl
     * @param scale 
     */
    public DrawerComposer(ComposerController ctrl, int scale){
        this.scale = scale;
        this.w = ctrl.getWidth();
        this.h = ctrl.getHeight();
        this.ctrl = ctrl;
    }
    
    /**
     * Handles all drawing
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int weight[][] = ctrl.getWeights();
        g.setFont(new Font("TimesRoman",Font.PLAIN,8));
        g.setColor(Color.white);
        g.fill3DRect(0, 0, w*scale, h*scale, false);
        
        for(int y = 0; y < h; y++){
            for(int x = 0; x < w; x++){
                if(weight[y][x] == 1){
                     g.setColor(Color.green);
                } else if(weight[y][x] == 2){
                     g.setColor(Color.red);
                }
                else {
                    int color = Math.max(0,255-weight[y][x]);
                    g.setColor(new Color(color,color,color));
                }
                g.fill3DRect(x*scale, y*scale, scale-1, scale-1,false);
            }
        }
    }
    
    /**
     * Returns scale in GUI
     * @return 
     */
    public int getScale(){
        return this.scale;
    }

}
