package akhil.assignment.data;

public class Data {
    private int firstVariable;
    private char secondVariable;

    public Data()
    {
    }

    public void printMemberVars()
    {
        System.out.println(String.valueOf(firstVariable) + "\n" + String.valueOf(secondVariable));
    }

    public void printLocalVars()
    {
        int firstVariable;
        char secondVariable;

        System.out.println("This can't be done");
        // This is not possible in java.
        // All the local variables must be initialized before printing.
    }
}
