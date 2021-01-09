package sketch;

import processing.core.PApplet;

public class ProceduralSketch extends PApplet {

    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    public static final int BACKGROUND_COLOR = 150;
    public static final int NUMBER_OF_BALLS = 4;
    private static final int GAP_BETWEEN_BALLS = HEIGHT / (NUMBER_OF_BALLS + 1);
    public static final int DIAMETER_OF_BALL = 10;

    private int[] xCordinateOfBall, yCordinateOfBall;

    public static void main(String args[]) { PApplet.main("sketch.ProceduralSketch", args); }

    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        background(BACKGROUND_COLOR);
        xCordinateOfBall = new int[NUMBER_OF_BALLS];
        yCordinateOfBall = new int[NUMBER_OF_BALLS];
        for(int currentBall = 0; currentBall < NUMBER_OF_BALLS; currentBall ++){
            xCordinateOfBall[currentBall] = 0; // not needed but for clarity
            yCordinateOfBall[currentBall] = GAP_BETWEEN_BALLS * currentBall + GAP_BETWEEN_BALLS;
        }
    }

    @Override
    public void draw() {
        for(int currentBall = 0; currentBall < NUMBER_OF_BALLS; currentBall ++){
            drawCircleFor(currentBall);
            moveBallToTheRight(currentBall);
        }
        if(isScreenFilled()){
            stopMovingBalls();
            closeScreen();
        }
    }

    private void closeScreen() {
        System.exit(0);
    }

    private void stopMovingBalls() {
        super.finished = true;
    }

    private boolean isScreenFilled() {
        return xCordinateOfBall[0] >= WIDTH + DIAMETER_OF_BALL;
    }

    private void moveBallToTheRight(int currentBall) {
        xCordinateOfBall[currentBall] += currentBall + 1;
    }

    private void drawCircleFor(int currentBall) {
        ellipse(xCordinateOfBall[currentBall], yCordinateOfBall[currentBall], DIAMETER_OF_BALL, DIAMETER_OF_BALL);
    }
}
