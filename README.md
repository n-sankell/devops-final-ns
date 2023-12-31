# devops-final-ns
## Overview
This repository contains a calculator using Java and Spring Boot.
## Table of Contents
- [Features](#Features)
- [Prerequisites](#Prerequisites)
- [Getting Started](#Getting-started)
- [Project Structure](#Project-structure)
- [API Endpoints](#API-Endpoints)
- [Workflow](#Workflow)
## Features
Provide numbers **x**, **y** and one **operator** in a [calculateRequest](src/main/java/com/example/demo/request/CalculateRequest.java) to the [/calculate](src/main/java/com/example/demo/controller/CalculatorController.java) endpoint.

The valid operators are:
- Addition
- Subtraction
- Multiplication
- Division.
## Prerequisites
- Java 
- SpringBoot
- Gradle
- JUnit5
- MockMwc
- Rest Assured
- JaCoCo
- Checkstyle
## Getting Started
1. Clone the repository:
   ```bash
   git clone https://github.com/n-sankell/devops-final-ns
## Project structure
- [Controller](src/main/java/com/example/demo/controller) Layer
- [Service](src/main/java/com/example/demo/service) layer
- [Calculator](src/main/java/com/example/demo/calculator) layer
## Tests
- [Unit](src/test/java/com/example/demo) tests (JUnit5)
- [Integration](src/integrationTest/java/com/example/demo) tests (MockMwc)
- [System](src/systemIntegrationTest/java/com/example/demo) tests (Rest Assured)
## API-Endpoints
- [/calculate](src/main/java/com/example/demo/controller/CalculatorController.java)
- [/hello](src/main/java/com/example/demo/controller/CalculatorController.java)
## Workflow
Guidelines for this projects CI/CD

We use GitHub actions for CI/CD, with automated tests on unit- and system level.

The developers in this project won't be able to push to the main branch, 
instead create a feature branch and make a pull-request to the main branch.

Before you push code, run the tests with ./gradlew test and ./gradlew integrationTest to see if everything is working.
The gradle test tasks is configured to streamline your testing. 

When code gets pushed to GitHub it will trigger the Unit tests and a Checkstyle tests.
Make sure to write clean and well formatted code, checkstyle has a maximum of 5 warnings, 
otherwise you will not be able to merge with the main branch.

Every time you push code, all unit tests will run, giving you direct feedback if your code is working as it should.

When making a pull request, your code coverage will be calculated. If you have added new methods with different return values, your pull request might fail if your coverage is below 80%.

You will see the calculation and where it needs coverage as a comment in the pull request. 

If all previous steps pass, the integration and system tests will run, if all is successful the merge will be allowed.

## Useful commands
- **_./gradlew test_** (runs all unit-tests)
- **_./gradlew integrationTest_** (runs all integration tests)
- **_./gradlew systemIntegrationTest_** (runs system tests, this requires a running instance of the app)
- **_./gradlew checkstyleMain checkstyleTest_** (get a checkstyle report)

Happy coding!S