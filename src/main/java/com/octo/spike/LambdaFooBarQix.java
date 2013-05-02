package com.octo.spike;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LambdaFooBarQix {

    private static final NavigableMap<Integer, String> codes = new TreeMap<>();

    static {
        codes.put(3, "FOO");
        codes.put(5, "BAR");
        codes.put(7, "QIX");
    }

    public static String charToCode(int c) {
        return codes.get(Character.getNumericValue(c));
    }

    public String translate(int value) {
        final SortedSet<Integer> integers = codes.navigableKeySet();
        List<String> result = integers.stream().filter(i -> value % i == 0).map(i -> codes.get(i)).collect(Collectors.<String>toList());
        String charValue = Integer.toString(value);
        result.addAll(charValue.chars().map(LambdaFooBarQix::charToCode).filter(Objects::nonNull).collect(Collectors.<String>toList()));
        return (result.isEmpty() ? charValue : result.stream().collect(Collectors.toStringBuilder()).toString());
    }

    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
            System.out.println(new LambdaFooBarQix().translate(i));
        }
    }

}
