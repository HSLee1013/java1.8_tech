package ex01.dto;

import ex01.model.OrderOption;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class OrderDetailDTO {
    private int orderId;
    private List<OrderProductDTO> products;
    private int sumPrice;

    public OrderDetailDTO(List<OrderOption> options) {
        // orderId
        this.orderId = options.get(0).getOrder().getId();

        // 2. sumPrice
        sumPrice = options.stream().mapToInt(OrderOption::getTotalPrice).sum();

        // 3. products
        // 3.1 주문옵션들 productId [1,1,2]

        Set<Integer> ids = options.stream().map(o -> o.getProduct().getId()).collect(Collectors.toSet());

        products = new ArrayList<>();
        for (Integer id : ids) {
            products.add(new OrderProductDTO(options.stream().filter(o -> o.getProduct().getId() == id).toList()));
        }
    }

    @Data
    private class OrderProductDTO {
        private int productId;
        private List<OrderOptionDTO> options;

        public OrderProductDTO(List<OrderOption> options) {
            this.productId = options.get(0).getProduct().getId();
            this.options = options.stream().map(OrderOptionDTO::new).toList();
        }

        @Data
        private class OrderOptionDTO {
            private int id;
            private String optionName;
            private int qty;
            private int totalPrice;

            public OrderOptionDTO(OrderOption option) {
                this.id = option.getId();
                this.optionName = option.getOptionName();
                this.qty = option.getQty();
                this.totalPrice = option.getTotalPrice();
            }
        }
    }
}
