package ex01.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductOption {
    private int id;
    private String name;
    private int price;
    private int qty;
    private Product product;
}