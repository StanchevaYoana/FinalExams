import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Concert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> nameTime = new LinkedHashMap<>();
        Map<String, Set<String>> nameMembers = new LinkedHashMap<>();

        String input;
        while (!"start of concert".equals(input = scanner.nextLine())) {
            String[] command = input.split("; ");

            if (command[0].equals("Play")) {
                if (!nameTime.containsKey(command[1])) {
                    nameTime.put(command[1], Integer.valueOf(command[2]));
                } else {
                    int newValue = nameTime.get(command[1]) + Integer.valueOf(command[2]);
                    nameTime.put(command[1], newValue);
                }
            } else if (command[0].equals("Add")) {
                String[] listOfMembers = command[2].split(", ");
                nameMembers.putIfAbsent(command[1], new LinkedHashSet<>());

                for (String member : listOfMembers) {
                    nameMembers.get(command[1]).add(member);
                }
            }
        }
        String firstBand = scanner.nextLine();
        AtomicInteger sum = new AtomicInteger();
        nameTime.forEach((key, value) -> sum.addAndGet(value));
        System.out.println("Total time: "+sum);

        nameTime.entrySet().stream().sorted((band1,band2) -> {
            int sort = band2.getValue().compareTo(band1.getValue());
            if (sort == 0){
                sort = band1.getKey().compareTo(band2.getKey());
            }
            return sort;
        }).forEach(band -> {
            System.out.println(String.format("%s -> %d", band.getKey(), band.getValue()));
        });
        System.out.println(firstBand);
        nameMembers.get(firstBand).forEach(member -> {
            System.out.println(String.format("=> %s", member));
        });
    }
}
