package elk.sandbox.models;

import org.apache.commons.text.WordUtils;

import java.util.Random;

public enum Service {
    INVOICE, PAYROLL, USER, ACCOUNTING, PURCHASING;

    private static final Service[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static Service getRandom() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }

    @Override
    public String toString() {
        return WordUtils.capitalizeFully(super.toString());
    }
}
