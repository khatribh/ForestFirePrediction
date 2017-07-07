/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.util.ArrayList;

/**
 *
 * @author Bhumika
 */
public class Particle {
    private Position pos;
    private Velocity velocity;
    private double pBest;
    private double pBestCost;
    private boolean status;
    private double bestX;
    private double bestY;
    
    public Particle(){
        
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public Velocity getVelocity() {
        return velocity;
    }

    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getpBest() {
        return pBest;
    }

    public void setpBest(double pBest) {
        this.pBest = pBest;
    }

    public double getpBestCost() {
        return pBestCost;
    }

    public void setpBestCost(double pBestCost) {
        this.pBestCost = pBestCost;
    }

    public double getBestX() {
        return bestX;
    }

    public void setBestX(double bestX) {
        this.bestX = bestX;
    }

    public double getBestY() {
        return bestY;
    }

    public void setBestY(double bestY) {
        this.bestY = bestY;
    }

    
    
    
    
    
}
