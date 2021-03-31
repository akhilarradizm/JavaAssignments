import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class KYC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        ArrayList<String> input = new ArrayList<>();
        int numberOfLines = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numberOfLines; i++) {
            input.add(sc.nextLine());
        }
        for (String line : input) {
            LocalDate currentDate = LocalDate.parse(line.split(" ")[1], format);
            LocalDate joiningDate = LocalDate.parse(line.split(" ")[0], format);
            LocalDate prevDate = joiningDate.minusDays(30);
            LocalDate laterDate = joiningDate.plusDays(30);
            if (prevDate.compareTo(currentDate) < 0) {
                while (prevDate.plusYears(1).compareTo(currentDate) < 0) {
                    joiningDate = joiningDate.plusYears(1);
                    prevDate = joiningDate.minusDays(30);
                    laterDate = joiningDate.plusDays(30);
                }
                if (prevDate.compareTo(currentDate) < 0 && laterDate.compareTo(currentDate) > 0) {
                    laterDate = currentDate;
                }
                System.out.print(prevDate.format(format));
                System.out.print(" ");
                System.out.println(laterDate.format(format));
            } else {
                System.out.println("No range");
            }
        }
    }
}