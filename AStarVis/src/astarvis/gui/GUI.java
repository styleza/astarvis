package astarvis.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GUI implements Runnable {
 
    private JFrame frame;
    private JFrame frameComposer;
    private AstarController ctrl;    
    private ComposerController cctrl;  
    private Drawer d;
    private DrawerComposer dc;
    
    private int scale;
    
    /**
     * GUI interface
     * @param ctrl 
     * @param cctrl
     */
    public GUI(AstarController ctrl,ComposerController cctrl) {
        this.ctrl = ctrl;
        this.cctrl = cctrl;
        this.scale = 20;
    }
 

    /**
     * Initializes window
     */
    @Override
    public void run() {
        composerWindow();
        solverWindow();
        
    }
    
    /**
     * Creates components for solver window
     * @param container 
     */
    public void createComponentsSolver(Container container) {

        Drawer drawer = new Drawer(ctrl,this.scale);
        this.d = drawer;
        container.add(d);
        
        KeyListener nk = new KeyListener(ctrl,this.frameComposer,cctrl);
        
        this.frame.addKeyListener(nk);
    }
    
    /**
     * Creates components for composer window
     * @param container 
     */
    public void createComponentsComposer(Container container) {

        DrawerComposer drawer = new DrawerComposer(cctrl,this.scale);
        this.dc = drawer;
        container.add(dc);
        
        MouseListener ml = new MouseListener(cctrl);
        MouseMotionL mml = new MouseMotionL(cctrl);
        this.frameComposer.addMouseListener(ml);
        this.frameComposer.addMouseMotionListener(mml);
    }
 
 
    /**
     * Returns GUI's frame
     * @return 
     */
    public JFrame getFrame() {
        return frame;
    }
    
    /**
     * Returns solver GUI's drawer
     * @return 
     */
    public Drawer getDrawer(){
        return this.d;
    }
    
    /**
     * Rerurns composer GUI's drawer
     * @return 
     */
     public DrawerComposer getComposerDrawer(){
        return this.dc;
    }
    
     /**
      * Initialize Solver window
      */
    private void solverWindow(){
        frame = new JFrame("A*vis");
        int w = ctrl.getWidth() * scale + 50;
        int h = ctrl.getHeight() * scale + 50;
         
        frame.setPreferredSize(new Dimension(w, h));
 
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        frame.setResizable(false);
 
        createComponentsSolver(frame.getContentPane());
 
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Initialize composer window (defaultly hidden)
     */
    private void composerWindow(){
        frameComposer = new JFrame("A*vis Composer");
        int w = cctrl.getWidth() * scale + 50;
        int h = cctrl.getHeight() * scale + 50;
         
        frameComposer.setPreferredSize(new Dimension(w, h));
        
        frameComposer.setResizable(false);
 
        createComponentsComposer(frameComposer.getContentPane());
 
        frameComposer.pack();
    }
    
}