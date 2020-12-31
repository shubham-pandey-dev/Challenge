
import processing.core.*;

public class ObjectSketch extends PApplet{

    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    public static final int DIAMETER = 10;
    public static final int COLOR = 100;
    public static final int START_OF_X = 0;
    public static final int NUMBER_OF_PARTITIONS = 5;
    public static final int NUMBER_OF_CIRCLES = NUMBER_OF_PARTITIONS; // Extra 1 for 1 based indexing..
    public static final int FIRST_CIRCLE = 1;
    private Circle[] circles;

    public static void main(String args[]) { PApplet.main("ObjectSketch", args); }

    /* Motive : Try to consider Circle as Objects.. */

    @Override
    public void settings() {
        super.settings();
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        /*can give custom color (I choose grey here)..*/
        background(COLOR);
        circles = new Circle[NUMBER_OF_CIRCLES];
        /*NUMBER_OF_PARTITION_OF_HEIGHT variable changes the number of lines automatically(like 4 to 20).*/
        for(int circle = FIRST_CIRCLE; circle < NUMBER_OF_CIRCLES; circle ++){
            circles[circle] = new Circle(START_OF_X, HEIGHT / NUMBER_OF_PARTITIONS * circle);
        }
    }

    @Override
    public void draw() {
        drawCircle();
    }

    private void drawCircle(){
        /*this helps if there are many number of circles (or lines of circles)..*/
        for(int circle = FIRST_CIRCLE; circle < NUMBER_OF_CIRCLES; circle ++){
            ellipse(circles[circle].getX(), circles[circle].getY(), DIAMETER, DIAMETER);
            circles[circle].addToX(circle);
            /*An alternative for updating:
            circles[circle].setX(circles[circle].getX() + circle);*/
        }
        if(drawingComplete()){
            finishDrawing();
        }
    }

    private boolean drawingComplete() {
        return circles[FIRST_CIRCLE].getX() >= WIDTH + DIAMETER;
    }

    private void finishDrawing() {
        super.finished = true;
        /*Use below line to close the window automatically after the drawing is complete
        System.exit(0);*/
    }
}
