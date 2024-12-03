package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.recommendations.domain;


import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.domain_annotations.DomainClass;

import java.util.Set;

@DomainClass
@SuppressWarnings("unused")
public final class ReadBook {

    private final Person person;
    private final Book book;
    private final int year;

    private final Set<Recommendation> recommendations;

    public ReadBook(Person person, Book book, int year, Set<Recommendation> recommendations) {
        this.person = person;
        this.book = book;
        this.year = year;
        this.recommendations = recommendations;
    }

    public Person getPerson() {
        return person;
    }

    public Book getBook() {
        return book;
    }

    public int getYear(){
        return year;
    }

    public Set<Recommendation> getRecommendations() {
        return recommendations;
    }

    public void removeRecommendation(Recommendation r){
        recommendations.remove(r);
    }

    public void addAllRecommendations(Set<Recommendation> recommendations) {
        this.recommendations.addAll(recommendations);
    }

}
