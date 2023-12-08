package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name){
        return new ContextualLogger(new CompositeLogger(new FilteredLogger(new FileLogger("logs.txt"),m -> m.contains("simulation")),new ConsoleLogger()),name);
    }
}