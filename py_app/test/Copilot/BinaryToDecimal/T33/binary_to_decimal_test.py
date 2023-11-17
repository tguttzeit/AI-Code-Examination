from py_app.src.Copilot.BinaryToDecimal.T33.binary_to_decimal import BinaryToDecimal

import unittest


class BinaryToDecimalTest(unittest.TestCase):
    def setUp(self):
        self.sut = BinaryToDecimal()

    def test_should_convert_binary_0_to_decimal(self):
        expected = 0
        actual = self.sut.convert_to_decimal("0")
        self.assertEqual(expected, actual)

    def test_should_convert_binary_1_to_decimal(self):
        expected = 1
        actual = self.sut.convert_to_decimal("1")
        self.assertEqual(expected, actual)

    def test_should_convert_binary_10_to_decimal(self):
        expected = 2
        actual = self.sut.convert_to_decimal("10")
        self.assertEqual(expected, actual)

    def test_should_convert_binary_11_to_decimal(self):
        expected = 3
        actual = self.sut.convert_to_decimal("11")
        self.assertEqual(expected, actual)

    def test_should_convert_binary_1010_to_decimal(self):
        expected = 10
        actual = self.sut.convert_to_decimal("1010")
        self.assertEqual(expected, actual)

    def test_should_convert_binary_1100_to_decimal(self):
        expected = 12
        actual = self.sut.convert_to_decimal("1100")
        self.assertEqual(expected, actual)


if __name__ == '__main__':
    unittest.main()
