package ex04;

import java.util.Arrays;
import java.util.List;

public class MapApp {
    public static void main(String[] args) {
        // 2. map (가공)
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        List<String> newNames = names.stream().map(name -> name.toLowerCase()).filter(name -> name.length() > 3).toList();

        newNames.forEach(name -> System.out.println(name));
    }
}
