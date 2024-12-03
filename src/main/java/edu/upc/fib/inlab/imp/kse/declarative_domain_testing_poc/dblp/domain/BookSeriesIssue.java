package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain;

import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.domain_annotations.DomainClass;

import java.util.Set;

@DomainClass
@SuppressWarnings("unused")
public class BookSeriesIssue extends Book {

    private final int number;
    private final Set<BookChapter> bookChapters;
    private final BookSeries bookSeries;
    private final Set<ConferenceEdition> conferenceEditions;

    public BookSeriesIssue(
            int numPages, Set<HomePage> homePages, String publisher, int publicationYear, String isbn, Publication publication,
            int number, Set<BookChapter> bookChapters, BookSeries bookSeries, Set<ConferenceEdition> conferenceEditions
    ) {
        super(numPages, homePages, publisher, publicationYear, isbn, publication);
        this.number = number;
        this.bookChapters = bookChapters;
        this.bookSeries = bookSeries;
        this.conferenceEditions = conferenceEditions;
    }

    public int getNumber() {
        return number;
    }

    public Set<BookChapter> getBookChapters() {
        return bookChapters;
    }

    public BookSeries getBookSeries() {
        return bookSeries;
    }

    public Set<ConferenceEdition> getConferenceEditions() {
        return conferenceEditions;
    }

    public void addAllBookChapters(Set<BookChapter> bookChapters) {
        this.bookChapters.addAll(bookChapters);
    }

    public void addAllConferenceEditions(Set<ConferenceEdition> conferenceEditions) {
        this.conferenceEditions.addAll(conferenceEditions);
    }

}
