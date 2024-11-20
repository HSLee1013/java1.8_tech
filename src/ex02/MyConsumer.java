package ex02;

// 입력만 받고 출력이 없는 연산을 수행합니다.
public interface MyConsumer<T> {
    void consume(T data);
}
