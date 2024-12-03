package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc;


import edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.logs.LogToCSVConverter;
import edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.logs.LogToCSVFileNames;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;

class ExperimentTestExecutionListener implements TestExecutionListener {

    private final LogToCSVFileNames logToCSVFileNames;

    public ExperimentTestExecutionListener(LogToCSVFileNames logToCSVFileNames) {
        this.logToCSVFileNames = logToCSVFileNames;
    }

    @Override
    public void executionStarted(TestIdentifier testIdentifier) {
        TestExecutionListener.super.executionStarted(testIdentifier);
        System.out.println("Execution started: " + testIdentifier.getDisplayName());
    }

    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        TestExecutionListener.super.executionFinished(testIdentifier, testExecutionResult);
        System.out.println("Execution finished: " + testIdentifier.getDisplayName());
    }

    @Override
    public void testPlanExecutionFinished(TestPlan testPlan) {
        LogToCSVConverter.convert(logToCSVFileNames);
    }
}