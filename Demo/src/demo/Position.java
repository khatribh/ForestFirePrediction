/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

/**
 *
 * @author Bhumika
 */
public class Position {
    private double X;
    private double Y;
    
    
    public Position(double X,double Y){
        this.X=X;
        this.Y=Y;
        
    }
    public Position(){
        
    }
    public double getX() {
        return X;
    }

    public void setX(double X) {
        this.X = X;
    }

    public double getY() {
        return Y;
    }

    public void setY(double Y) {
        this.Y = Y;
    }

    
    
}
