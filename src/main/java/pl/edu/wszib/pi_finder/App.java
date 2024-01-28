package pl.edu.wszib.pi_finder;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        int allPoints = 100000000;
        int pointsInCircle = 0;

        Random random = new Random();
        for (int i = 0; i < allPoints; i++){
            double x = random.nextDouble();
            double y = random.nextDouble();

            double distanceFromCenter = Math.sqrt(x*x + y*y);
            if(distanceFromCenter < 1){
                pointsInCircle++;
            }
        }

        double pi = (double) (pointsInCircle * 4) / (double) allPoints;
        System.out.println(pi);
    }
}
