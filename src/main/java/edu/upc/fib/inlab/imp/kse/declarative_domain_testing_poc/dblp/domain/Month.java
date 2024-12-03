package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain;

import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.domain_annotations.DomainClass;

@DomainClass
@SuppressWarnings("unused")
public class Month {

    private final int value;
    private final int endPage;

    public Month(int value, int endPage) {
        this.value = value;
        this.endPage = endPage;
    }

    public int getValue() {
        return value;
    }

    public int getEndPage() {
        return endPage;
    }

}
