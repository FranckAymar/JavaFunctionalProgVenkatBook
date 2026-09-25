package playground.lazy.initialization;

public class HolderNaive {

    private Heavy heavy;

    HolderNaive(){
        System.out.println("Holder created");
    }

    public synchronized Heavy getHeavy(){
        if(heavy == null){
            heavy = new Heavy();
        }

        return heavy;
    }

    static void main() {
        final HolderNaive holder = new HolderNaive();
        System.out.println("deferring heavy creation...");
        System.out.println(holder.getHeavy());
        System.out.println(holder.getHeavy());
    }
}
