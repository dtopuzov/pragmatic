import unittest

class MorseTests(unittest.TestCase):
"""
Please start morsecodetranslator.bat manually before tests.
"""
    def test_01_english_to_morse(self):
        click("1608318352562.png")
        click(Pattern("1608318398560.png").targetOffset(0,25))
        type("test")
        click("1608318460446.png")
        assert exists("1608318484531.png") is not None

    def test_02_morse_to_english(self):
        click("1608318589613.png")
        click(Pattern("1608318602884.png").targetOffset(0,25))
        type("--.- .-  / ")
        click("1608318651692.png")
        assert exists("1608318663405.png") is not None

suite = unittest.TestLoader().loadTestsFromTestCase(MorseTests)
unittest.TextTestRunner(verbosity=2).run(suite)