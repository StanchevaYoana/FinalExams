import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\|");

        Pattern patternCapitals = Pattern.compile("([#$%*&]+)(?<capitals>[A-Z]+)\\1");
        Pattern patternLength = Pattern.compile("(?<letter>[\\d]{2}):(?<length>[0-9][0-9])");

        List<String> capitals = new ArrayList<>();
        Matcher matcherCapitals = patternCapitals.matcher(input[0]);
        if (matcherCapitals.find()) {
            capitals = Arrays.stream(matcherCapitals.group("capitals")
                    .split("")).collect(Collectors.toList());
        }

        Map<String, Integer> letterLength = new LinkedHashMap<>();
        capitals.forEach(e -> letterLength.putIfAbsent(e, 0));

        Matcher matcherLength = patternLength.matcher(input[1]);
        while (matcherLength.find()) {
            int unicode = Integer.parseInt(matcherLength.group("letter"));
            char character = (char) unicode;
            String letter = String.valueOf(character);

            if (letterLength.containsKey(letter)) {
                letterLength.put(letter, Integer.parseInt(matcherLength.group("length")));
            }
        }

        String[] words = input[2].split(" ");
        for (String word : words) {
            String firstLetter = String.valueOf(word.charAt(0));
            if (letterLength.containsKey(firstLetter)) {
                if (word.length() == letterLength.get(firstLetter) + 1) {
                    System.out.println(word);
                }
            }
        }
    }
}
