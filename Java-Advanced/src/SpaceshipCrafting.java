import java.util.*;
import java.util.stream.Collectors;

public class SpaceshipCrafting {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> listLiquid = Arrays.stream(scanner.nextLine()
                .split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> listPhysical = Arrays.stream(scanner.nextLine()
                .split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        ArrayDeque<Integer> liquid = new ArrayDeque<>();
        for (Integer integer : listLiquid) {
            liquid.offer(integer);
        }

        ArrayDeque<Integer> physicalItems = new ArrayDeque<>();
        for (Integer integer : listPhysical) {
            physicalItems.push(integer);
        }

        int glass = 0;
        int aluminium = 0;
        int lithium = 0;
        int carbonFiber = 0;

        while (!liquid.isEmpty() && !physicalItems.isEmpty()) {

            int physic = physicalItems.pop();
            int liquidPooled = liquid.poll();
            int sum = liquidPooled + physic;

            if (sum == 25) {
                glass++;
            } else if (sum == 50) {
                aluminium++;
            } else if (sum == 75) {
                lithium++;
            } else if (sum == 100) {
                carbonFiber++;
            } else {
                physicalItems.push(physic + 3);
            }
        }

        if (carbonFiber >= 1 && lithium >= 1 && aluminium >= 1 && glass >= 1) {
            System.out.println("Wohoo! You succeeded in building the spaceship!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to build the spaceship.");
        }

        if (liquid.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            while (liquid.size() != 1) {
                System.out.print(liquid.poll() + ", ");
            }
            System.out.println(liquid.poll());
        }

        if (physicalItems.isEmpty()) {
            System.out.println("Physical items left: none");
        } else {
            System.out.print("Physical items left: ");
            while (physicalItems.size() != 1) {
                System.out.print(physicalItems.pop() + ", ");
            }
            System.out.println(physicalItems.pop());
        }

        System.out.printf("Aluminium: %d%n", aluminium);
        System.out.printf("Carbon fiber: %d%n", carbonFiber);
        System.out.printf("Glass: %d%n", glass);
        System.out.printf("Lithium: %d", lithium);
    }
}
