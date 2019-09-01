import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hospital {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>> doctorAndPatients = new LinkedHashMap<>();
        Map<String, List<String>> departmentAndPatients = new LinkedHashMap<>();

        String input;
        while (!"Output".equals(input = reader.readLine())) {
            String[] data = input.split("\\s+");
            String department = data[0];
            String doctor = data[1] + " " + data[2];
            String patient = data[3];

            departmentAndPatients.putIfAbsent(department, new ArrayList<>());
            departmentAndPatients.get(department).add(patient);
            doctorAndPatients.putIfAbsent(doctor, new ArrayList<>());
            doctorAndPatients.get(doctor).add(patient);
        }

        String string;
        while (!"End".equals(string = reader.readLine())) {

            String[] command = string.split("\\s+");

            if (command.length == 1) {
                if (departmentAndPatients.containsKey(command[0])) {
                    departmentAndPatients.get(command[0]).forEach(System.out::println);
                }
            } else {
                String doctorName = command[0] + " " + command[1];

                if (doctorAndPatients.containsKey(doctorName)) {
                    doctorAndPatients.get(doctorName).stream().sorted(String::compareTo).forEach(System.out::println);
                } else {
                    int numOfRoom = Integer.parseInt(command[1]);
                    if (numOfRoom > 20 || numOfRoom < 0) {
                        continue;
                    }
                    int numOfPatientInDepartment = (numOfRoom - 1) * 3;
                    Set<String> patientsOfGivenRoom = new TreeSet<>();
                    for (int i = numOfPatientInDepartment; i < numOfPatientInDepartment + 3; i++) {
                        patientsOfGivenRoom.add(departmentAndPatients.get(command[0]).get(i));
                    }
                    patientsOfGivenRoom.forEach(System.out::println);
                }
            }
        }
    }
}
