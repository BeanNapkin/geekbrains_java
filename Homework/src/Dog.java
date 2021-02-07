public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void run(int distance) {
        if (distance > 500) {
            System.out.println(getName() + " пробежал 500 метров из " + distance + ", а потом устал и больше не хочет.");
        } else {
            System.out.println(getName() + " пробежал " + distance + " метров.");
        }
    }


    @Override
    public void swim(int distance) {
        if (distance > 10) {
            System.out.println(getName() + " проплыл 10 метров из " + distance + ", а потом устал и больше не хочет.");
        } else {
            System.out.println(getName() + " проплыл " + distance + " метров.");
        }
    }
}

