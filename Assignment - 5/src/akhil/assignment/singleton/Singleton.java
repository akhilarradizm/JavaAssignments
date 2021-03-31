package akhil.assignment.singleton;

public class Singleton {
    String myString;
    private Singleton(String newString)
    {
        myString = newString;
    }

    public static Singleton initialize(String newString)
    {
        return new Singleton(newString);
    }

    public void printString()
    {
        System.out.println(myString);
    }
}
