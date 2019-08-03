import java.util.Scanner;

public class StringManipulatorExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        String input;

        while (!"Done".equals(input = scanner.nextLine())) {
            String[] command = input.split(" ");

            switch (command[0]) {
                case "Change":
                    string = string.replaceAll(command[1], command[2]);
                    System.out.println(string);
                    break;

                case "Includes":
                    if (string.contains(command[1])) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;

                case "End":
                    String tobeChecked = command[1];
                    if (tobeChecked.length() < string.length()) {
                        int length = string.length() - tobeChecked.length();
                        String newString = string.substring(length);
                        if (newString.equals(tobeChecked)) {
                            System.out.println("True");
                        } else {
                            System.out.println("False");
                        }
                    }

                    break;
                case "Uppercase":
                    string = string.toUpperCase();
                    System.out.println(string);

                    break;

                case "FindIndex":
                    if (string.contains(command[1])) {
                        System.out.println(string.indexOf(command[1]));
                    }
                    break;

                case "Cut":
                    int start = Integer.parseInt(command[1]);
                    int end = Integer.parseInt(command[2]);
                    if (start > 0 && end < string.length()) {
                        string = string.substring(Integer.parseInt(command[1]), Integer.parseInt(command[1]) + Integer.parseInt(command[2]));
                        System.out.println(string);
                    }
                    break;
            }
        }
    }
}

