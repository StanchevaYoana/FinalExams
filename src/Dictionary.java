import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> dictionary = new TreeMap<>();

        String[] input = scanner.nextLine().split("( \\| )+");
        for (String word : input) {
            String[] wordDef = word.split(": ");
            dictionary.putIfAbsent(wordDef[0], new ArrayList<>());
            dictionary.get(wordDef[0]).add(wordDef[1]);
        }

        String[] wordsToPrint = scanner.nextLine().split("( \\| )+");

        for (String word : wordsToPrint) {
            if (dictionary.containsKey(word)) {
                System.out.println(word);
                dictionary.get(word).stream().sorted((def1, def2) -> {
                    if (dictionary.get(word).size() > 1) {
                        return Integer.compare(def2.length(), def1.length());
                    } else return def1.length();
                }).forEach(def -> System.out.println(String.format("-%s", def)));
            }
        }
        String outputCommand = scanner.nextLine();
        if (outputCommand.equals("List")) {
            System.out.println(String.join(" ", dictionary.keySet()));
        }
    }
}

