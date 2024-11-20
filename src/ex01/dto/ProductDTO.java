package ex01.dto;


import ex01.model.Product;
import lombok.Data;

@Data
public class ProductDTO {
    private int id;
    private String name;

    public ProductDTO(Product product) {
        id = product.getId();
        name = product.getName();
    }
}
