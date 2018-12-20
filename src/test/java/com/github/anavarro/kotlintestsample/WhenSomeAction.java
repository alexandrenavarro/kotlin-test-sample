package com.github.anavarro.kotlintestsample;

import com.tngtech.jgiven.Stage;

public class WhenSomeAction extends Stage<WhenSomeAction> {
    public WhenSomeAction some_action() {
        System.out.println("When");
        return self();
    }
}
