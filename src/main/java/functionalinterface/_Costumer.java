package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Costumer {
    public static void main(String [] args){
//        normal java function
        greetCustomer(new Customer("Tolga", "0541 411 41 41"));
        Customer ahmet = new Customer("Ahmet", "0531 331 31 31");
        greetCustomerV2(new Customer("Tolga", "0541 411 41 41"), false);
//        consumer function interface
        greetCustomerConsumer.accept(ahmet);
        greetCustomerConsumer2.accept(ahmet, false);
    }

    static BiConsumer<Customer, Boolean> greetCustomerConsumer2 = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number " +
                (showPhoneNumber ? customer.customerPhoneNumber : "************"));


    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number " +
                customer.customerPhoneNumber);

    static void greetCustomer(Customer customer){
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number " +
                customer.customerPhoneNumber);
    }
    static void greetCustomerV2(Customer customer, boolean showPhoneNumber) {
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number " +
                (showPhoneNumber ? customer.customerPhoneNumber : "************"));
    }
    static class Customer{
        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
