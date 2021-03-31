public class Cycle {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
class Unicycle extends Cycle
{
    public void balance()
    {
        System.out.println("Balancing Unicycle");
    }
}
class Bicycle extends Cycle
{
    public void balance()
    {
        System.out.println("Balancing Bicycle");
    }
}
class Tricycle extends Cycle
{

}
class Execute
{
    public static void main(String[] args)
    {
        Cycle firstCycle= new Bicycle();
        Cycle secondCycle = new Unicycle();
        Cycle thirdCycle = new Tricycle();
        Bicycle first= (Bicycle)firstCycle;
        Unicycle second = (Unicycle) secondCycle;
        Tricycle third = (Tricycle) thirdCycle;
        first.balance();
        second.balance();

    }
}
