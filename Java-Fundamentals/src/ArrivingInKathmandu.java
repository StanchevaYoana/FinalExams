import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrivingInKathmandu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "^(?<name>[A-Za-z\\d!@#$?]+)=(?<length>[\\d]+)<<(?<geohash>.+)$";
        Pattern pattern = Pattern.compile(regex);

        while (!"Last note".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {

                StringBuilder name = new StringBuilder(matcher.group("name"));
                StringBuilder coordination = new StringBuilder(matcher.group("geohash"));
                StringBuilder peak = new StringBuilder();
                for (int i = 0; i < name.length(); i++) {
                    if (Character.isAlphabetic(name.charAt(i)) || Character.isDigit(name.charAt(i))) {
                        peak.append(name.charAt(i));
                    }
                }
                int length = Integer.parseInt(matcher.group("length"));
                if (length == coordination.length()) {
                    System.out.println(String.format("Coordinates found! %s -> %s", peak, coordination));
                } else
                    System.out.println("Nothing found!");
            } else {
                System.out.println("Nothing found!");
            }
            input = scanner.nextLine();

        }
    }
}
