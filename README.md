# Mobile Testing Course Resources

Resources for [Mobile Testing](https://pragmatic.bg/courses/mobile-apps-test-automation-course/) course at Pragmatic.

## Setup

The setup for this course is quite complex, we need:

- GitHub client
- JDK 1.8 (and later)
- IntelliJ IDEA (or other IDE of your choice)
- Android Studio/SDK
- NodeJS and Appium
- [Optional, iOS Only] Apple hardware with macOS and Xcode
- [Optional] Sikuli IDE
- [Optional] Jenkins

We cover all the steps in details during course, but we ship some scripts in `setup` folder as well.
Those scripts might be useful for both local setup and automation of test infrastructure (build machines).

Please read [setup/README.md](setup/README.md) for more details!

## Sikuli

[Sikuli](http://sikulix.com/) is not a tool for mobile testing, it just drive everything you can see on your desktop.

Since Android Emulators and iOS Simulators are actually desktop apps Sikuli might be useful if you have complex workflows where you need to control some desktop app and emulator/simulator in the same time.

We will not spend much time on it in this course, but it worths showing the concept for image based testing.

Image based testing is powerful concept (think about self driving cars, they do not find ids, they look to the current situation as images and take actions based on image analysis) and can be implemented with other tools as well.

## Appium

Appium examples can be found in `appium` folder.

Before start with them first read about [Official Docs](http://appium.io/docs/en/about-appium/intro/).

For more advanced topics [this](https://appiumpro.com/) blog is very useful.

Please also read the `README.md` file in each demo project inside `appium` folder.

## Continuous Integration

It is important to be able to run automated test as part of CI/CD so you should think about it and have in mind when take decisions.

CI/CD systems are usually complex and can not be shipped as demo project that can be opened with IDE.

Resources for this topic are primarily in form of markdown files.
