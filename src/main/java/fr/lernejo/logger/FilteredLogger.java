package fr.lernejo.logger;

import java.util.function.Predicate;

public class FilteredLogger  implements Logger{

    private final Logger delegateLogger;
    private final Predicate<String> condition;

    public FilteredLogger(Logger delegateLogger, Predicate<String> condition) {
        this.delegateLogger = delegateLogger;
        this.condition = condition;
    }


    @Override
    public void log(String message) {
        if(condition.test(message)){
            delegateLogger.log(message);
        }
    }
}