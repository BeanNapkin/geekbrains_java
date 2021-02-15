package Homework8;

public class Cat implements Running, Jumping{

    public String name = "Кот";
    int length;
    int heigth;

    public Cat(int length, int heigth) {
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
