import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class BattleManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> personHealth = new LinkedHashMap<>();
        Map<String, Integer> personEnergy = new LinkedHashMap<>();

        String input;

        while (!"Results".equals(input = scanner.nextLine())) {

            String[] command = input.split(":");

            switch (command[0]) {
                case "Add":
                    //Add:{personName}:{health}:{energy}":
                    if (personHealth.containsKey(command[1])) {
                        int health = personHealth.get(command[1]) + Integer.parseInt(command[2]);
                        personHealth.put(command[1], health);
                    } else {
                        personHealth.put(command[1], Integer.parseInt(command[2]));
                        personEnergy.put(command[1], Integer.parseInt(command[3]));
                    }
                    break;
                //Attack:{attackerName}:{defenderName}:{damage}":
                case "Attack":
                    if (personEnergy.containsKey(command[1]) && personEnergy.containsKey(command[2])) {
                        int damage = personHealth.get(command[2]) - Integer.parseInt(command[3]);
                        if (damage <= 0) {
                            personEnergy.remove(command[2]);
                            personHealth.remove(command[2]);
                            System.out.printf("%s was disqualified!%n", command[2]);
                        } else {
                            personHealth.put(command[2], damage);
                        }
                        int attack = personEnergy.get(command[1]) - 1;
                        if (attack <= 0) {
                            personEnergy.remove(command[1]);
                            personHealth.remove(command[1]);
                            System.out.printf("%s was disqualified!%n", command[1]);

                        } else {
                            personEnergy.put(command[1], attack);
                        }
                    }
                    break;

                case "Delete":
                    if (command[1].equals("All")) {
                        personEnergy = new LinkedHashMap<>();
                        personHealth = new LinkedHashMap<>();
                    } else {
                        personEnergy.remove(command[1]);
                        personHealth.remove(command[1]);
                    }
                    break;
            }
        }
        System.out.println(String.format("People count: %d", personEnergy.size()));

        Map<String, Integer> finalPersonEnergy = personEnergy;
        personHealth.entrySet().stream().sorted((player1, player2) -> {
            int sort = player2.getValue().compareTo(player1.getValue());
            if (sort == 0) {
                sort = player1.getKey().compareTo(player2.getKey());
            }
            return sort;
        }).forEach(player -> {
            System.out.println(String.format("%s - %d - %d", player.getKey(), player.getValue(), finalPersonEnergy.get(player.getKey())));
        });
    }
}

