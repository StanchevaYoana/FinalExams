import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> studentsPoints = new LinkedHashMap<>();
        Map<String, Integer> languageSubmissions = new LinkedHashMap<>();
        String input;

        while (!"exam finished".equals(input = scanner.nextLine())) {
            String[] command = input.split("-");

            if (command.length == 3) {
                if (!studentsPoints.containsKey(command[0])) {
                    studentsPoints.put(command[0], Integer.valueOf(command[2]));
                } else {
                    int oldScore = studentsPoints.get(command[0]);
                    if (oldScore < Integer.valueOf(command[2])) {
                        studentsPoints.put(command[0], Integer.valueOf(command[2]));
                    }
                }
                if (!languageSubmissions.containsKey(command[1])) {
                    languageSubmissions.put(command[1], 1);
                } else {
                    languageSubmissions.put(command[1], languageSubmissions.get(command[1]) + 1);
                }
            } else {
                studentsPoints.remove(command[0]);
            }
        }

        System.out.println("Results:");
        studentsPoints.entrySet().stream().sorted((student1, student2) -> {
            int sort = student2.getValue().compareTo(student1.getValue());
            if (sort == 0) {
                sort = student1.getKey().compareTo(student2.getKey());
            }
            return sort;
        }).forEach(student -> {
            System.out.println(String.format("%s | %d", student.getKey(), student.getValue()));
        });
        System.out.println("Submissions:");
        languageSubmissions.entrySet().stream().sorted((language1, language2) -> {
            int sort = language2.getValue().compareTo(language1.getValue());
            if (sort == 0) {
                sort = language1.getKey().compareTo(language2.getKey());
            }
            return sort;
        }).forEach(student -> {
            System.out.println(String.format("%s - %d", student.getKey(), student.getValue()));
        });
    }
}
