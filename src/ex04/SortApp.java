package ex04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortApp {
    public static void main(String[] args) {
        // 4. sort, distinct(정렬 후 성능 더 좋음)
        List<Integer> nums = Arrays.asList(5, 3, 1, 4, 2);

        nums.stream().sorted().distinct().forEach(System.out::println);
    }
}
