package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain;

import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.domain_annotations.DomainClass;

import java.util.Set;

@DomainClass
public class Book {

    private final int numPages;
    private final Set<HomePage> homePages;
    private final String publisher;
    private final int publicationYear;
    private final String isbn;
    private final Publication publication;

    public Book(int numPages, Set<HomePage> homePages, String publisher, int publicationYear, String isbn, Publication publication) {
        this.numPages = numPages;
        this.homePages = homePages;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.publication = publication;
    }

    @SuppressWarnings("unused")
    public int getNumPages() {
        return numPages;
    }

    @SuppressWarnings("unused")
    public Set<HomePage> getHomePages() {
        return homePages;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @SuppressWarnings("unused")
    public String getIsbn() {
        return isbn;
    }

    public Publication getPublication() {
        return publication;
    }

    @SuppressWarnings("unused")
    public void addAllHomePages(Set<HomePage> homePages) {
        this.homePages.addAll(homePages);
    }

}
