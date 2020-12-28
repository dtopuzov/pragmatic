"""
Tests for checkbox elements.
"""

from pages.the_internet_app.checkboxes_page import CheckboxPage


class TestCheckboxes(object):
    def test_checkbox_check(self, driver):
        self.page = CheckboxPage(driver)
        self.page.visit()
        self.page.get_first_checkbox().click()
        assert self.page.get_first_checkbox().is_selected()

    def test_checkbox_uncheck(self, driver):
        self.page = CheckboxPage(driver)
        self.page.visit()
        self.page.get_second_checkbox().click()
        assert not self.page.get_second_checkbox().is_selected()
