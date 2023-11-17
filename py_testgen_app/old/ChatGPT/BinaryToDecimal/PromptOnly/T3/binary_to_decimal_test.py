from py_testgen_app.src.ChatGPT.BinaryToDecimal.PromptOnly.T3.binary_to_decimal import BinaryToDecimal

import unittest

class BinaryToDecimalTest(unittest.TestCase):
    def test_binary_to_decimal_1(self):
        binary = "1010"
        expected_decimal = 10
        self.assertEqual(BinaryToDecimal.convert_to_decimal(binary), expected_decimal)

    def test_binary_to_decimal_2(self):
        binary = "1101"
        expected_decimal = 13
        self.assertEqual(BinaryToDecimal.convert_to_decimal(binary), expected_decimal)

    def test_binary_to_decimal_3(self):
        binary = "11110000"
        expected_decimal = 240
        self.assertEqual(BinaryToDecimal.convert_to_decimal(binary), expected_decimal)
