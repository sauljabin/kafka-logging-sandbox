package elk.sandbox.models;

import java.util.Random;

public enum Consumer {
    CONSUMER_1(KafkaClientType.CONSUMER, "app-1", "supplier-c67cd02e-f25d-4c1a-a3c4-1d46089d2095", "supplier-1", "supplier", "172.19.0.1"),
    CONSUMER_2(KafkaClientType.CONSUMER, "app-1", "supplier-ac200237-9ccb-4d80-ac4a-c17aafbcdf07", "supplier-1", "supplier", "172.19.0.1"),
    CONSUMER_3(KafkaClientType.CONSUMER, "app-2", "supplier-c67gf02e-445d-4c1a-a3c4-1d460pgd2095", "supplier-1", "supplier", "172.19.0.20"),
    CONSUMER_4(KafkaClientType.CONSUMER, "app-2", "supplier-bb450256-56cb-4d25-ac4a-c17aa7fcdf07", "supplier-1", "supplier", "172.19.0.20"),
    CONSUMER_5(KafkaClientType.CONSUMER, "app-3", "supplier-ty7hg02e-f478-4c14-hjc4-1ddf0p6dr0rt", "supplier-2", "supplier", "172.19.0.30"),
    CONSUMER_6(KafkaClientType.CONSUMER, "app-3", "supplier-bb450567-56cb-4d25-ac4a-c1yua7fc8gh7", "supplier-2", "supplier", "172.19.0.30");

    private static final Consumer[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();
    private final String clientId;
    private final String memberId;
    private final String groupId;
    private final KafkaClientType clientType;
    private final String host;

    private final String topic;

    Consumer(KafkaClientType clientType, String clientId, String memberId, String groupId, String topic, String host) {
        this.clientId = clientId;
        this.memberId = memberId;
        this.groupId = groupId;
        this.clientType = clientType;
        this.topic = topic;
        this.host = host;
    }

    public static Consumer getRandom() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }

    public String getTopic() {
        return topic;
    }

    public String getClientId() {
        return clientId;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getGroupId() {
        return groupId;
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
}
