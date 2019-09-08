import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ExcelFunctions {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());

        String[][] table = new String[size][];

        for (int i = 0; i < table.length; i++) {
            table[i] = reader.readLine().split(", ");
        }

        String[] command = reader.readLine().split("\\s+");

        switch (command[0]) {
            case "hide":
                hideByColumnAndPrint(table, command[1]);
                break;

            case "sort":
                sortByColumnAndPrint(table, command[1]);
                break;

            case "filter":
                filterByColumnAndPrint(table, command[1], command[2]);
                break;
        }
    }

    private static int findIndex(String[] table, String command) {
        int index = -1;
        for (int i = 0; i < table.length; i++) {
            if (table[i].equals(command)) {
                index = i;
                break;
            }
        }
        return index;
    }

    private static void filterByColumnAndPrint(String[][] table, String filterColumn, String filterValue) {
        int filterColumnIndex = findIndex(table[0], filterColumn);
        System.out.println(String.join(" | ", table[0]));
        for (int i = 1; i < table.length; i++) {
            if (table[i][filterColumnIndex].equals(filterValue)) {
                System.out.println(String.join(" | ", table[i]));
            }
        }
    }

    private static void sortByColumnAndPrint(String[][] table, String sortValue) {
        int colToSort = findIndex(table[0], sortValue);

        for (int j = 0; j < table.length; j++) {
            for (int i = 1; i < table.length - 1 - j; i++) {
                if (table[i][colToSort].compareTo(table[i + 1][colToSort]) > 0) {
                    String[] temp = table[i];
                    table[i] = table[i + 1];
                    table[i + 1] = temp;
                }
            }
        }
        for (String[] strings : table) {
            System.out.println(String.join(" | ", strings));
        }
    }


    private static void hideByColumnAndPrint(String[][] table, String columnToHide) {
        int hiddenColumnIndex = findIndex(table[0], columnToHide);

        for (int i = 0; i < table.length; i++) {
            table[i][hiddenColumnIndex] = null;
        }

        for (String[] strings : table) {
            List<String> printList = new ArrayList<>();
            Arrays.stream(strings).filter(Objects::nonNull).forEach(printList::add);
            System.out.println(String.join(" | ", printList));
        }
    }
}
