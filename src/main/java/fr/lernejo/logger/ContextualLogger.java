package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter
        .ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    private final Logger delegateLogger;
    private final String name;

    public ContextualLogger(Logger logger, String name) {
        this.delegateLogger = logger;
        this.name = name;
    }

    @Override
    public void log(String message) {
        delegateLogger.log(LocalDateTime.now().format(FORMATTER) + " " + name + " " + message);
    }
}