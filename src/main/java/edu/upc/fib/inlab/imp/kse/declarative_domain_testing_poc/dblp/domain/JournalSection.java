package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain;

import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.domain_annotations.DomainClass;

import java.util.Set;

@DomainClass
@SuppressWarnings("unused")
public class JournalSection {

    private final String title;
    private final int order;
    private final Set<JournalPaper> journalPapers;

    public JournalSection(String title, int order, Set<JournalPaper> journalPapers) {
        this.title = title;
        this.order = order;
        this.journalPapers = journalPapers;
    }

    public String getTitle() {
        return title;
    }

    public int getOrder() {
        return order;
    }

    public Set<JournalPaper> getJournalPapers() {
        return journalPapers;
    }

    public void addAllJournalPapers(Set<JournalPaper> journalPapers) {
        this.journalPapers.addAll(journalPapers);
    }

}
