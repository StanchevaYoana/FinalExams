import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChoreWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "(\\{.+\\})|(<([a-z]*[\\d]*)*>)|(\\[([A-Z]*[\\d]*)*\\])";
        Pattern pattern = Pattern.compile(regex);
        int landry = 0;
        int house = 0;
        int dishes = 0;

        String string;
        while (!"wife is happy".equals(string = scanner.nextLine())) {
            Matcher matcher = pattern.matcher(string);
            if (matcher.find()) {
                String input = matcher.group();

                Pattern patternDigit = Pattern.compile("[\\d+]");

                Matcher matcherDigit = patternDigit.matcher(input);
                int sumOfDigits = 0;

                while (matcherDigit.find()) {
                    sumOfDigits += Integer.parseInt(matcherDigit.group());
                }
                String firstChar = String.valueOf(input.charAt(0));
                if (firstChar.equals("<")) {
                    dishes += sumOfDigits;
                } else if (firstChar.equals("[")){
                    house += sumOfDigits;
                } else {
                   landry += sumOfDigits;
                }
            }
        }
        System.out.printf("Doing the dishes - %d min.%n", dishes);
        System.out.printf("Cleaning the house - %d min.%n", house);
        System.out.printf("Doing the laundry - %d min.%n", landry);
        System.out.printf("Total - %d min.", dishes+house+landry);
    }
}
