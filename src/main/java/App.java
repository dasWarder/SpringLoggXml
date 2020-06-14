import enumType.EventType;
import eventLogger.ConsoleLoggerEvent;
import eventLogger.LoggerEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import other.Client;
import other.Event;

import java.util.Map;


public class App {
    private static Client client;
    private static LoggerEvent logger;
    private static Map<EventType, LoggerEvent> loggers;

    public App(Client client, LoggerEvent logger, Map<EventType, LoggerEvent> loggers) {
        super();
        this.client = client;
        this.logger = logger;
        this.loggers = loggers;
    }

    public static void logMessage(EventType eventType, Event event) {
        event.setMsg(event.getMsg().replaceAll("for", client.getFullName() + " " +
                client.getId()) + " " + "with greeting " + client.getGreeting());
        LoggerEvent loggerEvent = loggers.get(eventType);
        if (loggerEvent == null) {
            loggerEvent = logger;
        }
        loggerEvent.logMessage(event);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext apc = new ClassPathXmlApplicationContext("spring.xml");

        App app = apc.getBean("app", App.class);
        Event event = apc.getBean("event", Event.class);
        event.setMsg("Check message for bean");

        Event event2 = apc.getBean("event", Event.class);
        event2.setMsg("Check message for bean2");

        Event event3 = apc.getBean("event", Event.class);
        event3.setMsg("Check message for bean3");

        Event event4 = apc.getBean("event", Event.class);
        event4.setMsg("Check message for bean4");

        Event event5 = apc.getBean("event", Event.class);
        event5.setMsg("Check message for bean5");

//        app.logMessage(EventType.INFO, event);
        app.logMessage(null, event2);
//        app.logMessage(EventType.ERROR, event3);
//        app.logMessage(event4);
//        app.logMessage(event5);

        apc.close();
    }
}
