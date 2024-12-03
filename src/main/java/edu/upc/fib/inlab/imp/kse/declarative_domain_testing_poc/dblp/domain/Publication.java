package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain;

import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.domain_annotations.DomainClass;

import java.util.Set;

@DomainClass
@SuppressWarnings("unused")
public abstract class Publication {

    private final String title;
    private final Set<Book> books;

    public Publication(String title, Set<Book> books) {
        this.title = title;
        this.books = books;
    }

    public String getTitle() {
        return title;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void addAllBooks(Set<Book> books) {
        this.books.addAll(books);
    }

}
