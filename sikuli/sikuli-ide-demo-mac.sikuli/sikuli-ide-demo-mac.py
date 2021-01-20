import unittest

class MorseTests(unittest.TestCase):
    def test_01_english_to_morse(self):
        click(Pattern("clear_english_text.png").similar(0.90))
        click(Pattern("english_tab.png").similar(0.80).targetOffset(0,25))
        type("test")
        click("english_to_morse.png")
        assert exists("test.png") is not None

    def test_02_morse_to_english(self):
        click(Pattern("clear_morse_text.png").similar(0.90))
        click(Pattern("morse_tab.png").targetOffset(0,25))
        type("--.- .-  / ")
        click("morse_to_english.png")
        assert exists("qa.png") is not None

suite = unittest.TestLoader().loadTestsFromTestCase(MorseTests)
unittest.TextTestRunner(verbosity=2).run(suite)