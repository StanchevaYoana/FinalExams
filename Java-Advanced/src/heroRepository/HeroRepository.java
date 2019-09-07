package heroRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HeroRepository {

    private Map<String, Hero> data;

    public HeroRepository() {
        this.data = new HashMap<>();
    }

    public void add(Hero hero) {
        this.data.put(hero.getName(), hero);
    }

    public void remove(String name) {
        this.data.remove(name);
    }

    public Hero getHeroWithHighestStrength (){
      return this.data.values()
              .stream().sorted((f,s)-> s.getItem().getStrength() - f.getItem().getStrength())
              .collect(Collectors.toList()).get(0);

    }

    public  Hero getHeroWithHighestAgility(){
        return this.data.values()
                .stream().sorted((f,s) -> s.getItem().getAgility() - f.getItem().getAgility())
                .collect(Collectors.toList()).get(0);
    }

    public  Hero getHeroWithHighestIntelligence () {
        return  this.data.values()
                .stream().sorted((f,s) -> s.getItem().getIntelligence() - f.getItem().getIntelligence())
                .collect(Collectors.toList()).get(0);
    }
    public  int getCount (){
        return this.data.size();
    }

    @Override
    public String toString() {
        return this.data.values()
                .stream()
                .map(Hero::toString)
                .collect(Collectors.joining("\n"));
    }
}
