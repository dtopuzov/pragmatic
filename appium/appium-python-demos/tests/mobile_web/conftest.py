import pytest

from utils.appium_session import AppiumSession


@pytest.fixture(scope='module')
def driver():
    desired_caps = {
        'platformName': 'Android',
        'platformVersion': '10',
        'deviceName': 'Pixel3Api29',
        'avdName': 'Pixel3Api29',
        'browser': 'Chrome',
        'chromeDriverVersion': '2.44'
    }

    s = AppiumSession(desired_caps)

    # Make its calls wait for elements to appear
    s.driver.implicitly_wait(30)

    # Return the WebDriver instance for the setup
    yield s.driver

    # Quit the WebDriver instance for the cleanup
    s.stop()
