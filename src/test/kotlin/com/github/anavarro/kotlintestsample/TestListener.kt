package com.github.anavarro.kotlintestsample

import org.spekframework.spek2.lifecycle.LifecycleListener
import org.spekframework.spek2.runtime.scope.TestScopeImpl

class TestListener : LifecycleListener {

    public override fun afterExecuteGroup(group: org.spekframework.spek2.lifecycle.GroupScope): kotlin.Unit {
        println(group)
    }

    public override fun afterExecuteTest(test: org.spekframework.spek2.lifecycle.TestScope): kotlin.Unit {
        /* compiled code */
        test as TestScopeImpl
        println(test.path)
    }

    public override fun beforeExecuteGroup(group: org.spekframework.spek2.lifecycle.GroupScope): kotlin.Unit {
        /* compiled code */
        println(group)
    }

    public override fun beforeExecuteTest(test: org.spekframework.spek2.lifecycle.TestScope): kotlin.Unit {
        /* compiled code */
        println(test)

    }
}