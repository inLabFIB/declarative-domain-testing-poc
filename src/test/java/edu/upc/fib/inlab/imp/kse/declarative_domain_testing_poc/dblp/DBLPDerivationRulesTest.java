package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp;

import ch.qos.logback.classic.Logger;
import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.BusinessRules;
import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.DeclarativeInput;
import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.DeclarativeTest;
import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.Domain;
import edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

class DBLPDerivationRulesTest {

    @BeforeAll
    static void setUp() {
        //Disable slf4j logging for DeclarativeTestExtension
        Logger rootLogger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        rootLogger.detachAppender("STDOUT");
    }

    @Nested
    class DerivedAttributes {

        @Nested
        class Person_numberPublications_1 {

            @Domain(path = "edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain")
            @BusinessRules(files = "examples/dblp/businessRules.impl")
            @DeclarativeInput("(oid) :- Person(oid,_,_,editedBooks,authoredPublications), " +
                    "Person_editedBooks(editedBooks), CollectionElement(editedBooks,_,_), " +
                    "Person_authoredPublications(authoredPublications), CollectionElement(authoredPublications,_,_)")
            @DeclarativeTest(cache = false)
            void shouldGeneratePerson_numberPublications(Person o) {
                assertThat(o).isNotNull();
                assertThat(o.getAuthoredPublications()).hasSizeGreaterThanOrEqualTo(1);
                assertThat(o.getEditedBooks()).hasSizeGreaterThanOrEqualTo(1);
            }
        }


        @Nested
        class JournalIssue_numPages_2 {

            @Domain(path = "edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain")
            @BusinessRules(files = "examples/dblp/businessRules.impl")
            @DeclarativeInput("""
                    (oid) :- JournalIssue(oid,_,_,_,_,_,_), JournalPaper(jp1,_,2,_,oid), not(aux(oid))
                    aux(oid) :- JournalPaper(jp2,_,endPage,_,oid), endPage>2
                    """)
            @DeclarativeTest(cache = false)
            void shouldGenerateJournalIssue_numPages(JournalIssue o) {
                assertThat(o).isNotNull();
                int lastEndPage = o.getJournalPapers().stream().mapToInt(JournalPaper::getEndPage).max().orElseThrow();
                assertThat(lastEndPage).isEqualTo(2);
            }

        }

        @Nested
        class Publication_year_3 {

            @Domain(path = "edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain")
            @BusinessRules(files = "examples/dblp/businessRules.impl")
            @DeclarativeInput("(oid) :- Publication(oid,_,_), Book(b1,_,_,_,2010,_,oid)")
            @DeclarativeTest(cache = false)
            void shouldGeneratePublication_year(Publication o) {
                assertThat(o).isNotNull();
                assertThat(o.getBooks())
                        .hasSize(1)
                        .first()
                        .extracting(Book::getPublicationYear)
                        .isEqualTo(2010);
            }
        }

        @Nested
        class Publication_edition_4 {
            @Domain(path = "edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain")
            @BusinessRules(files = "examples/dblp/businessRules.impl")
            @DeclarativeInput("(oid) :- Publication(oid,_,books), EditedBook(oid,_,_,_), Book(b1,_,_,'publisher',2010,_,oid)")
            @DeclarativeTest(cache = false)
            void shouldGeneratePublication_edition_withEditedBook(Publication o) {
                assertThat(o).isNotNull();
                assertThat(o)
                        .isInstanceOf(EditedBook.class);
                assertThat(o.getBooks())
                        .hasSize(1)
                        .first()
                        .satisfies(book -> {
                            assertThat(book.getPublisher()).isEqualTo("publisher");
                            assertThat(book.getPublicationYear()).isEqualTo(2010);
                        });
            }

        }

        @Nested
        class JournalPaper_conferencePaper_5 {

            @Domain(path = "edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain")
            @BusinessRules(files = "examples/dblp/businessRules.impl")
            @DeclarativeInput("(oid) :- JournalPaper(oid,_,_,_,journalIssue), JournalIssue(journalIssue,_,_,_,_,_,ces), CollectionElement(ces,_,_)")
            @DeclarativeTest(cache = false)
            void shouldGenerateJournalPaper_conferencePaper(JournalPaper o) {
                assertThat(o).isNotNull();
                assertThat(o.getJournalIssue()).isNotNull();
                assertThat(o.getJournalIssue().getConferenceEditions()).isNotEmpty();
            }
        }

        @Nested
        class BookChapter_conferencePaper_6 {

            @Domain(path = "edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain")
            @BusinessRules(files = "examples/dblp/businessRules.impl")
            @DeclarativeInput("(oid) :- BookChapter(oid,_,_,_,editedBooks,_), CollectionElement(editedBooks,_,eb1), EditedBook(eb1,ces,_,_), CollectionElement(ces,_,_)")
            @DeclarativeTest(cache = false)
            void shouldGenerateBookChapter_conferencePaper_fromEditedBook(BookChapter o) {
                assertThat(o).isNotNull();
                assertThat(o.getEditedBooks())
                        .hasSize(1)
                        .first()
                        .satisfies(eb -> assertThat(eb.getConferenceEditions()).isNotEmpty());
            }
        }

    }

    @Nested
    class DerivedAssociations {

        @Nested
        class Publishes_between_Person_and_Publication_1 {

            @Domain(path = "edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain")
            @BusinessRules(files = "examples/dblp/businessRules.impl")
            @DeclarativeInput("(oid) :- Person(oid,_,_,editedBooks,authoredPublications), " +
                    "Person_editedBooks(editedBooks), CollectionElement(editedBooks,_,_), " +
                    "Person_authoredPublications(authoredPublications), CollectionElement(authoredPublications,_,_)")
            @DeclarativeTest(cache = false)
            void shouldGeneratePublishes_between_Person_and_Publication(Person o) {
                assertThat(o).isNotNull();
                assertThat(o.getAuthoredPublications()).hasSizeGreaterThanOrEqualTo(1);
                assertThat(o.getEditedBooks()).hasSizeGreaterThanOrEqualTo(1);
            }

        }

        @Nested
        class Association_Between_JournalIssue_and_JournalSection_2 {

            @Domain(path = "edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain")
            @BusinessRules(files = "examples/dblp/businessRules.impl")
            @DeclarativeInput("(oid) :- JournalPaper(jp1,_,_,journalSections,oid), CollectionElement(journalSections,_,_)")
            @DeclarativeTest(cache = false)
            void shouldGenerateAssociation_Between_JournalIssue_and_JournalSection(JournalIssue o) {
                assertThat(o).isNotNull();
                assertThat(o.getJournalPapers()).isNotEmpty();
                assertThat(o.getJournalPapers())
                        .anySatisfy(jp -> assertThat(jp.getJournalSections()).isNotEmpty());
            }

        }

        @Nested
        class Association_Between_EditedBook_and_BookSection_3 {

            @Domain(path = "edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain")
            @BusinessRules(files = "examples/dblp/businessRules.impl")
            @DeclarativeInput("(oid) :- EditedBook(oid,_,bookChapters,_), CollectionElement(bookChapters,_,bc1), BookChapter(bc1,_,_,bookSections,_,_), CollectionElement(bookSections,_,_)")
            @DeclarativeTest(cache = false)
            void shouldGenerateAssociation_Between_EditedBook_and_BookSection(EditedBook o) {
                assertThat(o).isNotNull();
                assertThat(o.getBookChapters()).isNotEmpty();
                assertThat(o.getBookChapters())
                        .anySatisfy(bc -> assertThat(bc.getBookSections()).isNotEmpty());
            }
        }

        @Nested
        class Association_Between_BookSeriesIssue_and_BookSection_4 {

            @Domain(path = "edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.domain")
            @BusinessRules(files = "examples/dblp/businessRules.impl")
            @DeclarativeInput("(oid) :- BookSeriesIssue(oid,_,bookChapters,_,_), CollectionElement(bookChapters,_,bc1), " +
                    "BookChapter(bc1,_,_,bookSections,_,_), CollectionElement(bookSections,_,_)")
            @DeclarativeTest(cache = false)
            void shouldGenerateAssociation_Between_BookSeriesIssue_and_BookSection(BookSeriesIssue o) {
                assertThat(o).isNotNull();
                assertThat(o.getBookChapters()).isNotEmpty();
                assertThat(o.getBookChapters())
                        .anySatisfy(bc -> assertThat(bc.getBookSections()).isNotEmpty());
            }

        }

    }
}