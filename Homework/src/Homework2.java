import java.util.Arrays;

public class Homework2 {
    public static void main(String[] args) {
        System.out.println("Задание 1:");
        invertArr();

        System.out.println("\n\nЗадание 2:");
        fillArr();

        System.out.println("\n\nЗадание 3:");
        doubleArrElement();

        System.out.println("\n\nЗадание 4:");
        fillTable();

        System.out.println("\nЗадание 5:");

        int arr[] = {10, -7869, 1000, 2, 0, 57, 7777777, -19};
        System.out.println("Максимальное значение: " + maxArray(arr));
        System.out.println("Минимальное значение: " + minArray(arr));

        int arr6[] = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println("\nЗадание 6: " + checkBalance(arr6));

        System.out.println("\nЗадание 7: " + Arrays.toString(moveElements(new int[]{0, 1, 2, 3, 4}, -2)));
    }

    public static void invertArr() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
                System.out.print(arr[i]);
            } else {
                arr[i] = 0;
                System.out.print(arr[i]);
            }
        }
    }

    public static void fillArr() {
        int[] arr2 = new int[8];
        for (int i = 0, j = 0; i < arr2.length; i++, j = j + 3) {
            arr2[i] = j;
            System.out.print(arr2[i] + " ");
        }
    }

    public static void doubleArrElement() {
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] = arr3[i] * 2;
                System.out.print(arr3[i] + " ");
            } else {
                System.out.print(arr3[i] + " ");
            }
        }
    }

    public static void fillTable() {
        int[][] table = new int[3][3];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = 1;
                System.out.print(table[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static int maxArray(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int minArray(int arr[]) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }


    public static boolean checkBalance(int[] arr) {

        int sum1 = arr[0] + arr[1];
        int sum2 = arr[2];

        for (int i = 3; i < arr.length; i++) {
            sum2 += arr[i];
        }

        for (int j = 2; j < arr.length - 2; j++) {
            sum1 += arr[j];
            sum2 -= arr[j];

            if (sum1 == sum2) {
                break;
            }
        }
        return sum1 == sum2;
    }

    public static int[] moveElements(int[] arr, int n) {
        if (n > 0) {
            for (int k = 1; k <= n; k++) {
                int elementForChange = arr[arr.length - 1];

                for (int i = 0; i < arr.length; i++) {
                    int temporary = arr[i];
                    arr[i] = elementForChange;
                    elementForChange = temporary;
                }
            }
        } else if (n < 0) {
            n = Math.abs(n);

            for (int k = 1; k <= n; k++) {
                int elementForChange = arr[0];

                for (int i = arr.length - 1; i >= 0; i--) {
                    int temporary = arr[i];
                    arr[i] = elementForChange;
                    elementForChange = temporary;
                }
            }
        }
        return arr;
    }
}
