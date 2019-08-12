import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongEncryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        String regex = "^(?<artist>[A-Z]{1}([a-z]*\\s*'*)*):(?<song>([A-Z]*\\s*)+)$";
        Pattern pattern = Pattern.compile(regex);

        while (!"end".equals(input = scanner.nextLine())) {

            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String artist = matcher.group("artist");
                int key = artist.length();
                StringBuilder encryptedTAxt = new StringBuilder();
                input = input.replace(":", "@");
                for (int i = 0; i < input.length(); i++) {
                    char symbol = input.charAt(i);
                    if (Character.isAlphabetic(symbol)) {
                        if (Character.isLowerCase(symbol)) {
                            symbol = (char) (symbol + key);
                            if (symbol > 122) {
                                symbol -= 26;
                            }
                        } else {
                            symbol = (char) (symbol + key);
                            if (symbol > 90) {
                                symbol -= 26;
                            }
                        }
                        encryptedTAxt.append(symbol);
                    } else {
                        encryptedTAxt.append(symbol);
                    }
                }
                System.out.println("Successful encryption: "+encryptedTAxt);

            }else {
                System.out.println("Invalid input!");
            }
        }
    }
}
