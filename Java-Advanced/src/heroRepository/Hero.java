package heroRepository;

public class Hero {
    private String name;
    private int level;
    private Item item;

    public Hero(String name, int level, Item item) {
        this.name = name;
        this.level = level;
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "Hero: " + name + " - " + level +
                "\n * Strength: " + item.getStrength() +
                "\n * Agility: " + item.getAgility() +
                "\n * Intelligence: " + item.getIntelligence();
    }
}
