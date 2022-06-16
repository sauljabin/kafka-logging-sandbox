package elk.sandbox;

import elk.sandbox.loggers.ProducerConsumerRateLogger;
import elk.sandbox.loggers.RequestsLogger;

import java.util.Timer;

public class Main {
    private static final int PERIOD = 500;

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new RequestsLogger(), 0, PERIOD);
        timer.scheduleAtFixedRate(new ProducerConsumerRateLogger(), 0, PERIOD);
    }
}
