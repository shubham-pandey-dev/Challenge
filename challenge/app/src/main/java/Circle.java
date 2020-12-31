public class Circle {
    private int x;
    private int y;

    public Circle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void addToX(int value){
        this.x += value;
    }
    public void addToY(int value){
        this.y += value;
    }
}
