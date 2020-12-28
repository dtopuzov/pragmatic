from selenium.webdriver.common.by import By


class CheckboxPage:
    # URL
    URL = "https://the-internet.herokuapp.com/checkboxes"

    # Locators
    FIRST_CHECKBOX = (By.CSS_SELECTOR, "#checkboxes > input[type=checkbox]:nth-child(1)")
    SECOND_CHECKBOX = (By.CSS_SELECTOR, "#checkboxes > input[type=checkbox]:nth-child(3)")

    # Initializer
    def __init__(self, browser):
        self.browser = browser

    def visit(self):
        self.browser.get(self.URL)

    def get_first_checkbox(self):
        return self.browser.find_element(*self.FIRST_CHECKBOX)

    def get_second_checkbox(self):
        return self.browser.find_element(*self.SECOND_CHECKBOX)
