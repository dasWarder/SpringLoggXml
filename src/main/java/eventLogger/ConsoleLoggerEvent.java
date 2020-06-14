package eventLogger;
import org.springframework.stereotype.Component;
import other.*;


public class ConsoleLoggerEvent implements LoggerEvent {

    public void logMessage(Event event) {

        System.out.println(event.toString());
    }
}
