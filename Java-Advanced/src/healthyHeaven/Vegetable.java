package healthyHeaven;

public class Vegetable {
    private String name;
    private int calories;

    public Vegetable(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return String.format(" - %s have %d calories",this.name,this.calories);
    }
}