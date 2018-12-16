package com.github.anavarro.kotlintestsample;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorJunit5Test {

    @Test
    public void addSameValues() {
        final Calculator calculator = new Calculator();
        int add = calculator.add(1, 1);
        Assertions.assertThat(add).isEqualTo(1 * 2);
    }

}
