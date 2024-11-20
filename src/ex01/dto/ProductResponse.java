package ex01.dto;

import ex01.model.Product;
import ex01.model.ProductOption;

import java.util.ArrayList;
import java.util.List;

public class ProductResponse {
    public static class DTO {
        private int id;
        private String name;

        public DTO(Product product) {
            this.id = product.getId();
            this.name = product.getName();
        }

        @Override
        public String toString() {
            return "%d %s".formatted(id, name);
        }
    }

    public static class DetailDTO {
        private int id;
        private String name;
        private List<OptionDTO> options;

        public DetailDTO(List<ProductOption> options) {
            this.id = options.get(0).getProduct().getId();
            this.name = options.get(0).getProduct().getName();
            this.options = new ArrayList<OptionDTO>();
            for (ProductOption option : options) {
                this.options.add(new OptionDTO(option));
            }
        }

        @Override
        public String toString() {
            return "%d %s\n%s".formatted(id, name, options);
        }

        public static class OptionDTO {
            private int id;
            private String name;
            private int price;
            private int qty;

            public OptionDTO(ProductOption productOption) {
                this.id = productOption.getId();
                this.name = productOption.getName();
                this.price = productOption.getPrice();
                this.qty = productOption.getQty();
            }

            @Override
            public String toString() {
                return "%d %s %d %d".formatted(id, name, price, qty);
            }
        }
    }
}
