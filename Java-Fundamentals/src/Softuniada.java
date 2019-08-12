import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Softuniada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> countryPoints = new LinkedHashMap<>();
        Map<String, Map<String, Integer>> countryMembersPoints = new LinkedHashMap<>();

        String string;
        while (!"END".equals(string = scanner.nextLine())) {
            String[] command = string.split("( -> )+");

            countryPoints.putIfAbsent(command[0], 0);
            int point = countryPoints.get(command[0]) + Integer.valueOf(command[2]);
            countryPoints.put(command[0], point);

            countryMembersPoints.putIfAbsent(command[0], new LinkedHashMap<>());
            countryMembersPoints.get(command[0]).putIfAbsent(command[1], 0);
            countryMembersPoints.get(command[0])
                    .put(command[1], countryMembersPoints.get(command[0]).get(command[1]) + Integer.valueOf(command[2]));
        }
        AtomicInteger sum1 = new AtomicInteger();
        AtomicInteger sum2 = new AtomicInteger();
        countryMembersPoints.entrySet().stream().sorted((pair1, pair2) -> {

            sum1.set(0);
            sum2.set(0);

            pair1.getValue().forEach((key, value) -> sum1.addAndGet(value));
            pair2.getValue().forEach((key, value) -> sum2.addAndGet(value));

            return Integer.compare(sum2.get(), sum1.get());
        }).forEach(pair -> {

            sum1.set(0);

            pair.getValue().forEach((key, value) -> sum1.addAndGet(value));
            System.out.println(String.format("%s: %d", pair.getKey(), sum1.get()));

            pair.getValue().forEach((key, value) -> System.out.println(String.format("-- %s -> %d"
                    , key, value)));
        });
    }
}
