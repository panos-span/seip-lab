# Unit testing

Purpose of this submodule is to test and challenge the functionality of the classes in the `math` and `io` packages.

The goal of this assignment (Assignment 3) is to get familiar with unit testing and
continuous integration.

For this assignment, `junit 4.12` is used for testing.

```xml

<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
</dependency>
```

Also, `mockito 4.5.1` is used for mocking objects.

```xml

<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>4.5.1</version>
    <scope>test</scope>
</dependency>
```

Lastly, to generate the coverage report, `jacoco-maven-plugin` is used from the parent module.

```xml

<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.3</version>
    <executions>
        <execution>
            <id>prepare-agent</id>
            <goals>
                <goal>prepare-agent</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

## Packages that are tested

### math

This package contains the classes MyMath, ArithmeticOperations, and ArrayOperations that 
perform mathematical operations.

### io

This package has the FileIO class that reads a file and returns the integers it contains.

## Build the project

- To build the project, run the following command:

```bash
mvn package
```

## Generate test reports

- To test the functionality of the classes in the `math` and `io` packages, run the following command:

```bash
mvn test
```

This will generate a test report in the `target/surefire-reports` directory.
All tests should pass.

- To generate the coverage report, run the following command:

```bash
mvn package jacoco:report
```

This will generate a coverage report in the `target/site/jacoco` directory.

To see the coverage report, open the `index.html` file in a browser.

The **JaCoCo** report shows the code coverage for the project, including
 1. the percentage of lines covered by tests, 
 2. the percentage of branches covered by tests, 
 3. the percentage of instructions covered by tests.

You can use the **JaCoCo** report to identify areas of the code that are not covered by tests and improve the test
coverage for the project.



