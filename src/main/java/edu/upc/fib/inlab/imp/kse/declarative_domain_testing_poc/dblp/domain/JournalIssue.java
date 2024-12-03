package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain;

import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.domain_annotations.DomainClass;

import java.util.Set;

@DomainClass
@SuppressWarnings("unused")
public class JournalIssue {

    private final int number;
    private final int year;
    private final Set<Month> months;
    private final Set<JournalPaper> journalPapers;
    private final JournalVolume journalVolume;
    private final Set<ConferenceEdition> conferenceEditions;

    public JournalIssue(int number, int year, Set<Month> months, Set<JournalPaper> journalPapers, JournalVolume journalVolume, Set<ConferenceEdition> conferenceEditions) {
        this.number = number;
        this.year = year;
        this.months = months;
        this.journalPapers = journalPapers;
        this.journalVolume = journalVolume;
        this.conferenceEditions = conferenceEditions;
    }

    public int getNumber() {
        return number;
    }

    public int getYear() {
        return year;
    }

    public Set<Month> getMonths() {
        return months;
    }

    public Set<JournalPaper> getJournalPapers() {
        return journalPapers;
    }

    public JournalVolume getJournalVolume() {
        return journalVolume;
    }

    public Set<ConferenceEdition> getConferenceEditions() {
        return conferenceEditions;
    }

    public void addAllMonths(Set<Month> months) {
        this.months.addAll(months);
    }

    public void addAllJournalPapers(Set<JournalPaper> journalPapers) {
        this.journalPapers.addAll(journalPapers);
    }

    public void addAllConferenceEditions(Set<ConferenceEdition> conferenceEditions) {
        this.conferenceEditions.addAll(conferenceEditions);
    }

}
