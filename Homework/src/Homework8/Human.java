package Homework8;

public class Human implements Running, Jumping {

    public String name = "Человек";
    public int length;
    public int heigth;

    public Human(int length, int heigth) {
        this.length = length;
        this.heigth = heigth;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

}
