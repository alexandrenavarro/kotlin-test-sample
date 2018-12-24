package com.github.anavarro.kotlintestsample



import com.github.anavarro.kotlintestsample.Persons.adress
import com.github.anavarro.kotlintestsample.Persons.person
import org.amshove.kluent.shouldBe
import org.assertj.core.api.Assertions
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature


object CalculatorFeature : Spek({


    Feature("A calculator") {
        val calculator = Calculator()
        var result = 1

        Scenario("Add 2 numbers") {

            When("Add 1 with 1") {
                result = calculator.substract(2, 1)
            }

            Then("it should be equals to 2") {
                Assertions.assertThat(result).isEqualTo(1)
            }

        }

    }

    Feature("A Person Feature") {
        Scenario("A person Scenario") {

            var aPerson = person {
                firstName = "first"
                lastName = "lastname"
                adresses = listOf(
                        adress {
                            number = 10
                            street = "My Street"
                        },
                        adress {
                            number = 11
                            street = "My Street2"
                        })
            }

            Given("A person with 2 adresses Given") {
            }

            Then("it should have adresses.size()=2 Then") {
                aPerson.adresses.size shouldBe 2
            }

        }
    }

    this.registerListener(JGivenJsonGeneratorListener())
})


object Persons {
    fun person(block: Person.() -> Unit): Person = Person().apply(block)

    fun adress(block: Adress.() -> Unit): Adress = Adress().apply(block)
    operator fun Adress.unaryPlus() = listOf<Adress>(this)

}

fun Person.name() = "${this.firstName} ${this.lastName}"




