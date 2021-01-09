package sketch;

import processing.core.PApplet;

public class Ball extends Shape {

    private int SPEED;
    private int DIAMETER_OF_BALL;

    public Ball(int positionX, int positionY, int SPEED, int DIAMETER_OF_BALL) {
        super(positionX, positionY);
        this.SPEED = SPEED;
        this.DIAMETER_OF_BALL = DIAMETER_OF_BALL;
    }

    public void moveToTheRight() {
        positionX += SPEED;
    }

    public void draw(PApplet pApplet) {
        pApplet.ellipse(positionX, positionY, DIAMETER_OF_BALL, DIAMETER_OF_BALL);
    }
}
