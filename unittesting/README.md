# Unit testing

Create test cases that challenge the functionality
of a given set of Java source files.
The goal of this assignment is to get familiar with unit testing and
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

## Packages that are tested

### math

Create a set of test cases that challenge the
functionality of the classes contained in the `math` package.

### io

This package has the FileIO class that reads a file and returns the integers it contains.
