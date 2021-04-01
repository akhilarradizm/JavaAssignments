public class ConstructorOverloading{

    private String data;

    public ConstructorOverloading()
    {
        this("data");
    }

    public ConstructorOverloading(String data)
    {
        this.data = data;
    }
}