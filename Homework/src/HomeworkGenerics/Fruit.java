package HomeworkGenerics;

public abstract class Fruit {

    public abstract float getWeight();

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

}
