import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deciphering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "^[d-z\\|{}\\#]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(scanner.nextLine());

        StringBuilder reducedText = new StringBuilder();

        if (matcher.find()) {
            for (int i = 0; i < matcher.group(0).length() ; i++) {
                char symbol = (char) (matcher.group(0).charAt(i) - 3);
                reducedText.append(symbol);
            }
            String finalText = String.valueOf(reducedText);

            String [] replacedValues = scanner.nextLine().split(" ");
            finalText = finalText.replaceAll(replacedValues[0], replacedValues [1]);
            System.out.println(finalText);

        } else {
            System.out.println("This is not the book you are looking for.");
        }
    }
}
