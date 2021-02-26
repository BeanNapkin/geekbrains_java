package HomeworkGenerics;

public class FruitApp {
    public static void main(String[] args) {

        Box<Apple> boxWithApples = new Box<>();
        Box<Orange> boxWithOranges = new Box<>();

        Box<Apple> boxWithApples2 = new Box<>();

        Apple apple = new Apple();
        Orange orange = new Orange();

        boxWithApples.addFruitToBox(apple);
        boxWithApples.addFruitToBox(apple);
        boxWithApples.addFruitToBox(apple);
        boxWithOranges.addFruitToBox(orange);
        boxWithOranges.addFruitToBox(orange);

        boxWithApples2.addFruitToBox(apple);

        System.out.println(boxWithApples.compare(boxWithOranges));

        boxWithApples2.moveFruits(boxWithApples);
        System.out.println(boxWithApples);
        System.out.println(boxWithApples2);


    }
}
