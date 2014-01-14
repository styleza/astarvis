/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package astarvis.ds;

/**
 *
 * @author ilri@cs
 */
public class Point {
    private int x,y;
    
    public Point(){
        x = y = 0;
    }
    
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public void move(int dx,int dy){
        this.x += dx;
        this.y += dy;
    }
}
