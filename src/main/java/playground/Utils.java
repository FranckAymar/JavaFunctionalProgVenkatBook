package playground;

public class Utils {

    public static void simulateSomeTimeConsumption(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}