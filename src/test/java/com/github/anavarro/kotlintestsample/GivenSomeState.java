package com.github.anavarro.kotlintestsample;

import com.tngtech.jgiven.Stage;

public class GivenSomeState extends Stage<GivenSomeState> {
    public GivenSomeState some_state() {
        System.out.println("Given");
        return self();
    }
}
