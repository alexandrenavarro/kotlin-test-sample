package com.github.anavarro.kotlintestsample

import org.assertj.core.api.Assertions
import org.spekframework.spek2.Spek
import org.spekframework.spek2.lifecycle.LifecycleListener
import org.spekframework.spek2.runtime.scope.TestScopeImpl
import org.spekframework.spek2.style.gherkin.Feature

object CalculatorFeature : Spek({
    Feature("A calculator") {
        val calculator = Calculator()
        var result = 1;

        Scenario("Add 2 numbers") {

            When("Add 1 with 1") {
                result = calculator.substract(2, 1)
            }

            Then("it should be equals to 2") {
                Assertions.assertThat(result).isEqualTo(1)
            }

        }
    }
    this.registerListener(TestListener())
})



