package ex02;

// 입력을 받아 논리값을 반환
public interface MyPredicate<T> {
    boolean apply(T t);
}
