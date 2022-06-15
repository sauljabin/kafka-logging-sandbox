package elk.sandbox;

import java.util.Random;

public enum Error {
    BAD_REQUEST("Bad request", "A001", 400),
    NULL_POINTER_EXCEPTION("Null pointer exception", "B002", 500),
    UNAUTHORIZED_TOKEN("Unauthorized token", "C050", 403),
    NOT_COMPLETED("Records not completed", "B003", 500),
    UNKNOWN("Unknown: \\\"I\\\'m sorry, I don\\\'t know what happened\\\"", "X010", 500);

    private static final Error[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    private String message;
    private String code;
    private int status;

    private Error(String message, String code, int status) {
        this.message = message;
        this.code = code;
        this.status = status;
    }

    public static Error getRandom() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }

    public String getDuration() {
        return String.format("%.2f", RANDOM.nextDouble());
    }

    @Override
    public String toString() {
        return message;
    }
}
