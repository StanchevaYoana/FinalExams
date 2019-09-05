import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Socks {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> leftSocks = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(leftSocks::push);
        ArrayDeque<Integer> rightSocks = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(rightSocks::offer);
        List<Integer> pairs = new ArrayList<>();

        while (!leftSocks.isEmpty() && !rightSocks.isEmpty()) {
            int left = leftSocks.peek();
            int right = rightSocks.peek();

            if (left == right) {
                rightSocks.poll();
                leftSocks.push(leftSocks.pop() + 1);
            } else if (right > left) {
                leftSocks.pop();
            } else {
                pairs.add(leftSocks.pop() + rightSocks.poll());
            }
        }

        int max = Collections.max(pairs);

        System.out.println(max);
        System.out.println(pairs.toString()
                .replaceAll("[\\[\\],]", ""));


    }
}
