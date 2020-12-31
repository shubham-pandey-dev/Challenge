
import processing.core.*;

public class ObjectSketch extends PApplet{

    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    public static final int DIAMETER = 10;
    public static final int COLOR = 100;
    public static final int START = 0;
    public static final int NUMBER_OF_PARTITION_OF_HEIGHT = 5;
    public static final int NUMBER_OF_CIRCLES = 5;
    private Circle[] circles;

    public static void main(String args[]) { PApplet.main("ObjectSketch", args); }

    // Motive : Try to consider Circle as Objects..

    @Override
    public void settings() {
        super.settings();
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        // can give custom color (I choose grey here)..
        background(COLOR);
        circles = new Circle[NUMBER_OF_CIRCLES];
        for(int circle = 1; circle <= 4; circle ++){
            circles[circle] = new Circle(START, HEIGHT / NUMBER_OF_PARTITION_OF_HEIGHT * circle);
        }
    }

    @Override
    public void draw() {
        drawCircle();
    }

    private void drawCircle(){
        // this helps if there are many number of circles (or lines of circles)..
        for(int circle = 1; circle <= 4; circle ++){
            ellipse(circles[circle].getX(), circles[circle].getY(), DIAMETER, DIAMETER);
            circles[circle].addToX(circle);
        }
    }
}
