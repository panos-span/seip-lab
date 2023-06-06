# Project: Source Code Analyzer

This project is a demonstration of some software design patterns in Java. It aims to analyze source code files and
export their metrics (like the number of classes, number of methods, and lines of code).

## How to Build and Run

1. Build the executable Java application with:
   ~~~bash
   mvn package jacoco:report
   ~~~

2. Run the executable by executing
   java –jar “jar-with-dependencies” arg0 arg1 arg2 arg3 arg4
   > where args translate to:
    - arg0 = `JavaSourceCodeInputFile` (e.g., src/test/resources/TestClass.java)
    - arg1 = `sourceCodeAnalyzerType` [regex|strcomp]
    - arg2 = `SourceCodeLocationType` [local|web]
    - arg3 = `OutputFilePath` (e.g., ../output_metrics_file)
    - arg4 = `OutputFileType` [csv|json]

**Example**:

~~~bash
java –jar sourcecodeanalyzer/target/sourcecodeanalyzer-0.0.1-SNAPSHOT-jar-with-dependencies.jar sourcecodeanalyzer/src/test/resources/TestClass.java regex local metrics_results csv
~~~

---

## Project Structure

The project is structured as follows:

- `codeanalyzer` package: Contains the main classes of the project and notably the `SourceCodeAnalyzerFacade` class.
- `codeanalyzer.analyzer` package: Contains the `SourceCodeAnalyzer` interface and its implementations.
- `codeanalyzer.metricsexporter` package: Contains the `MetricsExporter` interface and its implementations.
- `codeanalyzer.filereader` package: Contains the `SourceFileReader` interface and its implementations.
- `demo` package: Contains the `Demo` class, which is used to demonstrate the project.

---

## Class Diagram

The class diagram of the final version of the system is displayed below:

![Class Diagram](src/main/resources/UML.png)

---

## Solution Description

There are three primary dimensions in the system :

1. **source code analyzer type**

2. **source file reader type**

3. **metrics exporter type**

For the redesign of the system based on the **SOLID** principles, the following design patterns are used:
- **Facade Pattern**: The `SourceCodeAnalyzerFacade` class is an example of the Facade design pattern.
- **Factory Pattern**: The `SourceFileReaderFactory`, `SourceCodeAnalyzerFactory`, and `MetricsExporterFactory` classes implement the Factory design pattern.
- **Strategy Pattern**: The classes `SourceFileReader`, `SourceCodeAnalyzer`, and `MetricsExporter` represent the Strategy pattern.
- **Null Object Pattern**: The `NullMetricsExporter` class and the `NullSourceCodeAnalyzer` class use the Null Object design pattern.


## Design Patterns Used

### Facade Pattern

The `SourceCodeAnalyzerFacade` class is an example of the Facade design pattern.
This pattern provides a unified
interface to a set of interfaces in a subsystem.
It defines a higher-level interface that makes the subsystem easier to
use.

`SourceCodeAnalyzerFacade` wraps complicated subsystems (`SourceFileReader`, `SourceCodeAnalyzer`, `MetricsExporter`)
and provides a simpler API to clients.
This facade hides the complexities of the subsystems, thus providing an easier
way to the client to access the subsystem's functionality.

#### Pros:

- **Simplified Interface**: Provides a simple interface to a complex subsystem, making it easy for clients to use the
  system.
- **Decoupling**: Facade decouples a client implementation from the subsystem, making the system more modular and easier
  to modify or extend.

#### Cons:

- **Limited Flexibility**: Clients might need more flexibility than the Facade provides, limiting access to only some
  features of the subsystem.
- **Additional Layer**: Introduces an additional layer between the client and the subsystem, which could potentially add
  complexity or performance overhead.

### Factory Pattern

The `SourceFileReaderFactory`, `SourceCodeAnalyzerFactory`, and `MetricsExporterFactory` classes implement the Factory
design pattern.
This pattern deals with the problem of creating objects without specifying the exact class of the object
that will be created.

Each factory is responsible for creating a different kind of object: `SourceFileReaderFactory`
creates `SourceFileReader` objects, `SourceCodeAnalyzerFactory` creates `SourceCodeAnalyzer` objects,
and `MetricsExporterFactory` creates `MetricsExporter` objects.
The type of object created depends on the string
parameter provided to the factory method.

#### Pros:

- **Encapsulation**: Encapsulates the creation logic and decouples the client code from concrete classes.
- **Flexibility**: Allows the introduction of new product types without breaking existing client code.

#### Cons:

- **Complexity**: Can make code more complex than necessary if the product types are not likely to change or the
  creation process is straightforward.
- **Class Proliferation**: The pattern can lead to an increase in the number of classes, making the code harder to
  follow.

### Strategy Pattern

The classes `SourceFileReader`, `SourceCodeAnalyzer`, and `MetricsExporter` and their implementations
such as `LocalFileReader` and `WebFileReader` for the `SourceFileReader`, `RegexAnalyzer` 
and `StrcompAnalyzer` for the `SourceCodeAnalyzer` and `CsvExporter` and `JsonExporter` for the `MetricsExporter`
represent the Strategy pattern.
This pattern
enables an algorithm's behavior to be selected at runtime.
With this pattern, the algorithm can vary independently
of the clients that use it.
This way, the system can be extended with new algorithms without modifying existing code.


The `SourceFileReader` class has different implementations to read files from different locations (local, web, etc.).
The `SourceCodeAnalyzer` class has different implementations to analyze source code based on different strategies (
regex, strcomp, etc.).
The `MetricsExporter` class has different implementations to export metrics to different
formats (csv, json, etc.).

#### Pros:

- **Flexibility**: Allows the selection of an algorithm at runtime.
- **Open for Extension**: Allows the addition of new algorithms without modifying existing code.

### Null Object Pattern

The `NullMetricsExporter` class and the `NullSourceCodeAnalyzer` class use the Null Object design pattern.
This pattern provides an
object that acts as a surrogate for a lack of an object of a given type.
This object behaves as a real object but does
not do anything.
This way, the system handles the null case by letting the program terminate without interruptions
or errors.

#### Pros:

- **Eliminates Null Checks**: Eliminates the need for tedious null checks in the client code.
- **Consistency**: Provides a consistent way to handle nulls and real objects.

#### Cons:

- **Complexity**: Can make code more complex than necessary if the product types are not likely to change or the
  creation process is straightforward.
- **Hidden Errors**: Errors can get masked and become harder to debug since the system behaves as though nothing wrong has happened.
- **Class Proliferation**: The pattern can lead to an increase in the number of classes, making the code harder to
  follow.

## Conclusion

Understanding these design patterns helps in recognizing the common structures that make software flexible, modular, and
resilient.
These patterns offer solutions to common coding problems, thus they can save developers a lot of time.
