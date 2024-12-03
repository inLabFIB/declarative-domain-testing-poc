package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc;

import edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.logs.LogToCSVFileNames;
import edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.logs.LoggerConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.DiscoverySelector;
import org.junit.platform.engine.FilterResult;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.discovery.ClassSelector;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.engine.support.descriptor.MethodSource;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.PostDiscoveryFilter;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder.request;

class DBLPExperimentsExecutor {

    private static LogToCSVFileNames logToCSVFileNames;
    private static final Set<String> testClassNames = Set.of(
            "edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.DBLPDerivationRulesTest"
    );

    @BeforeAll
    static void setup() {
        logToCSVFileNames = LogToCSVFileNames.createWithNowDate();
        LoggerConfig.configureLogger(logToCSVFileNames.logFileName());
    }

    @Test
    void executeTestExperiments() {
        LauncherDiscoveryRequest request = request()
                .selectors(selectors())
                .filters(new DisabledFilter())
                .build();

        SummaryGeneratingListener summaryListener = new SummaryGeneratingListener();
        ExperimentTestExecutionListener executionListener = new ExperimentTestExecutionListener(logToCSVFileNames);
        LauncherFactory.create().execute(request, summaryListener, executionListener);

        if (summaryListener.getSummary().getFailures().isEmpty()) {
            System.out.println("All tests passed");
        } else {
            summaryListener.getSummary().printFailuresTo(new PrintWriter(System.out, true));
        }

    }

    private static List<DiscoverySelector> selectors() {
        List<ClassSelector> classSelectors = testClassNames.stream().map(DiscoverySelectors::selectClass).toList();
        return new ArrayList<>(classSelectors);
    }

    private static class DisabledFilter implements PostDiscoveryFilter {
        @Override
        public FilterResult apply(TestDescriptor testDescriptor) {
            return testDescriptor.getSource()
                    .filter(source -> source instanceof MethodSource &&
                            ((MethodSource) source).getJavaMethod().isAnnotationPresent(Disabled.class))
                    .map(source -> FilterResult.excluded("Disabled test"))
                    .orElse(FilterResult.included("Included test"));
        }
    }
}

