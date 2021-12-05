package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String [] args){
//        System.out.println(isPhoneNumberValid("05414141414"));
//        System.out.println(isPhoneNumberValid("07416898693"));

        System.out.println(isPhoneNumberValidPredicate.test("05414141414"));
        System.out.println(isPhoneNumberValidPredicate.test("07416898698"));
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("05414141414"));
        System.out.println(isPhoneNumberValidPredicate.or(containsNumber3).test("07416898693"));
    }
    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("05") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("05") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");
}
