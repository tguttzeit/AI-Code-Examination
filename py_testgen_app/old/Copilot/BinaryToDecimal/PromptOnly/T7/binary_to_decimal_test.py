from py_testgen_app.src.Copilot.BinaryToDecimal.PromptOnly.T7.binary_to_decimal import BinaryToDecimal

import unittest


class BinaryToDecimalTest(unittest.TestCase):
    def test_binary_to_decimal_1(self):
        binary = "10"
        expected = 2
        actual = BinaryToDecimal.convert_to_decimal(binary)
        self.assertEqual(expected, actual)

    def test_binary_to_decimal_2(self):
        binary = "101"
        expected = 5
        actual = BinaryToDecimal.convert_to_decimal(binary)
        self.assertEqual(expected, actual)

    def test_binary_to_decimal_3(self):
        binary = "1101"
        expected = 13
        actual = BinaryToDecimal.convert_to_decimal(binary)
        self.assertEqual(expected, actual)

    def test_binary_to_decimal_4(self):
        binary = "11111111"
        expected = 255
        actual = BinaryToDecimal.convert_to_decimal(binary)
        self.assertEqual(expected, actual)

    def test_binary_to_decimal_5(self):
        binary = "100000000"
        expected = 256
        actual = BinaryToDecimal.convert_to_decimal(binary)
        self.assertEqual(expected, actual)
