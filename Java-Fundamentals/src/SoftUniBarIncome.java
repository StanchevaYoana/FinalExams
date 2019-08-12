import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "%(?<name>[A-Z][a-z]+)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>\\d+)\\|[^|$%.]*?(?<price>\\d+([.]\\d+)?)\\$";
        Pattern pattern = Pattern.compile(regex);
        double sum = 0;

        String input;
        while (!"end of shift".equals(input = scanner.nextLine())) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                double sumOfProducts = Integer.parseInt(matcher.group("count"))*Double.parseDouble(matcher.group("price"));
                sum += sumOfProducts;
                System.out.println(String.format("%s: %s - %.2f", matcher.group("name"), matcher.group("product"), sumOfProducts));
            }
        }
        System.out.printf("Total income: %.2f", sum);
    }
}
