import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class MakeSalad2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> veggies = new HashMap<>();
        veggies.put("tomato", 80);
        veggies.put("carrot", 136);
        veggies.put("lettuce", 109);
        veggies.put("potato", 215);

        ArrayDeque<String> vegetables = new ArrayDeque<>();
        List<String> in = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());
        for (String str : in) {
            vegetables.offer(str);
        }
        List<Integer> calories = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        ArrayDeque<Integer> salads = new ArrayDeque<>();
        for (Integer cal : calories) {
            salads.push(cal);
        }
        List<Integer> madeSalads = new ArrayList<>();

        while (!vegetables.isEmpty() && !salads.isEmpty()) {
            int calorie = salads.pop();
            int salad = calorie;

            while (calorie >= 0) {
                String veggie = vegetables.poll();
                int veggieCal = veggies.get(veggie);
                if (calorie > veggieCal) {
                    calorie -= veggieCal;
                } else {
                    madeSalads.add(salad);
                    break;
                }
                if (vegetables.isEmpty()) {
                    madeSalads.add(salad);
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(new List[]{madeSalads}).replaceAll("[\\[|\\],]", ""));
        if (vegetables.size() > 0) {
            printLeftVeggie(vegetables);
        } else if (salads.size() > 0) {
            printLeftSalads(salads);
        }


    }

    private static void printLeftSalads(ArrayDeque<Integer> salads) {
        while (salads.size() > 0) {
            System.out.print(salads.pop() + " ");
        }
    }

    private static void printLeftVeggie(ArrayDeque<String> vegetables) {
        while (vegetables.size() > 0) {
            System.out.print(vegetables.poll() + " ");
        }
    }
}

