package org.sa46lll.kiosk;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class KioskTest {

    @Test
    void 키오스크에_null을_입력하면_예외_발생() {
        Kiosk kiosk = new TddKiosk();

        Assertions.assertThatThrownBy(
                () -> kiosk.selectProduct(null)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 키오스크에_없는_상품을_입력하면_예외_발생() {
        Kiosk kiosk = new TddKiosk();

        Assertions.assertThatThrownBy(
                () -> kiosk.selectProduct("없는 상품")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 키오스크에_상품이_존재한다() {
        Kiosk kiosk = new TddKiosk();
        List<Product> menus = kiosk.getProduct();

        List<String> menuNames = menus.stream()
                .map(Product::getName)
                .toList();

        Assertions.assertThat(menuNames).contains("아메리카노");
    }

    @Test
    void 상품을_선택하면_상세_정보가_반환된다() {
        Kiosk kiosk = new TddKiosk();
        Product product = kiosk.selectProduct("아메리카노");

        Assertions.assertThat(product.getPrice()).isPositive();
    }
}
