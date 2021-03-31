import java.util.Scanner;
import java.util.regex.*;
public class RegularExpression {
    public boolean checkSentence(String inputSentence)
    {
        String regex= "[A-Z].*\\.";
        return Pattern.matches(regex, inputSentence);
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string");
        String inputString = input.nextLine();
        RegularExpression regularExpression= new RegularExpression();
        if(regularExpression.checkSentence(inputString))
        {
            System.out.println("It follows the rules");
        }
        else
        {
            System.out.println("It does not follow the rules");
        }
    }
}
