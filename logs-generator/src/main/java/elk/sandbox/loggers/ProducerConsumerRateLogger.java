package elk.sandbox.loggers;

import elk.sandbox.models.Consumer;
import elk.sandbox.models.Producer;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.TimerTask;

@Slf4j
public class ProducerConsumerRateLogger extends TimerTask {

    private static final int MAX_PROBABILITY = 100;
    private static final int PROBABILITY = 80;
    private static final Random random = new Random();
    private static final String MESSAGE_CONSUMER = "log.type=event client.id={} member.id={} group.id={} client.type={} duration={} host={} topic={}";
    private static final String MESSAGE_PRODUCER = "log.type=event client.id={} client.type={} duration={} host={} topic={}";

    private boolean isConsumer() {
        return random.nextInt(MAX_PROBABILITY) < PROBABILITY;
    }

    @Override
    public void run() {
        if (isConsumer()) {
            logConsumer();
        } else {
            logProducer();
        }
    }

    private void logProducer() {
        Producer producer = Producer.getRandom();
        log.error(MESSAGE_PRODUCER, producer.getClientId(), producer.getClientType(), producer.getDuration(), producer.getHost(), producer.getTopic());
    }

    private void logConsumer() {
        Consumer consumer = Consumer.getRandom();
        log.info(MESSAGE_CONSUMER, consumer.getClientId(), consumer.getMemberId(), consumer.getGroupId(), consumer.getClientType(), consumer.getDuration(), consumer.getHost(), consumer.getTopic());
    }
}
