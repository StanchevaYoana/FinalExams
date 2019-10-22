package softUniParking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parking {
    private Map<String, Car> cars;
    private int capacity;

    public Parking(int capacity) {
        this.capacity = capacity;
        this.cars = new HashMap<>();
    }

    public String addCar(Car car) {
        if (this.cars.containsKey(car.getRegistrationNumber())){
            return "Car with that registration number, already exists!";
        }
        if (this.cars.size()>=this.capacity){
            return "Parking is full!";
        }
        this.cars.put(car.getRegistrationNumber(),car);
        return String.format("Successfully added new car %s %s",car.getMake(),car.getRegistrationNumber());
    }

    public String removeCar(String registrationNumber) {
        if (!this.cars.containsKey(registrationNumber)){
            return "Car with that registration number, doesn't exists!";
        }

        this.cars.remove(registrationNumber);
        return "Successfully removed "+registrationNumber;
    }

    public void removeSetOfRegistrationNumber(List<String> registrationNumbers) {
        for (String regNum : registrationNumbers) {
            if (cars.containsKey(regNum)) {
              removeCar(regNum);
            }
        }
    }

    public Car getCar(String registrationNumber) {
        return this.cars.get(registrationNumber);
    }

    public int getCount() {
        return cars.values().size();
    }
}
