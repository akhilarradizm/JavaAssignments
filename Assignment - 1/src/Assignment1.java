import java.io.File;
import java.util.Scanner;
import java.util.regex.*;

class SearchFiles
{
    public void printFiles(String pattern)
    {
        String homeDirectory="./";
        File[] listOfFiles=new File(homeDirectory).listFiles();
        printFilesPath(listOfFiles,pattern);
    }
    public void printFilesPath(File[] listOfFiles, String pattern)
    {
        if(listOfFiles==null)
        {
            return;
        }
        for(File file: listOfFiles)
        {
            if(file.isDirectory())
            {
                File[] list=file.listFiles();
                printFilesPath(list,pattern);
            }
            else
            {
                Pattern givenPattern= Pattern.compile(pattern);
                Matcher matcher=givenPattern.matcher(file.getName());
                if(matcher.matches())
                {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}
public class Assignment1 {
    public static void main(String[] args)
    {
        SearchFiles searchFiles= new SearchFiles();
        Scanner input=new Scanner(System.in);
        String pattern="";
        while(true)
        {
            System.out.println("Enter a pattern to search");
            pattern=input.nextLine();
            if(pattern.equalsIgnoreCase("Done"))
            {
                break;
            }
            searchFiles.printFiles(pattern);
        }
    }
}
