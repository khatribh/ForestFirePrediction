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
public class Data {
    private double windSpeed;
    private double humidity;
    private double rainfall;
    private double thundering;
    
    public Data(){
        
    }
    public Data(double w, double h, double r, double t){
        this.windSpeed=w;
        this.humidity=h;
        this.rainfall=r;
        this.thundering=t;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getRainfall() {
        return rainfall;
    }

    public void setRainfall(double rainfall) {
        this.rainfall = rainfall;
    }

    public double getThundering() {
        return thundering;
    }

    public void setThundering(double thundering) {
        this.thundering = thundering;
    }
    
    
    
}
