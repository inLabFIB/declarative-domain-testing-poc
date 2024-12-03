package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.recommendations.domain;

import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.domain_annotations.DomainClass;

@DomainClass
@SuppressWarnings("unused")
public final class Recommendation {

    private final ReadBook from;
    private final Person to;
    private final String comment;

    public Recommendation(ReadBook from, Person to, String comment) {
        this.from = from;
        this.to = to;
        this.comment = comment;
    }

    public ReadBook getFrom() {
        return from;
    }

    public Person getPerson() {
        return to;
    }

    private String getComment() {
        return comment;
    }
}
