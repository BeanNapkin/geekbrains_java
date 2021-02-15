package Homework8;

public class Wall {

    public final int height = 10;

    public int getHeight() {
        return height;
    }

    public boolean jump(Jumping jumping){
        return jumping.getHeigth() >= this.height;
    }
}
