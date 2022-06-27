package kafka.sandbox;

import kafka.sandbox.loggers.ProducerConsumerRateLogger;
import kafka.sandbox.loggers.RebalancingLogger;

import java.util.Timer;

public class Main {
    private static final int PERIOD = 500;

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new RebalancingLogger(), 0, PERIOD);
        timer.scheduleAtFixedRate(new ProducerConsumerRateLogger(), 0, PERIOD);
    }
}
