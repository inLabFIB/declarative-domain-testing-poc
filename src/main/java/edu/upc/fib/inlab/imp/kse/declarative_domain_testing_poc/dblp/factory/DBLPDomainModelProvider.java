package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.factory;

import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.domain_model.DomainClasses;
import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.domain_model.DomainClassesHierarchy;
import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.domain_model.DomainModel;
import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.domain_model.DomainRelations;
import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.rule_automation.DomainModelProvider;
import edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain.*;

import java.util.List;

@SuppressWarnings("unused")
public class DBLPDomainModelProvider implements DomainModelProvider {

    @Override
    public DomainModel obtainDomainModel() {
        return new DomainModel(
                getDomainClasses(),
                getDomainRelations(),
                getDomainClassesHierarchy()
        );
    }

    private static DomainClassesHierarchy getDomainClassesHierarchy() {
        return DomainClassesHierarchy.builder()
                .addSubclassSuperclassRelation(EditedBook.class, Publication.class)
                .addSubclassSuperclassRelation(AuthoredPublication.class, Publication.class)
                .addSubclassSuperclassRelation(AuthoredBook.class, AuthoredPublication.class)
                .addSubclassSuperclassRelation(BookChapter.class, AuthoredPublication.class)
                .addSubclassSuperclassRelation(JournalPaper.class, AuthoredPublication.class)
                .addSubclassSuperclassRelation(BookSeriesIssue.class, Book.class)
                .build();
    }

    private static DomainRelations getDomainRelations() {
        return DomainRelations.builder()
                .addRelation(AuthoredPublication.class, Person.class, List.class, "authors", 0)
                .addUnorderedAndUniqueRelation(BookChapter.class, BookSection.class, "bookSections", 2)
                .addUnorderedAndUniqueRelation(BookChapter.class, EditedBook.class, "editedBooks", 3)
                .addUnorderedAndUniqueRelation(BookChapter.class, BookSeriesIssue.class, "bookSeriesIssues", 4)
                .addUnorderedAndUniqueRelation(Book.class, HomePage.class, "homePages", 1)
                .addUnorderedAndUniqueRelation(BookSection.class, BookChapter.class, "bookChapters", 2)
                .addUnorderedAndUniqueRelation(BookSeriesIssue.class, BookChapter.class, "bookChapters", 1)
                .addUnorderedAndUniqueRelation(BookSeriesIssue.class, ConferenceEdition.class, "conferenceEditions", 3)
                .addUnorderedAndUniqueRelation(ConferenceEdition.class, HomePage.class, "homePages", 4)
                .addUnorderedAndUniqueRelation(ConferenceEdition.class, EditedBook.class, "editedBooks", 5)
                .addUnorderedAndUniqueRelation(ConferenceEdition.class, BookSeriesIssue.class, "bookSeriesIssues", 6)
                .addUnorderedAndUniqueRelation(ConferenceEdition.class, JournalIssue.class, "journalIssues", 7)
                .addUnorderedAndUniqueRelation(EditedBook.class, ConferenceEdition.class, "conferenceEditions", 0)
                .addUnorderedAndUniqueRelation(EditedBook.class, BookChapter.class, "bookChapters", 1)
                .addRelation(EditedBook.class, Person.class, List.class, "editors", 2)
                .addUnorderedAndUniqueRelation(Journal.class, JournalVolume.class, "journalVolumes", 2)
                .addUnorderedAndUniqueRelation(JournalIssue.class, Month.class, "months", 2)
                .addUnorderedAndUniqueRelation(JournalIssue.class, JournalPaper.class, "journalPapers", 3)
                .addUnorderedAndUniqueRelation(JournalIssue.class, ConferenceEdition.class, "conferenceEditions", 5)
                .addUnorderedAndUniqueRelation(JournalPaper.class, JournalSection.class, "journalSections", 2)
                .addUnorderedAndUniqueRelation(JournalSection.class, JournalPaper.class, "journalPapers", 2)
                .addUnorderedAndUniqueRelation(JournalVolume.class, JournalIssue.class, "journalIssues", 2)
                .addUnorderedAndUniqueRelation(Person.class, HomePage.class, "homePages", 1)
                .addUnorderedAndUniqueRelation(Person.class, EditedBook.class, "editedBooks", 2)
                .addUnorderedAndUniqueRelation(Person.class, AuthoredPublication.class, "authoredPublications", 3)
                .addUnorderedAndUniqueRelation(Publication.class, Book.class, "books", 1)

                .addSimpleRelation(Book.class, Publication.class, "publication", 5)
                .addSimpleRelation(BookSeriesIssue.class, BookSeries.class, "bookSeries", 2)
                .addSimpleRelation(ConferenceEdition.class, ConferenceSeries.class, "conferenceSeries", 8)
                .addSimpleRelation(JournalPaper.class, JournalIssue.class, "journalIssue", 3)
                .addSimpleRelation(JournalIssue.class, JournalVolume.class, "journalVolume", 4)
                .addSimpleRelation(JournalVolume.class, Journal.class, "journal", 3)
                .build();
    }

    private static DomainClasses getDomainClasses() {
        return DomainClasses.builder()
                .add(AuthoredBook.class, 0)
                .add(AuthoredPublication.class, 1)
                .add(Book.class, 6)
                .add(BookChapter.class, 5)
                .add(BookSection.class, 3)
                .add(BookSeries.class, 2)
                .add(BookSeriesIssue.class, 4)
                .add(ConferenceEdition.class, 9)
                .add(ConferenceSeries.class, 2)
                .add(EditedBook.class, 3)
                .add(HomePage.class, 1)
                .add(Journal.class, 3)
                .add(JournalIssue.class, 6)
                .add(JournalPaper.class, 4)
                .add(JournalSection.class, 3)
                .add(JournalVolume.class, 4)
                .add(Month.class, 2)
                .add(Person.class, 4)
                .add(Publication.class, 2)
                .build();
    }
}
