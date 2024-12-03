package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.logs;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.FileAppender;
import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.DeclarativeTestExtension;
import org.slf4j.LoggerFactory;

public class LoggerConfig {


    private LoggerConfig() {
        throw new IllegalStateException("Utility class");
    }

    public static void configureLogger(String logFilename) {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setContext(context);
        encoder.setPattern("%d{yyyy-MM-dd HH:mm:ss:SSS} %-5level- %msg%n");
        encoder.start();

        FileAppender<ILoggingEvent> fileAppender = new FileAppender<>();
        fileAppender.setContext(context);
        fileAppender.setName("fileAppender");
        fileAppender.setFile(logFilename);
        fileAppender.setEncoder(encoder);
        fileAppender.start();

        ch.qos.logback.classic.Logger measurementLogger = context.getLogger(DeclarativeTestExtension.EXPERIMENT_MEASUREMENT_LOGGER_NAME);
        measurementLogger.addAppender(fileAppender);
    }


}