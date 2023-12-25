package com.amigoscode.examples;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class JoiningStrings {

    @Test
    public void joiningStrings() throws Exception {
        List<String> names = List.of("anna", "john", "marcos", "helena", "yasmin");
        // "Anna, John, Marcos, Helena, Yasmin"
        StringBuilder join = new StringBuilder();

        for (String name : names) {
            join.append(name.substring(0, 1).toUpperCase())
                    .append(name.substring(1))
                    .append(", ");
        }

        String result = join.substring(0, join.length() - 2);
        System.out.println(result);
    }

    @Test
    public void joiningStringsWithStream() throws Exception {
        List<String> names = List.of("anna", "john", "marcos", "helena", "yasmin");
        // "Anna, John, Marcos, Helena, Yasmin"
        String result = names.stream()
                .map(name -> name.substring(0, 1).toUpperCase()
                        .concat(name.substring(1)))
                .collect(Collectors.joining(", "));

        System.out.println(result);
    }

}
