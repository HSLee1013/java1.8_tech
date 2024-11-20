package ex01.dto;

import ex01.model.ProductOption;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDetailDTO {
    private int productId;
    private String productName;

    private List<ProductOptionDTO> options;

    public ProductDetailDTO(List<ProductOption> options) {
        this.productId = options.get(0).getProduct().getId();
        this.productName = options.get(0).getProduct().getName();
        this.options = new ArrayList<>();
        for (ProductOption option : options) {
            this.options.add(new ProductOptionDTO(option));
        }
        this.options = options.stream().map(ProductOptionDTO::new).toList();
    }

    @Data
    private class ProductOptionDTO {
        private int id;
        private String name;
        private int price;
        private int qty;

        public ProductOptionDTO(ProductOption option) {
            this.id = option.getId();
            this.name = option.getName();
            this.price = option.getPrice();
            this.qty = option.getQty();
        }
    }
}
