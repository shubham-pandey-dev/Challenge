package sketch;

import processing.core.PApplet;

public class Rectangle extends Shape{

    private int SPEED;
    private int LENGTH_OF_RECTANGLE;
    private int BREADTH_OF_RECTANGLE;

    public Rectangle(int positionX, int positionY, int SPEED, int LENGTH_OF_RECTANGLE, int BREADTH_OF_RECTANGLE) {
        super(positionX, positionY);
        this.SPEED = SPEED;
        this.LENGTH_OF_RECTANGLE = LENGTH_OF_RECTANGLE;
        this.BREADTH_OF_RECTANGLE = BREADTH_OF_RECTANGLE;
    }

    public void moveToTheRight() {
        positionX += SPEED;
    }

    public void draw(PApplet pApplet) {
        pApplet.rect(positionX, positionY, LENGTH_OF_RECTANGLE, BREADTH_OF_RECTANGLE);
    }
}
