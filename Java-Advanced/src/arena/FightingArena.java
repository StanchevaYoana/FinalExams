package arena;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FightingArena {
    private List<Gladiator> gladiators;
    private String name;

    public FightingArena(String name) {
        this.name = name;
        this.gladiators = new ArrayList<>();
    }

    public void add(Gladiator gladiator) {
        this.gladiators.add(gladiator);
    }

    public void remove(String name) {
        this.gladiators = this.gladiators.stream().filter(e -> !e.getName().equals(name)).collect(Collectors.toList());
    }

    public Gladiator getGladiatorWithHighestStatPower() {
        return this.gladiators.stream().max(Comparator.comparing(Gladiator::getStatPower)).orElse(null);
    }

    public Gladiator getGladiatorWithHighestWeaponPower() {
        return this.gladiators.stream().max(Comparator.comparing(Gladiator::getWeaponPower)).orElse(null);
    }

    public Gladiator getGladiatorWithHighestTotalPower() {
        return this.gladiators.stream().max(Comparator.comparing(Gladiator::getTotalPower)).orElse(null);
    }

    public int getCount() {
        return this.gladiators.size();
    }

    @Override
    public String toString() {
        return String.format("%s – %d gladiators are participating.", this.name, this.getCount());
    }
}
