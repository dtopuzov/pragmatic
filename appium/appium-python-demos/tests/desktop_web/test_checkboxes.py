"""
Tests for checkbox elements.
"""
import pytest

from pages.the_internet_app.checkboxes_page import CheckboxPage


class TestCheckboxes(object):
    @pytest.fixture(scope='function', autouse=True)
    def before_each(self, driver):
        self.page = CheckboxPage(driver)
        self.page.visit()

    def test_checkbox_check(self):
        self.page.get_first_checkbox().click()
        assert self.page.get_first_checkbox().is_selected()

    def test_checkbox_uncheck(self):
        self.page.get_second_checkbox().click()
        assert not self.page.get_second_checkbox().is_selected()
