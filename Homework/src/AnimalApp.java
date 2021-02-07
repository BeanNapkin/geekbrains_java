public class AnimalApp {
    public static void main(String[] args) {
        Cat catBarsik = new Cat("Барсик");
        Dog dogSharik = new Dog("Шарик");

        dogSharik.swim(17);
        dogSharik.swim(9);
        dogSharik.run(700);
        dogSharik.run(499);

        catBarsik.run(250);
        catBarsik.run(100);
        catBarsik.swim(100);
    }
}
