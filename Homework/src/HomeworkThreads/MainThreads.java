package HomeworkThreads;

import java.util.Arrays;
import java.util.concurrent.*;

public class MainThreads {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {

        method1();
        method2();
    }

    public static void method1() {
        float[] arr = new float[SIZE];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println(System.currentTimeMillis() - a);
    }

    public static void method2() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);


        long a = System.currentTimeMillis();

        Future<float[]> future1 = executorService.submit(() -> {
            float[] arrFirstPart = new float[HALF];
            System.arraycopy(arr, 0, arrFirstPart, 0, HALF);
            for (int i = 0; i < arrFirstPart.length; i++) {
                arrFirstPart[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            return arrFirstPart;
        });

        Future<float[]> future2 = executorService.submit(() -> {
            float[] arrSecondPart = new float[HALF];
            System.arraycopy(arr, HALF, arrSecondPart, 0, HALF);
            for (int i = 0; i < arrSecondPart.length; i++) {
                arrSecondPart[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            return arrSecondPart;
        });

        try {
            System.arraycopy(future1.get(), 0, arr, 0, HALF);
            System.arraycopy(future2.get(), 0, arr, HALF, HALF);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() - a);

        executorService.shutdown();
    }

}



