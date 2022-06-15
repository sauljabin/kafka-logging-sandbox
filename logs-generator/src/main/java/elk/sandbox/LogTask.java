package elk.sandbox;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.TimerTask;

@Slf4j
public class LogTask extends TimerTask {

    private static final int MAX_PROBABILITY = 100;
    private static final int PROBABILITY = 80;
    private static final String FAIL = "Fail";
    private static final String SUCCESS = "Success";
    private static final String MESSAGE_INFO = "complete={} service={} status={} response='{}' duration={}";
    private static final String MESSAGE_ERROR = "complete={} service={} status={} code={} response='{}' duration={}";
    private static final Random random = new Random();

    @Override
    public void run() {
        if (isInfo()) {
            logInfo();
        } else {
            logError();
        }
    }

    private boolean isInfo() {
        return random.nextInt(MAX_PROBABILITY) < PROBABILITY;
    }

    private void logError() {
        Error error = Error.getRandom();
        Service service = Service.getRandom();
        log.error(MESSAGE_ERROR, FAIL, service, error.getStatus(), error.getCode(), error.getMessage(), error.getDuration());
    }

    private void logInfo() {
        Success success = Success.getRandom();
        Service service = Service.getRandom();
        log.info(MESSAGE_INFO, SUCCESS, service, success.getStatus(), success.getMessage(), success.getDuration());
    }

}
