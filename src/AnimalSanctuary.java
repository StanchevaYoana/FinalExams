import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnimalSanctuary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "n:(?<name>[^\\;]+);t:(?<kind>[^\\;]+);c--(?<country>[A-Za-z ]+)";
        Pattern pattern = Pattern.compile(regex);
        int totalWeight = 0;
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                StringBuilder name = new StringBuilder();
                StringBuilder kind = new StringBuilder();
                String country = matcher.group("country");

                for (int i = 0; i < matcher.group("name").length(); i++) {
                    char symbol = matcher.group("name").charAt(i);
                    if (Character.isDigit(symbol)){
                        totalWeight += Integer.parseInt(String.valueOf(symbol));
                    } else if (Character.isAlphabetic(symbol)|| symbol == ' '){
                        name.append(symbol);
                    }
                }
                for (int i = 0; i < matcher.group("kind").length(); i++) {
                    char symbol = matcher.group("kind").charAt(i);
                    if (Character.isDigit(symbol)){
                        totalWeight += Integer.parseInt(String.valueOf(symbol));
                    } else if (Character.isAlphabetic(symbol)|| symbol == ' '){
                        kind.append(symbol);
                    }
                }

                System.out.println(String.format("%s is a %s from %s", name, kind, country));

            }
        }
        System.out.printf("Total weight of animals: %dKG", totalWeight);
    }
}
