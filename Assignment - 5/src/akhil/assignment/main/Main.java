package akhil.assignment.main;
import akhil.assignment.data.Data;
import akhil.assignment.singleton.Singleton;
public class Main {
    public static void main(String[] args) {
        Data data = new Data();
        data.printMemberVars();
        data.printLocalVars();
        System.out.println();

        Singleton singleton = Singleton.initialize("Singleton");
        singleton.printString();
    }
}
