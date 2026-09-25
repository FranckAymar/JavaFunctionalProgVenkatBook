package playground.lazy.evaluation;

import playground.Utils;

import java.util.function.Supplier;

public class Evaluation {

    public static boolean evaluate(final int value) {
        System.out.println("Evaluating ..."   + value);
        Utils.simulateSomeTimeConsumption(2000);
        return value > 100;
    }

    public static void eagerEvaluator(final boolean input1, final boolean input2){

        System.out.println("eager evaluate called ...");
        System.out.println("accept?: " + (input1 && input2) );
    }

    public static void lazyEvaluator(
            Supplier<Boolean> input1,
            Supplier<Boolean> input2
    ){
        System.out.println("eager evaluate called ...");
        System.out.println("accept?: " + (input1.get() && input2.get()) );
    }

    static void main()  {
        eagerEvaluator(
                evaluate(1), evaluate(2)
        );

        lazyEvaluator(
                () -> evaluate(1),
                () -> evaluate(2)
        );
    }
}
