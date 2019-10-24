package healthyHeaven;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Restaurant {
    private String name;
    private Map<String, Salad> data;

    public Restaurant(String name) {
        this.name = name;
        this.data = new LinkedHashMap<>();
    }

    public void add(Salad salad) {
        this.data.put(salad.getName(), salad);
    }

    public boolean buy(String name) {

        if (this.data.containsKey(name)) {

            this.data.remove(name);
            return true;

        }
        return false;
    }

    public Salad getHealthiestSalad(){
        return this.data.values().stream().min(Comparator.comparingInt(Salad::getTotalCalories)).orElse(null);
    }

    public String generateMenu() {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("%s have %d salads:",this.name,this.data.size())).append(System.lineSeparator());

        this.data.values().forEach(e->builder.append(e.toString()).append(System.lineSeparator()));

        return builder.toString().trim();
    }

}
