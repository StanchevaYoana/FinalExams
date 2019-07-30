import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NascarQualifications {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> racers = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String input;
        while (!"end".equals(input = scanner.nextLine())) {

            String[] command = input.split(" ");
            switch (command[0]) {
                case "Race":
                    if (!racers.contains(command[1])) {
                        racers.add(command[1]);
                    }
                    break;
                case "Accident":
                    racers.remove(command[1]);
                    break;
                case "Box":
                    if (racers.contains(command[1]) && racers.indexOf(command[1]) != racers.size()) {
                        int index = racers.indexOf(command[1]);
                        String holder = racers.remove(index + 1);
                        racers.set(index, holder);
                        racers.add(index + 1, command[1]);
                    }
                    break;
                case "Overtake":
                    if (racers.contains(command[1])) {
                        int index = racers.indexOf(command[1]);
                        int forwardPositions = Integer.valueOf(command[2]);
                        if (index - forwardPositions >= 0) {
                            racers.add(index - forwardPositions, command[1]);
                            racers.remove(index+1);
                        }
                    }
                    break;
            }
        }
        System.out.print(String.join(" ~ ", racers));
    }
}
