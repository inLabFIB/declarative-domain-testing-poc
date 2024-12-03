package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain;

import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.domain_annotations.DomainClass;

@DomainClass
@SuppressWarnings("unused")
public class BookSeries {

    private final String id;
    private final String publisher;

    public BookSeries(String id, String publisher) {
        this.id = id;
        this.publisher = publisher;
    }

    public String getId() {
        return id;
    }

    public String getPublisher() {
        return publisher;
    }

}
