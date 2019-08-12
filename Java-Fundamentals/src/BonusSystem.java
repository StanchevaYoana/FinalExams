import java.util.Scanner;

public class BonusSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = Integer.parseInt(scanner.nextLine());
        int courseLectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());

        int totalBonus = 0;

        int maxAttendedLectures = 0;

        while (students-- > 0) {
            int studentAttendances = Integer.parseInt(scanner.nextLine());
            int studentBonus = (int) Math.ceil(1.0 * studentAttendances / courseLectures * (5 + additionalBonus));
            if (studentBonus >= totalBonus) {
                totalBonus = studentBonus;
                if (studentAttendances > maxAttendedLectures) {
                    maxAttendedLectures = studentAttendances;
                }
            }
        }
        System.out.printf("The maximum bonus score for this course is %d.The student has attended %d lectures.", totalBonus, maxAttendedLectures);
    }
}

