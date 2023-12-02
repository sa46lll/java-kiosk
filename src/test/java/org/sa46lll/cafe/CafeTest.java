package org.sa46lll.cafe;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.sa46lll.client.Kiosk;
import org.sa46lll.client.TddKiosk;
import org.sa46lll.order.Order;
import org.sa46lll.product.CoffeeSize;
import org.sa46lll.product.Product;

class CafeTest {

    private Cafe cafe;
    private Kiosk kiosk;

    @BeforeEach
    void setUp() {
        cafe = new TddCafe();
        kiosk = new TddKiosk(cafe);
    }

    @Test
    void 상품의_사이즈와_수량을_선택하여_주문한다() {
        Product product = kiosk.mapToProduct("아메리카노");

        Order order = cafe.order(product, 3, CoffeeSize.TALL);

        System.out.println(order.getQuantity());
        Assertions.assertThat(order.getQuantity()).isEqualTo(3);
        Assertions.assertThat(order.getSize()).isEqualTo(CoffeeSize.TALL);
    }

    @Disabled
    @Test
    void 주문한_상품의_가격을_알_수_있다() {
        Product product = kiosk.mapToProduct("아메리카노");

        Order order = cafe.order(product, 3, CoffeeSize.TALL);

        Assertions.assertThat(order.getTotalPrice()).isEqualTo(product.getPrice() * 3);
    }

    @Disabled
    @Test
    void 주문_번호는_연속적으로_증가해야_한다() {
        Product product = kiosk.mapToProduct("아메리카노");

        Order order1 = cafe.order(product, 1, CoffeeSize.TALL);
        Order order2 = cafe.order(product, 2, CoffeeSize.GRANDE);

        Assertions.assertThat(order1.getOrderNumber() - order2.getOrderNumber()).isEqualTo(1);
    }

    @Disabled
    @Test
    void 주문_생성_시간을_알_수_있다() {
        Product product = kiosk.mapToProduct("아메리카노");

        Order order = cafe.order(product, 1, CoffeeSize.TALL);

        Assertions.assertThat(order.getCreatedAt()).isNotNull();
    }
}
