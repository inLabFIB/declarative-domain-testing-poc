package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain;

import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.domain_annotations.DomainClass;

@DomainClass
@SuppressWarnings("unused")
public class HomePage {

    private final String value;

    public HomePage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
