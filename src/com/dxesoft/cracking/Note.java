package com.dxesoft.cracking;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class Note {

    public void note(String[] magazine, String[] note) {

        boolean contains = true;
        if (note.length <= magazine.length) {

            Stream<String> magazineStream = Arrays.stream(magazine);

            final Map<String, Long> magazineMap = magazineStream.collect(groupingBy(Function.identity(), counting()));

            final Map<String, Integer> noteMap = Arrays.stream(note).collect(groupingBy(Function.identity(), summingInt(e -> 1)));


            for (Map.Entry<String, Integer> entry : noteMap.entrySet()) {

                if (magazineMap.containsKey(entry.getKey())) {
                    if (entry.getValue() > magazineMap.get(entry.getKey())) {
                        contains = false;
                        break;
                    }
                } else {
                    contains = false;
                    break;
                }
            }
        } else {
            contains = false;
        }

        System.out.println(contains ? "Yes" : "No");

    }
}
