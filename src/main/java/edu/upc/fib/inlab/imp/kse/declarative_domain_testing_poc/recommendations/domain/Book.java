package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.recommendations.domain;


import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.domain_annotations.DomainClass;

@DomainClass
@SuppressWarnings("unused")
public class Book {

    private final String title;
    private final int year;
    private final Person author;

    public Book(String title, int year, Person author) {
        this.title = title;
        this.year = year;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public Person getAuthor(){
        return author;
    }
}
