# Appium Demos

- Basics of TestNG
  - Available at `src/tests/java/tests.demo01`
  - Demonstrate TestNG features like
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

- [Maven](https://maven.apache.org/) to build the project and manage dependencies
- [TestNG](https://testng.org/doc/) as unit testing framework
- [Appium](http://appium.io/) to drive mobile devices/emulators/simulators.

## Execution

### Commandline

Execute hello-world tests for inheritance:

```bash
mvn clean test -Dtest="tests.demo01.inheritance.*Tests"
```

Execute tests for native mobile app and android emulator:

```bash
 mvn clean test -Dtest="nativeapp.tests.*Tests" -Dconfig="nativeapp.emulator"
```

### IntelliJ IDEA

- You may hit [this issue](https://stackoverflow.com/questions/57299606/testng-by-default-disables-loading-dtd-from-unsecure-urls) on older versions of IntelliJ IDEA.
  - The solution is to upgrade to `2020.3` release where the issue is [addressed](https://youtrack.jetbrains.com/issue/IDEA-234765).
