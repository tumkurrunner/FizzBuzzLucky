package com.equalexperts.assignment;


import com.equalexperts.assignment.validators.RangeValidation;

import java.util.StringJoiner;
import java.util.function.Predicate;

import static java.lang.String.valueOf;
import static java.util.stream.IntStream.rangeClosed;

public class FizzBuzzLuckyService implements IFizzBuzzLuckyService {

    private RangeValidation rangeValidation;
    private static final Predicate<Integer> DIV_BY_3 = arg -> (arg % 3) == 0;
    private static final Predicate<Integer> DIV_BY_5 = arg -> (arg % 5) == 0;
    private static final Predicate<Integer> CONTAINS_3 = arg -> (valueOf(arg).contains("3"));

    public FizzBuzzLuckyService(RangeValidation rangeValidation) {
        this.rangeValidation = rangeValidation;
    }

    public String execute(int startRange, int endRange) {
        rangeValidation.validateRange(startRange, endRange);
        return reduce(startRange, endRange);
    }

    private String reduce(int startRange, int endRange) {
        StringJoiner joiner = new StringJoiner(" ");
        rangeClosed(startRange, endRange)
                .mapToObj(this::transform)
                .forEach(joiner::add);
        return joiner.toString();
    }

    private String transform(int number) {
        if (CONTAINS_3.test(number)) return "lucky";
        if (DIV_BY_3.and(DIV_BY_5).test(number)) return "fizzbuzz";
        if (DIV_BY_3.test(number)) return "fizz";
        if (DIV_BY_5.test(number)) return "buzz";
        return valueOf(number);
    }
}
