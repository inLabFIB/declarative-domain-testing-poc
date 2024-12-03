package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.recommendations.factory;

import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.domain_model.DomainClasses;
import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.domain_model.DomainClassesHierarchy;
import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.domain_model.DomainModel;
import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.domain_model.DomainRelations;
import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.rule_automation.DomainModelProvider;
import edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.recommendations.domain.*;

import java.util.List;
import java.util.Set;

public class RecommendationsDomainModelProvider implements DomainModelProvider {

    @Override
    public DomainModel obtainDomainModel() {
        return new DomainModel(
                generateDomainClasses(),
                generateDomainRelations(),
                generateDomainClassesHierarchy()
        );
    }

    public DomainClasses generateDomainClasses() {
        return DomainClasses.builder()
                .addAll(List.of(Book.class, Person.class, ReadBook.class, Recommendation.class, BestSeller.class),
                        List.of(3, 2, 4, 3, 3))
                .build();
    }

    public DomainRelations generateDomainRelations() {
        return DomainRelations.builder()
                .addRelation(ReadBook.class, Recommendation.class, Set.class,
                             "recommendations", 3
                )
                .addSimpleRelation(Book.class, Person.class, "author",2)
                .addSimpleRelation(ReadBook.class, Person.class, "person", 0)
                .addSimpleRelation(ReadBook.class, Book.class, "book", 1)
                .addSimpleRelation(Recommendation.class, ReadBook.class, "from", 0)
                .addSimpleRelation(Recommendation.class, Person.class, "to", 1)
                .build();
    }

    public DomainClassesHierarchy generateDomainClassesHierarchy() {
        return DomainClassesHierarchy.builder()
                .addSubclassSuperclassRelation(BestSeller.class, Book.class)
                .build();
    }

}