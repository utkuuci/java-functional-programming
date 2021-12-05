package combinatorpattern;

import java.time.LocalDate;

public class Main {
    public static void main(String [] args){
        Customer customer = new Customer(
                "Tolga",
                "tolgayakar@email.com",
                "05414114141",
                LocalDate.of(2000, 1, 1)
        );
//        System.out.println(new CustomValidatorService().isValid(customer));
        CustomerRegisterationValidator.ValidationResult result = CustomerRegisterationValidator
                .isEmailValid()
                .and(CustomerRegisterationValidator.isPhoneNumberValid())
                .and(CustomerRegisterationValidator.isAdult())
                .apply(customer);
        System.out.println(result);
        if(result != CustomerRegisterationValidator.ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }
    }
}
