# Python Demos

Sample web and mobile tests in Python.

## Technology Stack

- [pytest](https://pypi.org/project/pytest/) as unit testing framework.
- [pytest-xdist](https://pypi.org/project/pytest-xdist/) to run tests in parallel.
- [appium](https://pypi.org/project/Appium-Python-Client/) to browsers and apps.
- [webdriver-manager](https://pypi.org/project/webdriver-manager/) to setup browser drivers.

## Requirements

- [Python 3.8](https://www.python.org/downloads/)
- [pipenv](https://pipenv-fork.readthedocs.io/en/latest/)

## Install Dependencies

- Open terminal and go to project home
- Run `pipenv install` to ensure all dependencies are available

## Execute Tests

### Web Tests

```bash
pipenv run pytest tests/desktop_web -s -n <number-of-parallel-threads> --dist=loadscope
```

### Mobile Web

```bash
pipenv run pytest tests/mobile_web
```

## Resource

- [Appium Python Testing: The Complete Guide](https://experitest.com/appium-testing/the-complete-guide-appium-testing-using-python/) by Experitest
