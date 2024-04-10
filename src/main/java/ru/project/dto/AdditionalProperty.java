package ru.project.dto;

import lombok.Data;

@Data
public class AdditionalProperty {
    private String key;
    private String value;
    private String name;

    @Override
    public String toString() {
        return "{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
