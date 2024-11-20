package ex01.model;

import ex01.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OrderOption {
    private int id;
    private String optionName; // 하얀티
    private int qty; // 5개
    private int totalPrice; // 10000원

    private Product product;
    private Order order;
}