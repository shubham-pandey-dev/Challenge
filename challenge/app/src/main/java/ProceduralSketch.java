
import processing.core.*;

public class ProceduralSketch extends PApplet{

    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    public static final int DIAMETER = 10;
    public static final int COLOR = 100;
    public static final int START = 0;
    public static final int NUMBER_OF_PARTITION_OF_HEIGHT = 5;
    public static final int NUMBER_OF_CIRCLES = 5; // Extra 1 for 1 based indexing..
    public static final int FIRST_CIRCLE = 1;

    private int[] circleXof, circleYof;

    public static void main(String args[]) { PApplet.main("ProceduralSketch", args); }

    @Override
    public void settings() {
        super.settings();
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        background(COLOR);
        // using indexing for accessing the circles..
        circleXof = new int[NUMBER_OF_CIRCLES];
        circleYof = new int[NUMBER_OF_CIRCLES];
        for(int circle = 1; circle <= 4; circle ++){
            circleXof[circle] = START; // not needed but for clarity.
            circleYof[circle] = HEIGHT / NUMBER_OF_PARTITION_OF_HEIGHT * circle;
        }
    }

    @Override
    public void draw() {
        drawCircle();
    }

    private void drawCircle() {
        for(int circle = 1; circle <= 4; circle ++){
            ellipse(circleXof[circle], circleYof[circle], DIAMETER, DIAMETER);
            circleXof[circle] += circle;
        }
        if(drawingComplete()){
            finishDrawing();
        }
    }

    private boolean drawingComplete() {
        return circleXof[FIRST_CIRCLE] >= WIDTH + DIAMETER;
    }

    private void finishDrawing() {
        super.finished = true;
        /*
        Use below line to close the window automatically after the drawing is complete
        System.exit(0);
        */
    }
}