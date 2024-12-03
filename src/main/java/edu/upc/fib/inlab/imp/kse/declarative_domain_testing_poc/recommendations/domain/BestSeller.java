package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.recommendations.domain;


import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.domain_annotations.DomainClass;

@DomainClass
@SuppressWarnings("unused")
public class BestSeller extends Book {

    private final int soldCopies;

    public BestSeller(String title, int year, Person author, int soldCopies) {
        super(title, year, author);
        this.soldCopies = soldCopies;
    }

    public int getSoldCopies() {
        return soldCopies;
    }
}
