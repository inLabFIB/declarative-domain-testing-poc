package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain;

import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.domain_annotations.DomainClass;

import java.util.Set;

@DomainClass
@SuppressWarnings("unused")
public class BookSection {

    private final String title;
    private final int order;
    private final Set<BookChapter> bookChapters;

    public BookSection(String title, int order, Set<BookChapter> bookChapters) {
        this.title = title;
        this.order = order;
        this.bookChapters = bookChapters;
    }

    public String getTitle() {
        return title;
    }

    public int getOrder() {
        return order;
    }

    public Set<BookChapter> getBookChapters() {
        return bookChapters;
    }

    public void addAllBookChapters(Set<BookChapter> bookChapters) {
        this.bookChapters.addAll(bookChapters);
    }

}
