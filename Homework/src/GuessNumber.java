import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String repeat = "Да";

        while (repeat.equals("Да")) {
            int number = createNumber();
            int count = 3;


            System.out.println("Попробуйте угадать число, которое загадал компьютер. У вас " + count + " попытки.");

            boolean isUserGuess = false;

            while (!isUserGuess && count > 0) {
                System.out.println("Введите число от 0 до 9.");
                int usersNumber = scanner.nextInt();

                while (!isInputCorrect(usersNumber)) {
                    System.out.println("Некорректный ввод. Введите число от 0 до 9.");
                    usersNumber = scanner.nextInt();
                }

                count--;

                if (usersNumber == number) {
                    System.out.println("Вы угадали!");
                    isUserGuess = true;
                } else if (usersNumber > number) {
                    System.out.println("Вы ввели слишком большое число.");
                } else {
                    System.out.println("Вы ввели слишком маленькое число.");
                }

                if (!isUserGuess) {
                    if (count == 0) {
                        System.out.println("У вас не осталось попыток!");
                    } else {
                        System.out.println("У вас осталось " + count + " попыток!");
                    }
                }
            }

            System.out.println("Хотите сыграть ещё раз? Введите 'Да' или 'Нет'.");
            repeat = scanner.next();
        }

        scanner.close();
    }

    private static boolean isInputCorrect(int usersNumber) {
        return usersNumber >= 0 && usersNumber <= 9;
    }

    public static int createNumber() {
        Random random = new Random();
        return random.nextInt(9);
    }

}


