# Java Software Testing

Collection of advanced software-testing exercises developed in Java.

The repository focuses on automated testing, test doubles, structural coverage, mutation testing and systematic test design. It contains selected university labs that demonstrate more than basic unit testing.

## Project overview

The exercises explore different strategies for evaluating software quality and the effectiveness of test suites.

The repository includes:

- Unit testing with JUnit
- Mock-based testing with Mockito
- Verification of interactions between dependencies
- Structural coverage criteria
- Mutation testing
- Test design for boundary cases and exceptions
- Analysis of test-suite effectiveness

## Technologies

- Java
- JUnit
- Mockito
- Eclipse
- Git and GitHub

## Repository structure

```text
.
├── mockito-notification-service/
├── structural-coverage-agenda/
├── mutation-testing-date-calculator/
├── junit-test-design/
├── .gitignore
└── README.md
```

## Included projects

### Mockito Notification Service

Tests for a notification component that decides how to send alerts depending on severity and the available user contact information.

The tests use Mockito to:

- Create mock dependencies
- Simulate email and SMS services
- Verify expected method calls
- Check that unnecessary interactions do not occur
- Cover different execution branches
- Test missing-contact scenarios

This exercise demonstrates how mocks can isolate a unit from external services and validate collaboration between objects.

### Structural Coverage Agenda

White-box testing exercise focused on structural coverage.

The test suite is designed using criteria such as:

- Correlated Active Clause Coverage
- Primary paths
- Compound conditions
- Exception-related execution paths

The objective is to derive test cases from the internal control flow rather than only from input and output behaviour.

### Mutation Testing Date Calculator

Testing exercise based on a date-calculation component and several deliberately modified program versions.

The project compares different test sets and studies whether they detect introduced faults.

It includes:

- Base-case tests
- Edge-pair tests
- Primary-path tests
- Multiple mutants
- Comparison of test effectiveness
- Analysis of surviving and detected mutations

This exercise demonstrates that high code coverage does not automatically imply a strong test suite.

### JUnit Test Design

Selected JUnit exercises focused on systematic test design.

The tests cover:

- Normal cases
- Boundary values
- Invalid input
- Expected exceptions
- Repeated conditions
- Behavioural equivalence classes

## Testing concepts demonstrated

### Unit testing

Each test focuses on a small unit of behaviour and checks the expected result independently.

### Mocking

Mockito is used to replace real dependencies with controlled test doubles.

This makes it possible to:

- Isolate the class under test
- Simulate different dependency responses
- Verify interactions
- Avoid sending real emails or SMS messages

### Structural testing

Test cases are derived from control-flow structures, branches and conditions.

### Mutation testing

Small faults are introduced into the implementation to evaluate whether the tests are capable of detecting incorrect behaviour.

### Boundary and exception testing

The exercises include limits, invalid values and exceptional execution paths instead of testing only standard cases.

## Running the tests

### Requirements

- Java 8 or later
- JUnit
- Mockito
- Eclipse, IntelliJ IDEA or another Java IDE

### Eclipse

1. Import the desired folder as an existing Java project.
2. Add the required JUnit and Mockito libraries to the build path.
3. Open the test class.
4. Select:

```text
Run As → JUnit Test
```

### Command line

The exact command depends on how each original project is configured.

For Maven-based projects:

```bash
mvn test
```

For Gradle-based projects:

```bash
gradle test
```

If a project does not include a build tool, it can be imported and executed directly from an IDE.

## What I learned

This repository helped me strengthen my knowledge of:

- Automated testing in Java
- JUnit assertions and test organisation
- Mocking with Mockito
- Dependency isolation
- Interaction verification
- White-box test design
- Structural coverage criteria
- Mutation testing
- Boundary-value analysis
- Exception testing
- Evaluating the real effectiveness of a test suite

## Possible improvements

- Standardise all projects with Maven or Gradle
- Add continuous integration with GitHub Actions
- Generate JaCoCo coverage reports
- Add PIT mutation-testing reports
- Unify naming and package structure
- Add test documentation for each exercise
- Include coverage badges
- Add automated execution scripts

## Academic context

Selected university exercises developed for a Software Testing course.

The repository contains the most technically relevant practices and excludes introductory exercises that only demonstrate basic assertions.

## Author

**Katty Vasquez Peinado**

- [GitHub](https://github.com/KaTVasq)
