import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SantaNewList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> childNumOfPresents = new LinkedHashMap<>();
        Map<String, Integer> presentsCount = new LinkedHashMap<>();

        String string;
        while (!"END".equals(string = scanner.nextLine())) {
            String[] input = string.split("->");

            if (input[0].equals("Remove")) {
                childNumOfPresents.remove(input[1]);
            } else {
                childNumOfPresents.putIfAbsent(input[0], 0);
                childNumOfPresents.put(input[0], childNumOfPresents.get(input[0]) + Integer.parseInt(input[2]));
                presentsCount.putIfAbsent(input[1], 0);
                presentsCount.put(input[1], presentsCount.get(input[1]) + Integer.parseInt(input[2]));
            }
        }

        System.out.println("Children:");
        childNumOfPresents.entrySet().stream().sorted((child1, child2) -> {
            int sort = child2.getValue().compareTo(child1.getValue());
            if (sort == 0) {
                sort = child1.getKey().compareTo(child2.getKey());
            }
            return sort;
        }).forEach(child -> {
            System.out.println(String.format("%s -> %d", child.getKey(), child.getValue()));
        });

        System.out.println("Presents:");
        presentsCount.forEach((key, value) -> System.out.println(String.format("%s -> %d", key, value)));
    }
}
