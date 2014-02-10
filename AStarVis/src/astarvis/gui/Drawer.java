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
public class Drawer extends JPanel {
    private AstarController ctrl;
    private int scale;
    private int w;
    private int h;
    private int tick;
    

    /**
     * Initilize Drawer
     * @param ctrl
     * @param scale 
     */
    public Drawer(AstarController ctrl, int scale){
        this.ctrl = ctrl;
        this.scale = scale;
        this.w = ctrl.getWidth();
        this.h = ctrl.getHeight();
        this.tick = 0;
    }
    
    /**
     * Handles all drawing
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setFont(new Font("TimesRoman",Font.PLAIN,8));
        g.setColor(Color.black);
        g.fill3DRect(0, 0, w*scale, h*scale, false);
        
        for(int y = 0; y < h; y++){
            for(int x = 0; x < w; x++){
                Node n = ctrl.getGraph().getNodeAt(x, y);
                g.setColor(new Color(255-n.getCost(),255-n.getCost(),255-n.getCost()));
                g.fill3DRect(x*scale, y*scale, scale, scale, true);
                if(n == ctrl.getGraph().getGoal() || n == ctrl.getGraph().getStart()){
                    g.setColor(Color.green);
                    g.drawRect(x*scale, y*scale, scale-1, scale-1);
                } else if(ctrl.getPath().contains(n) && ctrl.getLookupHistory(tick).contains(n.getLocation())){
                    g.setColor(Color.red);
                    g.drawRect(x*scale, y*scale, scale-1, scale-1);
                }  
                else if(ctrl.getLookupHistory(tick).contains(n.getLocation())){
                    g.setColor(Color.yellow);
                    g.drawRect(x*scale, y*scale, scale-1, scale-1);
                }
                
                g.setColor(Color.black);
                g.drawString(n.getCost()+"", x*scale+1, y*scale+8);
            }
        }
        g.drawString("Press R to generate (new) Random maze, M to generate Maze", 10, (h+1)*scale);
        tick++;
    }
    
    /**
     * Sets tick (animation point)
     * @param t 
     */
    public void setTick(int t){
        this.tick = t;
    }
    
}
