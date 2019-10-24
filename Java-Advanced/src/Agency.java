import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;


public class Agency {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<String> ID = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+")).forEach(ID::push);
        ArrayDeque<String> agents = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+")).forEach(agents::offer);

        String input;

        while (!"stop".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "add-ID":
                    ID.push(tokens[1]);
                    break;
                case "add-agent":
                    agents.offer(tokens[1]);
                    break;
                case "remove-ID":
                    System.out.println(ID.poll() + " has been removed.");
                    break;
                case "remove-agent":
                    System.out.println(agents.removeLast() + " has left the queue.");
                    break;
                case "sort-ID":
                    ID = ID.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(ArrayDeque::new));
                    break;
            }
        }

        while (!agents.isEmpty() && !ID.isEmpty()){
            System.out.println(String.format("%s takes ID number: %s", agents.poll(), ID.pop()));
        }
        if (!agents.isEmpty() && ID.isEmpty()){
            while(agents.size() > 0){
                System.out.println(String.format("%s does not have an ID.", agents.poll()));
            }
        }
        if (agents.isEmpty() && !ID.isEmpty()){
            System.out.println("No more agents left.");
            while(ID.size() > 0){
                System.out.println(String.format("ID number: %s", ID.pop()));
            }
        }
    }
}
