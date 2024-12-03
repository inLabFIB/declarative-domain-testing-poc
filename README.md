# Declarative Domain Testing - Proof of Concept

This project is a proof of concept for declarative domain testing using Java and Maven. It includes various modules and tests for handling DBLP domain and generating Recommendations domain.

## Requisites

- Java 17 or higher
- Maven (included in the project as a wrapper)

## Directory Structure

- `src/main/java`: Contains the main application source code.
- `src/test/java`: Contains the test source code.
- `src/test/resources`: Contains resources used in tests.
- `experiments/`: Directory for experiment files.
- `logs/`: Directory for log files when execute DBLPExperimentsExecutor
- `cache/`: Directory for cache files (only when use cache=true in @DeclarativeTest)
- `libs/`: Directory for external libraries.

## Running Recommendation Tests

To run the recommendation tests, follow these steps:

1. **Build the Project**: Ensure that the project is built using Maven. Run the following command in the project root directory:
    ```sh
    ./mvnw clean test-compile
    ```

2. **Run the Recommendation Tests**: Execute the recommendation tests using Maven. Run the following command in the project root directory:
    ```sh
    ./mvnw test -Dtest=RecommendationsTest
    ```

This will run all the tests related to recommendations.

## Running DBLP Experiments

To execute the DBLP experiments using `DBLPExperimentsExecutor`, follow these steps:

1. **Build the Project**: Ensure that the project is built using Maven. Run the following command in the project root directory:
    ```sh
    ./mvnw clean test-compile 
    ```

2. **Run the Executor**: Execute the `DBLPExperimentsExecutor` class. You can do this from the command line or your IDE. For command line, use:
    ```sh
    ./mvnw test -Dtest=DBLPExperimentsExecutor
    ```

This will run the experiments and generate the results in the `logs/` directory.

## Activating/Deactivating Cache in @DeclarativeTest

In this project, you can control the caching behavior of declarative tests using the `@DeclarativeTest` annotation. By default, caching is disabled, but you can enable or disable it as needed.

### Disabling Cache

To disable caching for a declarative test, set the `cache` attribute to `false`:

```java
@DeclarativeTest(cache = false)
```

### Enabling Cache

To enable caching for a declarative test, set the `cache` attribute to `true`:

```java
@DeclarativeTest(cache = true)
```

Actually, the cache is not used in this repository tests, but you can enable it by changing the `cache` attribute in the `@DeclarativeTest` annotation.
This allows you to control whether the test results should be cached, which can be useful for improving performance during repeated test executions.
In directory `cache/` you can see the cache files generated by the tests.

## Generating `codeStructureRules` file for DBLP and Recommendations Domains

To generate the `codeStructureRules` file for the DBLP and Recommendations domains, you need to execute the `main` methods of the `RecommendationsCodeStructureFileGenerator` and `DBLPCodeStructureFileGenerator` classes, respectively. These methods require two parameters: the first is the `Provider` and the second is the `output path`.

### Steps to Execute

1. **Generate `codeStructureRules` file for the Recommendations domain:**

    ```sh
    ./mvnw exec:java -D"exec.mainClass"="edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.recommendations.factory.RecommendationsCodeStructureFileGenerator" -D"exec.args"="edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.recommendations.factory.RecommendationsDomainModelProvider ." -D"exec.classpathScope"="test"
    ```

2. **Generate `codeStructureRules` file for the DBLP domain:**

    ```sh
    ./mvnw exec:java -D"exec.mainClass"="edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.factory.DBLPCodeStructureFileGenerator" -D"exec.args"="edu.upc.fib.inlab.imp.kse.declarative_domain_testing_poc.dblp.factory.DBLPDomainModelProvider ." -D"exec.classpathScope"="test"
    ```
   
These files are not necessary to run the tests, but they can be useful to understand the structure of the domain and the rules that are being used in the tests.

## Additional Information

- **Dependencies**: All dependencies are managed through Maven. Ensure that your `pom.xml` file is correctly configured.

For any further questions or issues, please refer to the project documentation or contact the project maintainers.