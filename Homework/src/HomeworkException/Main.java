package HomeworkException;

public class Main {
    public static void main(String[] args) {

        String[][] arr = {{"1", "1", "1", "1"}, {"1", "@", "1", "1"}, {"1", "1", "@", "1"}, {"1", "1", "1", "1"}};
        String[][] arrSmall = new String[2][2];

        try {
            checkSizeAndSum(arr);
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка в элементе: " + e.errorIndexRow + ", " + e.errorIndexCol);
        }

        try {
            checkSizeAndSum(arrSmall);
        } catch (MyArraySizeException e) {
            System.out.println("Размер массива не 4*4");
        }
    }

    public static void checkSizeAndSum(String[][] arr) {

        int count = 0;

        if (arr.length != 4 || arr[0].length != 4) {
            throw new MyArraySizeException("Размер массива не 4*4.");
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                try {
                    Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
                count += Integer.parseInt(arr[i][j]);
            }
        }

        System.out.println(count);
    }
}




