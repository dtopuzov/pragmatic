# Appium Demos

- Basics of JUnit 5 
    - Available at `src/tests/java/tests.helloworld`
    - Demonstrate JUnit 5 features like
        - Basic tests attributes
        - Test order and priority
        - Hooks (before and after tests logic)
        - Inherit tests from base tests class
        - Data driven testing


- Test native Android and iOS apps
    - Available at `src/tests/java/nativeapp`
    - Since app under tests look the same on both platforms there is no point to implement tests twice.
    - That is the power of Appium - write tests once, run on both Android and iOS.
    - Just have in mind you should pass the configuration to the IDE when you run tests, please see the `Execution` section.


- Test web on mobile browsers
    - Available at `src/tests/java/nativeapp.mobileweb`
    - Same notes for the configuration apply too, see the `Execution` section.

## Technology Stack
- [Gradle](https://gradle.org/) to build the project and manage dependencies
- [JUnit 5](https://junit.org/junit5/) as unit testing framework
- [Appium](http://appium.io/) to drive mobile devices/emulators/simulators.

## Execution

### IntelliJ IDEA
TBD.

### Commandline

Execute hello-world tests:

```bash
./gradlew clean test --tests "helloworld.*"
```
