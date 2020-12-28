import pytest
from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager


@pytest.fixture(scope='class')
def driver():
    # Initialize the WebDriver instance
    options = webdriver.ChromeOptions()
    options.add_argument("--headless")
    options.add_argument("--no-sandbox")
    options.add_argument("--disable-dev-shm-usage")
    options.add_argument("--disable-gpu")
    options.add_argument("--window-size=800,600")
    options.add_argument('log-level=3')

    d = webdriver.Chrome(executable_path=ChromeDriverManager().install(), options=options)

    # Make its calls wait for elements to appear
    d.implicitly_wait(10)

    # Return the WebDriver instance for the setup
    yield d

    # Quit the WebDriver instance for the cleanup
    d.quit()
