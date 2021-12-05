package optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {
    public static void main(String [] args){
//        Supplier<IllegalStateException> exception = () -> new IllegalStateException("exception");
//        Object value = Optional.ofNullable("Tolga")
//                .ifPresent(System.out::println);
//                .orElseThrow(exception);
//                .orElseGet(() -> "default value");
//        .orElseThrow(() -> new IllegalArgumentException("exception"));
//         Optional.ofNullable("tolgayakar@gmail.com")
         Optional.ofNullable(null)
//                .ifPresent(email -> System.out.println("Sending email to " + email));
                .ifPresentOrElse(email -> System.out.println("Sending email to " + email),
                        () -> System.out.println("Couldn't send"));

    }
}
