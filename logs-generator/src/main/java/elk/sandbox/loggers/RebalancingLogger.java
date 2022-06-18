package elk.sandbox.loggers;

import elk.sandbox.models.Consumer;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.TimerTask;

@Slf4j
public class RebalancingLogger extends TimerTask {

    private static final String MESSAGE_CONSUMER = "log.type=rebalancing client.id={} member.id={} group.id={} host={} topic={}";
    private static final int MAX_PROBABILITY = 100;
    private static final int PROBABILITY = 20;

    private static final Random random = new Random();

    private boolean isRebalancing() {
        return random.nextInt(MAX_PROBABILITY) < PROBABILITY;
    }

    @Override
    public void run() {
        if (!isRebalancing())
            return;
        Consumer consumer = Consumer.getRandom();
        log.info(MESSAGE_CONSUMER, consumer.getClientId(), consumer.getMemberId(), consumer.getGroupId(), consumer.getHost(), consumer.getTopic());
    }
}
