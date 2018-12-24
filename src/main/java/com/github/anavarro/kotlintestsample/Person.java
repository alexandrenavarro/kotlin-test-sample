package com.github.anavarro.kotlintestsample;


import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class Person {
    private String firstName;
    private String lastName;
    private List<Adress> adresses;

}

