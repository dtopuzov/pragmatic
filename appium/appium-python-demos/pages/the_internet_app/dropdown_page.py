from selenium.webdriver.common.by import By


class DropDownPage:
    # URL
    URL = "https://the-internet.herokuapp.com/dropdown"

    # Locators
    DROPDOWN = (By.ID, "dropdown")

    # Initializer
    def __init__(self, browser):
        self.browser = browser

    def visit(self):
        self.browser.get(self.URL)

    def get_dropdown(self):
        return self.browser.find_element(*self.DROPDOWN)
