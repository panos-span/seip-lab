# seip-lab

This is my personal repository for the lab assignments of the course "Software Engineering in Practice"
at DMST (Department of Management Science and Technology) of Athens University of Economics and Business.

![Build Status](https://github.com/panos-span/seip-lab/actions/workflows/maven.yml/badge.svg)

[![codecov](https://codecov.io/gh/panos-span/seip-lab/branch/main/graph/badge.svg?token=ZE1ZNCLNO8)](https://codecov.io/gh/panos-span/seip-lab)

## Structure of the repository

The repository is structured in the following way:

- [Grades Histogram](gradeshistogram): Contains the code for the Maven assignment
- [Unit testing](unittesting): Contains the code for the UnitTesting assignment

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
