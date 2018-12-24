package com.github.anavarro.kotlintestsample

import io.mockk.every
import io.mockk.mockk
import org.amshove.kluent.shouldContain
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

        describe("mock calculator") {

            val mockCalculator = mockk<Calculator>()
            every { mockCalculator.substract(any(), any()) } returns 0

            describe("Test mock") {

                var test2 = mockCalculator.substract(1, 3)
                it("test mock returns 0") {
                    Assertions.assertThat(test2).isEqualTo(0)
                }
                it("test mock retrun 0") {
                    Assertions.assertThat(test2).isEqualTo(0)
                }

            }
        }

        describe("test list with test1 and test2") {
            val list = listOf("test1", "test2")

            it("should contain test1") {
                list shouldContain "test1"
            }

            it("should contain test2") {
                list shouldContain "test2"
            }

        }


    }




})