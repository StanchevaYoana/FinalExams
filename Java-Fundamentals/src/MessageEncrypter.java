import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageEncrypter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile
                ("(\\*|@)(?<tag>[A-Z][a-z]{2,})\\1: ((\\[)(?<first>[A-Za-z])(\\]))\\|((\\[)(?<second>[A-Za-z])(\\]))\\|((\\[)(?<third>[A-Za-z])(\\]))(\\|)$");

        while (n-- > 0) {
            String string = scanner.nextLine();
            Matcher matcher = pattern.matcher(string);
            if (matcher.find()) {
                char firstSymbol = matcher.group("first").charAt(0);
                int first = (int)firstSymbol;
                char secondSymbol = matcher.group("second").charAt(0);
                int second = (int)secondSymbol;
                char thirdSymbol = matcher.group("third").charAt(0);
                int third = (int)thirdSymbol;

                System.out.println(String.format("%s: %d %d %d", matcher.group("tag"), first, second, third));
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}