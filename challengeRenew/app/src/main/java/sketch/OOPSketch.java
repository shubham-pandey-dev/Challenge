package sketch;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class OOPSketch extends PApplet{

    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    public static final int BACKGROUND_COLOR = 150;
    public static final int NUMBER_OF_BALLS = 4;
    private static final int GAP_BETWEEN_BALLS = HEIGHT / (NUMBER_OF_BALLS + 1);
    public static final int DIAMETER_OF_BALL = 10;

    private List<Shape> balls;

    public static void main(String args[]) { PApplet.main("sketch.OOPSketch", args); }

    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        background(BACKGROUND_COLOR);
        balls = new ArrayList<>();
//        For Balls
        for(int currentBall = 0; currentBall < NUMBER_OF_BALLS; currentBall ++){
            balls.add(new Ball(0, GAP_BETWEEN_BALLS * currentBall + GAP_BETWEEN_BALLS, currentBall + 1, DIAMETER_OF_BALL));
        }
//        For Rectangles
//        for(int currentBall = 0; currentBall < NUMBER_OF_BALLS; currentBall ++){
//            balls.add(new Rectangle(0, GAP_BETWEEN_BALLS * currentBall + GAP_BETWEEN_BALLS, currentBall + 1, DIAMETER_OF_BALL, DIAMETER_OF_BALL));
//        }
    }

    @Override
    public void draw() {
        balls.forEach(currentBall -> drawCurrentBall((Ball) currentBall));
    }

    private void drawCurrentRectangle(Rectangle rectangle) {
        rectangle.draw(this);
        rectangle.moveToTheRight();
    }

    private void drawCurrentBall(Ball ball) {
        ball.draw(this);
        ball.moveToTheRight();
    }
}
