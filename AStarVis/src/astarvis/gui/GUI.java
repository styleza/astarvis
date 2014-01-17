package astarvis.gui;


import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GUI implements Runnable {
 
    private JFrame frame;
    private AstarController ctrl;    
    private Drawer d;
    
    private int scale;
    
    public GUI(AstarController ctrl) {
        this.ctrl = ctrl;
        this.scale = 20;
    }
 

    @Override
    public void run() {
        frame = new JFrame("A*vis");
        int w = ctrl.getWidth() * scale + 50;
        int h = ctrl.getHeight() * scale + 50;
         
        frame.setPreferredSize(new Dimension(w, h));
 
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        frame.setResizable(false);
 
        createComponents(frame.getContentPane());
 
        frame.pack();
        frame.setVisible(true);
    }
    
    public void createComponents(Container container) {

        Drawer drawer = new Drawer(ctrl,this.scale);
        this.d = drawer;
        container.add(d);
        
        KeyListener nk = new KeyListener(ctrl);
        
        this.frame.addKeyListener(nk);
    }
 
 
    public JFrame getFrame() {
        return frame;
    }
    
    public Drawer getDrawer(){
        return this.d;
    }
    
}