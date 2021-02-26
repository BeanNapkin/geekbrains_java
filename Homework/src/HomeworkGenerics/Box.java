package HomeworkGenerics;

import java.util.ArrayList;

public class Box <T extends Fruit> {

    private final ArrayList<T> boxWithAnyFruits = new ArrayList<>();

    public void addFruitToBox(T fruit){
        boxWithAnyFruits.add(fruit);
    }

    public float getWeight(){
        return boxWithAnyFruits.get(0).getWeight() * boxWithAnyFruits.size();
    }

    public boolean compare(Box<?> boxForCompare){
        return boxForCompare.getWeight() == getWeight();
    }

    public void moveFruits(Box<T> boxForMoving){
        boxForMoving.boxWithAnyFruits.addAll(boxWithAnyFruits);
        boxWithAnyFruits.clear();
    }

    @Override
    public String toString() {
        return boxWithAnyFruits.toString();
    }

}
