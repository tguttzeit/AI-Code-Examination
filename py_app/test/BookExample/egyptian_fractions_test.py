from py_app.src.BookExample.egyptian_fractions import EgyptianFractions

import unittest


class EgyptianFractionsTest(unittest.TestCase):

    def setUp(self):
        self.egyptian_fractions = EgyptianFractions()

    def test_1(self):
        result = self.egyptian_fractions.build(2, 3)

        expected = [2, 6]
        self.assertTrue(result, expected)

    def test_2(self):
        result = self.egyptian_fractions.build(6, 14)

        expected = [3, 11, 231]
        self.assertTrue(result, expected)

    def test_3(self):
        result = self.egyptian_fractions.build(12, 13)

        expected = [2, 3, 12, 156]
        self.assertTrue(result, expected)

    def test_4(self):
        result = self.egyptian_fractions.build(3, 4)

        expected = [2, 4]
        self.assertTrue(result, expected)

    def test_5(self):
        result = self.egyptian_fractions.build(6, 7)

        expected = [2, 3, 42]
        self.assertTrue(result, expected)

    def test_6(self):
        result = self.egyptian_fractions.build(5, 8)

        expected = [2, 8]
        self.assertTrue(result, expected)

    def test_7(self):
        result = self.egyptian_fractions.build(123, 1500)

        expected = [13, 197, 1280500]
        self.assertTrue(result, expected)

    def test_8(self):
        result = self.egyptian_fractions.build(6123, 7451)

        expected = [2, 4, 14, 2939, 14955066, 654986696590548]
        self.assertTrue(result, expected)


if __name__ == '__main__':
    unittest.main()
