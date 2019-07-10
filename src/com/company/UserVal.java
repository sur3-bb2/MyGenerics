package com.company;

import java.util.function.Function;
import java.util.function.Predicate;

import static com.company.ValidationResult.*;

interface UserValidation extends Function<User, ValidationResult> {
    static UserValidation nameIsNotEmpty() {
        return holds(user -> !user.name.trim().isEmpty(), "Name is empty.");
    }

    static UserValidation ageIsValid() {
        return holds(user -> user.age > 0, "Missing age.");
    }

    static UserValidation eMailContainsAtSign() {
        return holds(user -> user.mail.contains("@"), "Missing @-sign.");
    }

    static UserValidation holds(Predicate<User> p, String message){
        return user -> p.test(user) ? valid() : invalid(message);
    }

    default UserValidation and(UserValidation other) {
        return user -> {
            final ValidationResult result = this.apply(user);
            return result.isValid() ? other.apply(user) : result;
        };
    }
}