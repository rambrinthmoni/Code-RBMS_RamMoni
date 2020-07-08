package com.pten.rbms.util;

import com.pten.rbms.model.Booking;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidBookingValidator
implements ConstraintValidator<ValidBooking, Booking> {

  @Override
  public boolean isValid(
    Booking booking, ConstraintValidatorContext context) {

      if (booking == null) {
          return true;
      }

      if (!(booking instanceof Booking)) {
          throw new IllegalArgumentException("Illegal method signature, "
          + "expected parameter of type Booking.");
      }
      		
      if (booking.getResrvStartDate() == null
        || booking.getResrvEndDate() == null) {
          return false;
      }
      return (booking.getResrvStartDate().after(booking.getResrvEndDate()));
  }
}
