package eventLogger;
import other.*;

import java.util.Collection;


public class CombinedEventLogger implements LoggerEvent {
    private Collection<LoggerEvent> loggers;

    public CombinedEventLogger(Collection<LoggerEvent> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logMessage(Event event) {
        for (LoggerEvent logger : loggers) {
            logger.logMessage(event);
        }
    }
}
