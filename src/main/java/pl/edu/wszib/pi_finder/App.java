package pl.edu.wszib.pi_finder;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static final List<Integer> partialResults = new ArrayList<>();

    public static void main(String[] args) {
        int allPoints = 500000000;
        int threadNumber = 4;
        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(new PiFinder(allPoints, threadNumber));
        Thread t2 = new Thread(new PiFinder(allPoints, threadNumber));
        Thread t3 = new Thread(new PiFinder(allPoints, threadNumber));
        Thread t4 = new Thread(new PiFinder(allPoints, threadNumber));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e){
            System.out.println("Something went wrong");
        }

        int globalPointsInCircle = 0;
        for(int element : partialResults){
            globalPointsInCircle += element;
        }

        double pi = (double) (globalPointsInCircle * 4) / (double) allPoints;

        long endTime = System.currentTimeMillis();
        System.out.println(pi);
        System.out.println("Time in ms: " + (endTime - startTime));
    }
}
