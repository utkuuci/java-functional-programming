package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface CustomerRegisterationValidator
        extends Function<Customer, CustomerRegisterationValidator.ValidationResult> {

    static CustomerRegisterationValidator isEmailValid (){
        return customer -> customer.getEmail().contains("@") ?
                ValidationResult.SUCCESS : ValidationResult.EMAIL_NOT_VALID;
    }
    static CustomerRegisterationValidator isPhoneNumberValid (){
        return customer -> customer.getPhoneNumber().startsWith("05") ?
                ValidationResult.SUCCESS : ValidationResult.PHONE_NUMBER_NOT_VALID;
    }
    static CustomerRegisterationValidator isAdult (){
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ?
                ValidationResult.SUCCESS : ValidationResult.IS_NOT_ADULT;
    }
    default CustomerRegisterationValidator and (CustomerRegisterationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(ValidationResult.SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult{
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        IS_NOT_ADULT,
        EMAIL_NOT_VALID
    }
}
