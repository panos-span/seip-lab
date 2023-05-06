# seip-lab

This is my personal repository for the lab assignments of the course "Software Engineering in Practice"
at DMST (Department of Management Science and Technology) of Athens University of Economics and Business.

## Prerequisites for running the histogram generator

- Java 8
- Maven

## Steps to run the histogram generator

1. Clone the repository
2. Open the project locally
3. Add the grades file in the resources directory of the project `gradeshistogram/src/main/resources`
4. Once you have added the file, run the following command in the terminal:

```bash
mvn clean package
```

5. Finally, run the following command in the terminal to run the application:

```bash
java -jar gradeshistogram/target/gradeshistogram-1.0-SNAPSHOT-jar-with-dependencies.jar grades.txt
```

## Task

Create a Java application using the Maven build automation tool that
reads a file with students’ grades, and generates its histogram.
The goal of this assignment is twofold:

1. Get familiar with a Java library.
2. Use Maven to package your application and the aforementioned library
   into a standalone executable.
   Deadline:
    - 15/4/2023 23:55: Pull requests
    - 30/4/2023 23:55: Issue resolution based on received reviews

## Assignment (1)

- Step 1: Create a parent Maven simple project (skip archetype selection) with the following
  details:
    - groupId = gr.aueb.dmst.panagiotis_spanakis
    - artifactId = seip2023_practical_assignments
- Step 2: Create a module Maven simple project (skip archetype selection) with the following
  details:
    - Module artifactId = gradeshistogram
      Also, include a proper name and a good description in the corresponding POM elements for
      both parent and module.
      The following steps refer to the child (module) Maven project.
- Step 3: Add the latest [JFreeChart](https://mvnrepository.com/artifact/org.jfree/jfreechart) charting Java library
  from the central Maven Repository as a
  dependency in your POM.
- Step 4: Add the appropriate plugin in the POM so that your project can be packaged
  including the dependency (fat jar)

## Assignment (2)

- Step 5: Download the file with the [grades](https://drive.google.com/file/d/1ARM-MvoT4qRwWJbTqIJZPxhsi8D9vvRf/view).
- Step 6: Create a class named HistogramGenerator.
- Step 7: In HistogramGenerator, create a method that reads the grades file and
  stores the values in an array. Then, generate and present a histogram based on the
  array of values. A chart such as XYLineChart satisfies the assignment
  requirements.
    - In the main method, call the other methods to generate the histogram of the
      grades’ frequencies.
    - [Here](https://github.com/AntonisGkortzis/BuildAutomationToolsDemoProject/blob/master/histogramgenerator/src/main/java/histogramgenerator/JFreeChartXYLineChartDemo.java)
      is an example of how to use a XYLineChart to create charts. You are
      free to use any other charts available in the library.
    - **Important**: The grades file should be given as a command-line argument at
      runtime.

## Delivery guidelines

- Commit and push everything to your “development” branch.
- Create a pull request for merging the development branch to
  the main one on GitHub, and request a review from **zkotti**.
  Zoe will then allocate pull requests to reviewers.
- Do not merge on your own!
- The deadline for the pull requests is *15/4/2023 23:55*.
- Only then will we review your code and give you feedback.

## Grading rules

1. Project completeness and correctness:
    - The project structure should be correct.
    - Your Maven parent-module projects should be connected and compilable.
    - Your module should generate an executable jar.
    - The output histogram should be correct.
2. Clean and tidy repository: Unnecessary files (like IDE configuration and project
   files) and directories should not be committed. Check the .gitignore file.
3. Code quality: Code should be well-formatted and commented following the
   [Javadoc guidelines](https://www.tutorialspoint.com/java/java_documentation.htm), and POM description should be
   appropriate.
4. Resolved GitHub issues: After creating the pull request, address the issues that
   we will create. (We are responsible for closing the issues, do not close the
   issues on your own.)