public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void run(int distance) {
       if (distance > 200){
           System.out.println(getName() + " пробежал 200 метров из " + distance + ", а потом устал и больше не хочет.");
       } else {
           System.out.println(getName() + " пробежал " + distance + " метров.");
       }
    }

    @Override
    public void swim(int distance) {
        System.out.println(getName() + " не любит плавать и не будет!");
    }


}

