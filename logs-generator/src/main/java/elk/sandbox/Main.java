package elk.sandbox;

import java.util.Timer;

public class Main {
    private static final int PERIOD = 500;

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new LogTask(), 0, PERIOD);
    }
}
