package com.company;

import com.sun.tools.javac.util.StringUtils;

import java.util.function.Function;
import java.util.function.Predicate;

public interface MyFun<T> extends Function<T, ValidationResult> {
    default MyFun<T> holds(final Predicate<T> p, final String message) {
        return member -> p.test(member) ? ValidationResult.valid() : ValidationResult.invalid(message);
    }

    default MyFun<T> and(final MyFun<T> other) {
        return member -> {
            final ValidationResult result = this.apply(member);
            return result.isValid() ? other.apply(member) : result;
        };
    }
}