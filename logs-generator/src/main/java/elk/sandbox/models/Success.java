package elk.sandbox.models;

import java.util.Random;

public enum Success {
    OPERATION_SUCCESS("Operation success", 200),
    SAVED_RECORD("Saved record", 201),
    OPERATION_SUCCESS_EMPTY("Operation success", 204),
    NOT_FOUND("Not found", 404);

    private static final Success[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    private final String message;
    private final int status;

    Success(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public static Success getRandom() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public String getDuration() {
        return String.format("%.2f", 2. * RANDOM.nextDouble());
    }

    @Override
    public String toString() {
        return message;
    }
}
