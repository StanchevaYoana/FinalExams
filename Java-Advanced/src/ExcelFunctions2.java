import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ExcelFunctions2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        String[][] table = new String[n][];

        for (int i = 0; i < n; i++) {
            table[i] = reader.readLine().split(", ");
        }
        System.out.println();

        String[] command = reader.readLine().split(" ");
        int col = findColumn(table, command[1]);

        switch (command[0]) {
            case "hide":
                for (int i = 0; i < table.length; i++) {
                    table[i][col] = null;
                }
                for (String[] strings : table) {
                    List<String> list = new ArrayList<>();
                    Arrays.stream(strings).filter(Objects::nonNull).forEach(list::add);
                    System.out.println(String.join(" | ", list));
                }
                break;

            case "sort":
                for (int j = 0; j < table.length; j++) {
                    for (int i = 1; i < table.length - 1 - j; i++) {
                        if (table[i][col].compareTo(table[i + 1][col]) > 0) {
                            String[] temp = table[i];
                            table[i] = table[i + 1];
                            table[i + 1] = temp;
                        }
                    }
                }
                for (String[] strings : table) {
                    System.out.println(String.join(" | ", strings));
                }
                break;
            case "filter":
                System.out.println(String.join(" | ", table[0]));
                for (int i = 1; i < table.length; i++) {
                    if (table[i][col].equals(command[2])) {
                        System.out.println(String.join(" | ", table[i]));
                    }
                }
                break;
        }
    }

    private static int findColumn(String[][] table, String column) {
        int col = -1;

        for (int i = 0; i < table[0].length; i++) {
            if (table[0][i].equals(column)) {
                col = i;
                break;
            }
        }
        return col;
    }
}
