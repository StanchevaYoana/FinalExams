package healthyHeaven;

import java.util.LinkedHashMap;
import java.util.Map;

public class Salad {
    private Map<String,Vegetable> products;
    private String name;

    public Salad(String name) {
        this.name = name;
        this.products = new LinkedHashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public void add (Vegetable vegetable){
        this.products.put(vegetable.getName(),vegetable);
    }

    public int getTotalCalories(){
        return this.products.values().stream().mapToInt(Vegetable::getCalories).reduce(0, Integer::sum);
    }
    public int getProductCount(){
        return this.products.size();
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append(String.format("* Salad %s is %d calories and have %d products:",getName(),getTotalCalories(),getProductCount()))
                .append(System.lineSeparator());

        this.products.values().forEach(e->builder.append(e.toString()).append(System.lineSeparator()));

        return builder.toString().trim();
    }
}
