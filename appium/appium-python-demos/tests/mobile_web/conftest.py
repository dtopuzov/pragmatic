import pytest

from utils.appium_session import AppiumSession


@pytest.fixture(scope='package', autouse=True)
def driver():
    desired_caps = {
        'platformName': 'iOS',
        'platformVersion': '12.4',
        'deviceName': 'iPhone 8',
        'browserName': 'Safari',
        'automationName': 'XCUITest'
    }

    s = AppiumSession(desired_caps)

    # Make its calls wait for elements to appear
    s.driver.implicitly_wait(30)

    # Return the WebDriver instance for the setup
    yield s.driver

    # Quit the WebDriver instance for the cleanup
    s.stop()
