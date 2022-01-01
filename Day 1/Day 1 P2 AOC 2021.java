import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Main2 {
    public static void main(String[] args) {
        try {
            File inputs = new File("Day 1 P1 AOC 2021 Input.txt");
            Scanner reader = new Scanner(inputs);

            // add values into an ArrayList
            ArrayList<Integer> measurements = new ArrayList<>();
            while (reader.hasNextLine()) {
                measurements.add(Integer.valueOf(reader.nextLine()));
            }

            // variables for counter
            int counter = 0;
            int previousSum = slidingWindowSum(measurements, 0);
            int currentSum;

            // go through each sliding window
            for (int i = 0; i < measurements.size(); i++) {
                currentSum = slidingWindowSum(measurements, i);

                if (currentSum > previousSum) {
                    counter ++;
                }

                previousSum = currentSum;
            }

            reader.close();

            System.out.println(counter);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public static int slidingWindowSum(ArrayList<Integer> a, int startPos) {
        // returns sum of current line + next three lines
        int sum = 0;
        int arraySize = a.size();

        // add current element + next two elements (sliding window of 3)
        for (int i = startPos; (i < startPos + 3) && (i < arraySize); i++) {
            sum += a.get(i);
        }

        return sum;
    }
}