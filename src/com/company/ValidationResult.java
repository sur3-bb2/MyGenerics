package com.company;

import java.util.Optional;

public interface ValidationResult {
    /**
     * @return ValidationResult
     */
    static ValidationResult valid() {
        return ValidationSupport.valid();
    }

    /**
     * Returns invalid result.
     * @param reason reason for failure
     * @return ValidationResult
     */
    static ValidationResult invalid(String reason) {
        return new Invalid(reason);
    }

    /**
     * Checks if valid.
     * @return boolean
     */
    boolean isValid();

    /**
     * Gets the reason for invalid status.
     * @return String
     */
    Optional<String> getReason();
}

/**
 * Responds with Invalid status if validation fails.
 *
 */
final class Invalid implements ValidationResult {

    private final String reason;

    /**
     * Constructor for setting reason for Invald.
     * @param reason reason
     */
    Invalid(final String reason) {
        this.reason = reason;
    }

    /* (non-Javadoc)
     * @see com.target.registries.core.validators.ValidationResult#isValid()
     */
    @Override
    public boolean isValid() {
        return false;
    }

    /* (non-Javadoc)
     * @see com.target.registries.core.validators.ValidationResult#getReason()
     */
    @Override
    public Optional<String> getReason() {
        return Optional.of(reason);
    }

}

/**
 * Responds with valid status if validation succeeds.
 *
 */
final class ValidationSupport {

    private static final ValidationResult VALID = new ValidationResult() {

        /* (non-Javadoc)
         * @see com.target.registries.core.validators.ValidationResult#isValid()
         */
        @Override
        public boolean isValid() {
            return true;
        }

        /* (non-Javadoc)
         * @see com.target.registries.core.validators.ValidationResult#getReason()
         */
        @Override
        public Optional<String> getReason() {
            return Optional.empty();
        }
    };

    /**
     * private Contructor.
     */
    private ValidationSupport() {
    }

    /**
     * Returns valid result.
     * @return ValidationResult
     */
    static ValidationResult valid() {
        return VALID;
    }
}

