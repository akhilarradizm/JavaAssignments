import java.util.Scanner;
class CheckString {
    public boolean[] constructBooleanArray(String inputString)
    {
        boolean charArray[] = new boolean[26];
        inputString=inputString.toLowerCase();
        for(char ch:inputString.toCharArray())
        {
            charArray[ch-'a']=true;
        }
        return charArray;
    }
    public boolean checkString(String inputString)
    {
        boolean charArray[] = constructBooleanArray(inputString);
        for(boolean value:charArray)
        {
            if(value==false)
                return false;
        }
        return true;
    }
}
public class Assignment2
{
    public static void main(String[] args)
    {
        CheckString check=new CheckString();
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the string");
        String inputString=input.nextLine();
        System.out.println(check.checkString(inputString));
    }
}
