import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class TrojanInvasion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int wavesTrojanWarriors = Integer.parseInt(reader.readLine());
        List<Integer> plates = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> warriors = new ArrayList<>();


        for (int i = 1; i <= wavesTrojanWarriors; i++) {
            warriors = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
            Collections.reverse(warriors);

            while (!plates.isEmpty() && !warriors.isEmpty()) {
                int warrior = warriors.get(0);
                int plate = plates.get(0);

                if (warrior == plate) {
                    warriors.remove(0);
                    plates.remove(0);

                } else if (warrior > plate) {
                    warriors.set(0, warrior - plate);
                    plates.remove(0);
                } else {
                    plates.set(0, plate - warrior);
                    warriors.remove(0);
                }
            }
            if (i % 3 == 0) {
                plates.add(Integer.valueOf(reader.readLine()));
            }
            if (plates.isEmpty()) {
                break;
            }
        }

        if (!warriors.isEmpty()) {
            System.out.println("The Trojans successfully destroyed the Spartan defense.");
            System.out.print("Warriors left: ");
            System.out.println(warriors.toString()
                    .replaceAll("[\\[\\]]", ""));

        } else {
            System.out.println("The Spartans successfully repulsed the Trojan attack.");
            System.out.print("Plates left: ");
            System.out.print(plates.toString()
                    .replaceAll("[\\[\\]]", ""));
        }
    }

}

