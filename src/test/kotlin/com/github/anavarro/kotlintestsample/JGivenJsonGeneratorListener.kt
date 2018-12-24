package com.github.anavarro.kotlintestsample

import com.fasterxml.jackson.databind.ObjectMapper
import org.spekframework.spek2.lifecycle.LifecycleListener
import org.spekframework.spek2.runtime.scope.TestScopeImpl
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

class JGivenJsonGeneratorListener() : LifecycleListener {

    val reportMap: MutableMap<String, JGivenReport> = mutableMapOf()

    override fun afterExecuteTest(test: org.spekframework.spek2.lifecycle.TestScope): kotlin.Unit {

        test as TestScopeImpl

        var words = test.path.toString().split("/")
        val executedTest = ExecutedTest("${words[0]}.${words[1]}", words[2], words[3], words[4])

        val reportKey = executedTest.className + " " + executedTest.featureName
        if (!reportMap.containsKey(reportKey)) {
            reportMap[reportKey] = JGivenReport(executedTest.className, executedTest.featureName)
        }
        val report = reportMap[reportKey]

        report?.addExectutedTestPath(executedTest)

        val result = ObjectMapper().writeValueAsString(report)

        // TODO not optimize at all
        for (value in reportMap.values) {
            Files.deleteIfExists(Paths.get("target/jgiven-reports/json/${value.className}${value.name}.json"))
            Files.write(Paths.get("target/jgiven-reports/json/${value.className}${value.name}..json"), listOf(result))

        }

    }

}

data class ExecutedTest(val className: String,
                        val featureName: String,
                        val scenarioName: String,
                        val stepName: String)


data class JGivenReport(val className: String,
                        val name: String,
                        val scenarios: MutableList<Scenario> = mutableListOf()) {

    fun addExectutedTestPath(executedTest: ExecutedTest) {
        var existedScenarios = scenarios.filter { it.description == executedTest.scenarioName }
        val scenario : Scenario
        if (existedScenarios.isEmpty()) {
            scenario = Scenario(executedTest.scenarioName)
            val caseNr = scenario.scenarioCases.size + 1
            scenario.scenarioCases.add(UseCase(caseNr))
            scenarios.add(scenario)
        } else {
            scenario = existedScenarios.last()
        }
        scenario.scenarioCases[0].steps.add(Step(mutableListOf(Word(executedTest.stepName))))


    }
}

data class Scenario(val description: String,
                    val scenarioCases: MutableList<UseCase> = mutableListOf())

data class UseCase(val caseNr: Int,
                   val steps: MutableList<Step> = mutableListOf())

data class Step(val words: MutableList<Word> = mutableListOf())

data class Word(val value: String)


//{
//    "className": "com.github.anavarro.kotlintestsample.CalculatorFeature",
//    "name": "Feature: A calculator",
//    "scenarios": [
//    {
//        "description": "Scenario: Add 2 numbers",
//        "scenarioCases": [
//        {
//            "caseNr": 1,
//            "steps": [
//            {
//                "words": [
//                {
//                    "value": "When: Add 1 with 1 json:{euieuisrneiut}\n neiseti \n nuesiet \n"
//                }
//                ]
//            },
//            {
//                "words": [
//                {
//                    "value": "Then: it should be equals to 2"
//                }
//                ]
//            }
//            ]
//        },
//        {
//            "caseNr": 2,
//            "steps": [
//            {
//                "words": [
//                {
//                    "value": "When: Add 2 with 2"
//                }
//                ]
//            },
//            {
//                "words": [
//                {
//                    "value": "Then: it should be equals to 4"
//                }
//                ]
//            }
//            ]
//        }
//        ]
//    },
//    {
//        "description": "Scenario: Sub 2 numbers",
//        "scenarioCases": [
//        {
//            "steps": [
//            {
//                "words": [
//                {
//                    "value": "When: Sub 1 with 1"
//                }
//                ]
//            },
//            {
//                "words": [
//                {
//                    "value": "Then: it should be equals to 0"
//                }
//                ]
//            }
//            ]
//        }
//        ]
//    }
//    ]
//}