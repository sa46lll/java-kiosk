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
                () -> kiosk.selectProduct(null)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 키오스크에_없는_상품을_입력하면_예외_발생() {
        Kiosk kiosk = new TddKiosk(cafe);

        Assertions.assertThatThrownBy(
                () -> kiosk.selectProduct("없는 상품")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 상품을_선택하면_상세_정보가_반환된다() {
        Kiosk kiosk = new TddKiosk(cafe);

        Product product = kiosk.selectProduct("아메리카노");

        Assertions.assertThat(product.getPrice()).isPositive();
    }
}
