package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.logs;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogToCSVConverter {

    public static final String HEADER_COLUMNS = "TestName,InputParsingTime,ReasonerTime,InstantiationTime,NumberOfDomainInstances,NumberOfCollectionsInstances,NumberOfCollectionElementsInstances\n";

    public static void convert(LogToCSVFileNames logToCSVFileNames) {
        String logFilename = logToCSVFileNames.logFileName();
        String csvFilename = logToCSVFileNames.csvFileName();
        try {
            List<String> lines = Files.readAllLines(Paths.get(logFilename));
            try (FileWriter writer = new FileWriter(csvFilename)) {
                writer.append(HEADER_COLUMNS);

                String currentTestName = null;
                Map<String, Long> timestamps = new HashMap<>();

                for (String line : lines) {
                    if (line.contains("DeclarativeTestName:")) {
                        if (currentTestName != null) {
                            writeSummary(writer, currentTestName, timestamps);
                        }
                        currentTestName = line.split(": ")[1];
                        timestamps.clear();
                    } else if (line.contains(": ")) {
                        String[] parts = line.split(" - ")[1].split(": ");
                        String eventName = parts[0].trim();
                        try {
                            long timestamp = Long.parseLong(parts[1].trim());
                            timestamps.put(eventName, timestamp);
                        } catch (NumberFormatException e) {
                            System.err.println("Skipping line due to invalid number format: " + line);
                        }
                    }
                }

                if (currentTestName != null) {
                    writeSummary(writer, currentTestName, timestamps);
                }

            } catch (IOException e) {
                throw new RuntimeException("Error writing CSV file", e);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading log file", e);
        }
    }

    private static void writeSummary(FileWriter writer, String testName, Map<String, Long> timestamps) throws IOException {
        long inputParsingTime = obtainTimestamp(timestamps, "endInputParsing", "startInputParsing");
        long reasonerTime = obtainTimestamp(timestamps, "endReasoner", "startReasoner");
        long instantiationTime = obtainTimestamp(timestamps, "endInstantiation", "startInstantiation");
        int numberOfDomainInstances = obtainCount(timestamps, "numberOfDomainInstances");
        int numberOfCollectionsInstances = obtainCount(timestamps, "numberOfCollectionsInstances");
        int numberOfCollectionElementsInstances = obtainCount(timestamps, "numberOfCollectionElementsInstances");
        writer.append(testName).append(',')
                .append(String.valueOf(inputParsingTime)).append(',')
                .append(String.valueOf(reasonerTime)).append(',')
                .append(String.valueOf(instantiationTime)).append(',')
                .append(String.valueOf(numberOfDomainInstances)).append(',')
                .append(String.valueOf(numberOfCollectionsInstances)).append(',')
                .append(String.valueOf(numberOfCollectionElementsInstances)).append('\n');
    }

    private static long obtainTimestamp(Map<String, Long> timestamps, String endTimestampName, String startTimestampName) {
        return timestamps.get(endTimestampName) - timestamps.get(startTimestampName);
    }

    private static int obtainCount(Map<String, Long> timestamps, String countName) {
        return timestamps.get(countName).intValue();
    }
}