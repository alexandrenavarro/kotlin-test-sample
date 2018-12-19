package com.github.anavarro.kotlintestsample;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CalculatorJunit5Test {


    @Nested
    class TestContext1 {

        @Test
        public void addSameValuesLevel2() {
            final Calculator calculator = new Calculator();
            int add = calculator.add(1, 1);
            Assertions.assertThat(add).isEqualTo(1 * 2);
        }
    }

    @Test
    public void addSameValuesLevel1() {
        final Calculator calculator = new Calculator();
        int add = calculator.add(1, 1);

        Assertions.assertThat(add).isEqualTo(1 * 2);
    }

}
