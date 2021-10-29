package arraylab;

import java.util.*;

public class ArrayLab {

    // Author James Jensen
    public static void main(String[] args) {
        int[] numbers = new int[37];
        Arrays.fill(numbers, -1);
        numbers[4] = 99;
        numbers[9] = 99;

        for (int i = 0; i < 37; i++) {
            if (numbers[i] == -1) {
                Random rand = new Random();
                int upperbound = 99;
                int randInt = rand.nextInt(upperbound);
                numbers[i] = randInt;
            }
        }

        System.out.println(Arrays.toString(numbers));

        Arrays.sort(numbers);

        System.out.println(Arrays.toString(numbers));

        int target = 47;

        for (int i = 0; i < 37; i++) {

            if (numbers[i] == target) {
                System.out.println("the target of " + target + " was found!");
                break;
            } else if (numbers[i] > target) {
                System.out.println("the target of " + target + " was not found!");
                break;
            }

        }

        int total = 0;

        for (int i = 0; i < 37; i++) {
            total = total + numbers[i];
        }

        int average = total / numbers.length;

        System.out.println("The average number of the numbers in the array is " + average);
    }

}
