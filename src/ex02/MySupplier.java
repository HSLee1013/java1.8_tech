package ex02;

// 입력 없이 값을 반환(리턴)
@FunctionalInterface
public interface MySupplier<T> {
    T get();
}
