import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regexTreasure = "&(?<treasure>[A-Za-z]*)&";
        String regexCoordinates = "<(?<coordinates>.+)>";
        Pattern patternTreasure = Pattern.compile(regexTreasure);
        Pattern patternCoordinates = Pattern.compile(regexCoordinates);

        int[] keys = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String string;
        while (!"find".equals(string = scanner.nextLine())) {
            StringBuilder output = new StringBuilder();
            boolean isFinish = false;

            for (int j = 0; j < keys.length; j++) {
                for (int i = 0; i < string.length(); i++) {
                    char symbol = (char) (string.charAt(i) - keys[j]);
                    output.append(symbol);
                    j++;
                    if (j == keys.length) {
                        j = 0;
                    }
                    if (i == string.length() - 1) {
                        isFinish = true;
                        break;
                    }

                }
                if (isFinish) {
                    break;
                }
            }
            Matcher matcherTreasure = patternTreasure.matcher(output);
            Matcher matcherCoordinates = patternCoordinates.matcher(output);
            if (matcherCoordinates.find() && matcherTreasure.find()) {
                System.out.printf("Found %s at %s%n", matcherTreasure.group("treasure"), matcherCoordinates.group("coordinates"));

            }
        }
    }
}


