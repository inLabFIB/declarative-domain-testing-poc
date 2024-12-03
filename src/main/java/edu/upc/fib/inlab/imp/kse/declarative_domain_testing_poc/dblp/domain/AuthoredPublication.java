package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain;

import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.domain_annotations.DomainClass;

import java.util.List;
import java.util.Set;

@DomainClass
public abstract class AuthoredPublication extends Publication {

    private final List<Person> authors;

    public AuthoredPublication(String title, Set<Book> books, List<Person> authors) {
        super(title, books);
        this.authors = authors;
    }

    public List<Person> getAuthors() {
        return authors;
    }

    @SuppressWarnings("unused")
    public void addAllAuthors(List<Person> authors) {
        this.authors.addAll(authors);
    }
}
