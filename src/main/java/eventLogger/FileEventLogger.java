package eventLogger;

import java.io.*;

import org.springframework.stereotype.Component;
import other.*;

import javax.annotation.PostConstruct;


public class FileEventLogger implements LoggerEvent {
    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public FileEventLogger() {
    }

    public void logMessage(Event event) {
        try {
            OutputStream os = new FileOutputStream(file, true);
            os.write(event.toString().getBytes(), 0, event.toString().length());
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void init() throws IOException {
        this.file = new File(fileName);
        if (file.exists() && !file.canWrite()) {
            throw new FileNotFoundException("File can't be written this file! No properties for this!");
        } else if (!file.exists()) {
            try {
                file.createNewFile();
            }
            catch (Exception e) {
                throw new IllegalArgumentException("Can't create a file", e);
            }
        }
    }
}
