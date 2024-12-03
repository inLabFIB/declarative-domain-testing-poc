package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain;

import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.domain_annotations.DomainClass;

import java.util.List;
import java.util.Set;

@DomainClass
public class AuthoredBook extends AuthoredPublication {

    public AuthoredBook(String title, Set<Book> books, List<Person> authors) {
        super(title, books, authors);
    }
}
