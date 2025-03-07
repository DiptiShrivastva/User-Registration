
#Guidelines for running tests scripts

## installations
- Java 11+ (JDK 11 or higher)
- Maven (for dependency management)

Dependencies in pom.xml
Copy dependencies from maven repository
- JUnit Jupiter Engine » 5.10.0
- Cucumber JVM: Java » 7.14.0
- Cucumber JVM: JUnit 4 » 7.14.0
- Cucumber JVM: JUnit 5 JUnit Platform Engine » 7.14.0
- Selenium Java » 4.16.0
- WebDriverManager » 5.9.2(for running test in headless through gitHub actions)

- For running test in headed form
(Install chromeDriver according to your OS
Install geckodriver according to your OS) take the commented code in driver setup file and give the path of your locals and run the tests

For running tests follow command in terminals
- mvn test -Dbrowser=chrome
- mvn test -Dbrowser=firefox
Hook set up because it can close and reopen browser

 
 