import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = "@(?<name>[A-Za-z]+)\\|";
        String age = "#(?<age>[\\d+]+)\\*";
        Pattern patternName = Pattern.compile(name);
        Pattern patternAge = Pattern.compile(age);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0){
            String input = scanner.nextLine();
            Matcher matchName = patternName.matcher(input);
            Matcher matchAge = patternAge.matcher(input);

            if (matchAge.find() && matchName.find()){
                System.out.printf("%s is %s years old.%n", matchName.group("name"), matchAge.group("age"));
            }
        }
    }
}
