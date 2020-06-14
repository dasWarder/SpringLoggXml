package eventLogger;

import other.*;

import javax.annotation.PreDestroy;
import java.util.*;


public class CashFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache;


    public CashFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
        this.cache = new ArrayList<Event>(cacheSize);
    }

    @Override
    public void logMessage(Event event) {
        cache.add(event);

        if (cache.size() == cacheSize) {
            writeEventFromCache();
            cache.clear();
        }
    }
    @PreDestroy
    public void destroy() {
        if(!cache.isEmpty()){
            writeEventFromCache();
        }
    }

    private void writeEventFromCache() {
        for (Event event : cache) {
            super.logMessage(event);
        };
    }
}
