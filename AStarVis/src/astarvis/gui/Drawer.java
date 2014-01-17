package astarvis.gui;
import astarvis.ds.Node;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.*;


public class Drawer extends JPanel {
    AstarController ctrl;
    int scale;
    int w;
    int h;
    

    public Drawer(AstarController ctrl, int scale){
        this.ctrl = ctrl;
        this.scale = scale;
        this.w = ctrl.getWidth();
        this.h = ctrl.getHeight();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setFont(new Font("TimesRoman",Font.PLAIN,10));
        g.setColor(Color.black);
        g.fill3DRect(0, 0, w*scale, h*scale, false);
        
        for(int y = 0; y < h; y++){
            for(int x = 0; x < w; x++){
                Node n = ctrl.getGraph().getNodeAt(x, y);
                if(n == ctrl.getGraph().getGoal() || n == ctrl.getGraph().getStart()){
                    g.setColor(Color.green);
                } else if(ctrl.getPath().contains(n)){
                    g.setColor(Color.red);
                }  
                else{
                    g.setColor(new Color(255-n.getCost(),255-n.getCost(),255-n.getCost()));
                }
                g.fill3DRect(x*scale, y*scale, scale, scale, true);
                
                g.setColor(Color.black);
                g.drawString(n.getCost()+"", x*scale, y*scale+15);
            }
        }
        g.drawString("Press R to generate (new) Random maze, M to generate Maze", 10, (h+1)*scale);
    }
    
}
