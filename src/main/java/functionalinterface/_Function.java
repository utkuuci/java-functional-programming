package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String [] args){
//        Function Takes One Arguments
        int increment = incrementByOne(1);
        System.out.println(increment);
        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);
        int mulitply = multiplyBy10.apply(3);
        System.out.println(mulitply);
        Function<Integer, Integer> addByOneAndMultiplyBy10 =
                incrementByOneFunction.andThen(multiplyBy10);
        System.out.println(addByOneAndMultiplyBy10.apply(6));

//        BiFunction Example takes 2 argument 1 result
        System.out.println(incrementByOneAndMultiply(4, 100));
        System.out.println(incrementByOneAndMultiplyBiFunction.apply(4,100));

    }
//    Function
    static Function<Integer, Integer> incrementByOneFunction =
            number -> number+1;
    static Function<Integer, Integer> multiplyBy10 =
            number -> number * 10;

    static int incrementByOne(int number){
        return number + 1;
    }
//    BiFunction
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy)
                    -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

    static int incrementByOneAndMultiply(int number, int numMutliplyBy){
        return (number + 1)*numMutliplyBy;
    }
}
