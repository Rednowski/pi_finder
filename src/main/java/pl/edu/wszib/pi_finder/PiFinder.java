package pl.edu.wszib.pi_finder;

import java.util.Random;

public class PiFinder implements Runnable {
    private int threadNumber;
    private int pointNumber;

    public PiFinder(int pointNumber, int threadNumber) {
        this.threadNumber = threadNumber;
        this.pointNumber = pointNumber;
    }

    @Override
    public void run(){
        int pointsInCircle = 0;
        Random random = new Random();
        for(int i = 0; i < this.pointNumber/this.threadNumber; i++){
            double x = random.nextDouble();
            double y = random.nextDouble();

            double distanceFromCenter = Math.sqrt(x*x + y*y);
            if(distanceFromCenter < 1){
                pointsInCircle++;
            }
        }

        synchronized (App.partialResults){
            App.partialResults.add(pointsInCircle);
        }

    }
}
