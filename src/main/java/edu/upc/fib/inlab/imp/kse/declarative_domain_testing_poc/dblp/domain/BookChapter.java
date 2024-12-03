package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain;

import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.domain_annotations.DomainClass;

import java.util.List;
import java.util.Set;

@DomainClass
public class BookChapter extends AuthoredPublication {

    private final int iniPage;
    private final int endPage;
    private final Set<BookSection> bookSections;
    private final Set<EditedBook> editedBooks;
    private final Set<BookSeriesIssue> bookSeriesIssues;

    public BookChapter(String title, Set<Book> books, List<Person> authors, int iniPage, int endPage, Set<BookSection> bookSections, Set<EditedBook> editedBooks, Set<BookSeriesIssue> bookSeriesIssues) {
        super(title, books, authors);
        this.iniPage = iniPage;
        this.endPage = endPage;
        this.bookSections = bookSections;
        this.editedBooks = editedBooks;
        this.bookSeriesIssues = bookSeriesIssues;
    }

    @SuppressWarnings("unused")
    public int getIniPage() {
        return iniPage;
    }

    @SuppressWarnings("unused")
    public int getEndPage() {
        return endPage;
    }

    public Set<BookSection> getBookSections() {
        return bookSections;
    }

    public Set<EditedBook> getEditedBooks() {
        return editedBooks;
    }

    public Set<BookSeriesIssue> getBookSeriesIssues() {
        return bookSeriesIssues;
    }

    @SuppressWarnings("unused")
    public void addAllBookSections(Set<BookSection> bookSections) {
        this.bookSections.addAll(bookSections);
    }

    @SuppressWarnings("unused")
    public void addAllEditedBooks(Set<EditedBook> editedBooks) {
        this.editedBooks.addAll(editedBooks);
    }

    @SuppressWarnings("unused")
    public void addAllBookSeriesIssues(Set<BookSeriesIssue> bookSeriesIssues) {
        this.bookSeriesIssues.addAll(bookSeriesIssues);
    }

}
