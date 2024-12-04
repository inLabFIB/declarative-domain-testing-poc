package edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.recommendations;

import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.BusinessRules;
import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.DeclarativeInput;
import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.DeclarativeTest;
import edu.upc.fib.inlab.imp.kse.declarative_domain_testing.annotations.Domain;
import edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.recommendations.domain.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RecommendationsTest {

    @Domain(path = "edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.recommendations.domain")
    @BusinessRules(files = "examples/recommendations/businessRules.impl")
    @DeclarativeInput( "(r,rb) :- Recommendation(r, rb, p, c), ReadBook(rb, p2, bo, y, rs)")
    @DeclarativeTest(cache = false)
    void shouldRemoveRecommendation(Recommendation r, ReadBook b) {
        b.removeRecommendation(r);
        assertThat(b.getRecommendations()).doesNotContain(r);
    }
}
