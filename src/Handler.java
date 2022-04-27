import java.awt.*;
import java.io.*;
import java.util.*;

public class Handler {
    private Queue<Ball> balls;
    private Point lastPoint;
    private final Random r;

    public static final double DIVISOR = 10;
    public static final int CIRCLE_SIZE = 100;


    // create initial balls
    public Handler(int num){
        balls = new LinkedList<Ball>();
        for (int i = 0; i < num; i++){
            balls.add(new Ball());
        }
        lastPoint = new Point(-10, 0);
        r = new Random();

    }

    // creates new balls and removes the oldest ones
    // changes balls movements off grsvity moving downward
    public void tick(int width, int height){
        balls.poll();
        Point point = MouseInfo.getPointerInfo().getLocation();
        Color myColor = new Color(r.nextInt(200) + 55, r.nextInt(200) + 55, r.nextInt(200) + 55);
        balls.add(new Ball(point.getX(), point.getY(),
                    ((point.getX() - lastPoint.getX()) / DIVISOR) + (r.nextDouble() * 2) - 1,
                     (point.getY() - lastPoint.getY()) / DIVISOR, myColor));
        lastPoint = point;

        for (Ball ball : balls){
            ball.setX(ball.getX() + ball.getXVel());
            ball.setY(ball.getY() + ball.getYVel());
            ball.setXVel(ball.getXVel() + .05);
        }
    }

    public void render(Graphics g, int width, int height){
        g.setColor(Color.BLACK);
        g.fillRect(0,0, width, height);
        for (Ball ball : balls){

            g.setColor(ball.getColor());
            g.fillOval((int) ball.getX(), (int) ball.getY(), CIRCLE_SIZE, CIRCLE_SIZE);
            // g.setColor(Color.WHITE);
            // g.drawOval((int) ball.getX(), (int) ball.getY(), CIRCLE_SIZE, CIRCLE_SIZE);
        }
    }
}