package io.github.mokaim.domain;

import lombok.*;

@Getter
@Setter
public class InteliJunitTest {


    private String id;
    private String name;

    @Builder
    public InteliJunitTest(String id, String name) {
        this.id = id;
        this.name = name;
    }


}
