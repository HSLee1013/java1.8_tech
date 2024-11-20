package ex04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupApp {
    public static void main(String[] args) {
        // 5. group
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Bavid", "anna");

        // Map<Character, List<String>>
        var groupData = names.stream().map(String::toUpperCase).collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println(groupData);
    }
}
