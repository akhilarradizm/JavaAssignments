public class ErrorHandler {
    public void errorThrower()
    {
        try
        {
            int arr[] = new int[10];
            arr[10]= 2/0;
            String s = null;
            if(s.equals("hello"))
            {
                System.out.println("Hello");
            }
        }
        catch (ArithmeticException | ArrayIndexOutOfBoundsException | NullPointerException ex)
        {
            System.out.println(ex.getMessage());
        }
        finally {
            System.out.println("All errors are handles");
        }
    }
    public static void main(String[] args)
    {
        ErrorHandler handler = new ErrorHandler();
        handler.errorThrower();
    }
}
