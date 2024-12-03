package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain;

import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.domain_annotations.DomainClass;

import java.util.List;
import java.util.Set;

@DomainClass
@SuppressWarnings("unused")
public class EditedBook extends Publication {

    private final Set<ConferenceEdition> conferenceEditions;
    private final Set<BookChapter> bookChapters;
    private final List<Person> editors;

    public EditedBook(String title, Set<Book> books, Set<ConferenceEdition> conferenceEditions, Set<BookChapter> bookChapters, List<Person> editors) {
        super(title, books);
        this.conferenceEditions = conferenceEditions;
        this.bookChapters = bookChapters;
        this.editors = editors;
    }

    public Set<ConferenceEdition> getConferenceEditions() {
        return conferenceEditions;
    }

    public Set<BookChapter> getBookChapters() {
        return bookChapters;
    }

    public List<Person> getEditors() {
        return editors;
    }

    public void addAllConferenceEditions(Set<ConferenceEdition> conferenceEditions) {
        this.conferenceEditions.addAll(conferenceEditions);
    }

    public void addAllBookChapters(Set<BookChapter> bookChapters) {
        this.bookChapters.addAll(bookChapters);
    }

    public void addAllEditors(List<Person> editors) {
        this.editors.addAll(editors);
    }

}
