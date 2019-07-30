import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheIsleofManTTRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "(#|$|%|\\*|&){1}(?<name>[A-Za-z]+)\\1=(?<length>(\\d+))!!(?<code>.+)";
        Pattern pattern = Pattern.compile(regex);

        while(scanner.hasNext()){
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                int length = matcher.group("code").length();
                StringBuilder hashcode = new StringBuilder();
                if (length == Integer.parseInt(matcher.group("length"))) {
                    String code = matcher.group("code");
                    for (int i = 0; i < code.length(); i++) {
                        char symbol = code.charAt(i);
                        symbol += length;
                        hashcode.append(symbol);
                    }
                    System.out.println(String.format("Coordinates found! %s -> %s", matcher.group("name"), hashcode));
                } else {
                    System.out.println("Nothing found!");
                }
            }else {
                System.out.println("Nothing found!");
            }

        }
    }
}