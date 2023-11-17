from py_testgen_app.src.ChatGPT.BinaryToDecimal.PromptOnly.T8.binary_to_decimal import BinaryToDecimal

import unittest

class BinaryToDecimalTest(unittest.TestCase):
    def test_binary_to_decimal_1(self):
        binary = "1101"
        expected_decimal = 13
        actual_decimal = BinaryToDecimal().convert_to_decimal(binary)
        self.assertEqual(actual_decimal, expected_decimal)

    def test_binary_to_decimal_2(self):
        binary = "1010"
        expected_decimal = 10
        actual_decimal = BinaryToDecimal().convert_to_decimal(binary)
        self.assertEqual(actual_decimal, expected_decimal)

    def test_binary_to_decimal_3(self):
        binary = "11111111"
        expected_decimal = 255
        actual_decimal = BinaryToDecimal().convert_to_decimal(binary)
        self.assertEqual(actual_decimal, expected_decimal)

