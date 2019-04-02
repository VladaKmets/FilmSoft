package com.vladaprojects.films.domain;

import lombok.*;

@Data
@AllArgsConstructor
public class Film {
    private String name;
    private String director;
    private String year;
}
