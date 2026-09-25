package playground.lazy.initialization;

import java.util.function.Supplier;

public class Holder {

    private Supplier<Heavy> heavy = () ->  createAndCacheHeavy();

    Holder(){
        System.out.println("Holder created");
    }

    public Heavy getHeavy() {
        return heavy.get();
    }


    public synchronized Heavy createAndCacheHeavy() {
        class HeavyFactory implements Supplier<Heavy> {
            private final Heavy instance = new Heavy();

            @Override
            public Heavy get() {
                return instance;
            }
        }

        if(!(heavy instanceof HeavyFactory)){
            heavy = new HeavyFactory();
        }

        return heavy.get();
    }

    static void main() {
        final Holder holder = new Holder();
        System.out.println("deferring heavy creation...");
        System.out.println(holder.getHeavy());
        System.out.println(holder.getHeavy());
    }

}
