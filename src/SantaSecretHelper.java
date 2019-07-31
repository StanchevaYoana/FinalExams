import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantaSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        String regex = "@(?<name>[A-Za-z]+)[^\\-@!:>]*!(?<behavior>G)!";
        Pattern pattern = Pattern.compile(regex);
        List<String> list = new ArrayList<>();

        String input;
        while (!"end".equals(input = scanner.nextLine())) {
            StringBuilder message = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                char symbol = (char) (input.charAt(i) - key);
                message.append(symbol);
            }
            Matcher matcher = pattern.matcher(message);
            if (matcher.find()) {
                list.add(matcher.group("name"));
            }
        }
        list.forEach(System.out::println);
    }
}
