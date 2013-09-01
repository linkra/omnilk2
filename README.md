Omni / Plan3 - Assignment: Java / Backend
===========

## About the assignment

This assignment consists of two parts that each consists of one development task and a set of belonging questions.

## Intention
The assignment aims primarily to provide us with a freshly developed code base that you've authored. We'll look at your solution in combination with your answers to the questions but primarily it serves as a foundation for a discussion between us. We can discuss the solution with you in order to get a picture of how you work, how you've reasoned.
But the assignment also serves as an example of code that you might write as part of our team. This way we hope to convey a image of how you and we work in order for us to figure out if we might be a good match for each other. As much as this assignment is tailored to give us a view of who you are as programmer we also try to see it as a way for us to show you who we are and how we work.

An remember: **there are no hard rights or wrongs.** The rules outlined below are mainly to narrow the scope of the assignment so that it's easier to compare different solutions.

## Expectations
We expect that you supply us with:

* Two copies source trees, one for each of the tasks
   * The second task and its source code should be a reworked version of the first one
* A plain text document with your answers to the questions for the two tasks

## Execution
* You're allowed to:
    * Email us at dev@plan3.se and ask questions!
    * Use, add and remove any libraries and frameworks you'd like as long as you manage them with Maven
    * Change the indention and/or reformat the code, as long as _all of the code_ is consistencly formatted. All or nothing.
    * Take notes of and/or version the code during your work. If you want to submit your solution as a git repo that's ok but it's not required.
    * Question and critize the assignment! (too hard? too easy? too weird? not consistent?)
    * Break all or any of the rules if you get stuck. We'd rather receive a partial solution or a solution that doesn't conform to the rules than no solution. But if you choose to deviate from the rules we require that you document how and why you deviated from the instructions.
* You must not:
    * Alter the tests apart from what's done as part of refactoring. If you move a test or change a package name, then of course that will result in some minor changes in the tests.
* You are not required to:
    * Document your solution other than answering the questions in this document
    * Save data persistently, it's sufficient if data is stored in memory while the solution is running

And remember, this is meant to be fun.

### Preparations
* Install [Maven](http://maven.apache.org), see also:
    * [installation](http://maven.apache.org/download.html#Installation)
    * [getting started](http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html).
* If you're using Eclipse run `mvn eclipse:eclipse` in the root directory to create a project setup for [Eclipse](http://www.eclipse.org/)

### Testing
* To run the unit tests: `mvn test`
* To start the server: `mvn exec:java`, it'll be available at http://127.0.0.1:8080/
* To package and run the packaged solution the solution:
    * `mvn clean package`
    * `java -jar target/java-backend-recruitment-0.0.1-SNAPSHOT.jar server`

----

## The assignment

### Task 1
* Do a bare minimum implementation and/or adjustment to the code so that all tests passes:
    * Implement the code that's missing so that the solution compiles
    * Adjust the existing code so that the tests pass
* Questions: 
    1. if you would have built this solution, from scratch, which frameworks and libraries had you used?
    2. what's your impression and understanding of the frameworks and libraries we've used here?

### Task 2
* Adjust the code according to a set of rules
    * We'd like that you **wait with reading these rules** until you've completed the first task
    * The rules are here: https://dl.dropboxusercontent.com/u/697196/plan3-rekrytering-regler-del-2-en.txt
* Questions:
    1. What effect did applying the rules have on your code?
    2. Anything that became better?
    3. Anything that became worse?
