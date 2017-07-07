/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import static java.awt.Color.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Bhumika
 */
public class Ball extends JPanel{
    ArrayList<Particle> particleList=new ArrayList<Particle>();
    //double gBest=0.0;
    double localBest=0.0;
    Random r=new Random();
    final double w=1;
    final double C1=2;
    final double C2=2;
    private int delay = 10000;
    Particle gBest=null;
    Image background;

//Create a timer with delay 1000 ms
private Timer timer = new Timer(delay, new TimerListener());

//increment on ball's y-coordinate

public Ball()
{initialize();
//background=new ImageI("C:\\Users\\Bhumika\\Documents\\Algos\\AlgoProject\\image.jpeg");
timer.start();
}
private class TimerListener implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
    int epochMax=1000;
        //initialize();
        gBest=particleList.get(0);
        
        for(int i=0;i<epochMax;i++){
            System.out.println("Iteration"+i);
            //System.out.println("GBESTBefore"+gBest.getpBest());
            Particle local=maximum();
            
            System.out.println("Local Best"+local.getpBest());
           
            if(local.getpBest()>gBest.getpBest())
                gBest=local;
            //System.out.println("GBESTAfter"+gBest.getpBest());
//            System.out.println("GBest"+gBest.getpBest());
             System.out.println("Best X "+gBest.getPos().getX());
            System.out.println("Best Y "+gBest.getPos().getY());
            changeVelocity(gBest);
            updateLocation(gBest);
            try {
                timer.setDelay(100); // wait 600 msec before continuing
            } catch (Exception eu) {
                return;
            }
       
repaint();
        }
        //timer.stop();
}
}
protected void paintComponent(Graphics g)
{
super.paintComponent(g);
resize(1000, 1000);
g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        setBackground(BLUE);
        //super.paint(g);
//        int gbestx = (int) gBest.getPos().getX();
//        int gbesty = (int) gBest.getPos().getY();
//        System.out.println("gbest X"+gbestx);
//         System.out.println("gbest y"+gbesty);
//        g.setColor(YELLOW);
    //    g.fillOval(gbestx, gbesty, 30, 30);
       // g.setColor(GREEN);
       // g.fillRect(0, 0, 30, 30);
        int i = 0;
        for (Particle p : particleList) {

            // set current color
            // draw filled oval using current x and y coordinates and diameter
            //double[] loc = p.getPosition();

            int x = Integer.valueOf((int) Math.round(p.getPos().getX()));
            int y = Integer.valueOf((int) Math.round(p.getPos().getY()));
            System.out.println("X Coords:\t" + x);
            System.out.println("Y Coords:\t" + y);
            
            g.setColor(RED);
//            int pbestx = (int) p.getPartclebest().getPostion().get(i).getLoc()[0];
//            int pbesty = (int) pBestLocation.get(i).getLoc()[1];
//           g.drawLine(pbestx, pbesty, gbestx, gbesty);
//           g.setColor(RED);
//            g.drawLine(x, y, pbestx, pbesty);
//            g.setColor(PINK);
//            g.drawLine(x, y, gbestx, gbesty);
//            g.setColor(BLUE);
            g.fillOval(x, y, 10, 10);
            i++;

        }
}
    public double cost(){
         Data d=new Data();
            d.setHumidity(getRandomNumber(15.0,100.0));
            d.setRainfall(getRandomNumber(2.0,6.4));
            d.setWindSpeed(getRandomNumber(1.40, 9.40));
            d.setThundering(getRandomNumber(30.0,150.0));
            
        double p= 0.2*d.getRainfall()+0.2*d.getHumidity()+0.3*d.getWindSpeed()+0.3*d.getThundering();
        return p;
    }
    public double getRandomNumber(double low, double high)
    {
        return ((high - low) * new Random().nextDouble() + low);
    }
    public void initialize(){
        for(int i=0; i< 40;i++){
            
            Particle p=new Particle();
           
            Position pos=new Position(getRandomNumber(100,500),getRandomNumber(100,500));
            
            Velocity velocity=new Velocity(0,0);
            p.setPos(pos);
            p.setpBest(cost());
            p.setpBestCost(0.0);
            p.setBestX(0);
            p.setBestY(0);
            p.setVelocity(velocity);
            p.setStatus(false);
            particleList.add(p);
        }
    }
    public void changeVelocity(Particle gbest){
        
        
        double bestResults = 0;
        

        

        for(int i = 0; i <40; i++)
        {
            Particle par=particleList.get(i);
            bestResults = par.getpBest();
            double newVelX = (w*par.getVelocity().getX())+ (r.nextDouble()*C1) * (par.getBestX() - par.getPos().getX()) + (r.nextDouble()*C2)*(gbest.getPos().getX() - par.getPos().getX());
            
            double newVelY=(w*par.getVelocity().getY())+((r.nextDouble()*C1)*(par.getBestY()-par.getPos().getY()))+((r.nextDouble()*C2)*(gbest.getPos().getY()-par.getPos().getY()));
            if(newVelX > 10){
                newVelX=10;
            }
            else if(newVelX<0){
                newVelX=0;    
            }
            if(newVelY > 10){
                newVelY=10;
            }
            else if(newVelY<0){
                newVelY=0;    
            }
            par.setVelocity(new Velocity(newVelX,newVelY));
            
        }
    }
    public void updateLocation(Particle gPar){
        for(int i=0;i<40;i++){
            Particle par=particleList.get(i);
            if(par!=gPar){
                double newLocX=par.getPos().getX()+par.getVelocity().getX();
                double newLocY=par.getPos().getY()+par.getVelocity().getY();
                if(newLocX>500){
                    newLocX=500;
                }
                else if(newLocX<100){
                    newLocX=100;
                }
                if(newLocY>500){
                    newLocY=500;
                }
                else if(newLocY<100){
                    newLocY=100;
                }
                par.setPos(new Position(newLocX,newLocY));
                if(par.getpBest()<cost()){
                par.setpBest(cost());
            }
            
            if(par.getpBestCost()<par.getpBest()){
                par.setpBestCost(par.getpBest());
                par.setBestX(par.getPos().getX());
                par.setBestY(par.getPos().getY());
                
                
            }
        }
            
            
            //par.setPos();
        }
    }
    public Particle maximum(){
    // Returns an array index.
        double highest = particleList.get(0).getpBest();
        int highestIndex = 0;

        for(int i = 0; i<40; i++){
            double cur = particleList.get(i).getpBest();
            if (cur > highest) {
                highest = cur;
                highestIndex = i;
            }
        }
        return particleList.get(highestIndex);
    }
    public void suspend()
{
timer.stop();
}

public void resume()
{
timer.start();
}

public void setDelay(int delay)
{
this.delay = delay;
timer.setDelay(delay);
}
}
