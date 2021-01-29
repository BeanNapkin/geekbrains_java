import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SeaBattle {

    static final int COUNT_AVAILABLE_SHIPS = 3;
    static final int SIZE_WAR_FIELD = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String repeat = "Да";

        while (repeat.equals("Да")) {
            int[] usersField = createUsersField();
            int[] computersField = createComputersField();

            int[] usersShots = new int[SIZE_WAR_FIELD];
            int[] computersShots = new int[SIZE_WAR_FIELD];
            int usersSurvivingShips = COUNT_AVAILABLE_SHIPS;
            int computersSurvivingShips = COUNT_AVAILABLE_SHIPS;

            boolean isUsersShot = random.nextBoolean();

            do {
                if (isUsersShot) {
                    computersSurvivingShips = usersTurn(computersSurvivingShips, computersField, usersShots);
                    isUsersShot = false;
                } else {
                    usersSurvivingShips = computersTurn(usersSurvivingShips, usersField, computersShots);
                    isUsersShot = true;
                }
            } while (computersSurvivingShips > 0 && usersSurvivingShips > 0);

            System.out.println("Хотите сыграть ещё раз? Введите 'Да' или 'Нет'.");
            repeat = scanner.next();
        }
        scanner.close();

    }

    public static int[] createUsersField() {
        Scanner scanner = new Scanner(System.in);

        int[] usersField = new int[SIZE_WAR_FIELD];
        int i = 0;

        while (i < COUNT_AVAILABLE_SHIPS) {
            System.out.println("Поставьте свой корабль, введя число от 0 до " + (usersField.length - 1));
            int shipIndex = scanner.nextInt();

            if (shipIndex >= 0 && shipIndex < usersField.length) {
                usersField[shipIndex] = 1;
                i++;
            } else {
                System.out.println("Вы ввели некорректное значение!");
            }

        }
        return usersField;
    }

    public static int[] createComputersField() {
        Random random = new Random();
        int[] computersField = new int[SIZE_WAR_FIELD];
        int i = 0;

        while (i < COUNT_AVAILABLE_SHIPS) {
            int shipIndex = random.nextInt(computersField.length - 1);

            if (computersField[shipIndex] == 0) {
                computersField[shipIndex] = 1;
                i++;
            }
        }
        return computersField;
    }

    public static int usersTurn(int computersSurvivingShips, int[] computersField, int[] usersShots) {
        Scanner scanner = new Scanner(System.in);

        if (computersSurvivingShips > 0) {
            boolean isCorrectInput = false;
            int shotIndex = 0;

            while (!isCorrectInput) {
                System.out.println("Совершите выстрел, введя в консоль число от 0 до " + (computersField.length - 1));
                shotIndex = scanner.nextInt();
                if (shotIndex >= 0 && shotIndex < computersField.length) {
                    if (computersField[shotIndex] == 9) {
                        System.out.println("Вы сюда уже стреляли!");
                    } else {
                        isCorrectInput = true;
                    }
                } else {
                    System.out.println("Некорректный ввод!");
                }
            }

            if (computersField[shotIndex] == 1) {
                usersShots[shotIndex] = -1;
                System.out.println(Arrays.toString(usersShots));
                System.out.println("Вы попали!");
                computersSurvivingShips--;
                computersSurvivingShips = usersTurn(computersSurvivingShips, computersField, usersShots);
            } else {
                usersShots[shotIndex] = 9;
                System.out.println(Arrays.toString(usersShots));
                System.out.println("Промахнулись!");
            }

        } else {
            System.out.println("Игрок выиграл!");
        }

        return computersSurvivingShips;
    }

    public static int computersTurn(int usersSurvivingShips, int[] usersField, int[] computersShots) {
        Random random = new Random();

        if (usersSurvivingShips > 0) {

            boolean isAlreadyShotThisIndex = true;
            int shotIndex = 0;

            while (isAlreadyShotThisIndex) {
                shotIndex = random.nextInt(SIZE_WAR_FIELD - 1);

                if (computersShots[shotIndex] != 1) {
                    isAlreadyShotThisIndex = false;
                }
            }

            if (usersField[shotIndex] == 1) {
                usersField[shotIndex] = -1;
                computersShots[shotIndex] = 1;
                usersSurvivingShips--;
                System.out.println(Arrays.toString(usersField));
                System.out.println("Компьютер попал!");
                usersSurvivingShips = computersTurn(usersSurvivingShips, usersField, computersShots);
            } else {
                computersShots[shotIndex] = 1;
                System.out.println("Компьютер промахнулся!");
            }

        } else {
            System.out.println("Компьютер выиграл!");
        }

        return usersSurvivingShips;
    }
}


