import java.util.Arrays;

public class VampireNumbers{
    public void printVampireNumbers(int count)
    {
        String[] str1, str2;
        int product, currentCount = 0;
        for(int i = 10; i < 1000; i++) {
            for(int j = 10; j < 1000; j++) {
                if(currentCount >= count)
                    return;
                product = i * j;
                str1 = String.valueOf(product).split("");
                str2 = (String.valueOf(i) + String.valueOf(j)).split("");
                Arrays.sort(str1);
                Arrays.sort(str2);
                if(Arrays.equals(str1, str2)) {
                    currentCount++;
                    System.out.println(" "+ currentCount + ". vampire number: " + product);
                }
            }
        }
    }
}