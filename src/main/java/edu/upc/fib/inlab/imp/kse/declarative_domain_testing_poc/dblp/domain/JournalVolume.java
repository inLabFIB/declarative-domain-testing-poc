package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain;

import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.domain_annotations.DomainClass;

import java.util.Set;

@DomainClass
@SuppressWarnings("unused")
public class JournalVolume {

    private final int volume;
    private final int endPage;
    private final Set<JournalIssue> journalIssues;
    private final Journal journal;

    public JournalVolume(int volume, int endPage, Set<JournalIssue> journalIssues, Journal journal) {
        this.volume = volume;
        this.endPage = endPage;
        this.journalIssues = journalIssues;
        this.journal = journal;
    }


    public int getVolume() {
        return volume;
    }

    public int getEndPage() {
        return endPage;
    }

    public Set<JournalIssue> getJournalIssues() {
        return journalIssues;
    }

    public Journal getJournal() {
        return journal;
    }

    public void addAllJournalIssues(Set<JournalIssue> journalIssues) {
        this.journalIssues.addAll(journalIssues);
    }

}
