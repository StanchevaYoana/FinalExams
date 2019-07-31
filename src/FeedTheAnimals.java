import java.util.*;

public class FeedTheAnimals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> areaAnimal = new LinkedHashMap<>();
        Map<String, Integer> animalFood = new LinkedHashMap<>();
        String string;
        while (!"Last Info".equals(string = scanner.nextLine())) {
            String[] command = string.split(":");
            switch (command[0]) {
                case "Add":
                    areaAnimal.putIfAbsent(command[3], new LinkedHashSet<>());
                    areaAnimal.get(command[3]).add(command[1]);

                    if (!animalFood.containsKey(command[1])) {
                        animalFood.put(command[1], Integer.parseInt(command[2]));
                    } else {
                        int value = animalFood.get(command[1]) + Integer.parseInt(command[2]);
                        animalFood.put(command[1], value);
                    }
                    break;
                case "Feed":
                    if (animalFood.containsKey(command[1])) {
                        int value = animalFood.get(command[1])- Integer.parseInt(command[2]);
                        animalFood.put(command[1], value);
                        if (value <= 0) {
                            animalFood.remove(command[1]);
                            areaAnimal.get(command[3]).remove(command[1]);
                            System.out.printf("%s was successfully fed\n", command[1]);
                        }
                    }
                    break;
            }
        }
        System.out.println("Animals:");
        animalFood.entrySet().stream().sorted((animal1, animal2) -> {
            int sort = animal2.getValue().compareTo(animal1.getValue());
            if (sort == 0) {
                sort = animal1.getKey().compareTo(animal2.getKey());
            }
            return sort;
        }).forEach(animal -> System.out.println(String.format("%s -> %dg", animal.getKey(), animal.getValue())));

        System.out.println("Areas with hungry animals:");
        areaAnimal.entrySet().stream().filter(e -> e.getValue().size() > 0).sorted((area1, area2) -> {
            return Integer.compare(area2.getValue().size(), area1.getValue().size());
        }).forEach(area -> System.out.println(String.format("%s : %d", area.getKey(), area.getValue().size())));
    }
}
