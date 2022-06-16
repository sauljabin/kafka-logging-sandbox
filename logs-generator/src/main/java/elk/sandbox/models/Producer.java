package elk.sandbox.models;

import java.util.Random;

public enum Producer {
    PRODUCER_1(KafkaClientType.PRODUCER, "app-1", "customer", "10.105.76.71"),
    PRODUCER_2(KafkaClientType.PRODUCER, "app-2", "customer", "10.105.76.73");

    private static final Producer[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();
    private final String clientId;
    private final KafkaClientType clientType;
    private final String host;

    private final String topic;

    Producer(KafkaClientType clientType, String clientId, String topic, String host) {
        this.clientId = clientId;
        this.clientType = clientType;
        this.host = host;
        this.topic = topic;
    }

    public static Producer getRandom() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }

    public String getClientId() {
        return clientId;
    }

    public KafkaClientType getClientType() {
        return clientType;
    }

    public String getHost() {
        return host;
    }

    public String getDuration() {
        return String.format("%.2f", RANDOM.nextDouble());
    }

    @Override
    public String toString() {
        return clientId;
    }

    public String getTopic() {
        return topic;
    }
}
