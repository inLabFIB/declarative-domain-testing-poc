package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain;

import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.domain_annotations.DomainClass;

import java.util.Set;

@DomainClass
@SuppressWarnings("unused")
public class Journal {

    private final String title;
    private final String issn;
    private final Set<JournalVolume> journalVolumes;

    public Journal(String title, String issn, Set<JournalVolume> journalVolumes) {
        this.title = title;
        this.issn = issn;
        this.journalVolumes = journalVolumes;
    }

    public String getTitle() {
        return title;
    }

    public String getIssn() {
        return issn;
    }

    public Set<JournalVolume> getJournalVolumes() {
        return journalVolumes;
    }

    public void addAllJournalVolumes(Set<JournalVolume> journalVolumes) {
        this.journalVolumes.addAll(journalVolumes);
    }

}
