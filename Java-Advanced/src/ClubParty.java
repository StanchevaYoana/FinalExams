import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ClubParty {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maxCapacity = Integer.parseInt(reader.readLine());

        ArrayDeque<String> inputData = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+")).forEach(inputData::push);

        ArrayDeque<String> halls = new ArrayDeque<>();
        List<Integer> currentHall = new ArrayList<>();

        while (!inputData.isEmpty()) {
            String currentPeople = inputData.pop();

            if (Character.isAlphabetic(currentPeople.charAt(0))) {
                halls.offer(currentPeople);

            } else {
                int numsOfPeople = Integer.parseInt(currentPeople);
                int sum = currentHall.stream().mapToInt(Integer::intValue).sum() + numsOfPeople;
                if (sum <= maxCapacity && !halls.isEmpty()) {
                    currentHall.add(numsOfPeople);
                } else {
                    if (!halls.isEmpty()) {
                        System.out.print(String.format("%s -> ", halls.poll()));
                        System.out.println(currentHall.toString()
                                .replaceAll("[\\[\\]]", ""));
                        currentHall = new ArrayList<>();
                        if (!halls.isEmpty()) {
                            currentHall.add(numsOfPeople);
                        }
                    }
                }
            }
        }
    }
}