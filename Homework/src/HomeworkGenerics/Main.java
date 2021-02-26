package HomeworkGenerics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> arr = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
        int element1 = 1;
        int element2 = 2;
        System.out.println(changeElements(arr, element1, element2));

        String[] arrayOfStrings = {"1", "2", "3", "4"};
        System.out.println(arrayToArrayList(arrayOfStrings).getClass());

    }

    public static <T> List<T> changeElements(List<T> arr, int element1, int element2) {
        T element = arr.get(element1);
        arr.set(element1, arr.get(element2));
        arr.set(element2, element);
        return arr;
    }

    public static <T> List<T> arrayToArrayList(T[] arr) {
        List<T> list = Arrays.asList(arr);
        return list;
    }
}
