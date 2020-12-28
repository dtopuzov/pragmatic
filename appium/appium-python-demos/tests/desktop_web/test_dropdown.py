"""
Tests for checkbox elements.
"""
import pytest

from pages.the_internet_app.dropdown_page import DropDownPage


class TestDropdown(object):
    @pytest.fixture(scope='function', autouse=True)
    def before_each(self, driver):
        self.page = DropDownPage(driver)
        self.page.visit()

    def test_select_value_with_click(self):
        assert self.page.get_dropdown() is not None

    def test_select_value_with_keayboard(self):
        assert self.page.get_dropdown() is not None
