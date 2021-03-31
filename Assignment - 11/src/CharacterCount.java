import java.io.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class CharacterCount {
    public void characterMap(String filePath) throws IOException {
        Scanner input = new Scanner(new File(filePath));
        HashMap<Character, Integer> characterCount = new HashMap<Character, Integer>();
        while (input.hasNextLine()) {
            String currentLine = input.nextLine();
            currentLine = currentLine.toLowerCase();
            char[] characters = currentLine.toCharArray();
            for (char c : characters) {
                if(Character.compare(c,' ')==0)
                    continue;
                Character currentCharacter = Character.valueOf(c);

                if (characterCount.containsKey(currentCharacter)) {
                    characterCount.put(currentCharacter, characterCount.get(currentCharacter) + 1);
                } else {
                    characterCount.put(currentCharacter, 1);
                }
            }
        }
        for (Map.Entry mapElement : characterCount.entrySet()) {
            Character key = (Character) mapElement.getKey();
            int value = ((int) mapElement.getValue());
            System.out.println(key + " : " + value);
        }
    }
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        String filePath = input.nextLine();
        CharacterCount count = new CharacterCount();
        count.characterMap(filePath);

    }
}
