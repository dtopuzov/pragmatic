# Mobile Test Automation 2021 Classwork Project

## About
Project we develop during Mobile Test Automation course.

Goals:
- Exercise Appium APIs
- Demonstrate some basic good practices in test automation

Non Goals:
- Create production ready testing framework

## Technology Stack

## Technology Stack

- [Maven](https://maven.apache.org/) to build the project and manage dependencies
- [TestNG](https://testng.org/doc/) as unit testing framework
- [Appium](http://appium.io/) to drive mobile devices/emulators/simulators
- [webdrivermanager](https://github.com/bonigarcia/webdrivermanager) to download appropriate browser drivers

## Execute Tests

Commandline execution:
```bash
 mvn clean test -Dtest=wdio.tests.*Tests -Dconfig=emulator
```

IDE execution depends on the specific IDE.

In IntelliJ IDE config is passed as `VM Options:` with value like `-Dconfig=emulator`.
