package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain;

import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.domain_annotations.DomainClass;

@DomainClass
@SuppressWarnings("unused")
public class ConferenceSeries {

    private final String acronym;
    private final String name;

    public ConferenceSeries(String acronym, String name) {
        this.acronym = acronym;
        this.name = name;
    }

    public String getAcronym() {
        return acronym;
    }

    public String getName() {
        return name;
    }

}
