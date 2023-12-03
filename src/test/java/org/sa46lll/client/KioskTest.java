package org.sa46lll.client;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sa46lll.cafe.Cafe;
import org.sa46lll.cafe.TddCafe;
import org.sa46lll.product.Product;

class KioskTest {

    private Cafe cafe;

    @BeforeEach
    void setUp() {
        cafe = new TddCafe();
    }

    @Test
    void 키오스크에_null을_입력하면_예외_발생() {
        Kiosk kiosk = new TddKiosk(cafe);

        Assertions.assertThatThrownBy(
                () -> kiosk.mapToProduct(null)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 키오스크에_없는_상품을_입력하면_예외_발생() {
        Kiosk kiosk = new TddKiosk(cafe);

        Assertions.assertThatThrownBy(
                () -> kiosk.mapToProduct("없는 상품")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 상품을_선택하면_상세_정보가_반환된다() {
        Kiosk kiosk = new TddKiosk(cafe);

        Product product = kiosk.mapToProduct("아메리카노");

        Assertions.assertThat(product.getPrice()).isPositive();
    }

    @Test
    void 커피와_빵이_포함된_메뉴를_확인한다() {
        Kiosk kiosk = new TddKiosk(cafe);

        Product product1 = kiosk.mapToProduct("아메리카노");
        Product product2 = kiosk.mapToProduct("소금빵");

        Assertions.assertThat(product1).isNotNull();
        Assertions.assertThat(product2).isNotNull();
    }
}
