package menu;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MenuInputValidator {

    public static int checkIfNumberEntered(String prompt) {
        return checkIfNumberEntered(prompt, new Integer[]{});
    }

    public static int checkIfNumberEntered(String prompt, Integer[] validNumbers) {
        do {
            Scanner input = new Scanner(System.in);
            System.out.print(prompt);
            if (input.hasNextInt()) {

                Integer number = input.nextInt();

                if (validNumbers.length > 0) {
                    List<Integer> validOptions = Arrays.asList(validNumbers);

                    if (!validOptions.contains(number)) {
                        System.out.println("This is not a valid option");
                        continue;
                    }
                }

                return number;
            } else {
                System.out.println("ERROR: Invalid Enter");
            }
        } while (true);
    }
}
