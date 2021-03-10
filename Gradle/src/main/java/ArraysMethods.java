
public class ArraysMethods {

    public int[] returnArrWithElementsAfterFour(int[] arr) {

        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
               index = i;
            }
        }

        if (index == -1) {
            throw new RuntimeException("В массиве нет ни одной 4!");
        }

        int[] newArr = new int[arr.length - index - 1];

        int k = 0;
        for (int i = index + 1; i < arr.length; i++) {
            newArr[k] = arr[i];
            k++;
        }
        return newArr;
    }

    public boolean checkArraysContent(int[] arr){
        boolean one = false;
        boolean four = false;

        for (int j : arr) {
            if (j != 1 && j != 4) {
                return false;
            } else if (j == 1) {
                one = true;
            } else {
                four = true;
            }
        }
        return four && one;
    }
}
