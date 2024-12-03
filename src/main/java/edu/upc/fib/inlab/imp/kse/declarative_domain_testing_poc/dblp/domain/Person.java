package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain;

import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.domain_annotations.DomainClass;

import java.util.LinkedHashSet;
import java.util.Set;

@DomainClass
@SuppressWarnings("unused")
public class Person {

    private final String name;
    private final Set<HomePage> homePages;
    private final Set<EditedBook> editedBooks;
    private final Set<AuthoredPublication> authoredPublications;

    public Person(String name, Set<HomePage> homePages, Set<EditedBook> editedBooks, Set<AuthoredPublication> authoredPublications) {
        this.name = name;
        this.homePages = homePages;
        this.editedBooks = editedBooks;
        this.authoredPublications = authoredPublications;
    }

    public String getName() {
        return name;
    }

    public Set<HomePage> getHomePages() {
        return homePages;
    }

    public Set<EditedBook> getEditedBooks() {
        return editedBooks;
    }

    public Set<AuthoredPublication> getAuthoredPublications() {
        return authoredPublications;
    }

    public void addAllHomePages(Set<HomePage> homePages) {
        this.homePages.addAll(homePages);
    }

    public void addAllEditedBooks(Set<EditedBook> editedBooks) {
        this.editedBooks.addAll(editedBooks);
    }

    public void addAllAuthoredPublications(Set<AuthoredPublication> authoredPublications) {
        this.authoredPublications.addAll(authoredPublications);
    }

    public Set<Publication> getPublications() {
        Set<Publication> publications = new LinkedHashSet<>();
        publications.addAll(editedBooks);
        publications.addAll(authoredPublications);
        return publications;
    }
}
