package pl.edu.wszib.pi_finder;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static final List<Integer> partialResults = new ArrayList<>();

    public static void main(String[] args) {
        int allPoints = 500000000;
        int threadNumber = 8;
        Thread[] threads = new Thread[threadNumber];
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < threadNumber; i++){
            threads[i] = new Thread(new PiFinder(allPoints, threadNumber));
            threads[i].start();
        }

        try {
            for(int i = 0; i < threadNumber; i++){
                threads[i].join();
            }
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
