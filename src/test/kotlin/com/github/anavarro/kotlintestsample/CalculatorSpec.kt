package com.github.anavarro.kotlintestsample

import org.assertj.core.api.Assertions
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object CalculatorSpec: Spek({

    describe("A calculator") {
        val calculator by memoized { Calculator() }

        describe("addition") {
            it("returns the sum of its arguments") {
                var test = calculator.substract(2, 1)
                Assertions.assertThat(test).isEqualTo(1)

            }
        }

        for (i in 1..3) {
            describe("addition $i + $i") {
                it("returns the sum of its arguments") {
                    var test = calculator.substract(i, i)
                    Assertions.assertThat(test).isEqualTo(0)

                }
            }
        }
    }


})