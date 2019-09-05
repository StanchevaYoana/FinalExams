import java.util.Scanner;

public class MergingAndSquashing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] anArray = new String[n];
        String temp;
        for (int i = 0; i < n; i++) {
            anArray[i] = scanner.nextLine();
        }
        for (int i = 0; i < n - 1; i++) {
            temp = anArray[i] + anArray[i + 1];
            System.out.print(temp.substring(1, temp.length() - 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < n - 1; i++) {
            int result = (anArray[i].charAt(1) - '0') + (anArray[i + 1].charAt(0) - '0');
            if (result >= 10 ) {
                result = result%10;
            }
            System.out.print(anArray[i].charAt(0) + "" + result + "" + anArray[i + 1].charAt(1) + " ");
        }
    }
}