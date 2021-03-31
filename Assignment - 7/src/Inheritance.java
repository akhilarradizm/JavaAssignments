class Rodent {
    public void makeSound()
    {
        System.out.println("Squeak");
    }
    public void printType()
    {
        System.out.println("Rodent");
    }
}
class Mouse extends Rodent
{
    public void printType()
    {
        System.out.println("Mouse");
    }
}
class Gerbil extends Rodent
{
    public void printType()
    {
        System.out.println("Gerbil");
    }
}
class Hamster extends Rodent
{
    public void printType()
    {
        System.out.println("Hamster");
    }
}
public class Inheritance
{
    public static void main(String[] args)
    {
        Rodent rodents[] = new Rodent[3];
        rodents[0]=new Mouse();
        rodents[1]=new Gerbil();
        rodents[2]=new Hamster();
        for(Rodent r : rodents)
        {
            r.makeSound();
            r.printType();
        }
    }
}

