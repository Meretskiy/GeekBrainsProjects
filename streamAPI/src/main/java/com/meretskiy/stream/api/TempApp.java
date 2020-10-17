package com.meretskiy.stream.api;

import java.util.function.Function;
import java.util.stream.Stream;

public class TempApp {
    public static void main(String[] args) {
        Stream.of("AA", "B", "CCC")
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return s.length();
                    }
                })
                .forEach(s -> System.out.println(s));
        //2 1 3

        Stream.of("AA", "B", "CCC")
                .map((s) -> s.length())
                .forEach(s -> System.out.println(s));
        //2 1 3

        Stream.of("AA", "B", "CCC")
                .map((s) -> "X: " + s)
                .forEach(s -> System.out.println(s));
        //X: AA X: B X: CCC
    }
}
