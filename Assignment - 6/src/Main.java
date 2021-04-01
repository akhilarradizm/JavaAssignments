import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        VampireNumbers vampireNumbers = new VampireNumbers();
        vampireNumbers.printVampireNumbers(100);

        /* Experimenting */
        PrintString[] printStrings = new PrintString[10];
        // Result: Initialization messages aren't printed, as expected as objects haven't been created.

        // Final part: Initialization messages are printed here
        for (int i = 0; i < printStrings.length; i++) {
            printStrings[i] = new PrintString("Experiment number " + i);
        }
    }
}