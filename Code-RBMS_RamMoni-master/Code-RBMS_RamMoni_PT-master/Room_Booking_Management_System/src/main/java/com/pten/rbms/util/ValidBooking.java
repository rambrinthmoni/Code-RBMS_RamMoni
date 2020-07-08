package com.pten.rbms.util;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ValidBookingValidator.class)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidBooking {
    String message() default "End date must be after start date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
