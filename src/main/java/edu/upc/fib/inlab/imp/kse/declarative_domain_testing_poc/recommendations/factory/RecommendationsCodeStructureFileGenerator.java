package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.recommendations.factory;

import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.rule_automation.CodeStructureFileGenerator;

public class RecommendationsCodeStructureFileGenerator extends CodeStructureFileGenerator {

    private RecommendationsCodeStructureFileGenerator() {
        super();
    }

    public static void main(String[] args) {
        // add first argument as the path to the project
        if (args.length == 0) {
            args = new String[] {
                    "edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.recommendations.factory.RecommendationsDomainModelProvider",
                    "."
            };
        }
        CodeStructureFileGenerator.main(args);
    }
}
