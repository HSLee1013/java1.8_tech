package ex02;

// 1. 람다는 인터페이스로 만든다.
// 2. 인터페이스는 메서드 하나만 존재해야 한다.
// 3. 메서드가 인터페이스를 매개변수로 받고 있으면, 행위를 주세요!!
// 4. 람다에서는 매개변수에 타입을 생략 가능하다.
// 5. @FunctionalInterface로 람다 인터페이스 표시 가능

public class App {
    public static void main(String[] args) {
        MyConsumer<Integer> r1 = (data) -> {
            System.out.println("소비할 데이터: " + data);
        };
        r1.consume(1);

        MySupplier<String> r2 = () -> {
            return "good";
        };
        MySupplier<String> r3 = () -> "good";
        String msg = r3.get();
        System.out.println(msg);

        MyFunction<Integer, String> r4 = (data)->{
            return "data:" + data;
        };

        MyPredicate<Integer> r5 = x -> x > 5;
        boolean msg2 = r5.apply(10);
        System.out.println(msg2);
    }
}
