import java.util.*;
import java.util.stream.Collectors;

public class HornetAssault {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Long> beehives = Arrays.stream(scanner.nextLine()
                .split(" ")).map(Long::parseLong)
                .collect(Collectors.toList());
        List<Long> hornets = Arrays.stream(scanner.nextLine().split("\\s+")).map(Long::parseLong).collect(Collectors.toList());

        long powerOfHornets = hornets.stream().mapToLong(e -> e).sum();

        for (int i = 0; i < beehives.size(); i++) {
            beehives.set(i,beehives.get(i)-powerOfHornets);

            if (beehives.get(i)>=0){
                hornets.remove(0);
                powerOfHornets = hornets.stream().mapToLong(e -> e).sum();
            }
            if (beehives.isEmpty()||hornets.isEmpty()){
                break;
            }
        }

        long beesSize = beehives.stream().filter(e->e>0).count();

        if (beesSize>0) {
            beehives.stream().filter(e->e>0).forEach(e-> System.out.print(e+" "));
        }else {
            hornets.stream().filter(e->e>0).forEach(e-> System.out.print(e+" "));
        }
    }
}