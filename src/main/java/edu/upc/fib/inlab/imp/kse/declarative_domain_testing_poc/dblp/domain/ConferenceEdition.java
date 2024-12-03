package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain;

import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.domain_annotations.DomainClass;

import java.util.Set;

@DomainClass
@SuppressWarnings("unused")
public class ConferenceEdition {

    private final String title;
    private final int year;
    private final String city;
    private final String country;
    private final Set<HomePage> homePages;
    private final Set<EditedBook> editedBooks;
    private final Set<BookSeriesIssue> bookSeriesIssues;
    private final Set<JournalIssue> journalIssues;
    private final ConferenceSeries conferenceSeries;

    public ConferenceEdition(String title, int year, String city, String country, Set<HomePage> homePages, Set<EditedBook> editedBooks, Set<BookSeriesIssue> bookSeriesIssues, Set<JournalIssue> journalIssues, ConferenceSeries conferenceSeries) {
        this.title = title;
        this.year = year;
        this.city = city;
        this.country = country;
        this.homePages = homePages;
        this.editedBooks = editedBooks;
        this.bookSeriesIssues = bookSeriesIssues;
        this.journalIssues = journalIssues;
        this.conferenceSeries = conferenceSeries;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Set<HomePage> getHomePages() {
        return homePages;
    }

    public Set<EditedBook> getEditedBooks() {
        return editedBooks;
    }

    public Set<BookSeriesIssue> getBookSeriesIssues() {
        return bookSeriesIssues;
    }

    public Set<JournalIssue> getJournalIssues() {
        return journalIssues;
    }

    public ConferenceSeries getConferenceSeries() {
        return conferenceSeries;
    }

    public void addAllHomePages(Set<HomePage> homePages) {
        this.homePages.addAll(homePages);
    }

    public void addAllEditedBooks(Set<EditedBook> editedBooks) {
        this.editedBooks.addAll(editedBooks);
    }

    public void addAllBookSeriesIssues(Set<BookSeriesIssue> bookSeriesIssues) {
        this.bookSeriesIssues.addAll(bookSeriesIssues);
    }

    public void addAllJournalIssues(Set<JournalIssue> journalIssues) {
        this.journalIssues.addAll(journalIssues);
    }

}
