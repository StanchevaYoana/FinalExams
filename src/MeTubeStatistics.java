import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MeTubeStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> videoLikes = new LinkedHashMap<>();
        Map<String, Integer> videoViews = new LinkedHashMap<>();

        String input;
        while(!"stats time".equals(input = scanner.nextLine())){
            if (input.contains(":")) {
                String [] command = input.split(":");
                if (videoLikes.containsKey(command[1])){
                    if (command [0].equals("like")){
                        videoLikes.put(command[1], videoLikes.get(command[1])+1);
                    } else {
                        videoLikes.put(command[1], videoLikes.get(command[1])- 1);
                    }
                }
            } else {
                String [] command = input.split("-");
                if (videoViews.containsKey(command[0])){
                    int allViews = videoViews.get(command[0]) +  Integer.parseInt(command [1]);
                    videoViews.put(command[0], allViews);
                } else {
                    videoViews.put(command [0], Integer.parseInt(command[1]));
                    videoLikes.put(command[0],0);
                }

            }
        }
        String howToSort = scanner.nextLine();

        if (howToSort.equals("by likes")) {
            videoLikes.entrySet().stream().sorted((video1, video2) -> {
                return video2.getValue().compareTo(video1.getValue());
            }).forEach(video -> {
                System.out.println(String.format("%s - %d views - %d likes", video.getKey(),videoViews.get(video.getKey()), video.getValue()));
            });

        } else {
            videoViews.entrySet().stream().sorted((video1, video2) -> {
                return video2.getValue().compareTo(video1.getValue());
            }).forEach(video -> {
                System.out.println(String.format("%s - %d views - %d likes", video.getKey(),video.getValue(), videoLikes.get(video.getKey())));
            });
        }
    }
}
