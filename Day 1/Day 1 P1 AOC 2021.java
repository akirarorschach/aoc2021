import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try {
            File inputs = new File("Day 1 P1 AOC 2021 Input.txt");
            Scanner reader = new Scanner(inputs);

            int counter = 0;
            int previous = Integer.valueOf(reader.nextLine());
            int current;

            while(reader.hasNextLine()) {
                current = Integer.valueOf(reader.nextLine());

                // increase counter if depth measurement increased
                if (current > previous) {
                    counter ++;
                }

                previous = current;
            }

            reader.close();

            System.out.println(counter);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
