interface Cycle {
    void start();
    void setId(int id);
    int getId();
}
class  Unicycle implements Cycle {
    private int id;
    @Override
    public void start() {
        System.out.println("UniCycle has been started in start methods");
    }

    @Override
    public void setId(int id) {
        this.id=id;
    }

    @Override
    public int getId() {
        return id;
    }
}
class Bicycle implements Cycle {
    private int id;
    @Override
    public void start() {
        System.out.println("Bicycle has been started in start methods");
    }
    @Override
    public void setId(int id) {
        this.id=id;
    }

    @Override
    public int getId() {
        return id;
    }
}
class Tricycle implements Cycle{
    private int id;
    @Override
    public void start() {
        System.out.println("Car has been started in start method");
    }
    @Override
    public void setId(int id) {
        this.id=id;
    }

    @Override
    public int getId() {
        return id;
    }
}
class Garage {

    //use getShape method to get object of type shape
    public Cycle getCycle(String cycleType){
        if(cycleType == null){
            return null;
        }
        if(cycleType.equalsIgnoreCase("Unicycle")){
            return new Unicycle();

        } else if(cycleType.equalsIgnoreCase("Bicycle")){
            return new Bicycle();

        } else if(cycleType.equalsIgnoreCase("Tricycle")){
            return new Tricycle();
        }

        return null;
    }
}
public class FactoryPatternDemo {

    public static void main(String[] args) {
        Garage garage = new Garage();

        //get an object of Car and call its start method.
        Cycle firstCycle = garage.getCycle("Unicycle");
        firstCycle.setId(111);
        //call start method of firstVehicle
        System.out.println(firstCycle.getId());
        firstCycle.start();

        //get an object of Bike and call its start method.
        Cycle secondCycle = garage.getCycle(     "Bicycle");
        secondCycle.setId(222);
        //call start method of secondVehicle
        System.out.println(secondCycle.getId());
        secondCycle.start();

        //get an object of Cycle and call its start method.
        Cycle thirdCycle = garage.getCycle("Tricycle");
        thirdCycle.setId(333);
        //call start method of Cycle
        System.out.println(thirdCycle.getId());
        thirdCycle.start();
    }
}