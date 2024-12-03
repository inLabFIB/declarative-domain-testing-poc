package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.logs;

import java.text.SimpleDateFormat;
import java.util.Date;

public record LogToCSVFileNames(String logFileName, String csvFileName) {

    public static final String LOGS_FOLDER = "logs";
    public static final String TEST_RESULTS_FILE_NAME = "test_results";

    public static LogToCSVFileNames createWithNowDate() {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String logFileName = buildFileName(timestamp, "log");
        String csvFileName = buildFileName(timestamp, "csv");
        return new LogToCSVFileNames(logFileName, csvFileName);
    }

    private static String buildFileName(String timestamp, String suffix) {
        return LOGS_FOLDER + "/" + TEST_RESULTS_FILE_NAME + "_" + timestamp + "." + suffix;
    }
}
