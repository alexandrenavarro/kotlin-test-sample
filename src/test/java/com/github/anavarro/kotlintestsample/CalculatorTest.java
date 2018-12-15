package com.github.anavarro.kotlintestsample;

import org.assertj.core.api.Assertions;
import org.junit.Test;


public class CalculatorTest {

    @Test
    public void add() {
        final Calculator calculator = new Calculator();
        int add = calculator.add(1, 1);
        Assertions.assertThat(add).isEqualTo(2);
    }
}