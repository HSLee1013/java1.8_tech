package ex01.dto;

import ex01.model.OrderOption;

import java.util.*;

public class OrderResponse {

    public static class DetailDTO {
        private int id;
        private List<ProductDTO> products;
        private int sumPrice;

        public DetailDTO(List<OrderOption> options) {
            this.id = options.get(0).getOrder().getId();
            products = new ArrayList<ProductDTO>();
            Map<Integer, List<OrderOption>> map = new HashMap<>();
            for (OrderOption orderOption : options) {
                int id = orderOption.getProduct().getId();
                if (!map.containsKey(id)) {
                    map.put(id, new ArrayList<>());
                }
                map.get(id).add(orderOption);
                sumPrice += orderOption.getTotalPrice();
            }
            for (List<OrderOption> value : map.values()) {
                products.add(new ProductDTO(value));
            }
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("주문 번호: ").append(id).append('\n');
            for (ProductDTO productDTO : products) {
                stringBuilder.append(productDTO);
            }
            stringBuilder.append("총 가격: ").append(sumPrice).append("원");
            return stringBuilder.toString();
        }

        public static class ProductDTO {
            private int id;
            private List<OptionDTO> options;

            public ProductDTO(List<OrderOption> options) {
                this.id = options.get(0).getProduct().getId();
                this.options = new ArrayList<OptionDTO>();
                for (OrderOption orderOption : options) {
                    this.options.add(new OptionDTO(orderOption));
                }
            }

            @Override
            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("상품 번호: ").append(id).append('\n');
                for (OptionDTO optionDTO : options) {
                    stringBuilder.append(optionDTO).append('\n');
                }
                return stringBuilder.toString();
            }

            public static class OptionDTO {
                private int id;
                private String optionName;
                private int qty;
                private int totalPrice;

                public OptionDTO(OrderOption option) {
                    this.id = option.getId();
                    this.optionName = option.getOptionName();
                    this.qty = option.getQty();
                    this.totalPrice = option.getTotalPrice();
                }

                @Override
                public String toString() {
                    return "%d %s %d %d".formatted(id, optionName, qty, totalPrice);
                }
            }
        }
    }
}