package com.github.anavarro.kotlintestsample;

import com.tngtech.jgiven.Stage;
import org.assertj.core.api.Assertions;

public class ThenSomeOutcome extends Stage<ThenSomeOutcome> {
    public ThenSomeOutcome some_outcome() {
        Assertions.assertThat(true).isTrue();
        return self();
    }
}