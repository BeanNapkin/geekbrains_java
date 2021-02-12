public class KittenPlateApp {
    public static Kitten[] kittens = new Kitten[5];


    public  static Plate plate = new Plate(100);

    public static void main(String[] args) {
        kittens[0] = new Kitten("Барсик", 85, false);
        kittens[1] = new Kitten("Вася", 7, false);
        kittens[2] = new Kitten("Мурзик", 15, false);
        kittens[3] = new Kitten("Николай Василич", 6, false);
        kittens[4] = new Kitten("Мультик", 10, false);

        plate.info();
        kittensEat();

    }

    public static void kittensEat(){
        for (int i = 0; i < kittens.length; i++) {
           if(!kittens[i].eat(plate)){
               System.out.println("Мало еды!");
               plate.addFood();
               kittens[i].eat(plate);
           };

            if (kittens[i].getIsNotHungry()){
                System.out.println(kittens[i].getName() + " сыт.");
            } else {
                System.out.println(kittens[i].getName() + " голодный.");
            }

            plate.info();
        }
    }
}
