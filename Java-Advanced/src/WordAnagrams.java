import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WordAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = reader.readLine();
        int n = Integer.parseInt(reader.readLine());

        Map<String, Integer> charSequence = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            charSequence.putIfAbsent(String.valueOf(word.charAt(i)), 0);
            charSequence.put(String.valueOf(word.charAt(i)), charSequence.get(String.valueOf(word.charAt(i))) + 1);
        }

        while (n-- > 0) {
            String word1 = reader.readLine();
            Map<String, Integer> charSequence1 = new HashMap<>();

            for (int i = 0; i < word1.length(); i++) {
                charSequence1.putIfAbsent(String.valueOf(word1.charAt(i)), 0);
                charSequence1.put(String.valueOf(word1.charAt(i)), charSequence1.get(String.valueOf(word1.charAt(i))) + 1);
            }
            if (charSequence.equals(charSequence1)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
