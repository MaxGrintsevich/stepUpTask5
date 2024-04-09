package ru.project.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AdditionalProperty {
    String key;
    String value;
    String name;

    @Override
    public String toString() {
        return "{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
