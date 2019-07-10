package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
/*
public interface FunctionalValidation<T> extends Function<T, ValidationResult> {



    static FunctionalValidation holds(final Predicate<T> p, final String message) {
        return member -> p.test(member) ? ValidationResult.valid() : ValidationResult.invalid(message);
    }


    default FunctionalValidation<T> and(final FunctionalValidation<T> other) {
        return member -> {
            final ValidationResult result = this.apply(member);
            return result.isValid() ? other.apply(member) : result;
        };
    }

    static <T> Function<T, List<ValidationResult>> all(final FunctionalValidation<T>... validations) {
        return member -> {
            return Arrays.stream(validations).map(validation ->
                    validation.apply(member)
            ).filter(vr -> !vr.isValid())
                    .collect(Collectors.toList());
        };

    }

}*/
