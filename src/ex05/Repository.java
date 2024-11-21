package ex05;

import java.util.Arrays;
import java.util.List;

public class Repository {
    public List<Integer> findAll() {
        return Arrays.asList(1, 2, 3, 4, 5);
    }

    public int findById() {
        // 조회하다가 오류 [숫자를 리턴]
        // -1 오류 (안됨 - 타입이 달라질 수 있다)
        // 오류가 난 곳에서 처리 (안됨 - 책임이 분리되어 있으니까)
        throw new RuntimeException("디비에서 오류가 났어");
    }
}
