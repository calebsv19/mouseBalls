import java.awt.*;

public class Ball {
    private Color color;
    private double x;
    private double y;
    private double xVel;
    private double yVel;

    public Ball(){
        this(0, 0, 0, 0, Color.WHITE);
    }

    public Ball(double x, double y){
        this(x, y, 0, 0, Color.WHITE);
    }

    public Ball(double x, double y, double xVel, double yVel, Color color){
        this.x = x;
        this.y = y;
        this.xVel = xVel;
        this.yVel = yVel;
        this.color = color;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getXVel(){
        return xVel;
    }

    public double getYVel(){
        return yVel;
    }

    public Color getColor(){
        return color;
    }

    public void setX(double num){
        x = num;
    }

    public void setY(double num){
        y = num;
    }

    public void setXVel(double num){
        xVel = num;
    }

    public void setYVel(double num){
        yVel = num;
    }
}
