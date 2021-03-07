package HomeworkThreads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Race {
    private ArrayList<Stage> stages;

    public ArrayList<Stage> getStages() {
        return stages;
    }

    private Car winner;

    private CyclicBarrier preparationBarrier;
    private CyclicBarrier finishBarrier;

    public Car getWinner() {
        return winner;
    }

    public Race(int carsCount, Stage... stages) {
        preparationBarrier = new CyclicBarrier(carsCount + 1);
        finishBarrier = new CyclicBarrier(carsCount + 1);
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

    public void preparationDone() {
        try {
            preparationBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void raceDone(Car car) {

        if (winner == null) {
            winner = car;
        }

        try {
            System.out.println(car.getName() + " закончил гонку.");
            finishBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void awaitPreparationDone() {
        try {
            preparationBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
    }

    public void awaitRaceDone() {
        try {
            finishBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

}
