package heroRepository;

public class Item {
   private int strength;
   private int agility;
   private int intelligence;

    public Item(int strength, int agility, int intelligence) {
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    @Override
    public String toString() {
       return "Item:" +
                "\n * Strength: " + strength +
                "\n * Agility: " + agility +
                "\n * Intelligence: " + intelligence;
    }
}
