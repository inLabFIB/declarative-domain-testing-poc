package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain;

import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.domain_annotations.DomainClass;

import java.util.List;
import java.util.Set;

@DomainClass
@SuppressWarnings("unused")
public class JournalPaper extends AuthoredPublication {

    private final int iniPage;
    private final int endPage;
    private final Set<JournalSection> journalSections;
    private final JournalIssue journalIssue;

    public JournalPaper(String title, Set<Book> books, List<Person> authors, int iniPage, int endPage, Set<JournalSection> journalSections, JournalIssue journalIssue) {
        super(title, books, authors);
        this.iniPage = iniPage;
        this.endPage = endPage;
        this.journalSections = journalSections;
        this.journalIssue = journalIssue;
    }

    public int getIniPage() {
        return iniPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public Set<JournalSection> getJournalSections() {
        return journalSections;
    }

    public JournalIssue getJournalIssue() {
        return journalIssue;
    }

    public void addAllJournalSections(Set<JournalSection> journalSections) {
        this.journalSections.addAll(journalSections);
    }

}
