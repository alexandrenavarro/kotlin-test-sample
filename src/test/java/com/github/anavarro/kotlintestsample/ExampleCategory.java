package com.github.anavarro.kotlintestsample;

import com.tngtech.jgiven.annotation.IsTag;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IsTag
@Retention(RetentionPolicy.RUNTIME)
public @interface ExampleCategory {
}