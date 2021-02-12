import java.util.Scanner;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int appetite) {
        food -= appetite;
        if (food < 0){
            food = 0;
        }
    }

    public boolean isEnoughFood(int appetite) {
        if (food - appetite < 0) {
            return false;
        }
        return true;
    }

    public void info() {
        System.out.println("В тарелке осталось: " + food + " еды.");
    }

    public void addFood() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите, сколько еды вы бы хотели добавить: ");
        int n = scanner.nextInt();
        food += n;
    }
}

