public class Homework1 {
    public static void main(String[] args) {
        byte exampleByte = 100;
        short exampleShort = -5;
        int exampleInt = 3333;
        long exampleLong = 3000000L;
        float exampleFloat = -12.356f;
        double exampleDouble = 5.6721;
        char exampleChar = 8;
        boolean exampleBoolean = false;
        String exampleString = "Строка!";

        System.out.println("Задание №3 с вычислениями: " + calculation(10, -5, 12.66f, 2));
        System.out.println("Задание №4. Входит ли сумма чисел в диапазон: " + isInTheRage(5, 2));
        isPositive(100);
        System.out.println("Задание №6. Отрицательное ли число?: " + isNegative(-9));
        hello("Андрей");
        isYearLeap(2021);
    }

    public static float calculation(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    public static boolean isInTheRage(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void isPositive(int a) {
        if (a >= 0) {
            System.out.println("Задание №5 с позитивным/отрицательным числом: " + a + " - положительное");
        } else {
            System.out.println("Задание №5 с позитивным/отрицательным числом: " + a + " - отрицательное");
        }
    }

    public static boolean isNegative(int a) {
        return a < 0;
    }

    public static void hello(String name) {
        System.out.println("Задание № 7: Привет, " + name + "!");
    }

    public static void isYearLeap(int year) {
        boolean isLeap = year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
        String leap;
        if (isLeap) {
            leap = " - високосный";
        } else {
            leap = " - невисокосный";
        }
        System.out.println("Задание № 8. Високосный ли год?: " + year + leap);

//        if (year % 400 == 0){
//            System.out.println("Задание № 8. Високосный ли год?: " + year + " - високосный!");
//        } else if (year % 100 == 0){
//            System.out.println("Задание № 8. Високосный ли год?: " + year + " - невисокосный!");
//        } else if (year % 4 == 0){
//            System.out.println("Задание № 8. Високосный ли год?: " + year + " - високосный!");
//        } else {
//            System.out.println("Задание № 8. Високосный ли год?: " + year + " - невисокосный!");
//        }

    }
}

